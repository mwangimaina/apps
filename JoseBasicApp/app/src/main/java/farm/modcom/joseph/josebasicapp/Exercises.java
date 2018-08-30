package farm.modcom.joseph.josebasicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        WebView webfoods = findViewById(R.id.webexercise);
        //load HTML file in your webview
        webfoods.loadUrl("file:///android_asset/exercises.html");
        //right click on assets - New - File create exercises.html
    }
}
