package farm.modcom.joseph.josebasicapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //logic : delay for 5 sec
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO
                Intent x = new Intent(Splash.this,
                        MainActivity.class);
                startActivity(x);
                finish();//kill splash
                //NB: MainAcitivity is the launcher, its the starting
                //make changes in AndroidManifest.xml
            }
        }, 5000);
    }
}
