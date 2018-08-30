package farm.modcom.joseph.josephbmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calc login goes here
        //find the 2 Editetxts and 1 button
        final EditText weight = findViewById(R.id.weight);
        final EditText height = findViewById(R.id.height);
        Button getbmi = findViewById(R.id.getbmi);

        //make button listen to clicks
        getbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Do maths
                //get texts from edittexts
                String inputweight = weight.getText().toString();
                String inputheight = height.getText().toString();

                //convert the 2 strings to double, multiply them
                double w = Double.parseDouble(inputweight);
                double h = Double.parseDouble(inputheight);

                double answer = w/(h*h);
                Toast.makeText(MainActivity.this, "BMI is"+answer,
                        Toast.LENGTH_LONG).show();


                if (answer> 20 && answer< 22){
                    Toast.makeText(MainActivity.this, "Normal",
                            Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(MainActivity.this, "Not normal",
                            Toast.LENGTH_LONG).show();
                }









            }
        });










    }
}
