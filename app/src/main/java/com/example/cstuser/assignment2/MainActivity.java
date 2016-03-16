package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    Button exitButton;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);

        // Initializing Buttons and listeners for them
        exitButton = (Button) this.findViewById(R.id.exitButton);
        continueButton = (Button) this.findViewById(R.id.continueButton);

        exitButton.setOnClickListener(this);
        continueButton.setOnClickListener(this);

        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent("com.example.cstuser.assignment2.PickInvestorAct");
                startActivityForResult(i, 1);
            }
        }, 3000);
    }

    //Code for returning results through data from Activity 2
    public void onActivityResult(int requestCode, int resultCode, Intent data)   {
        if ((requestCode == 1) && (resultCode == RESULT_OK))   { //AFTER INVESTORS ARE CHOSEN AND RETURN TO MAINACTIVITY
            Toast.makeText(this,data.getData().toString(), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No investors chosen, bye!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == exitButton.getId()){
            finish();
        }
        else if (v.getId() == continueButton.getId()){
            Intent i = new Intent("com.example.cstuser.assignment2.PickCompTransAct");

            // TO CREATE METHOD TO CHECK SELECTED INVESTORS
            Bundle investor = new Bundle();
            investor.putString("investor1", "tony");
            investor.putString("investor2", "maria");
            i.putExtras(investor);
           startActivityForResult(i, 1);
        }
    }
}

