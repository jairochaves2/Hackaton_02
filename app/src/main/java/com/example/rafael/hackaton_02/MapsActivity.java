package com.example.rafael.hackaton_02;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String Origem;
    private String Destino;
    private Double Latitude_Origem;
    private Double Longitude_Origem;
    private Double Latitude_Destino;
    private Double Longitude_Destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent= getIntent();
        Origem = intent.getStringExtra("Origem");
        Destino = intent.getStringExtra("Destino");
        Latitude_Origem = Double.parseDouble(intent.getStringExtra("Latitude_Origem"));
        Longitude_Origem = Double.parseDouble(intent.getStringExtra("longitude_Origem"));
        Latitude_Destino = Double.parseDouble(intent.getStringExtra("Latitude_Destino"));
        Longitude_Destino = Double.parseDouble(intent.getStringExtra("longitude_Destino"));
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng OrigemM = new LatLng(Latitude_Origem,Longitude_Origem);
        LatLng DestinoM = new LatLng(Latitude_Destino,Longitude_Destino);

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(Latitude_Origem,Longitude_Origem),
                        new LatLng(Latitude_Destino,Longitude_Destino)));

        mMap.addMarker(new MarkerOptions().position(OrigemM).title(Origem.toString()));
        mMap.addMarker(new MarkerOptions().position(DestinoM).title(Destino.toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DestinoM));
    }
}
