package farm.modcom.joseph.simplestaticapp;

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
        //LOGIC
        Button dishes = findViewById(R.id.dishes);
        Button recipes = findViewById(R.id.recipes);
        Button drinks = findViewById(R.id.drinks);
        Button nutrition = findViewById(R.id.nutrition);
        Button diet = findViewById(R.id.diet);

        //set clicklisteners
        dishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: we create another page/Activity
                //Ho to create a new Activity
                //Right click on Java folder - New - Activity - Empty
                //Intents - links from one Activity to other
                Intent x  = new Intent(MainActivity.this, Dishes.class);
                startActivity(x);
            }
        });

        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //intent to recipes
                Intent x  = new Intent(MainActivity.this, Recipes.class);
                startActivity(x);

            }
        });

        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x  = new Intent(MainActivity.this, Nutrition.class);
                startActivity(x);
            }
        });












    }
}
