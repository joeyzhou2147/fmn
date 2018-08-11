package gai.forgetmenot.Models;

public class Contact {
    String contact_id;
    private String	contact_name;
    private String	contact_relation;
    private String	user_id;
    private int contact_birthmonth;
    private int	contact_birthday;
    private int	contact_birthyear;
    private String	contact_additionalinfo;
    private int contact_phone;
    private int	contact_streetname;
    private int	contact_aptnumber;
    private String	contact_city;
    private String	contact_state;
    private int	contact_zipcode;

    public Contact(String contact_id,String contact_name,String contact_relation,String	user_id,int	contact_birthmonth,
                   int contact_birthday,int contact_birthyear, String contact_additionalinfo,int contact_phone,
                   int contact_streetname,int contact_aptnumber, String contact_city,String contact_state,int contact_zipcode) {
        this.contact_id=contact_id;
        this.contact_name = contact_name;
        this.contact_relation=contact_relation;
        this.user_id = user_id;
        this.contact_birthmonth=contact_birthmonth;
        this.contact_birthday=contact_birthday;
        this.contact_birthyear=contact_birthyear;
        this.contact_additionalinfo=contact_additionalinfo;
        this.contact_phone=contact_phone;
        this.contact_streetname=contact_streetname;
        this.contact_aptnumber=contact_aptnumber;
        this.contact_city=contact_city;
        this.contact_state=contact_state;
        this.contact_zipcode=contact_zipcode;
    }

    public String getContact_id() {
        return contact_id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getContact_relation() {
        return contact_relation;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getContact_birthmonth() {
        return contact_birthmonth;
    }

    public int getContact_birthday() {
        return contact_birthday;
    }

    public int getContact_birthyear() {
        return contact_birthyear;
    }

    public String getContact_additionalinfo() {
        return contact_additionalinfo;
    }

    public int getContact_phone() {
        return contact_phone;
    }

    public int getContact_streetname() {
        return contact_streetname;
    }

    public int getContact_aptnumber() {
        return contact_aptnumber;
    }

    public String getContact_city() {
        return contact_city;
    }

    public String getContact_state() {
        return contact_state;
    }

    public int getContact_zipcode() {
        return contact_zipcode;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public void setContact_relation(String contact_relation) {
        this.contact_relation = contact_relation;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setContact_birthmonth(int contact_birthmonth) {
        this.contact_birthmonth = contact_birthmonth;
    }

    public void setContact_birthday(int contact_birthday) {
        this.contact_birthday = contact_birthday;
    }

    public void setContact_birthyear(int contact_birthyear) {
        this.contact_birthyear = contact_birthyear;
    }

    public void setContact_additionalinfo(String contact_additionalinfo) {
        this.contact_additionalinfo = contact_additionalinfo;
    }

    public void setContact_phone(int contact_phone) {
        this.contact_phone = contact_phone;
    }

    public void setContact_streetname(int contact_streetname) {
        this.contact_streetname = contact_streetname;
    }

    public void setContact_aptnumber(int contact_aptnumber) {
        this.contact_aptnumber = contact_aptnumber;
    }

    public void setContact_city(String contact_city) {
        this.contact_city = contact_city;
    }

    public void setContact_state(String contact_state) {
        this.contact_state = contact_state;
    }

    public void setContact_zipcode(int contact_zipcode) {
        this.contact_zipcode = contact_zipcode;
    }
}
