package farm.modcom.joseph.josephdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Dishes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);
        WebView webblues = findViewById(R.id.webdishes);
        webblues.loadUrl("file:///android_asset/dishes.html");
        //create  reggae.html in assets
    }
}
