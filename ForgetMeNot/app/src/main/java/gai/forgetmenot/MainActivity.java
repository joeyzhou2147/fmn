package gai.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jadedh.myprofile.MyProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void meButton (View v)
    {
        Button button = (Button) v;
        Intent intent = new Intent(this, gai.forgetmenot.me.MeActivity.class);
        v.findViewById(R.id.me);
        startActivity(intent);
    }

  public void trustButton (View v)
    {
        Button button = (Button) v;
        Intent intent = new Intent(this, gai.forgetmenot.trust.TrustActivity.class);
        v.findViewById(R.id.trust);
        startActivity(intent);
    }
}
