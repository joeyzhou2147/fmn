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
<<<<<<< HEAD:ForgetMeNot/app/src/main/java/gai/forgetmenot/LoginActivity.java
        Intent intent = new Intent(this, MainActivity.class);
=======
        Intent intent123 = new Intent(this, MedicalActivity.class);
>>>>>>> 3882bb087cd8be2b514c998620dd7604c95d2c2d:ForgetMeNot/app/src/main/java/gai/forgetmenot/Activities/LoginActivity.java
        v.findViewById(R.id.signin);
        Log.d("DEBUG 2", "Entering Medical acitivty");


        startActivity(intent123);
        Log.d("DEBUG 4", "After Start acitivty");

    }


}
