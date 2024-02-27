package com.ContactServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    String ID = "1986457802";
    String fName = "Chris";
    String lName = "Cooper";
    String phoneNum = "5559876754";
    String address = "2 Mill Road, Dallas, TX";
    String invalidID = "190876567656";
    String IDWithLetters = "ad34234";
    String invalidFName = "JollyOldStNick";
    String fNameWithNumbers = "John23";
    String invalidLName = "FrostyTheSnowman";
    String lNameWithNumbers = "Smith43";
    String invalidPhoneNum = "55567643hg";
    String phoneNumToShort = "770998765";
    String invalidAddress = "887 Pennington Dr. Little Rock, AR";
    String nullID = null;
    String emptyID = "";
    String nullFName = null;
    String emptyFName = "";
    String nullLName = null;
    String emptyLName = "";
    String nullPhoneNum = null;
    String emptyPhoneNum = "";
    String nullAddress = null;
    String emptyAddress = "";

    @Test
    void default_Constructor_Should_Not_Be_Null() {
        Contact contact = new Contact();

        assertNotNull(contact.GetID());
        assertNotNull(contact.GetFirstName());
        assertNotNull(contact.GetLastName());
        assertNotNull(contact.GetPhoneNumber());
        assertNotNull(contact.GetAddress());
    }

    @Test
    void test_constructor_Args() {
        Contact contact = new Contact(ID, fName, lName, phoneNum, address);

        assertEquals(ID, contact.GetID());
        assertEquals(fName, contact.GetFirstName());
        assertEquals(lName, contact.GetLastName());
        assertEquals(phoneNum, contact.GetPhoneNumber());
        assertEquals(address, contact.GetAddress());

        //Test invalid values
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(invalidID, fName, lName, phoneNum, address));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(ID, invalidFName, lName, phoneNum, address));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(ID, fName, invalidLName, phoneNum, address));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(ID, fName, lName, invalidPhoneNum, address));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(ID, fName, lName, phoneNum, invalidAddress));
    }
    @Test
    void tes_set_Methods() {
        Contact contact = new Contact();

        contact.SetID(ID);
        contact.SetFirstName(fName);
        contact.SetLastName(lName);
        contact.SetPhoneNumber(phoneNum);
        contact.SetAddress(address);

        assertEquals(ID, contact.GetID());
        assertEquals(fName, contact.GetFirstName());
        assertEquals(lName, contact.GetLastName());
        assertEquals(phoneNum, contact.GetPhoneNumber());
        assertEquals(address, contact.GetAddress());

        //Test invalid values
        //ID
        assertThrows(IllegalArgumentException.class, () -> contact.SetID(invalidID));
        assertThrows(IllegalArgumentException.class, () -> contact.SetID(IDWithLetters));
        assertThrows(IllegalArgumentException.class, () -> contact.SetID(nullID));
        assertThrows(IllegalArgumentException.class, () -> contact.SetID(emptyID));
        //First Name
        assertThrows(IllegalArgumentException.class, () -> contact.SetFirstName(invalidFName));
        assertThrows(IllegalArgumentException.class, () -> contact.SetFirstName(nullFName));
        assertThrows(IllegalArgumentException.class, () -> contact.SetFirstName(emptyFName));
        assertThrows(IllegalArgumentException.class, () -> contact.SetFirstName(fNameWithNumbers));
        //Last Name
        assertThrows(IllegalArgumentException.class, () -> contact.SetLastName(invalidLName));
        assertThrows(IllegalArgumentException.class, () -> contact.SetLastName(lNameWithNumbers));
        assertThrows(IllegalArgumentException.class, () -> contact.SetLastName(nullLName));
        assertThrows(IllegalArgumentException.class, () -> contact.SetLastName(emptyLName));
        //Phone Number
        assertThrows(IllegalArgumentException.class, () -> contact.SetPhoneNumber(invalidPhoneNum));
        assertThrows(IllegalArgumentException.class, () -> contact.SetPhoneNumber(phoneNumToShort));
        assertThrows(IllegalArgumentException.class, () -> contact.SetPhoneNumber(nullPhoneNum));
        assertThrows(IllegalArgumentException.class, () -> contact.SetPhoneNumber(emptyPhoneNum));
        //Address
        assertThrows(IllegalArgumentException.class, () -> contact.SetAddress(invalidAddress));
        assertThrows(IllegalArgumentException.class, () -> contact.SetAddress(nullAddress));
        assertThrows(IllegalArgumentException.class, () -> contact.SetAddress(emptyAddress));
    }

    @Test
    void method_GetFullName_should_Return_First_Last() {
        Contact contact = new Contact();

        contact.SetFirstName(fName);
        contact.SetLastName(lName);

        assertEquals(fName + " " + lName, contact.GetFullName());
    }
}