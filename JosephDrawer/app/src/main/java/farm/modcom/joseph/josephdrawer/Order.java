package farm.modcom.joseph.josephdrawer;

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

public class Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        final EditText name = findViewById(R.id.name);
        final EditText item = findViewById(R.id.item);
        final EditText place = findViewById(R.id.place);
        final EditText phone = findViewById(R.id.phone);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save to online PHP we did
                //we use async http library added in Gradle
                AsyncHttpClient client = new AsyncHttpClient();
                //wew will use above to post our data to php
                RequestParams params = new RequestParams();
                params.add("name", name.getText().toString());
                params.add("item", item.getText().toString());
                params.add("place", place.getText().toString());
                params.add("phone", phone.getText().toString());

                //post above parameters to PHP
                //above names should match the one in php
                client.post("http://modkenya.com/yourfolder/insert.php",
                        params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                Toast.makeText(Order.this, "Saved Succesfully", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                Toast.makeText(Order.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        });//END
            }
        });



    }
}
