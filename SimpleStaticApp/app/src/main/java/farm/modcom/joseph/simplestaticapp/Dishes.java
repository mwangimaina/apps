package farm.modcom.joseph.simplestaticapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Dishes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        WebView webdishes= findViewById(R.id.webdishes);
        //load html content to your webview
        webdishes.loadUrl("file:///android_asset/dishes.html");
        //How to create an assets folder
        //Right click on your app - New - Folder - Assets Folder - Finish


    }
}
