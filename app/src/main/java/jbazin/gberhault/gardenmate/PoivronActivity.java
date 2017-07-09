package jbazin.gberhault.gardenmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class PoivronActivity extends AppCompatActivity {

    TextView poivronDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poivron);

        poivronDescriptionTextView = (TextView) findViewById(R.id.poivronDescriptionTextView);

        poivronDescriptionTextView.setText(Html.fromHtml(getString(R.string.poivrondescription)));
    }
}
