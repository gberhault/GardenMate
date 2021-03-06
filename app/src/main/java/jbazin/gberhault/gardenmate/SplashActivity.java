////////////////////////////////////////////////////////////////////////////////
// Copyright (c) Guillaume Berhault and Jerome Bazin since 2017.
////////////////////////////////////////////////////////////////////////////////

package jbazin.gberhault.gardenmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashBackgroundProcessDone();
            }
        }, 1);
    }

    private void splashBackgroundProcessDone() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_enter_new, R.anim.zoom_exit_actual);
        finish();
    }
}
