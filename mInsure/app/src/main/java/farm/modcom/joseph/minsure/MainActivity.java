package farm.modcom.joseph.minsure;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LIST LOGIC

        ListView mylist = findViewById(R.id.mylist);
       //create an array of insurance companies
        String[] items = {"Jubilee","APA", "UAP","Britam","Heritage","Fidelity",
                "Amaco","Orient","Madison","ICEA LION"};

        //Adapter
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        //since the adpater has the items and the design, add it to the list
        mylist.setAdapter(aa);//DONE
        //ADD A LIST ITEMS LISTENER
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //the position-(int) holds the clicked item position
                //i.e Jubilee is zero, APA is 1
                  Intent x  = new Intent(MainActivity.this,
                          Info.class);
                  //we carry the position you picked to info Activity
                  Bundle b = new Bundle();
                  b.putInt("key", position); //key holds the posiiton
                  //add your bundle to your intent
                 x.putExtras(b);
                 startActivity(x);

            }
        });

    }
}
