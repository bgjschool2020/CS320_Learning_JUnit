import java.util.ArrayList;
import java.util.List;

public class ContactService {
    public static List<Contact> Contacts = new ArrayList<Contact>();
    int currentUniqueId = 0;

    public void addContact(String firstName,
                           String lastName,
                           String phoneNumber,
                           String address) {

        String currentUniqueIdString = Integer.toString(currentUniqueId);

        Contact contact = new Contact(currentUniqueIdString, firstName, lastName, phoneNumber, address);
        Contacts.add(contact);

        ++currentUniqueId;
    }

    public void deleteContact(String contactId) {
        Contacts.removeIf(contact -> contactId.equals(contact.get_contactId()));
    }

// Thought about making this more intuitive, but wasted a lot of time trying to get the tests working for it.
//    public void printMenu() {
//        System.out.println(
//                "**********************\n" +
//                        "UPDATING CONTACT\n" +
//                "**********************\n" +
//                        "What do you want to update?\n" +
//                        "(1) First Name\n" +
//                        "(2) Last Name\n" +
//                        "(3) Phone Number\n" +
//                        "(4) Address\n"
//        );
//    }

    public void updateFirstName(String contactId, String firstName) {
        for (Contact contact : Contacts) {
            if (contactId.equals(contact.get_contactId())) {
                contact.set_firstName(firstName);
            } else {
                throw new IllegalArgumentException("There is no such Contact ID!");
            }
        }
    }

    public void updateLastName(String contactId, String lastName) {
        for (Contact contact : Contacts) {
            if (contactId.equals(contact.get_contactId())) {
                contact.set_lastName(lastName);
            } else {
                throw new IllegalArgumentException("There is no such Contact ID!");
            }
        }
    }

    public void updatePhoneNumber(String contactId, String phoneNumber) {
        for (Contact contact : Contacts) {
            if (contactId.equals(contact.get_contactId())) {
                contact.set_phoneNumber(phoneNumber);
            } else {
                throw new IllegalArgumentException("There is no such Contact ID!");
            }
        }
    }

    public void updateAddress(String contactId, String address) {
        for (Contact contact : Contacts) {
            if (contactId.equals(contact.get_contactId())) {
                contact.set_address(address);
            } else {
                throw new IllegalArgumentException("There is no such Contact ID!");
            }
        }
    }
}
