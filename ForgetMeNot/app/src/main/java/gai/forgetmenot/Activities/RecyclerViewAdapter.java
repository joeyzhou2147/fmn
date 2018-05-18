package gai.forgetmenot.Activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import gai.forgetmenot.Models.Prescription;
import gai.forgetmenot.R;

/**
 * Created by Ajit on 5/17/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PrescriptionViewHolder> {

    private ArrayList<Prescription> prescriptions = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
        mContext = context;
    }

    @Override
    public PrescriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        PrescriptionViewHolder holder = new PrescriptionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PrescriptionViewHolder holder, int position) {
        holder.prescription_amount.setText(prescriptions.get(position).getPrescriptionAmount());
        holder.prescription_frequency.setText(prescriptions.get(position).getPrescriptionConsistency());
        holder.prescription_when.setText(prescriptions.get(position).getPrescriptionWhen());
    }

    @Override
    public int getItemCount() {
        return prescriptions.size();
    }

    public class PrescriptionViewHolder extends RecyclerView.ViewHolder {
        TextView prescription_when;
        TextView prescription_frequency;
        TextView prescription_amount;
        public PrescriptionViewHolder(View view) {
            super(view);
            prescription_amount = view.findViewById(R.id.prescriptionDosage);
            prescription_frequency = view.findViewById(R.id.prescriptionFrequency);
            prescription_when = view.findViewById(R.id.prescriptionDate);
        }
    }

}
