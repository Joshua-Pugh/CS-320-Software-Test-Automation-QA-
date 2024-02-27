package com.ContactServices;
import java.security.SecureRandom;
import java.util.*;

public class ContactServices {
    //Vector to hold contacts
    private final Vector<Contact> contactList = new Vector<>();
    //Int to track number of contacts created
    private int numContacts = 0;

    //Getters
    public int GetNumContacts() {
        return numContacts;
    }
    public Vector<Contact> GetContactList() {
        return contactList;
    }

    //Function to create a new uniqueID for each new contact
    public String createUniqueID() {
        //Use random to create a new contact ID
        SecureRandom random = new SecureRandom();
        long newID = random.nextLong(1000000000);

        //Send new ID to string
        String uniqueID = Long.toString(newID);

        //Display new ID
        System.out.println("New ID created: " + uniqueID);
        return uniqueID;
    }
    //Function to add new contact
    public void createNewContact(String id, String fName, String lName, String phoneNumber, String address) {
        //Create new contact with given args
        Contact newContact = new Contact(id, fName, lName, phoneNumber, address);

        //Increase amount of contacts created and added to the list
        numContacts++;
        contactList.add(newContact);

        //Display new contact ID
        System.out.println("Contact created with ID: " + newContact.GetID());
    }
    void addContact(Contact contact) {
        //Increase amount of contacts created and added to the list
        numContacts++;
        //Add new arg contact to the list
        contactList.add(contact);
        //Display conformation that contact was added
        System.out.println("Contact added to the list.");
    }
    //Function to delete contacts
    public void deleteContact(String id) {
        //If list is empty, no reason to try and search list
        if(contactList.isEmpty()) {
            throw new IllegalArgumentException("The contact list is empty");
        }
        //If list is not empty, find and remove contact with given ID
        int index = findContact(id);
        if (index >= 0) {
            contactList.remove(index);
            System.out.println("Contact removed");
        }
        //If contact not found, display not found
        else {
            System.out.println("Contact ID: " + id + " could not be found.");
        }
    }
    //Function to update contact info
    public void updateContactInfo(String id, String string, int selection) {
        //If list is empty, no reason to try and search list
        if(contactList.isEmpty()) {
            throw new IllegalArgumentException("The contact list is empty.");
        }
        //If list is not empty, find and update contact with given args
        Contact updateContact = new Contact();
        updateContact.verifyID(id);
        int index = findContact(id);

        //Verify index from find contact method == 0 or > 0 and not -1 which means contact not found
        if(index >= 0) {
            //Set updateContact to index of contact
            updateContact = contactList.get(index);
            //Use selection to update correct field within switch case
            switch (selection) {
                case 1:
                    updateContact.SetFirstName(string);
                    System.out.println("Contacts First name has been updated.");
                    break;
                case 2:
                    updateContact.SetLastName(string);
                    System.out.println("Contacts last name has been updated.");
                    break;
                case 3:
                    updateContact.SetPhoneNumber(string);
                    System.out.println("Contacts phone number has been updated.");
                    break;
                case 4:
                    updateContact.SetAddress(string);
                    System.out.println("Contacts address has been updated.");
                    break;
                    //Throw Exception if value not between 1-4
                default:
                    throw new IllegalArgumentException("Selection must be between 1-4.");
            }
        }
        //If index == -1 contact not found
        else {
            System.out.println("Contact ID: " + id + " could not be found.");
        }
    }
    //Method to find a contact within the list.
    private int findContact(String id) {
        //Set index to return -1 if contact not found
        int index = -1;
        //Find contact using ID
        for (Contact contact : contactList) {
            if (contact.GetID().equals(id)) {
                //Get and hold contacts index
                index = contactList.indexOf(contact);
                //Return index of contact
                return index;
            }
        }
        //If contact not found return -1
        return index;
    }
    //Function to print contact list
    public void PrintContactList() {
        System.out.println("Number of contacts: " + numContacts);
        for (Contact contact : contactList) {
            System.out.println("ID: " + contact.GetID());
            System.out.println("Name: " + contact.GetFullName());
            System.out.println("Phone Number: " + contact.GetPhoneNumber());
            System.out.println("Address: " + contact.GetAddress());
        }
    }
}
