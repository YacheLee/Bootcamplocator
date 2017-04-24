package com.dentaltw.bootcamplocator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dentaltw.bootcamplocator.R;
import com.dentaltw.bootcamplocator.models.Develops;
import com.dentaltw.bootcamplocator.services.DataService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MarkerOptions userMarker;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
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
    }

    public void setUserMarker(LatLng latLng){
        if(userMarker==null){
            userMarker = new MarkerOptions().position(latLng).title("Current Location");
            mMap.addMarker(userMarker);
            Log.v("MAPS","Current Location: "+latLng.latitude+" Long: "+latLng.longitude);
        }
        updateMapForZip(92284);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
    }

    private void updateMapForZip(int zipCode){
        ArrayList<Develops> locations = DataService.getInstance().getData(zipCode);

        for(Develops location: locations){
            MarkerOptions marker = new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude()));
            marker.title(location.getLocationTitle());
            marker.snippet(location.getLocationAddress());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
            mMap.addMarker(marker);
        }
        Log.v("MAPS","updateMapForZip");
    }
}
