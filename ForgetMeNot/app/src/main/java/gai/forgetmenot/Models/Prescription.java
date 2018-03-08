package gai.forgetmenot.Models;

/**
 * Created by Ajit on 3/4/2018.
 */

public class Prescription {

    private String prescription_id,medical_id,prescription_consistency,prescription_amount,prescription_sideefects, prescription_when;


    public Prescription(String prescription_id, String medical_id,String prescription_when,String prescription_consistency,String prescription_amount,String prescription_sideefects) {
        this.prescription_id = prescription_id;
        this.medical_id = medical_id;
        this.prescription_when = prescription_when;
        this.prescription_consistency = prescription_consistency;
        this.prescription_amount = prescription_amount;
        this.prescription_sideefects = prescription_sideefects;
    }

    public void setPrescriptionID(String prescription_id) {this.prescription_id = prescription_id;}
    public void setMedicalID(String medical_id) {this.medical_id = medical_id;}
    public void setPrescriptionConsistency(String prescription_consistency) {this.prescription_consistency = prescription_consistency;}
    public void setPrescriptionAmount(String prescription_amount) {this.prescription_amount = prescription_amount;}
    public void setPrescriptionSideEffects(String prescription_sideefects) {this.prescription_consistency = prescription_sideefects;}

    public String getPrescriptionID() {
        return prescription_id;
    }

    public String getMedicalID() {
        return medical_id;
    }

    public String getPrescriptionConsistency() {
        return prescription_consistency;
    }

    public String getPrescriptionAmount() {
        return prescription_amount;
    }

    public String getPrescriptionSideEffects() {
        return prescription_sideefects;
    }


    public String getPrescriptionWhen() {
        return prescription_when;
    }
}
