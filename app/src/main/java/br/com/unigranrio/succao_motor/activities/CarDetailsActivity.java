package br.com.unigranrio.succao_motor.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.unigranrio.succao_motor.R;

public class CarDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        ImageButton btnFuelCar = findViewById(R.id.btnFuelCar);
        btnFuelCar.setBackgroundColor(Color.parseColor("#5af799"));

        btnFuelCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?z=25&q=" + "gas station nearby"));
                startActivity(intent);
            }
        });
    }
}
