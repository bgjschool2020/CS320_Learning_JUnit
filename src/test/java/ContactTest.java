import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact defaultContact() {
        return new Contact("98765",
                "Loaded",
                "Cookie",
                "8019650745",
                "6132 Rock Springs Lane");
    }

    ///////////////////////
    // Constructor Tests //
    ///////////////////////

    @Test
    @DisplayName("Contact Constructor Test")
    void test_Contact() {
        Contact contact = defaultContact();

        assertAll(  () -> assertEquals("98765", contact.get_contactId()),
                () -> assertEquals("Loaded", contact.get_firstName()),
                () -> assertEquals("Cookie", contact.get_lastName()),
                () -> assertEquals("8019650745", contact.get_phoneNumber()),
                () -> assertEquals("6132 Rock Springs Lane", contact.get_address())
        );
    }

    @Test
    @DisplayName("Invalid Contact Constructor Test")
    void test_InvalidContact() {
        assertThrows(IllegalArgumentException.class, () -> { new Contact("98765",
                "Double Chocolate Loaded",
                "Cookie",
                "8019650745",
                "6132 Rock Springs Lane"); });
    }
    ///////////////////////
    ///////////////////////


    //////////////////
    /// Good Tests ///
    //////////////////
    @Test
    @DisplayName("Set a GOOD firstName Test")
    void test_set_firstName() {
        Contact contact = defaultContact();

        contact.set_firstName("Maple");
        assertEquals("Maple", contact.get_firstName());
    }

    @Test
    @DisplayName("Set a GOOD lastName Test")
    void test_set_lastName() {
        Contact contact = defaultContact();

        contact.set_lastName("Donut");
        assertEquals("Donut", contact.get_lastName());
    }

    @Test
    @DisplayName("Set a GOOD phoneNumber Test")
    void test_set_phoneNumber() {
        Contact contact = defaultContact();

        contact.set_phoneNumber("8019964345");
        assertEquals("8019964345", contact.get_phoneNumber());
    }

    @Test
    @DisplayName("Set a GOOD address Test")
    void test_set_address() {
        Contact contact = defaultContact();

        contact.set_address("123 Sesame Street");
        assertEquals("123 Sesame Street", contact.get_address());
    }
    //////////////////
    //////////////////


    //////////////////
    /// Null Tests ///
    //////////////////
    @Test
    @DisplayName("Set a NULL firstName Test")
    void test_set_null_firstName() {
        Contact contact = defaultContact();

        assertThrows(NullPointerException.class, () -> { contact.set_firstName(null); });
    }

    @Test
    @DisplayName("Set a NULL lastName Test")
    void test_set_null_lastName() {
        Contact contact = defaultContact();

        assertThrows(NullPointerException.class, () -> { contact.set_lastName(null); });
    }

    @Test
    @DisplayName("Set a NULL phoneNumber Test")
    void test_set_null_phoneNumber() {
        Contact contact = defaultContact();

        assertThrows(NullPointerException.class, () -> { contact.set_phoneNumber(null); });
    }

    @Test
    @DisplayName("Set a NULL address Test")
    void test_set_null_address() {
        Contact contact = defaultContact();

        assertThrows(NullPointerException.class, () -> { contact.set_address(null); });
    }
    //////////////////
    //////////////////


    /////////////////
    /// Bad Tests ///
    /////////////////
    @Test
    @DisplayName("Set a BAD firstName Test")
    void test_set_bad_firstName() {
        Contact contact = defaultContact();

        assertThrows(IllegalArgumentException.class, () -> { contact.set_firstName("Double Chocolate Loaded"); });
    }

    @Test
    @DisplayName("Set a BAD lastName Test")
    void test_set_bad_lastName() {
        Contact contact = defaultContact();

        assertThrows(IllegalArgumentException.class, () -> { contact.set_lastName("Cookie with Walnuts"); });
    }

    @Test
    @DisplayName("Set a BAD phoneNumber Test")
    void test_set_bad_phoneNumber() {
        Contact contact = defaultContact();

        assertThrows(IllegalArgumentException.class, () -> { contact.set_phoneNumber("ur mom's number"); });
    }

    @Test
    @DisplayName("Set a BAD address Test")
    void test_set_bad_address() {
        Contact contact = defaultContact();

        assertThrows(IllegalArgumentException.class, () -> { contact.set_address("6132 Rock Springs Lane, Salt Lake City, UT 84118"); });
    }
    /////////////////
    /////////////////

    // This is me wanting this to work so that everything is under one method, I wasn't able to figure it out and didn't want to waste time, so I left it here.
//    void test_firstName() {
//        Contact contact = defaultContact();
//
//        contact.set_firstName("Maple");
//        assertAll(() -> assertEquals("Maple", contact.get_firstName()),
//                () -> assertThrows(IllegalAccessException.class,)
//        );
//
//    }
}