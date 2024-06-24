package org.demo.summary05_20240621.code.ui;

import java.util.List;
import java.util.Scanner;

import org.demo.summary05_20240621.code.core.models.Contact;
import org.demo.summary05_20240621.code.core.mvp.View;

public class ConsoleView implements View {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getFirstName() {
        System.out.printf("FirstName: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("LastName: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getPhone() {
        System.out.printf("Phone: ");
        return in.nextLine();
    }

    @Override
    public void setPhone(String value) {
            System.out.printf("Phone: %s\n", value);
    }

    @Override
    public String getEmail() {
        System.out.printf("Email: ");
        return in.nextLine();
    }

    @Override
    public void setEmail(String value) {
        System.out.printf("Email: %s\n", value);
    }

    @Override
    public void dispayContacts(List<Contact> contacts) {
//        for (Contact c : contacts){
//            System.out.println(c + "\n");
//        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + ". " + contacts.get(i) + "\n");
        }
    }
}
