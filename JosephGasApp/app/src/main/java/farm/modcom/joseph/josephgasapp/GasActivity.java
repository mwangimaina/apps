package farm.modcom.joseph.josephgasapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GasActivity extends FragmentActivity implements OnMapReadyCallback,
        LocationListener {

    private GoogleMap mMap;


    //get current location
    LocationManager locManager;

    public void WhereIam() {
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //we use GPS
       // String provider = LocationManager.GPS_PROVIDER;
        //request location updates
        //'this'  listener which iis implemented in this class.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //check for netwok
        if (locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    5000, 5, this);
        }
       //check for for GPS
        if (locManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    5000, 5, this);
        }

    }//end



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas);
        WhereIam();
        //enable data/GPS
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng lionsplace = new LatLng(-1.17633571, 36.93680108);
        mMap.addMarker(new MarkerOptions().position(lionsplace).title("Lions Place"));

        LatLng kicc = new LatLng(-1.272834, 36.81077);
        mMap.addMarker(new MarkerOptions().position(kicc).title("KICC"));

        LatLng meseum = new LatLng(-1.27223333, 36.8144178);
        mMap.addMarker(new MarkerOptions().position(meseum).title("National Meseum"));

        LatLng villarosa = new LatLng(-1.27038843, 36.81004044);
        mMap.addMarker(new MarkerOptions().position(villarosa).title("Villa Rosa"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lionsplace,14));
    }
   //this method gets the current location
    @Override
    public void onLocationChanged(Location location) {

        Toast.makeText(this, ""+location.getLatitude(),
                Toast.LENGTH_SHORT).show();

        Toast.makeText(this, ""+location.getLongitude(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
