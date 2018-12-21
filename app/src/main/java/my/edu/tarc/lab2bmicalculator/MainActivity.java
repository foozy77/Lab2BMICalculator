package my.edu.tarc.lab2bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText height, weight;
    public static final String TAG_MESSAGE = "my.edu.tarc.lab2intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Link UI to program
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
    }

    public double calculateBMI(View v)
    {
        double bmi =0;

        if(TextUtils.isEmpty(height.getText()))
        {
            height.setError("Please enter your height");
            return 0;
        }
        else if(TextUtils.isEmpty(weight.getText()))
        {
            height.setError("Please enter your weight");
            return 0;
        }
        double kg = Double.parseDouble(weight.getText().toString());
        double m = Double.parseDouble(height.getText().toString());
        bmi = kg / m*m;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_MESSAGE, bmi);
        startActivity(intent);

        return bmi;

    }

}
