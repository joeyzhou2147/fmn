package gai.forgetmenot.Activities;

/**
 * Created by Ajit on 2/25/2018.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import gai.forgetmenot.Helpers.MedicalInfoHelper;
import gai.forgetmenot.R;

public class MedicalActivity extends AppCompatActivity {

    MedicalInfoHelper sqdb;
    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        final TextView MedicalInfo = (TextView) findViewById(R.id.MedicalInfo);
        MedicalInfoHelper sqldb = new MedicalInfoHelper(this);
    }
}
