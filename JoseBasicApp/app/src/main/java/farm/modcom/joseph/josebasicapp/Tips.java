package farm.modcom.joseph.josebasicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        WebView webfoods = findViewById(R.id.webtips);
        //load HTML file in your webview
        webfoods.loadUrl("file:///android_asset/tips.html");
       //Got to assets: right click, New File - tips.html

    }
}
