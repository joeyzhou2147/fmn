package gai.forgetmenot.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gai.forgetmenot.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button openMe, openEvent, openTrust, openMedical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openMe = (Button)this.findViewById(R.id.openMe);
        openMe.setOnClickListener(this);
        openEvent = (Button)this.findViewById(R.id.openEvent);
        openEvent.setOnClickListener(this);
        openTrust = (Button)this.findViewById(R.id.openTrust);
        openTrust.setOnClickListener(this);
        openMedical = (Button)this.findViewById(R.id.openMedical);
        openMedical.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case (R.id.openEvent):
                intent = new Intent(this,Events.class);
                startActivity(intent);
                break;
            case (R.id.openMe):
                intent = new Intent(this,MeActivity.class);
                startActivity(intent);
                break;
            case (R.id.openMedical):
                intent = new Intent(this,MedicalActivity.class);
                startActivity(intent);
                break;
        }
    }


    
}
