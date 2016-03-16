package com.example.sidemaster.convertdegrees;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton RBOne, RBTwo;
    TextView ShowResult;
    EditText EnterValue;
    Button ConvertNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RBOne = (RadioButton) findViewById(R.id.RBOne);
        RBTwo = (RadioButton) findViewById(R.id.RBTwo);
        ShowResult = (TextView) findViewById(R.id.ShowResult);
        RBTwo.setChecked(true);

        ConvertNow = (Button) findViewById(R.id.ConvertNow);
        ConvertNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EnterValue = (EditText) findViewById(R.id.EnterValue);

                if (EnterValue.getText().toString().isEmpty()){
                    EnterValue.setError("Hey!, What's up here?");
                } else {

                    Double Value = Double.parseDouble(EnterValue.getText().toString());

                    if (RBOne.isChecked()){
                        ShowResult.setText(String.format("%.2f", ((Value - 32) * 5 / 9)) + "ºC");
                    } else if (RBTwo.isChecked()){
                        ShowResult.setText(String.format("%.2f", ((Value * 9) / 5 + 32)) + "ºF");
                    }
                }
            }
        });

    }

}
