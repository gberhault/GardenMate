package jbazin.gberhault.gardenmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton poivronButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poivronButton = (ImageButton) findViewById(R.id.poivronImageButton);

        poivronButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent descriptionPoivronIntent = new Intent(MainActivity.this,PoivronActivity.class);
                startActivity(descriptionPoivronIntent);
            }
        });
    }
}
