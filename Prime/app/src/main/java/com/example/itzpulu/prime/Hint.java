package com.example.itzpulu.prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class Hint extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint_xml);
    }
    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent);
        finish();

    }
    /**
     * react to the user tapping the back/up icon in the action bar
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }


}
