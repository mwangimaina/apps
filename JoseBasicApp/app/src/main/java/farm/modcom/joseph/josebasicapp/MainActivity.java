package farm.modcom.joseph.josebasicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //lik java button to XML button
        Button foods = findViewById(R.id.foods);
        Button exercise = findViewById(R.id.exercise);
        Button tips = findViewById(R.id.tips);
        Button nutrition = findViewById(R.id.nutrition);
        Button tracker = findViewById(R.id.tracker);

       //make button food listen
       foods.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Create a Foods page
               Intent x = new Intent(MainActivity.this,
                       Foods.class);
               startActivity(x);
           }
       });

        //make button exercise listen
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a Foods page
                Intent x = new Intent(MainActivity.this,
                        Exercises.class);
                startActivity(x);
            }
        });


        //make button exercise listen
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a Foods page
                Intent x = new Intent(MainActivity.this,
                        Tips.class);
                startActivity(x);
            }
        });



        //make button exercise listen
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a Foods page
                Intent x = new Intent(MainActivity.this,
                        Nutrition.class);
                startActivity(x);
            }
        });
       //TODO: do the same for other buttons

    }
}
