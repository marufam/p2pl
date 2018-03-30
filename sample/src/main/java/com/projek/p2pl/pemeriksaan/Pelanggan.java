package com.projek.p2pl.pemeriksaan;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.projek.p2pl.Config;
import com.projek.p2pl.R;
import com.github.fcannizzaro.materialstepper.AbstractStep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.content.Context.LOCATION_SERVICE;


public class Pelanggan extends AbstractStep  {

    private int i = 1;
    private Button button;
    private final static String CLICK = "click";
    private GoogleMap map;

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

    @Bind(R.id.lokasi)
    TextView lokasi;
    @Bind(R.id.rd_pelanggan) RadioButton rd_pelanggan;
    @Bind(R.id.rd_nonpelanggan) RadioButton rd_nonpelanggan;

    @Bind(R.id.id_pelanggan) EditText id_pelanggan;
    @Bind(R.id.nama) EditText nama;
    @Bind(R.id.alamat) EditText alamat;
    @Bind(R.id.no_gardu) EditText no_gardu;
    @Bind(R.id.trafo) EditText trafo;
    @Bind(R.id.tarif) EditText tarif;
    @Bind(R.id.peruntukan) Spinner peruntukan;

    @Bind(R.id.nama_penghuni) EditText nama_penghuni;
    @Bind(R.id.alamat_penghuni) EditText alamat_penghuni;
    @Bind(R.id.nomor_identitas) EditText nomor_identitas;
    @Bind(R.id.pekerjaan_penghuni) EditText pekerjaan_penghuni;


//    @Bind(R.id.rdg_pelanggan)
//    RadioGroup rdg_pelanggan;
    @Bind(R.id.btn_pelanggan) Button btn_pelanggan;

    @Bind(R.id.noktp_saksi1) EditText noktp_saksi1;
    @Bind(R.id.nama_saksi1) EditText nama_saksi1;
    @Bind(R.id.noktp_saksi2) EditText noktp_saksi2;
    @Bind(R.id.nama_saksi2) EditText nama_saksi2;

    Button btn_foto;
    ImageView img1, img2, img3, img4, img5, img6;
    private Uri fileUri;
    File file1, file2, file3, file4, file5, file6;
    String files = "";
    int rCode = 100;

    private static final String TAG = "Permission";
    public static final int MEDIA_TYPE_IMAGE = 1;
    double latitude;
    double longitude;
    String terdaftar = "1" ;




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.pelanggan, container, false);
        ButterKnife.bind(this, rootView);
//        int selectedId = rdg_pelanggan.getCheckedRadioButtonId();

        rd_pelanggan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    rd_nonpelanggan.setChecked(false);
                    id_pelanggan.setEnabled(true);
                    id_pelanggan.setText("");
                    terdaftar = "1";
                }
            }
        });
        rd_nonpelanggan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    rd_pelanggan.setChecked(false);
                    id_pelanggan.setEnabled(false);
                    id_pelanggan.setText("-");
                    terdaftar = "0";
                }
            }
        });

//
//        if(rd_nonpelanggan.isChecked()){
//            rd_pelanggan.setChecked(false);

//        }else{
//            rd_nonpelanggan.setChecked(true);
//        }
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
//                Toast.makeText(mStepper, "Location "+String.valueOf(longitude)+","+String.valueOf(latitude), Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                lokasi.setText(String.valueOf(myLng)+","+String.valueOf(myLat));

            }
        }

        img1 = (ImageView) rootView.findViewById(R.id.img1);
        img2 = (ImageView) rootView.findViewById(R.id.img2);
        img3 = (ImageView) rootView.findViewById(R.id.img3);
        img4 = (ImageView) rootView.findViewById(R.id.img4);
        img5 = (ImageView) rootView.findViewById(R.id.img5);
        img6 = (ImageView) rootView.findViewById(R.id.img6);
        btn_foto = (Button) rootView.findViewById(R.id.btn_foto);
        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
            }
        });

        mMapView = (MapView) rootView.findViewById(R.id.posisi);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
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
//                Toast.makeText(mStepper, ""+myLat+","+myLng, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
//                prepareallmap();
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
        isCameraPermissionGranted();
        isReadPermissionGranted();


        // cek id pelanggan
        btn_pelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPel(id_pelanggan.getText().toString());
            }
        });


        return rootView;
    }


    public void prepareallmap() {
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
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

                googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {
//                        Toast.makeText(getContext(), ""+googleMap.getMyLocation().getLatitude(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

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



    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(CLICK, i);

//        state.putParcelable("file_uri", fileUri);
    }

    @Override
    public String name() {
        return "Step " + getArguments().getInt("position", 0);
    }

    @Override
    public boolean isOptional() {
        return true;
    }


    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
//        Toast.makeText(mStepper, "onNext", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        return "Form Pelanggan";
    }

    @Override
    public boolean nextIf() {
        SharedPreferences pref = getContext().getSharedPreferences("pemeriksaan", 0); // 0 - for private mode where the created file can only be accessed by the calling application
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("terdaftar", terdaftar.toString());
        editor.putString("id_pelanggan", id_pelanggan.getText().toString());
        editor.putString("nama_pelanggan", nama.getText().toString());
        editor.putString("alamat_pelanggan", alamat.getText().toString());
        editor.putString("no_gardu", no_gardu.getText().toString());
        editor.putString("trafo", trafo.getText().toString());
        editor.putString("tarif", tarif.getText().toString());
        editor.putString("peruntukan", peruntukan.getSelectedItem().toString());

        editor.putString("nama_penghuni", nama_penghuni.getText().toString());
        editor.putString("alamat_penghuni", alamat_penghuni.getText().toString());
        editor.putString("noktp_penghuni", nomor_identitas.getText().toString());
        editor.putString("pekerjaan_penghuni", pekerjaan_penghuni.getText().toString());

        editor.putString("noktp_saksi1", noktp_saksi1.getText().toString());
        editor.putString("nama_saksi1", nama_saksi1.getText().toString());
        editor.putString("noktp_saksi2", noktp_saksi2.getText().toString());
        editor.putString("nama_saksi2", nama_saksi2.getText().toString());
//        Toast.makeText(mStepper, ""+file1.getPath().toString(), Toast.LENGTH_SHORT).show();
        editor.putString("foto", files);
        editor.putString("status","unknown");
        editor.putString("lat",String.valueOf(myLat));
        editor.putString("lng",String.valueOf(myLng));

        // files gambar
        if ( !file1.getAbsolutePath().isEmpty() ) editor.putString("file1", file1.getAbsolutePath()); else editor.putString("file1", "0");
        if ( !file2.getAbsolutePath().isEmpty() ) editor.putString("file2", file2.getAbsolutePath()); else editor.putString("file2", "0");
        if ( !file3.getAbsolutePath().isEmpty() ) editor.putString("file3", file3.getAbsolutePath()); else editor.putString("file3", "0");
        if ( !file4.getAbsolutePath().isEmpty() ) editor.putString("file4", file4.getAbsolutePath()); else editor.putString("file4", "0");
        if ( !file5.getAbsolutePath().isEmpty() ) editor.putString("file5", file5.getAbsolutePath()); else editor.putString("file5", "0");
        if ( !file6.getAbsolutePath().isEmpty() ) editor.putString("file6", file6.getAbsolutePath()); else editor.putString("file6", "0");
        editor.commit();
        return i > 1;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }


    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        startActivityForResult(intent, rCode);
    }

    /**
     * Here we store the file url as it will be null after returning from camera
     * app
     */

//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // get the file url
//        fileUri = savedInstanceState.getParcelable("file_uri");
//    }


//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//        fileUri = savedInstanceState.getParcelable("file_uri");
//    }

    /**
     * Receiving activity result method will be called after closing the camera
     * */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // capture foto meter
//        if (requestCode == CAMERA_CAPTURE_METER_REQUEST_CODE) {
        if (resultCode == RESULT_OK) {

            // successfully captured the image
            Bitmap resized = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(fileUri.getPath()), 300, 300);
//            Bitmap resized = BitmapFactory.decodeFile(fileUri.getPath());

            // simpan gambar resized
            storeImage(resized);

            Log.d("compressing path", file1.getAbsolutePath());
            Log.d("compressing name", file1.getName());

            if (rCode == 100){
//                file1 = fileUri;
                files += file1.getName() + ",";
                img1.setImageBitmap(resized);
            } else if(rCode == 200){
//                file2 = fileUri;
                files += file2.getName() + ",";
                img2.setImageBitmap(resized);
            } else if(rCode == 300){
//                file3 = fileUri;
                files += file3.getName() + ",";
                img3.setImageBitmap(resized);
            } else if(rCode == 400){
//                file4 = fileUri;
                files += file4.getName() + ",";
                img4.setImageBitmap(resized);
            } else if(rCode == 500){
//                file5 = fileUri;
                files += file5.getName() + ",";
                img5.setImageBitmap(resized);
            } else if(rCode == 600){
//                file6 = fileUri;
                files += file6.getName();
                img6.setImageBitmap(resized);
            }

            Log.d("files", files);

            rCode += 100;

            if (rCode <= 600)
                captureImage();

        } else if (resultCode == RESULT_CANCELED) {

            // user cancelled Image capture
//            Toast.makeText(getApplicationContext(),
//                    "User cancelled image capture", Toast.LENGTH_SHORT)
//                    .show();
            Toast.makeText(mStepper, "Batal mengambil gambar", Toast.LENGTH_SHORT).show();

        } else {
            // failed to capture image
//            Toast.makeText(getApplicationContext(),
//                    "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
//                    .show();
            Toast.makeText(mStepper, "Gagal mengambil gambar", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * ------------ Helper Methods ----------------------
     * */

    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Config.IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(TAG, "Oops! Failed create "
                        + Config.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");

        } else {
            return null;
        }

        return mediaFile;
    }


    public  boolean isCameraPermissionGranted() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (mStepper.checkSelfPermission(Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(mStepper, new String[]{Manifest.permission.CAMERA}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

    public  boolean isReadPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (mStepper.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Read Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Read Permission is revoked");
                ActivityCompat.requestPermissions(mStepper, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Read Permission is granted");
            return true;
        }
    }




    private void storeImage(Bitmap image) {
        File pictureFile = getOutputMediaFile();
        if (pictureFile == null) {
            Log.d(TAG,
                    "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.JPEG, 100, fos);

            // check urutan gambar
            if (rCode == 100)
                file1 = new File(pictureFile.getAbsolutePath());
            else if (rCode == 200)
                file2 = new File(pictureFile.getAbsolutePath());
            else if (rCode == 300)
                file3 = new File(pictureFile.getAbsolutePath());
            else if (rCode == 400)
                file4 = new File(pictureFile.getAbsolutePath());
            else if (rCode == 500)
                file5 = new File(pictureFile.getAbsolutePath());
            else if (rCode == 600)
                file6 = new File(pictureFile.getAbsolutePath());

            fos.close();
        } catch (FileNotFoundException e) {
            Log.d(TAG, "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, "Error accessing file: " + e.getMessage());
        }
    }
    /** Create a File for saving an image or video */
    private  File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Config.IMAGE_DIRECTORY_NAME+"_compress");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        File mediaFile;
        String mImageName="MI_"+ timeStamp +"_compress.jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);

        Log.d("files1", mediaFile.getAbsolutePath());
        Log.d("files2", mediaFile.getAbsolutePath());
        Log.d("files3", mediaFile.getAbsolutePath());
        Log.d("files4", mediaFile.getAbsolutePath());
        Log.d("files5", mediaFile.getAbsolutePath());
        Log.d("files6", mediaFile.getAbsolutePath());
        return mediaFile;
    }

    public void getPel(final String idpel){
        new Thread(new Runnable() {

            @Override
            public void run() {
                Log.d("tew", "https://smartconnect.plnjateng.co.id/mappro/app/function/web_service.php?API=11223344&idpel=" + idpel);
                OkHttpClient client = new OkHttpClient();
                // code request code here

                Request request = new Request.Builder()
                        .url("https://smartconnect.plnjateng.co.id/mappro/app/function/web_service.php?API=11223344&idpel=" + idpel)
                        .get()
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();

                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("p2tl");
                    JSONObject data = jsonArray.getJSONObject(0);

                    final String namapel = data.isNull("nama") ? "-" : data.getString("nama") ;
                    final String alamatpel = data.isNull("alamat") ? "-" : data.getString("alamat") ;
                    final String no_gardupel = data.isNull("kdgardu") ? "-" : data.getString("kdgardu") ;
                    final String tarifpel = data.isNull("tarif") ? "-" : data.getString("tarif") ;

                    Log.d("tesa2", jsonObject.toString());
                    Log.d("tesa3", jsonArray.toString());
                    Log.d("tesa4", data.toString());
                    Log.d("tesa5", data.getString("result"));
//                    Log.d("tesa6", nama_pel);


                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nama.setText(namapel);
                            alamat.setText(alamatpel);
                            no_gardu.setText(no_gardupel);
                            tarif.setText(tarifpel);
                        }
                    });



                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//        return response.body().string();
            }
        }).start();

    }

}
