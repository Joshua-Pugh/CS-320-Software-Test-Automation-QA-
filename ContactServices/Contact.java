package com.ContactServices;

public class Contact {
    //Class variables
    private String contactId;
    private String contactFirstName;
    private String contactLastName;
    private String contactPhoneNumber;
    private String contactAddress;

    //Default constructor
    public Contact() {
        contactId = "";
        contactFirstName = "";
        contactLastName = "";
        contactPhoneNumber = "";
        contactAddress = "";
    }
    //Constructor with Args
    public Contact(String id, String fName, String lName, String phoneNumber, String address) {
        //Verify ID
        verifyID(id);
        //Set ID to value
        this.contactId = id;
        //Verify first name
        verifyFirstName(fName);
        //Set first name to value
        this.contactFirstName = fName;
        //Verify last name
        verifyLastName(lName);
        //Set last name to value
        this.contactLastName = lName;
        //Verify phone number
        verifyPhoneNumber(phoneNumber);
        //Set phone number to value
        this.contactPhoneNumber = phoneNumber;
        //Verify address
        verifyAddress(address);
        //Set address to value
        this.contactAddress = address;
    }

    //Getters
    public String GetID() {
        return contactId;
    }

    public String GetFirstName() {
        return contactFirstName;
    }

    public String GetLastName() {
        return contactLastName;
    }

    public String GetFullName() {
        return contactFirstName + " " + contactLastName;
    }

    public String GetPhoneNumber() {
        return contactPhoneNumber;
    }

    public String GetAddress() {
        return contactAddress;
    }

    //Setters
    void SetID(String id) {
        verifyID(id);
        this.contactId = id;
    }

    void SetFirstName(String fName) {
        verifyFirstName(fName);
        this.contactFirstName = fName;
    }
    void SetLastName(String lName) {
        verifyLastName(lName);
        this.contactLastName = lName;
    }
    void SetPhoneNumber(String phoneNumber) {
        verifyPhoneNumber(phoneNumber);
        this.contactPhoneNumber = phoneNumber;
    }

    void SetAddress(String address) {
        verifyAddress(address);
        this.contactAddress = address;
    }

    //Methods used to verify input strings.
    void verifyID(String t_id)  {
        //Check required conditions
        //Also check if string is only numbers and not empty
        if (t_id == null || t_id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        else if (!isNumeric(t_id)) {
            throw new IllegalArgumentException("ID must be numeric.");
        }
        else if (t_id.length() > 10) {
            throw new IllegalArgumentException("ID cannot be longer then 10 digits");
        }
    }
    void verifyFirstName(String fName) {
        //Check required conditions
        //Also check if string is only letters and not empty
        if (fName == null || fName.isEmpty()) {
            throw new IllegalArgumentException("First Name cannot be null or empty.");
        }
        if (!isAlpha(fName)) {
            throw new IllegalArgumentException("First Name must only contain characters.");
        }
        else if (fName.length() > 10) {
            throw new IllegalArgumentException("First Name cannot be longer than 10 characters.");
        }
    }

    void verifyLastName(String lName) {
        //Check required conditions
        //Also check if string is only letters and not empty
        if (lName == null || lName.isEmpty()) {
            throw new IllegalArgumentException("Last Name cannot be null or empty.");
        }
        if (!isAlpha(lName)) {
            throw new IllegalArgumentException("Last Name must only contain characters.");
        }
        else if (lName.length() > 10) {
            throw new IllegalArgumentException("Last Name cannot be longer than 10 characters.");
        }
    }

    void verifyPhoneNumber(String phoneNum) {
        //Check required conditions
        //Also check if string is only numbers and not empty
        if (phoneNum == null || phoneNum.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }
        else if (!isNumeric(phoneNum)) {
            throw new IllegalArgumentException("Phone number must only contain digits.");
        }
        else if (phoneNum.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits in length.");
        }
    }

    void verifyAddress(String address) {
        //Check required conditions
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        else if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be greater than 30 characters.");
        }
    }
    //Used to check is a String contains only numbers
    //Code derived from GeeksForGeeks: How to check if string contains only digits in Java
    //https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
    boolean isNumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) < '0' || string.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    //Used to check is a String contains only letters
    //Code derived from GeeksForGeeks: Check if a string contains only alphabets in Java
    //https://www.geeksforgeeks.org/check-if-a-string-contains-only-alphabets-in-java/
    boolean isAlpha(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}