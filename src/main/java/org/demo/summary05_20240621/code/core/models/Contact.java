package org.demo.summary05_20240621.code.core.models;

public class Contact {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Contact(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFullname() {
        return firstName + " " + lastName;
    }

    private String phone;
    private String email;

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Contact clone() {
        return new Contact(this.firstName, this.lastName, this.phone, this.email);
    }

    @Override
    public boolean equals(Object obj) {
        Contact c = (Contact) obj;
        return c.firstName.equals(this.firstName)
                && c.lastName.equals(this.lastName)
                && c.phone.equals(this.phone)
                && c.email.equals(this.email);
    }

    @Override
    public String toString() {
        String result = "Name : " + getFullname();
        if (this.phone != null){
            result+= "\nPhone: " + this.phone;
        }
        if (this.email != null){
            result+= "\nEmail: " + this.email;
        }
        return result;
    }
}
