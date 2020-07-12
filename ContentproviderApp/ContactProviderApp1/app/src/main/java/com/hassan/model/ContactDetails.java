package com.hassan.model;

public class ContactDetails {
    private String ContactID;
    private String ContactName;
    private String ContactNumber;
    private String ContactEmail;
    private String ContactPhoto;
    private String ContactOtherDetails;

    public ContactDetails(String contactID, String contactName, String contactNumber, String contactEmail, String contactPhoto, String contactOtherDetails) {
        ContactID = contactID;
        ContactName = contactName;
        ContactNumber = contactNumber;
        ContactEmail = contactEmail;
        ContactPhoto = contactPhoto;
        ContactOtherDetails = contactOtherDetails;
    }

    public String getContactID() {
        return ContactID;
    }

    public String getContactName() {
        return ContactName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public String getContactPhoto() {
        return ContactPhoto;
    }

    public String getContactOtherDetails() {
        return ContactOtherDetails;
    }
}
