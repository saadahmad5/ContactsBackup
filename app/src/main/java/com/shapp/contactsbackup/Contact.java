package com.shapp.contactsbackup;

/**
 * Created by Saad Harris Ahmad on 002 Mar 27, 16.
 */
public class Contact {
    private String contactNumber;
    private String contactName;
    private String email;
//Contructor
    public Contact()
    {
        this.contactNumber = "Unknown";
        this.contactName = "Unknown";
        this.email="someone@domain.com";
    }
    public Contact(String contactNumber, String contactName,String email) {
        this.contactNumber = contactNumber;
        this.contactName = contactName;
        this.email=email;
    }
//Getter Setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
