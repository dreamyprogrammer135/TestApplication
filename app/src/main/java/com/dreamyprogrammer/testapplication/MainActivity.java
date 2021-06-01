package com.dreamyprogrammer.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public EditText editText;
    public static final String CALC_DATA = "calcData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        editText = findViewById(R.id.eText);

        button.setOnClickListener(v -> {
            Intent runCalc = new Intent("com.freecalc");
            ActivityInfo activityInfo =
                    runCalc.resolveActivityInfo(getPackageManager(),
                            runCalc.getFlags());
            if (activityInfo != null) {
                runCalc.putExtra(CALC_DATA, editText.getText().toString());
                startActivity(runCalc);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        R.string.not_program, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}