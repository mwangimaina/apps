package farm.modcom.joseph.cliniclocator;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng medanta = new LatLng(-1.2949055, 36.8129285);
        mMap.addMarker(new MarkerOptions().position(medanta).title("Medanta Clinic : 0725*"));

        LatLng agakhan = new LatLng(-1.2616306, 36.824348);
        mMap.addMarker(new MarkerOptions().position(agakhan).title("Agakhan Clinic : 0725*"));

        LatLng meridian = new LatLng(-1.307814, 36.8243533);
        mMap.addMarker(new MarkerOptions().position(meridian).title("Meridian Clinic : 0725*"));

        LatLng coptic = new LatLng(-1.30847, 36.86308);
        mMap.addMarker(new MarkerOptions().position(coptic).title("Coptic Clinic : 0725*"));

        LatLng knh = new LatLng(-1.3010129, 36.8071939);
        mMap.addMarker(new MarkerOptions().position(knh).title("KNH Clinic : 0725*"));
        //camera at the center
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medanta,14));
        //GPS
    }
}
