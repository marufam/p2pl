package com.projek.p2pl;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.projek.p2pl.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import static android.content.Context.LOCATION_SERVICE;


public class MapFragment extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;
    double myLat = 0, myLng = 0;
    Location loc;
    LocationManager locationManager;
    String mprovider;
    Circle mapCircle;
    private Marker myMarker;
//    ApiInterface mApiInterface;
    private LocationListener listener;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

//        Toast.makeText(getContext(), "jarak tempuh saat ini : "+spbu.getString("jarak_tempuh",null), Toast.LENGTH_SHORT).show();
        prepareallmap();
        locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
//                t.append("\n " + location.getLongitude() + " " + location.getLatitude());
                if (myLat == 0 && myLng == 0) {
//                    Toast.makeText(getContext(), "" + location.getLatitude() + "  " + location.getLongitude(), Toast.LENGTH_LONG).show();
                    myLat = location.getLatitude();
                    myLng = location.getLongitude();
                } else {
                    myLat = location.getLatitude();
                    myLng = location.getLongitude();
                }

                if (mapCircle != null) {
                    mapCircle.remove();
                }

//                googleMap.clear();
                if (myLat > 0 && myLng > 0) {


                    mapCircle = googleMap.addCircle(new CircleOptions()
                            .center(new LatLng(myLat, myLng))
                            .radius(300) //1km=+-10000
                            .strokeColor(Color.argb(90, 255, 189, 31))
                            .fillColor(Color.argb(60, 255, 189, 31))
                            .strokeWidth((float) 2));
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {


            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        configure_button();


        return rootView;
    }




    public void prepareallmap() {
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                final SharedPreferences spbu = getContext().getSharedPreferences("p2tl", 0);
                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    return;
                }
                googleMap.setMyLocationEnabled(true);
                CameraPosition cameraPosition;
                // For dropping a marker at a point on the Map
                if (loc != null) {
                    myLat = loc.getLatitude();
                    myLng = loc.getLongitude();
                }
                LatLng myLocation = new LatLng(myLat, myLng);
                cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                }
//                Toast.makeText(getContext(), ""+googleMap.getMyLocation().getLatitude(), Toast.LENGTH_SHORT).show();
                CameraPosition PosisiTempat;


                googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {
//                        Toast.makeText(getContext(), ""+googleMap.getMyLocation().getLatitude(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                SharedPreferences pref = getContext().getSharedPreferences("spbu", 0); // 0 - for private mode

//                mApiInterface = ApiClient.GetSpbu().create(ApiInterface.class);
//                Call<Getspbu> getspbuCall = mApiInterface.getspbu();
//                getspbuCall.enqueue(new Callback<Getspbu>() {
//                    @Override
//                    public void onResponse(Call<Getspbu> call, final Response<Getspbu> response) {
//                        final List<Spbu> spbuList = response.body().getSpbu();
////                        Log.d("Retrofit Get", "Jumlah data : " + String.valueOf(jadwalList.size()));
//
//                        for (int i = 0; i < response.body().getSpbu().size(); i++) {
//                            String[] lnglat = spbuList.get(i).getLnglat().split(",");
//                            final LatLng origin = new LatLng(myLat,myLng);
//                            final String[] lat = response.body().getSpbu().get(i).getLnglat().split(",");
////                            Toast.makeText(getContext(), "jarak tempuh "+spbu.getString("jarak_tempuh","0"), Toast.LENGTH_SHORT).show();
//                            if(myLat!=0 && myLng!=0) {
//                                String num = getDistance(myLat, myLng, Double.parseDouble(lat[0].toString()), Double.parseDouble(lat[1].toString()));
////                                Toast.makeText(getContext(), "jarak marker "+num, Toast.LENGTH_SHORT).show();
//                                if(Integer.parseInt(num)< Integer.parseInt(spbu.getString("jarak_tempuh","0"))) {
//                                    //radius  hp ke spbu
//                                    googleMap.addMarker(new MarkerOptions()
//                                            .position(new LatLng(Double.parseDouble(lnglat[0].toString()), Double.parseDouble(lnglat[1].toString())))
//                                            .title("Lokasi")
//                                            .snippet(spbuList.get(i).getNama())
//                                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
//                                            .setTag(spbuList.get(i));
//
//                                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//                                        @Override
//                                        public boolean onMarkerClick(Marker marker) {
//                                            final Spbu k = (Spbu) marker.getTag();
//                                            String[] lat1 = k.getLnglat().split(",");
//                                            LatLng dest = new LatLng(Double.parseDouble(lat1[0].toString()), Double.parseDouble(lat1[1].toString()));
//
//
////                                    float[] results = new float[1];
////                                    Location.distanceBetween(myLat,myLng,Double.parseDouble(lat[0].toString()), Double.parseDouble(lat[1].toString()), results);
//                                            // Getting URL to the Google Directions API
//                                            String url = getDirectionsUrl(origin, dest);
//                                            DownloadTask downloadTask = new DownloadTask();
//
//                                            downloadTask.execute(url);
//
//                                            Snackbar snackbar = Snackbar.make(getView(), "Lokasi " + k.getNama(), Snackbar.LENGTH_SHORT)
//                                                    .setActionTextColor(Color.parseColor("#FFAA00"))
//                                                    .setAction("Lihat", new View.OnClickListener() {
//
//                                                        @Override
//                                                        public void onClick(View v) {
//                                                            Intent i = new Intent(getContext(), spbu_detail.class);
//                                                            i.putExtra("id_spbu", k.getId_spbu());
//                                                            i.putExtra("nama_spbu", k.getNama());
//                                                            i.putExtra("latlng", k.getLnglat());
//                                                            i.putExtra("buka", k.getBuka());
//                                                            i.putExtra("tutup", k.getTutup());
//                                                            i.putExtra("alamat", k.getAlamat());
//                                                            startActivity(i);
//                                                        }
//                                                    });
//                                            snackbar.show();
//
//                                            return false;
//                                        }
//                                    });
//                                }
//                            }
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Getspbu> call, Throwable t) {
//                        Toast.makeText(getContext(), "Check your connection (1)", Toast.LENGTH_SHORT).show();
//                    }
//
//
//                });

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, listener);
        if (locationManager != null) {
            loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            prepareallmap();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        prepareallmap();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }



}
