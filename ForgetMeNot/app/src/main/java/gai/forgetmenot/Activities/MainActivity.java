package gai.forgetmenot.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gai.forgetmenot.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void meButton (View v)
    {
        Button button = (Button) v;
        Intent intent = new Intent(this, PrescriptionActivity.class);
        v.findViewById(R.id.me);
        startActivity(intent);
    }
    
}
