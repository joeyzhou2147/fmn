package gai.forgetmenot;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jadedh.myprofile.MyProfile;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signinbutton (View v)
    {
        Button button = (Button) v;
        Intent intent = new Intent(this, MyProfile.class);
        v.findViewById(R.id.signin);
        startActivity(intent);
    }
}
