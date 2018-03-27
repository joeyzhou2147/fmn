package gai.forgetmenot.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import gai.forgetmenot.R;

public class splashpage extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashpage);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(splashpage.this, LoginActivity.class );
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}
