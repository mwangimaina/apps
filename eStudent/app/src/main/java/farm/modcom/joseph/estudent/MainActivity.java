package farm.modcom.joseph.estudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewrecord = findViewById(R.id.viewrecord);
        viewrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(MainActivity.this,
                        GetData.class);

                startActivity(x);
            }
        });




        final EditText adm = findViewById(R.id.adm);
        final EditText name = findViewById(R.id.name);
        final EditText course = findViewById(R.id.course);
        final EditText amount = findViewById(R.id.amount);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//save to online PHP we did
                //below client will send the data online
                AsyncHttpClient client = new AsyncHttpClient();
                //prepare what to send
                RequestParams params = new RequestParams();
                params.add("adm",adm.getText().toString());
                params.add("name",name.getText().toString());
                params.add("course",course.getText().toString());
                params.add("amount",amount.getText().toString());

                //use client to post paramters to PHP
                //below we post params to save.php
                client.post("http://modkenya.com/joseph/save.php", params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(MainActivity.this, "YES", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



    }
}
