package gai.forgetmenot.Activities;

/**
 * Created by Ajit on 3/25/2018.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gai.forgetmenot.Helpers.PrescriptionHelper;
import gai.forgetmenot.Models.Prescription;
import gai.forgetmenot.R;


public class PrescriptionActivity extends AppCompatActivity implements AddPrescriptionFragment.OnInputListener{


    private PrescriptionHelper sqdb;
    Toolbar toolbar;
    private RecyclerViewAdapter adapter;
    private  ArrayList<Prescription> prescriptions;
    private String medicalId;
    @Override
    public void sendInput(String name,String dosage, String prescription_date,String prescription_consistency, String side_effects) {
        Prescription newPrescription = new Prescription(name,medicalId,prescription_date,prescription_consistency,dosage, side_effects);
        sqdb.addPrescription(newPrescription);
        prescriptions.add(newPrescription);
        adapter.notifyItemChanged(prescriptions.size()-1);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        sqdb = new PrescriptionHelper(this);
        //sqdb.onUpgrade(sqdb.getReadableDatabase(),1,2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("TITLE", toolbar.getTitle().toString());
        medicalId = getIntent().getExtras().getString("MedicalID");

        //intializeTestValues();
        prescriptions = sqdb.getAllRecords(medicalId);
        RecyclerView recyclerView = findViewById(R.id.prescriptionlist);
        adapter = new RecyclerViewAdapter(this, prescriptions);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.prescription_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if(res_id==R.id.AddPrescription) {
            AddPrescriptionFragment dialog = new AddPrescriptionFragment();
            dialog.show(getFragmentManager(),"AddPrescriptionDialog");
        }
        return true;
    }



    private void intializeTestValues() {
        sqdb.addPrescription(new Prescription("245345","RogueOne",
                "December 2016","Every two weeks",
                "30 pounds","vomiting"));
        sqdb.addPrescription(new Prescription("sdfsdfsdfd","RogueOne",
                "December 2016","Every 8 weeks",
                "30 pounds","vomiting"));
        sqdb.addPrescription(new Prescription("afdsdfsdf","ANewHope",
                "1977","Every 2332 weeks",
                "30 pounds","vomiting"));
        sqdb.addPrescription(new Prescription("sjdnfsjdnfsjdfn","ANewHope",
                "2008","Every 3 weeks",
                "30 pounds","vomiting"));
    }


}

