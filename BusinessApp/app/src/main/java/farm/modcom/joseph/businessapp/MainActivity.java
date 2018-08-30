package farm.modcom.joseph.businessapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText name = findViewById(R.id.name);
        final EditText phone = findViewById(R.id.phone);
        final EditText desc = findViewById(R.id.desc);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Save
                //SQLite database is a built in ANdroid Database
                //Apps Using SQLite are Contacts, Messages, WhatsApp, Facebook,
                //Note taking Apps, etc, Google Maps, research Apps - offline
                SQLiteDatabase db = openOrCreateDatabase("bizdb", MODE_PRIVATE,
                        null);

                db.execSQL("CREATE TABLE IF NOT EXISTS biztbl(name TEXT(20), phone VARCHAR(14), description TEXT(100));");

                //insert your records
                String rname = name.getText().toString();
                String rphone = phone.getText().toString();
                String rdesc = desc.getText().toString();

                db.execSQL("INSERT INTO biztbl(name,phone,description) VALUES('"+rname+"','"+rphone+"','"+rdesc+"');");


                Toast.makeText(MainActivity.this, "Successfully Saved!",
                        Toast.LENGTH_SHORT).show();//END
                //CLEAR
                name.setText("");    phone.setText("");  desc.setText("");


            }
        });








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this, Search.class);
                startActivity(x);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
