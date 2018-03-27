package gai.forgetmenot.Activities;

/**
 * Created by Ajit on 2/25/2018.
 */

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import com.amitshekhar.DebugDB;

import gai.forgetmenot.Helpers.MedicalInfoHelper;
import gai.forgetmenot.Models.MedicalInfoModel;
import gai.forgetmenot.Models.Prescription;
import gai.forgetmenot.R;


public class MedicalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button openDoctorButton, openPrescriptionButton;
    private MedicalInfoHelper sqdb;
    private MedicalInfoModel model;
    private String medicalID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DEBUG 3", "MEDICAL ACTIVITY");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        final TextView MedicalInfo = (TextView) findViewById(R.id.MedicalInfo);

        sqdb = new MedicalInfoHelper(this);
        medicalID = "RogueOne";
        model = sqdb.getRecord("RogueOne");
        openDoctorButton = (Button)this.findViewById(R.id.openDoctor);
        openPrescriptionButton = (Button)this.findViewById(R.id.openPrescription);
        openDoctorButton.setOnClickListener(this);
        openPrescriptionButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Log.d("DEBUG 5", "onclick");
        Intent intent;
        switch (view.getId()) {
            case R.id.openDoctor:
                intent = new Intent(this,DoctorActivity.class);
                intent.putExtra("MedicalID",medicalID);
                startActivity(intent);
                break;
            case R.id.openPrescription:
                intent = new Intent(this,PrescriptionActivity.class);
                intent.putExtra("MedicalID",medicalID);
                startActivity(intent);
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            model = (MedicalInfoModel) data.getParcelableExtra("MedicalModel");
            sqdb.updateMedicalRecord(model);
        }
    }
}
