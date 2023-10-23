import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @AfterEach
    void clearAll(){
        ContactService.Contacts.clear();
    }

    private final String _firstName = "Hermione";
    private final String _lastName = "Potter";
    private final String _phoneNumber = "4435678910";
    private final String _address = "1 Hampstead Garden Sub, London";

    @Test
    @DisplayName("Add a new contact Test")
    void addContactTest() {
        ContactService contactTest = new ContactService();

        contactTest.addContact(_firstName, _lastName, _phoneNumber, _address);

        assertAll(
                () -> assertEquals("0", ContactService.Contacts.get(0).get_contactId()),
                () -> assertEquals(_firstName, ContactService.Contacts.get(0).get_firstName()),
                () -> assertEquals(_lastName, ContactService.Contacts.get(0).get_lastName()),
                () -> assertEquals(_phoneNumber, ContactService.Contacts.get(0).get_phoneNumber()),
                () -> assertEquals(_address, ContactService.Contacts.get(0).get_address())
        );
    }

    @Test
    @DisplayName("Deleting a Contact Test")
    void deleteContactTest() {
        ContactService contactTest = new ContactService();

        contactTest.addContact(_firstName, _lastName, _phoneNumber, _address);

        contactTest.deleteContact("0");

        assertTrue(ContactService.Contacts.isEmpty());
    }


    @Test
    @DisplayName("Update First Name")
    void updateFirstNameTest() {

        ContactService contactTest = new ContactService();
        contactTest.addContact(_firstName, _lastName, _phoneNumber, _address);

        // Before change check
        assertEquals(_firstName, ContactService.Contacts.get(0).get_firstName());

        String firstName = "Harry";
        contactTest.updateFirstName("0", firstName);

        // After change check
        assertEquals(firstName, ContactService.Contacts.get(0).get_firstName());
    }

    @Test
    @DisplayName("Update Last Name")
    void updateLastNameTest() {

        ContactService contactTest = new ContactService();
        contactTest.addContact(_firstName, _lastName, _phoneNumber, _address);

        // Before change check
        assertEquals(_lastName, ContactService.Contacts.get(0).get_lastName());

        String lastName = "Potter";
        contactTest.updateLastName("0", lastName);

        // After change check
        assertEquals(lastName, ContactService.Contacts.get(0).get_lastName());
    }

    @Test
    @DisplayName("Update Phone Number")
    void updatePhoneNumberTest() {

        ContactService contactTest = new ContactService();
        contactTest.addContact(_firstName, _lastName, _phoneNumber, _address);

        // Before change check
        assertEquals(_phoneNumber, ContactService.Contacts.get(0).get_phoneNumber());

        String phoneNumber = "4431098765";
        contactTest.updatePhoneNumber("0", phoneNumber);

        // After change check
        assertEquals(phoneNumber, ContactService.Contacts.get(0).get_phoneNumber());
    }

    @Test
    @DisplayName("Update Address")
    void updateAddressTest() {

        ContactService contactTest = new ContactService();
        contactTest.addContact(_firstName, _lastName, _phoneNumber, _address);

        // Before change check
        assertEquals(_address, ContactService.Contacts.get(0).get_address());

        String address = "2 Hampstead Garden Sub, London";
        contactTest.updateAddress("0", address);

        // After change check
        assertEquals(address, ContactService.Contacts.get(0).get_address());
    }
}