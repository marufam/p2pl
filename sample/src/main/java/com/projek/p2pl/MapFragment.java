package com.projek.p2pl;

import android.Manifest;
import android.content.Context;
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


import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;
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
import com.projek.p2pl.model.m_pelanggan;
import com.projek.p2pl.model.m_polri;

import io.realm.Realm;

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
    private Realm mRealm;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        mRealm = Realm.getInstance(getContext());
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        LocationManager locManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        boolean network_enabled = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        Location location;

        if (network_enabled) {

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return rootView;
            }
            location = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location!=null){
                myLng = location.getLongitude();
                myLat = location.getLatitude();
                Toast.makeText(getContext(), "Location "+String.valueOf(myLng)+","+String.valueOf(myLat), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
//                lokasi.setText(String.valueOf(myLng)+","+String.valueOf(myLat));

            }
        }


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

                        for (int i = 0; i < mRealm.allObjects(m_pelanggan.class).size(); i++) {
                            Double lng = mRealm.allObjects(m_pelanggan.class).get(i).getLng();
                            final LatLng origin = new LatLng(myLat,myLng);
                            Double lat = mRealm.allObjects(m_pelanggan.class).get(i).getLat();
//                            Toast.makeText(getContext(), ""+myLat, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getContext(), ""+SphericalUtil.computeDistanceBetween(new LatLng(myLat, myLng), new LatLng(lat, lng)), Toast.LENGTH_SHORT).show();
                            if ((SphericalUtil.computeDistanceBetween(new LatLng(myLat, myLng), new LatLng(lat, lng))) < 300) {

                                    googleMap.addMarker(new MarkerOptions()
                                            .position(new LatLng(lat, lng))
                                            .title("Lokasi")
                                            .snippet(mRealm.allObjects(m_pelanggan.class).get(i).getNama_penghuni())
                                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
                                            .setTag(mRealm.allObjects(m_pelanggan.class).get(i));

                                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                        @Override
                                        public boolean onMarkerClick(Marker marker) {
                                            final m_pelanggan pelanggan = (m_pelanggan) marker.getTag();

//                                            Snackbar snackbar = Snackbar.make(getView(), "Lokasi " + pelanggan.getNama_penghuni(), Snackbar.LENGTH_SHORT)
//                                                    .setActionTextColor(Color.parseColor("#FFAA00"))
//                                                    .setAction("Lihat", new View.OnClickListener() {
//
//                                                        @Override
//                                                        public void onClick(View v) {
//                                                            Intent i = new Intent(getContext(), DetailActivity.class);
//                                                            i.putExtra("id", k.getId_spbu());
//                                                            i.putExtra("nama", k.getNama());
//                                                            i.putExtra("alamat", k.getLnglat());
//                                                            i.putExtra("nogardu", k.getBuka());
//                                                            i.putExtra("tarif", k.getTutup());
//                                                            i.putExtra("deskripsi", k.getAlamat());
//                                                            startActivity(i);
//                                                        }
//                                                    });
//                                            snackbar.show();

                                            return false;
                                        }
                                    });
                                }
                            }

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
