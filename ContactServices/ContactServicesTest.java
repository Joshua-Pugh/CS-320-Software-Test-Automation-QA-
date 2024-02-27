package com.ContactServices;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class ContactServicesTest {
    //Values for test cases
    ContactServices services = new ContactServices();
    String ID = "1239876456";
    String UniqueID = services.createUniqueID();
    String fName = "Chris";
    String newFirstName = "John";
    String lName = "Cooper";
    String newLastName = "Homes";
    String phoneNum = "5559876754";
    String newPhoneNum = "7705553423";
    String address = "2 Mill Road, Dallas, TX";
    String newAddress = "554 Pine Dr, Florence SC.";
    Contact contact = new Contact(ID,fName,lName,phoneNum,address);
    int numContacts = 0;
    int selection = 1;
    Vector<Contact> list = new Vector<>();

    @Test
    void test_GetListMethod() {
        services.addContact(contact);
        list.add(contact);

        assertEquals(list, services.GetContactList());
    }
    @Test
    void test_GetNumContacts_Method() {
        assertEquals(numContacts, services.GetNumContacts());
    }
    @Test
    void test_Create_Random_ID() {
        assertNotNull(UniqueID);
        assertTrue(UniqueID.length() <= 10 && !UniqueID.isEmpty());
    }
    @Test
    void test_Create_Contact() {
        list = services.GetContactList();
        services.createNewContact(UniqueID,fName,lName,phoneNum,address);
        assertFalse(list.isEmpty());
    }
    @Test
    void test_Add_Contact() {
        list = services.GetContactList();
        services.addContact(contact);
        assertFalse(list.isEmpty());
    }
    @Test
    void test_deleteContact_With_Empty_list() {
        assertThrows(IllegalArgumentException.class,
                () -> services.deleteContact(ID));
    }
    @Test
    void test_deleteContact_With_Non_Empty_list() {
        list = services.GetContactList();
        services.addContact(contact);
        //Check with ID that is not in the list
        services.deleteContact(UniqueID);
        assertFalse(list.isEmpty());
        //Check with ID that is in the list
        services.deleteContact(ID);
        assertTrue(list.isEmpty());
    }
    @Test
    void test_UpdateContactInfo_With_Empty_List() {
        assertThrows(IllegalArgumentException.class,
                () -> services.updateContactInfo(ID,newFirstName,selection));
    }
    @Test
    void test_UpdateContactInfo_With_Non_Empty_List() {
        //For use in switch case
        //Valid selections
        int selection1 = 1;
        int selection2 = 2;
        int selection3 = 3;
        int selection4 = 4;

        //Invalid selections
        int invalidSelection = -1;
        int invalidSelection2 = 0;
        int invalidSelection3 = 5;

        //Make a new contact to add to the list
        services.addContact(contact);
        list = services.GetContactList();
        assertFalse(list.isEmpty());

        //Check with ID that is not in the list
        services.updateContactInfo(UniqueID,newFirstName,selection);
        assertFalse(list.contains(UniqueID));

        //Check with ID that is in the list
        //Check update first name selection
        services.updateContactInfo(ID,newFirstName,selection1);
        assertNotEquals(fName,contact.GetFirstName());

        //Check update last name selection
        services.updateContactInfo(ID,newLastName,selection2);
        assertNotEquals(lName, contact.GetLastName());

        //Check update phone number selection
        services.updateContactInfo(ID,newPhoneNum,selection3);
        assertNotEquals(phoneNum, contact.GetPhoneNumber());

        //Check update address selection
        services.updateContactInfo(ID, newAddress, selection4);
        assertNotEquals(address, contact.GetAddress());

        //Check throws IllegalArgumentException for negative value selection
        assertThrows(IllegalArgumentException.class,
                () -> services.updateContactInfo(ID,newFirstName,invalidSelection));
        //Check throws IllegalArgumentException for value of 0 selection
        assertThrows(IllegalArgumentException.class,
                () -> services.updateContactInfo(ID, newFirstName, invalidSelection2));

        //Check throws IllegalArgumentException for value > 4 selection
        assertThrows(IllegalArgumentException.class,
                () -> services.updateContactInfo(ID, newFirstName, invalidSelection3));
    }
    @Test
    void test_PrintList_Method() {
        services.addContact(contact);
        services.PrintContactList();

    }
}