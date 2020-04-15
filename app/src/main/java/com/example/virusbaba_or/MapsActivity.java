package com.example.virusbaba_or;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ArrayList<LatLng> test_centres=new ArrayList<LatLng>();
    ArrayList<String>testnames=new ArrayList<String>();

    LatLng Regional_Medical_Research_Centre=new LatLng(19.771860,  73.225658);
    LatLng Sri_Venkateswara_Institute_of_Medical_Sciences=new LatLng( 13.638198,  79.403831);
    LatLng Andhra_Medical_College=new LatLng( 17.706779, 83.304871);
    LatLng Sidhartha_Medical_College=new LatLng(  13.345448,  77.059609);
    LatLng Rangaraya_Medical_College=new LatLng( 16.979657, 82.237327);
    LatLng Rajendra_Memorial_Research_Institute_of_Medical_Sciences    =new LatLng(25.599903, 85.197727);
    LatLng All_India_Institute_Medical_Sciences1 =new LatLng(21.257030, 81.579216);
    LatLng All_India_Institute_Medical_Sciences2  =new LatLng(28.567262, 77.210045);
    LatLng BJ_Medical_College =new LatLng(23.052698, 72.602895);
    LatLng MP_Shah_Government_Medical_College   =new LatLng(22.477595, 70.065256);
    LatLng BPS_Govt_Medical_College =new LatLng(29.152210, 76.808429);
    LatLng Pt_BD_Sharma_Post_Graduate_Institute_of_Medical_Sciences=new LatLng(29.152210, 76.808429);
    LatLng Indira_Gandhi_Medical_College =new LatLng(31.106683, 77.182311);
    LatLng Dr_Rajendra_Prasad_Govt_Med_College  =new LatLng(32.098291, 76.302057);
    LatLng Sher_e_Kashmir_Institute_of_Medical_Sciences    =new LatLng(34.136323, 74.800073);
    LatLng Government_Medical_College1=new LatLng(32.736338, 74.853979);
    LatLng Government_Medical_College2 =new LatLng(34.086143, 74.798850);
    LatLng MGM_Medical_College    =new LatLng(22.843941, 86.232369);
    LatLng Bangalore_Medical_College_Research_Institute    =new LatLng(12.959553, 77.574695);
    LatLng National_Institute_of_Virology_Field_Unit_Bangalore    =new LatLng(12.937600, 77.590896);
    LatLng Mysore_Medical_College_Research_Institute    =new LatLng(12.315547, 76.650493);
    LatLng Hassan_Inst_of_Med_Sciences=new LatLng(13.005157, 76.102649);
    LatLng Shimoga_Inst_of_Med_Sciences =new LatLng(13.933131, 75.566734);
    LatLng  Indira_Gandhi_Government_Medical_College=new LatLng(21.153693, 79.093931);
    LatLng  Viva_Institute_of_Pharmacy=new LatLng(19.474024, 72.858289);
    LatLng  Kasturba_Hospital_for_Infectious_Diseases=new LatLng(18.984270, 72.829838);




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

        mMap.addMarker(new MarkerOptions().position(Regional_Medical_Research_Centre).title("Regional Medical Research Centre"));
        mMap.addMarker(new MarkerOptions().position(Sri_Venkateswara_Institute_of_Medical_Sciences).title("Sri Venkateswara Institute of Medical Sciences"));
        mMap.addMarker(new MarkerOptions().position(Andhra_Medical_College).title("Andhra Medical College"));
        mMap.addMarker(new MarkerOptions().position(Sidhartha_Medical_College).title("Sidhartha Medical College"));
        mMap.addMarker(new MarkerOptions().position(Rangaraya_Medical_College).title("Rangaraya Medical College"));
        mMap.addMarker(new MarkerOptions().position( Rajendra_Memorial_Research_Institute_of_Medical_Sciences).title("Rajendra Memorial Research Institute of Medical Sciences"));
        mMap.addMarker(new MarkerOptions().position(All_India_Institute_Medical_Sciences1).title("All India Institute Medical Sciences"));
        mMap.addMarker(new MarkerOptions().position(All_India_Institute_Medical_Sciences2).title("All India Institute Medical Sciences"));
        mMap.addMarker(new MarkerOptions().position(BJ_Medical_College).title("BJ Medical College"));
        mMap.addMarker(new MarkerOptions().position(MP_Shah_Government_Medical_College).title("M.P.Shah Government Medical College"));
        mMap.addMarker(new MarkerOptions().position(BPS_Govt_Medical_College).title("BPS Govt Medical College"));
        mMap.addMarker(new MarkerOptions().position(Pt_BD_Sharma_Post_Graduate_Institute_of_Medical_Sciences).title("Pt. B.D. Sharma Post Graduate Institute of Medical Sciences"));
        mMap.addMarker(new MarkerOptions().position(Indira_Gandhi_Medical_College).title("Indira Gandhi Medical College"));
        mMap.addMarker(new MarkerOptions().position(Dr_Rajendra_Prasad_Govt_Med_College).title("Dr. Rajendra Prasad Govt. Med. College"));
        mMap.addMarker(new MarkerOptions().position(Sher_e_Kashmir_Institute_of_Medical_Sciences).title("Sher-e- Kashmir Institute of Medical Sciences"));
        mMap.addMarker(new MarkerOptions().position(Government_Medical_College1).title("Government Medical College"));
        mMap.addMarker(new MarkerOptions().position(Government_Medical_College2).title("Government Medical College"));
        mMap.addMarker(new MarkerOptions().position(MGM_Medical_College).title("MGM Medical College"));
        mMap.addMarker(new MarkerOptions().position(Bangalore_Medical_College_Research_Institute).title("Bangalore Medical College & Research Institute"));
        mMap.addMarker(new MarkerOptions().position(National_Institute_of_Virology_Field_Unit_Bangalore).title("National Institute of Virology Field Unit Bangalore"));
        mMap.addMarker(new MarkerOptions().position(Mysore_Medical_College_Research_Institute).title("Mysore Medical College & Research Institute"));
        mMap.addMarker(new MarkerOptions().position(Indira_Gandhi_Government_Medical_College).title("Indira Gandhi Government Medical College"));
        mMap.addMarker(new MarkerOptions().position(Viva_Institute_of_Pharmacy).title("\"Viva Institute of Pharmacy"));
        mMap.addMarker(new MarkerOptions().position( Kasturba_Hospital_for_Infectious_Diseases).title("Kasturba Hospital for Infectious Diseases"));




        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String marker_title=marker.getTitle();
                Intent intent9=new Intent(MapsActivity.this,booking.class);
                intent9.putExtra("testcentrename",marker_title);
                startActivity(intent9);
                Toast.makeText(MapsActivity.this,"You have Selected: "+marker_title,Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }
}
