package jbazin.gberhault.gardenmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button goToPlantsActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToPlantsActivityButton = (Button) findViewById(R.id.plantsActivityButton);

        goToPlantsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plantActivity = new Intent(MainActivity.this, PlantsActivity.class);
                startActivity(plantActivity);
            }
        });
    }
}
