package gai.forgetmenot.Activities;

/**
 * Created by Ajit on 3/25/2018.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import gai.forgetmenot.Helpers.PrescriptionHelper;
import gai.forgetmenot.Models.Prescription;
import gai.forgetmenot.R;


public class PrescriptionActivity extends AppCompatActivity {


    private PrescriptionHelper sqdb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        sqdb = new PrescriptionHelper(this);
        sqdb.onUpgrade(sqdb.getReadableDatabase(),1,2);

        intializeTestValues();
        ArrayList<Prescription> prescriptions = sqdb.getAllRecords("ANewHope");

        // total number of textviews to add
        final int N = prescriptions.size();
        final TextView[] myTextViews = new TextView[N]; // create an empty array;
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.ConstraintLayout);

        for (int i = 0; i < N; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setText(prescriptions.get(i).toString());

            //add the textview to the linearlayout
            constraintLayout.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }
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

