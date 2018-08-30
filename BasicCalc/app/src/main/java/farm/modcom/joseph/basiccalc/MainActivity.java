package farm.modcom.joseph.basiccalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        final EditText editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        Button btnResult = (Button) findViewById(R.id.btnResult);
        final TextView textviewResult = (TextView) findViewById(R.id.textViewResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(editTextNum1.getText().toString());
                int num2 = Integer.parseInt(editTextNum2.getText().toString());
                int result = num1+num2;
                textviewResult.setText(result+"");
            }
        });



    }
}
