package com.example.itzpulu.prime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class Cheat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView Cheat_text,Cheat_Number;
        int Prime,Answer;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat_xml);
        Cheat_Number = (TextView) findViewById(R.id.Cheat_Number);
        Cheat_text = (TextView) findViewById(R.id.Cheat_text);
        assert Cheat_Number != null;
        assert Cheat_text != null;
        Bundle extras = getIntent().getExtras();
        Prime = extras.getInt("Prime");
        Answer = extras.getInt("Answer");
        String RandomString = String.format(Locale.US, "%d", Prime);
        Cheat_Number.setText(RandomString);
        if(Answer==1)
        {
            Cheat_text.setText("This is a Prime Number");
        }
        else
        {
            Cheat_text.setText("This is not a Prime Number");
        }
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
