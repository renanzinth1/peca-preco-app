package br.com.unigranrio.succao_motor.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import br.com.unigranrio.succao_motor.R;

public class ListCarActivity extends AppCompatActivity {

    private ListView listCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);

        listCar = findViewById(R.id.list_car);

        loadCars();

        listCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Intent intent = new Intent(ListCarActivity.this, CarDetailsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loadCars() {
        List<String> cars = Arrays.asList("Renault Clio | KJF-8798", "Honda Civic | LRZ-6789", "Ford Fiesta | KCY-7645");
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(ListCarActivity.this, android.R.layout.simple_list_item_1, cars);
        listCar.setAdapter(adapter);
    }
}
