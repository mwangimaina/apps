package farm.modcom.joseph.josephdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        WebView webblues = findViewById(R.id.webrecipe);
        webblues.loadUrl("file:///android_asset/recipes.html");
        //create assests folder.  Right click on the app
        //NEW - FOLDER - assetfolder
    }
}
