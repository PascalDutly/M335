package com.example.lb1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.text.*;

public class Gps extends Activity
        implements OnClickListener {

    private LocationManager locationMangaer = null;
    private LocationListener locationListener = null;
    private Button btnGetLocation = null;
    private TextView v_longitude = null;
    private TextView v_latitude = null;
    private TextView v_altitude = null;
    private TextView v_gps_status = null;
    String longitude = "";
    String latitude = "";
    String altitude = "";
    String sat_nr = "";

    private TextView v_oldlongitude = null;
    private TextView v_oldlatitude = null;
    private TextView v_oldaltitude = null;

    private TextView result_alt = null;
    private TextView result_lon = null;
    private TextView result_lat = null;

    //One Degree latitude is 111000 Meters
    int latitudeInMeters = 111000;
    int longitundeInMeters = 111120;

    double lon;
    double lat;
    double alt;

    double old_alt;
    double old_lat;
    double old_lon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //portrait mode

        v_longitude = (TextView) findViewById(R.id.longditude);
        v_latitude = (TextView) findViewById(R.id.latitude);
        v_altitude = (TextView) findViewById(R.id.altitude);
        v_gps_status = findViewById(R.id.v_gps_status);

        v_oldlongitude = (TextView) findViewById(R.id.longditude2);
        v_oldlatitude = (TextView) findViewById(R.id.latitude2);
        v_oldaltitude = (TextView)  findViewById(R.id.altitude2);

        result_lon = (TextView) findViewById(R.id.result_lon);
        result_lat = (TextView) findViewById(R.id.result_lat);
        result_alt = (TextView) findViewById(R.id.result_alt);

        btnGetLocation = (Button) findViewById(R.id.btn_enable_gps);
        btnGetLocation.setOnClickListener(this);
        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
    }

    public void goToMain(View view){
        setContentView(R.layout.activity_main_menu);
        Intent intent = new Intent(view.getContext(), MainMenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        //Check if GPS is enabled
        locationListener = new APPLocationListener();
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            v_gps_status.setText(getString(R.string.wait_for_signal));
            v_gps_status.setTextColor(Color.parseColor("#0066ff"));
            locationMangaer.requestLocationUpdates(LocationManager
                    .GPS_PROVIDER, 10000, 0, locationListener);
        } else {
            v_gps_status.setText(getString(R.string.no_gps_access));
            v_gps_status.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    private class APPLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {

            try{
                old_alt = alt;
                old_lat = lat;
                old_lon = lon;

                v_oldlatitude.setText(v_latitude.getText());
                v_oldlongitude.setText(v_longitude.getText());
                v_oldaltitude.setText(v_altitude.getText());
            }catch (Exception e){
                System.out.println("Doesn't work");
            }

            alt = loc.getAltitude(); //Get latitude
            lon = loc.getLongitude(); //Get longitude
            lat = loc.getLatitude();//Get height in meters

            calculateDistance();

            latitude = "" + lat;
            longitude = "" + lon;
            altitude = "" + alt + " m";

            sat_nr = "" + loc.getExtras().getInt("satellites"); //available satellites

            v_latitude.setText(latitude);
            v_longitude.setText(longitude);
            v_altitude.setText(altitude);
            v_gps_status.setText(getString(R.string.gps_working));
            v_gps_status.setTextColor(Color.parseColor("#33cc33"));
        }

        private void calculateDistance(){
            double difference_alt = old_alt - alt;
            double difference_lat = old_lat - lat;
            double difference_lon = old_lon - lon;

            showResult(difference_alt, difference_lat, difference_lon);
        }

        private void showResult(double difference_alt, double difference_lat, double difference_lon){

            DecimalFormat df = new DecimalFormat("#.##");

            if (difference_alt <= 0) {
                String resultAltitudeText = "Sie sind " + df.format(Math.abs(difference_alt)) + "m nach oben gereist";
                result_alt.setText(resultAltitudeText);
            }else{
                String resultAltitudeText = "Sie sind " + df.format(difference_alt) + "m nach unten gereist";
                result_alt.setText(resultAltitudeText);
            }

            if (difference_lat <= 0){
                String resultLatitude = "Sie sind " + df.format(Math.abs(difference_lat * latitudeInMeters)) + "m nach Norden gereist";
                result_lat.setText(resultLatitude);
            }else{
                String resultLatitude = "Sie sind " + df.format(difference_lat * latitudeInMeters) + "m nach Süden gereist";
                result_lat.setText(resultLatitude);
            }

            if (difference_lon <= 0){
                String resultLongitude = "Sie sind " + df.format(Math.abs(difference_lon * longitundeInMeters)) + "m nach Westen gereist";
                result_lon.setText(resultLongitude);
            }else{
                String resultLongitude = "Sie sind " + df.format(difference_lon * longitundeInMeters) + "m nach Osten gereist";
                result_lon.setText(resultLongitude);
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}