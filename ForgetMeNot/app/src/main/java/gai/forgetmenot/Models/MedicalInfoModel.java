package gai.forgetmenot.Models;

/**
 * Created by Ajit on 2/25/2018.
 */

public class MedicalInfoModel {
    private int doctor_phonenumber, doctor_zip, street_apt_num;
    private String medical_id, doctor_name, doctor_address_street, doctor_address_city, doctor_state, user_id;


    public MedicalInfoModel(String medical_id,String user_id,String doctor_name,String doctor_address_street,
                            int street_apt_num,String doctor_address_city,String doctor_state,int doctor_zip,int doctor_phonenumber) {

        this.medical_id = medical_id;
        this.user_id = user_id;
        this.doctor_name = doctor_name;
        this.doctor_address_street = doctor_address_street;
        this.street_apt_num = street_apt_num;
        this.doctor_address_city = doctor_address_city;
        this.doctor_state = doctor_state;
        this.doctor_zip = doctor_zip;
        this.doctor_phonenumber = doctor_phonenumber;
    }

    public String getDoctorAddress() {
        String address=doctor_address_street+doctor_address_city+doctor_zip;
        return address;
    }

    public String getMedical_id(){return medical_id; }
    public String getUser_id() { return user_id; }
    public String getDoctor_name() { return doctor_name; }
    public String getDoctor_address_street() {return doctor_address_street;}
    public int getStreet_apt_num() {return street_apt_num;}
    public String getDoctor_address_city() {return doctor_address_city;}
    public String getDoctor_state() {return doctor_state;}
    public int getDoctor_zip() {return doctor_zip;}
    public int getDoctor_phonenumber() {return doctor_phonenumber;}


    public void setMedicalID(String id) {
        medical_id=id;
    }
    public void setDoctor_address_zip(int id) {
        doctor_zip =id;
    }
    public void setDoctor_phone_number(int phone) {
        doctor_phonenumber= phone;
    }
    public void setDoctorAptNum(int aptNum) {
        this.street_apt_num = aptNum;
    }
    public void setDoctor_name(String name) {
        doctor_name = name;
    }
    public void setDoctor_address_street(String street) {
        doctor_address_street = street;
    }
    public void setDoctor_address_city(String city) {
        doctor_address_city = city;
    }






}
