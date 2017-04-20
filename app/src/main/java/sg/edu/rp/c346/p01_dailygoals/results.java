package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class results extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView tv1 = (TextView)findViewById(R.id.tv1);
        TextView tv2 = (TextView)findViewById(R.id.tv2);
        TextView tv3 = (TextView)findViewById(R.id.tv3);
        TextView tv4 = (TextView)findViewById(R.id.tv4);

        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] ans = i.getStringArrayExtra("ans");
        // Display the name and age on the TextView

        tv1.setText("Read up on materials before class: " + ans[0]);
        tv2.setText("Arrive on time so as to not miss an important part of the lesson: "+ ans[1]);
        tv3.setText("Attempt the problem myself: "+ ans[2]);
        tv4.setText("My personal reflection"+ ans[3]);

    }
}
