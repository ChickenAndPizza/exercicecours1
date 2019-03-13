package com.example.a533.exercicecours1;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompare = findViewById(R.id.btnCompare);
        btnCompare.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                CompareTwoNumbers();
            }
        });
    }

    private void CompareTwoNumbers() {
        RestartColors();
        try {
            String firstText = ((TextView) findViewById(R.id.Nbr1)).getText().toString();
            String scndText = ((TextView) findViewById(R.id.Nbr2)).getText().toString();
            String nbr;

            if (Integer.parseInt(firstText) > Integer.parseInt(scndText)) {
                SetGreenTextView(((TextView) findViewById(R.id.Nbr1)));
                nbr = "Premier";
            } else if (Integer.parseInt(firstText) < Integer.parseInt(scndText)) {
                SetGreenTextView(((TextView) findViewById(R.id.Nbr2)));
                nbr = "Deuxième";
            } else {
                nbr = "Égaux";
                SetGreenTextView(((TextView) findViewById(R.id.Nbr1)));
                SetGreenTextView(((TextView) findViewById(R.id.Nbr2)));
            }
            ShowAlert(nbr);
        }
        catch(Error error) {
            ShowAlert("Une erreur est survenue");
        }
    }

    private void RestartColors() {
        ((TextView) findViewById(R.id.Nbr1)).setBackgroundColor(getResources().getColor(android.R.color.transparent));
        ((TextView) findViewById(R.id.Nbr2)).setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    private void SetGreenTextView(TextView tv) {
        tv.setBackgroundColor(getResources().getColor(R.color.greenTv));
    }

    private void ShowAlert(String message) {
        Toast.makeText(((Activity) this), message,
                Toast.LENGTH_LONG).show();
    }
}