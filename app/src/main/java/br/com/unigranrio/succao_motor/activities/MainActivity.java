package br.com.unigranrio.succao_motor.activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import br.com.unigranrio.succao_motor.R;

public class MainActivity extends AppCompatActivity {

    CircleProgressBar circleProgressBar;
    ImageButton btnFindMyCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleProgressBar = findViewById(R.id.circleProgressBar);
        btnFindMyCar = findViewById(R.id.btn_find_my_car);

        circleProgressBar.setColorSchemeResources(R.color.loading);

        btnFindMyCar.setOnClickListener(new View.OnClickListener() {

            int progressValue = 0;

            @Override
            public void onClick(View v) {

                btnFindMyCar.setVisibility(View.INVISIBLE);
                circleProgressBar.setVisibility(View.VISIBLE);

                CountDownTimer countDownTimer = new CountDownTimer(11000, 800) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        progressValue += 10;

                        circleProgressBar.setProgress(progressValue);

                        if(progressValue >= 100) {
                            circleProgressBar.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFinish() {
                        final Intent intent = new Intent(MainActivity.this, ListCarActivity.class);
                        startActivity(intent);

                        circleProgressBar.setVisibility(View.INVISIBLE);
                        btnFindMyCar.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_outros:
                Intent intent = new Intent(MainActivity.this, OthersActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
