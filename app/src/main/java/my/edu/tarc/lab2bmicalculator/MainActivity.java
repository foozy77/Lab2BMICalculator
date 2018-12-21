package my.edu.tarc.lab2bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    public static final String TAG_MESSAGE = "my.edu.tarc.lab2bmicalculator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link UI to program
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
    }

    public void calculateBMI(View view)
    {
        double m, kg;
        Intent intent = new Intent(this, SecondActivity.class);
        if(TextUtils.isEmpty(height.getText()))
        {
            height.setError("Please enter your height");
        }
        else if(TextUtils.isEmpty(weight.getText()))
        {
            weight.setError("Please enter your weight");
        }

        m = Double.parseDouble(height.getText().toString());
        kg = Double.parseDouble(weight.getText().toString());

        double bmi = kg / (m*m);

        intent.putExtra("bmi", bmi);
        startActivity(intent);

    }

}
