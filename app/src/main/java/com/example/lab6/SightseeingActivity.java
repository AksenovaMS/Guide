package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class SightseeingActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sightseeing);

        Intent intent = getIntent();
        Sightseeing sightseeing = intent.getParcelableExtra("sightseeing");

        MapKitFactory.initialize(this);

        mapView = (MapView) findViewById(R.id.mapView);

        mapView.getMap().move(
                new CameraPosition(sightseeing.getCoordinates(), 18.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);

        mapView.getMap().getMapObjects().addPlacemark(sightseeing.getCoordinates());

        TextView textViewName = findViewById(R.id.textView6);
        textViewName.setText(sightseeing.getName());
        TextView textViewDescription = findViewById(R.id.textView7);
        textViewDescription.setText(sightseeing.getDescription());
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}