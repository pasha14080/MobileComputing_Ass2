package com.example.itzpulu.prime;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StarterActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_starter);
        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
        /* Duration of wait */
        int SPLASH_DISPLAY_LENGTH = 5000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(StarterActivity.this,MainActivity.class);
                StarterActivity.this.startActivity(mainIntent);
                StarterActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}