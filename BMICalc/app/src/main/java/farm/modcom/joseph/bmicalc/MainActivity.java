package farm.modcom.joseph.bmicalc;

import android.content.Intent;
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
        //request R to give you ids
        //find your Views by ids
        final EditText editweight = findViewById(R.id.editweight);
        final EditText editheight = findViewById(R.id.editheight);
        Button buttonfind = findViewById(R.id.buttonfind);
        //set listener to above button
        Button proceed = findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: move to the next page
                //How to create a New Page/Activity
                //Right click on the Java Folder, then New -> Activity-> Empty Activity
                //Android Link - using Intents
                Intent x = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(x);//start the move to next activity
            }
        });//end


        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: move to the next page
                //How to create a New Page/Activity
                //Right click on the Java Folder, then New -> Activity-> Empty Activity
                //Android Link - using Intents
                Intent x = new Intent(MainActivity.this,
                        ThirdAcitivity.class);
                startActivity(x);//start the move to next activity
            }
        });//end








        //set listener to find button
        buttonfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do your Maths
                //get user input from edittexts and store them in a String
                String height = editheight.getText().toString();
                String weight = editweight.getText().toString();

                //convert to double
                double w = Double.parseDouble(weight);
                double h = Double.parseDouble(height);

                double answer = w/(h*h);
                Toast.makeText(MainActivity.this, "BMI is "+answer,
                        Toast.LENGTH_LONG).show();
                //clear texts
                editheight.setText("");
                editweight.setText("");

                if (answer< 30){
                    Toast.makeText(MainActivity.this, "Too Low",
                            Toast.LENGTH_LONG).show();
                }

                else if(answer>=30 && answer<40){
                    Toast.makeText(MainActivity.this, "Normal",
                            Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(MainActivity.this, "Too High",
                            Toast.LENGTH_LONG).show();
                }//end







            }
        });










    }
}
