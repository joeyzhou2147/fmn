package gai.forgetmenot.Activities;

import android.util.Log;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gai.forgetmenot.Activities.HomeActivity;
import gai.forgetmenot.R;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signin (View v)
    {
        Log.d("DEBUG 1", "FIRST SIGN IN");
        Button button = (Button) v;
        Intent intent = new Intent(this, gai.forgetmenot.Activities.MainActivity.class);
        Intent intent123 = new Intent(this, gai.forgetmenot.Activities.MedicalActivity.class);
        v.findViewById(R.id.signin);
        Log.d("DEBUG 2", "Entering Medical acitivty");


        startActivity(intent123);
        Log.d("DEBUG 4", "After Start acitivty");

    }


}
