package farm.modcom.joseph.josebasicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Foods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        WebView webfoods = findViewById(R.id.webfoods);
        //load HTML file in your webview
        webfoods.loadUrl("file:///android_asset/foods.html");

        //how to create foods.html
        //right on your app, New Folder - Assets Folder
        //Assets folder is cretaed in your app
        //Create a  hTML file named foods.html in that assets folder

    }
}
