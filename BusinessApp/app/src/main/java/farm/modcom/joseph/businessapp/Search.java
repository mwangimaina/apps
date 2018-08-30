package farm.modcom.joseph.businessapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final EditText searchname = findViewById(R.id.searchname);
        Button search = findViewById(R.id.search);
        final TextView results = findViewById(R.id.results);
        //STOP

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Search LOGIC

                SQLiteDatabase db = openOrCreateDatabase("bizdb", MODE_PRIVATE,
                        null);

                String ename = searchname.getText().toString();
                //we create a cursor object to hold rows found in table
                Cursor c  = db.rawQuery("SELECT * FROM biztbl WHERE name = '"+ename+"' ",
                        null);
                //cursor can have 0, 1 or many rows
                if (c.getCount()==0)
                {
                    results.setText("No Member Found. Try Again");
                }

                else {
                    results.setText("");//make textview empty
                    while(c.moveToNext()){
                        //get record for 1st row
                        results.append("Names : "+c.getString(0));
                        results.append("\n");
                        results.append("Phone : "+c.getString(1));
                        results.append("\n");
                        results.append("Message : "+c.getString(2));
                        results.append("\n\n"); //2 spaces as you move next record
                    }
                }//close else

            }
        });//END

    }
}
