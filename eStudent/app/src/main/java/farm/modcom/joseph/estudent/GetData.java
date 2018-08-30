package farm.modcom.joseph.estudent;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class GetData extends AppCompatActivity {

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        dialog = new ProgressDialog(GetData.this);
        dialog.setMax(100);
        dialog.setTitle("Loading...");
        dialog.setMessage("Loading your Data..");
        dialog.show();

        //we get data from oour online PHP
        final TextView data = findViewById(R.id.data);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();

        client.post("http://modkenya.com/joseph/search.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                dialog.dismiss();
                //responseBody has your data, convert to String
                String ourdata = new String(responseBody);
                //put the above string in textview
                data.setText(ourdata);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
              dialog.dismiss();
              data.setText("Error");
            }
        });















    }
}
