package gai.forgetmenot.Activities;


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
        Button button = (Button) v;
        Intent intent = new Intent(this, HomeActivity.class);
        v.findViewById(R.id.signin);
        startActivity(intent);
    }


}
