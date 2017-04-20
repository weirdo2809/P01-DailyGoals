package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    String[] ans;
    String opt1, opt2, opt3, opt4;
    Boolean go;
    RadioGroup rg1, rg2, rg3;
    RadioButton yes1, yes2, yes3, no1, no2, no3;
    int selected1, selected2, selected3;
    EditText etRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        yes1 = (RadioButton) findViewById(R.id.yes1);
        yes2 = (RadioButton) findViewById(R.id.yes2);
        yes3 = (RadioButton) findViewById(R.id.yes3);
        no1 = (RadioButton) findViewById(R.id.no1);
        no2 = (RadioButton) findViewById(R.id.no2);
        no3 = (RadioButton) findViewById(R.id.no3);
        etRef = (EditText) findViewById(R.id.etRef);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg1 = (RadioGroup) findViewById(R.id.rg1);
                rg2 = (RadioGroup) findViewById(R.id.rg2);
                rg3 = (RadioGroup) findViewById(R.id.rg3);

                selected1 = rg1.getCheckedRadioButtonId();
                selected2 = rg2.getCheckedRadioButtonId();
                selected3 = rg3.getCheckedRadioButtonId();

                RadioButton qns1 = (RadioButton) findViewById(selected1);
                RadioButton qns2 = (RadioButton) findViewById(selected2);
                RadioButton qns3 = (RadioButton) findViewById(selected3);


                String ans1 = qns1.getText().toString();
                String ans2 = qns2.getText().toString();
                String ans3 = qns3.getText().toString();
                String ans4 = etRef.getText().toString();

                ans = new String[]{ans1, ans2, ans3, ans4};
                for (int i = 0; i < ans.length; i++) {
                    if (ans[i] != null) {
                        go = true;
                    } else {
                        go = false;
                        break;
                    }
                }
                Intent i = new Intent(MainActivity.this,
                        results.class);

                if (go == true) {
                    i.putExtra("ans", ans);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Please answer every question", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void SaveArray(String key, String[] value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < value.length; i++) {
            editor.putString(key + String.valueOf(i), value[i]);
        }
        editor.putInt("length", value.length);

        editor.commit();
    }

    private String[] retrieveArray(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        int size = sharedPreferences.getInt("value", 0);
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sharedPreferences.getString(key + String.valueOf(i), null);
        }

        return arr;
    }

   /* @Override
    protected void onPause() {
        super.onPause();
        SaveArray("ans", ans);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String[] dude = retrieveArray("ans");
        opt1 = dude[0];
        opt2 = dude[1];
        opt3 = dude[2];
        opt4 = dude[3];
        if (opt1 == "yes") {
            rg1.check(R.id.yes1);
        } else if (opt1 == "no") {
            rg1.check(R.id.no1);
        }
        if (opt2 == "yes") {
            rg2.check(R.id.yes2);
        } else if (opt2 == "no") {
            rg2.check(R.id.no2);
        }
        if (opt3 == "yes") {
            rg3.check(R.id.yes3);
        } else if (opt3 == "no") {
            rg3.check(R.id.no3);
        }
        etRef.setText(opt4);
    }*/
}
