package org.demo.summary05_20240621.code.core.mvp;

import org.demo.summary05_20240621.code.core.models.Contact;

import java.util.List;

public interface View {
    String getFirstName();

    void setFirstName(String value);

    String getLastName();

    void setLastName(String value);

    String getPhone();

    void setPhone(String value);
    String getEmail();

    void setEmail(String value);
    void dispayContacts(List<Contact> contacts);


}
