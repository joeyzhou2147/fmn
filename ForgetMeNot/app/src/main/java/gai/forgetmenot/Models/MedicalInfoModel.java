package gai.forgetmenot.Models;

import android.location.Address;
import android.os.Parcelable;
import android.os.Parcel;

import java.util.Locale;

/**
 * Created by Ajit on 2/25/2018.
 */

public class MedicalInfoModel implements Parcelable {
    private int doctor_phonenumber, doctor_zip, street_apt_num;
    private String medical_id, doctor_name, doctor_address_street, doctor_address_city, doctor_state, user_id;
    private Address doctor_address;


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
        doctor_address = new Address(new Locale("en","US"));
        doctor_address.setPostalCode(String.valueOf(doctor_zip));
        doctor_address.setPhone(String.valueOf(doctor_phonenumber));
        doctor_address.setSubThoroughfare(doctor_address_street);
        doctor_address.setAddressLine(0,String.valueOf(street_apt_num));
    }

    public String getDoctorAddress() {
        String address=doctor_address_street+doctor_address_city+doctor_zip;
        return address;
    }

    public String getMedicalId(){return medical_id; }
    public String getUserId() { return user_id; }
    public String getDoctorName() { return doctor_name; }
    public String getDoctorStreet() {return doctor_address_street;}
    public int getStreetAptNum() {return street_apt_num;}
    public String getDoctorAddressCity() {return doctor_address_city;}
    public String getDoctorState() {return doctor_state;}
    public int getDoctorZip() {return doctor_zip;}
    public int getDoctorPhone() {return doctor_phonenumber;}


    public void setMedicalID(String id) {
        medical_id=id;
    }
    public void setDoctorZip(int id) {
        doctor_zip =id;
    }
    public void setDoctorPhone(int phone) {
        doctor_phonenumber= phone;
    }
    public void setDoctorAptNum(int aptNum) {
        this.street_apt_num = aptNum;
    }
    public void setDoctorName(String name) {
        doctor_name = name;
    }
    public void setDoctorStreet(String street) {
        doctor_address_street = street;
    }
    public void setDoctorCity(String city) {
        doctor_address_city = city;
    }


    public MedicalInfoModel(Parcel in){
        this.medical_id = in.readString();
        this.user_id = in.readString();
        this.doctor_name = in.readString();
        this.doctor_address_street = in.readString();
        this.street_apt_num = in.readInt();
        this.doctor_address_city = in.readString();
        this.doctor_state = in.readString();
        this.doctor_zip = in.readInt();
        this.doctor_phonenumber = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(medical_id);
        dest.writeString(user_id);
        dest.writeString(doctor_name);
        dest.writeString(doctor_address_street);
        dest.writeInt(this.street_apt_num);
        dest.writeString(doctor_address_city);
        dest.writeString(doctor_state);
        dest.writeInt(doctor_zip);
        dest.writeInt(doctor_phonenumber);
    }

    public static final Parcelable.Creator<MedicalInfoModel> CREATOR = new Parcelable.Creator<MedicalInfoModel>() {

        @Override
        public MedicalInfoModel createFromParcel(Parcel source) {
            return new MedicalInfoModel(source);
        }

        @Override
        public MedicalInfoModel[] newArray(int size) {
            return new MedicalInfoModel[size];
        }
    };




}
