package farm.modcom.joseph.simplestaticapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        WebView webdishes= findViewById(R.id.webrecipes);
        //load html content to your webview
        webdishes.loadUrl("file:///android_asset/recipes.html");
    }
}
