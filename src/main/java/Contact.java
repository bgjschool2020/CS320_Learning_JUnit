public class Contact {
    private String _contactId;
    private String _firstName;
    private String _lastName;
    private String _phoneNumber;
    private String _address;



    private boolean idValidation(String _contactId) {
        return _contactId.length() > 10 || _contactId == null;
    }

    private boolean firstNameValidation(String _firstName) {
        return _firstName.length() > 10 || _firstName == null;
    }

    private boolean lastNameValidation(String _lastName) {
        return _lastName.length() > 10 || _lastName == null;
    }

    private boolean phoneNumberValidation(String _phoneNumber) {
        return _phoneNumber.length() != 10 || _phoneNumber == null;
    }

    private boolean addressValidation(String _address) {
        return _address.length() > 30 || _address == null;
    }

    /**
     * Constructor
     *
     * @param _contactId
     * @param _firstName
     * @param _lastName
     * @param _phoneNumber
     * @param _address
     */
    public Contact( String _contactId,
                    String _firstName,
                    String _lastName,
                    String _phoneNumber,
                    String _address ) {

        if ( idValidation(_contactId) ) {
            throw new IllegalArgumentException("Contact ID is invalid!");
        }

        if ( firstNameValidation(_firstName) ) {
            throw new IllegalArgumentException("First Name is invalid");
        }

        if ( lastNameValidation(_lastName) ) {
            throw new IllegalArgumentException("Last Name is invalid");
        }

        if ( phoneNumberValidation(_phoneNumber) ) {
            throw new IllegalArgumentException("Phone Number is invalid");
        }

        if ( addressValidation(_address) ) {
            throw new IllegalArgumentException("Address is invalid");
        }

        // I put these here instead of setters because a Constructor is used to set the initial value of fields. Calling other functions within it may cause unwanted results.
        this._contactId = _contactId;
        this._firstName = _firstName;
        this._lastName = _lastName;
        this._phoneNumber = _phoneNumber;
        this._address = _address;
    }


    public String get_contactId() {
        return _contactId;
    }

    public void set_contactId(String _contactId) {
        // added exception here so that it is hit if anything is changed after construction
        if ( !idValidation(_contactId) ) {
            throw new IllegalArgumentException("Contact ID is invalid!");
        }
        this._contactId = _contactId;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        if ( firstNameValidation(_firstName) ) {
            throw new IllegalArgumentException("First Name is invalid");
        }
        this._firstName = _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        if ( lastNameValidation(_lastName) ) {
            throw new IllegalArgumentException("Last Name is invalid");
        }
        this._lastName = _lastName;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        if ( phoneNumberValidation(_phoneNumber) ) {
            throw new IllegalArgumentException("Phone Number is invalid");
        }
        this._phoneNumber = _phoneNumber;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        if ( addressValidation(_address) ) {
            throw new IllegalArgumentException("Address is invalid");
        }
        this._address = _address;
    }
}
