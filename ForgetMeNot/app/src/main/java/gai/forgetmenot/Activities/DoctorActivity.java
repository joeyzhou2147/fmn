package gai.forgetmenot.Activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import gai.forgetmenot.Models.MedicalInfoModel;
import gai.forgetmenot.R;


/**
 * Created by Ajit on 3/25/2018.
 */

public class DoctorActivity extends AppCompatActivity {

    EditText name,address, phone;
    Button submit;
    private MedicalInfoModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        name = findViewById(R.id.DoctorName);
        address = findViewById(R.id.DoctorAddress);
        phone = findViewById(R.id.DoctorPhoneNumber);

        model = getIntent().getParcelableExtra("MedicalModel");

        name.setText(model.getDoctorName());
        address.setText(model.getDoctorAddress());
        phone.setText(String.valueOf(model.getDoctorPhone()));
        submit = findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || address.getText().toString().isEmpty() || phone.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Name -  " + name.getText().toString() + " \n" + "Password -  " + address.getText().toString()
                            + " \n" + "Phone" + phone.getText().toString() + " \n", Toast.LENGTH_SHORT).show();
                    model.setDoctorName(name.getText().toString());
                    model.setDoctorPhone(Integer.parseInt(phone.getText().toString()));

                }
            }
        });



    }



}
