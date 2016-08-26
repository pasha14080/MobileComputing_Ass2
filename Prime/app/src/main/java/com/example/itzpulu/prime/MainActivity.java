package com.example.itzpulu.prime;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView Text;
    private int RandomNumber = (int)(Math.random()*1000 + 1);
    private Button Hint,Cheat;
    private int Hint_flag=0,Cheat_flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text = (TextView) findViewById(R.id.Text);
        Hint = (Button) findViewById(R.id.Hint);
        Cheat = (Button) findViewById(R.id.Cheat);
        assert Text != null;
        if (savedInstanceState == null) {
            String RandomString = String.format(Locale.US, "%d", RandomNumber);
            Text.setText("Is " + RandomString + " a prime Number ?");
            Text.setTextColor(Color.parseColor("#FF000000"));
        }
        else
        {
            RandomNumber = savedInstanceState.getInt("RandomNumber");
            Cheat_flag = savedInstanceState.getInt("Cheat_flag");
            if (Cheat_flag==1)
            {
                Cheat.setEnabled(false);
            }
            Hint_flag= savedInstanceState.getInt("Hint_flag");
            if(Hint_flag==1)
            {
                Hint.setEnabled(false);
            }
            String RandomString = String.format(Locale.US, "%d", RandomNumber);
            Text.setText("Is " + RandomString + " a prime Number ?");
            Text.setTextColor(Color.parseColor("#FF000000"));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("RandomNumber", RandomNumber);
        savedInstanceState.putInt("Cheat_flag", Cheat_flag);
        savedInstanceState.putInt("Hint_flag",Hint_flag);
        super.onSaveInstanceState(savedInstanceState);
    }
    private int check_Prime() {
        for (int NumberToDivide = 2; NumberToDivide < RandomNumber; NumberToDivide++) {
            if (RandomNumber % NumberToDivide == 0) {
                return 0;
            }
        }
        return 1;
    }

    public void ChangeText(View view) {
        RandomNumber = (int)(Math.random()*1000 + 1);
        String RandomString = String.format(Locale.US, "%d", RandomNumber);
        Text.setText("Is " + RandomString + " a prime Number ?");
        Hint.setEnabled(true);
        Hint_flag=0;
        Cheat_flag=0;
        Cheat.setEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.Quit:
                finish();
                break;
            default:
                break;
        }

        return true;
    }
    public void check_incorrectness(View view) {
        if(check_Prime()==1)
        {
            Toast.makeText(this, "Your answer is wrong! ", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Your answer is right!", Toast.LENGTH_LONG).show();
        }
    }

    public void check_Correctness(View view) {
        if(check_Prime()==1)
        {
            Toast.makeText(this, "Your answer is correct! ", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Your answer is wrong!", Toast.LENGTH_LONG).show();
        }
    }
    private final int code_hint=1;
    private final int code_cheat=2;
    public void OnHint(View view)
    {
        Intent intent = new Intent(MainActivity.this,Hint.class);
        startActivityForResult(intent,code_hint);
    }

    public void OnCheat(View view)
    {
        Intent intent = new Intent(MainActivity.this, Cheat.class);
        intent.putExtra("Prime",RandomNumber);
        int answer = check_Prime();
        intent.putExtra("Answer",answer);
        startActivityForResult(intent,code_cheat);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(requestCode==code_hint)
        {
            if(resultCode==RESULT_OK)
            {
                Hint_flag=1;
                Toast.makeText(this, "Hint Taken! ", Toast.LENGTH_LONG).show();
                Hint.setEnabled(false);
            }
        }
        if(requestCode==code_cheat)
        {
            if(resultCode==RESULT_OK)
            {
                Cheat_flag=1;
                Toast.makeText(this, "Cheat taken! ", Toast.LENGTH_LONG).show();
                Cheat.setEnabled(false);
            }
        }
    }
}
