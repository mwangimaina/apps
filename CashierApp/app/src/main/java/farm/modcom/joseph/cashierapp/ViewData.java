package farm.modcom.joseph.cashierapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.nio.channels.AsynchronousServerSocketChannel;

import cz.msebera.android.httpclient.Header;

public class ViewData extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        dialog = new ProgressDialog(ViewData.this);
        dialog.setMax(100);
        dialog.setTitle("Loading");
        dialog.setMessage("Retrieving Records from Server");
        dialog.show();
        final TextView data = findViewById(R.id.data);
        //as the dilog loads, start getting data
        AsyncHttpClient client= new AsyncHttpClient();
        RequestParams params = new RequestParams();
        //we don't have params, empty
        client.post("http://modkenya.com/joseph/view.php",
                params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        //we convert respose body to string
                        String ourdata = new String(responseBody);
                        data.setText(ourdata);
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        data.setText("There was an Error");
                        dialog.dismiss();
                    }
                });






    }
}
