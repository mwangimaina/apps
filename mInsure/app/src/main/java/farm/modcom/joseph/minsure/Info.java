package farm.modcom.joseph.minsure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        WebView webinfo  = findViewById(R.id.webinfo);
        //check the position in bundle
        Bundle b = getIntent().getExtras();//recieve bundle
        int position = b.getInt("key");
        //above, use the key used in MainActivity to access the position
        if (position==0){
            webinfo.loadUrl("file:///android_asset/jubilee.html");
        }

        if (position==1){
            webinfo.loadUrl("file:///android_asset/apa.html");
        }

        if (position==2){
            webinfo.loadUrl("file:///android_asset/uap.html");
        }

        if (position==3){
            webinfo.loadUrl("file:///android_asset/britam.html");
        }


    }//end
}//end
