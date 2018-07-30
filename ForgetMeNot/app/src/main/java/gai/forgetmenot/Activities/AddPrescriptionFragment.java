package gai.forgetmenot.Activities;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import gai.forgetmenot.R;

public class AddPrescriptionFragment extends DialogFragment {

    private final String TAG = "PRESCRIPTIONDIALOG";

    public interface OnInputListener {
        void sendInput(String prescription_name,String dosage, String prescription_date,String prescription_consistency, String side_effects);
    }

    private OnInputListener mOnInputListener;


    private EditText mName;
    private EditText mDosage;
    private EditText mFrequency;
    private EditText mDate;
    private EditText mSideEffects;

    private Button mActionOk;
    private Button mActionCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_prescription, container, false);
        mName = view.findViewById(R.id.editName);
        mDosage = view.findViewById(R.id.editDosage);
        mFrequency = view.findViewById(R.id.editFrequency);
        mDate = view.findViewById(R.id.editStartDate);
        mSideEffects = view.findViewById(R.id.editSideEffects);

        mActionCancel = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnInputListener.sendInput(mName.getText().toString(),mDosage.getText().toString(),  mDate.getText().toString(), mFrequency.getText().toString(),mSideEffects.getText().toString());
                getDialog().dismiss();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnInputListener = (OnInputListener) getActivity();
        } catch (ClassCastException e) {
            Log.e(TAG,"onAttatch: ClassException");
        }
    }
}
