package com.example.mapandroidexpertapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Creamos marcador de 2 bibliotecas
        agregarMarcador(mMap, -34.5959839, -58.3942276,"Ateneo")
        agregarMarcador(mMap, -34.5844482, -58.3980291,"Nacional")

        //Posicionamos cámara sobre CABA
        val latLng = LatLng(-34.6118529, -58.4560401)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12F))
    }

    private fun agregarMarcador(mMap: GoogleMap, latitud: Double, longitude: Double, title: String) {
        val latLng = LatLng(latitud, longitude)
        val mark = crearMarcador(latLng, title)
        mMap.addMarker(mark)
    }

    private fun crearMarcador(latLng: LatLng, title: String): MarkerOptions {
        return MarkerOptions()
            .position(latLng)
            .title(title)
    }
}