package org.demo.summary05_20240621.code.core.mvp;

import org.demo.summary05_20240621.code.core.models.Contact;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        model.load();

        if (model.currentBook().size() > 0) {
            model.setCurrentIndex(0);
            Contact contact = model.currentContact();

            view.setFirstName(contact.getFirstName());
            view.setLastName(contact.getLastName());
            view.setPhone(contact.getPhone());
            view.setEmail(contact.getEmail());
        }
    }

    public void add() {
        model.currentBook().add(
                new Contact(
                        view.getFirstName(),
                        view.getLastName(),
                        view.getPhone(),
                        view.getEmail()));
    }

    public void remove() {
        Contact contact = new Contact(
                view.getFirstName(),
                view.getLastName(),
                view.getPhone(),
                view.getEmail()
                );
        model.currentBook().remove(contact);

        if (model.currentBook().size() < 1) {
            model.setCurrentIndex(-1);

            view.setFirstName("");
            view.setLastName("");
            view.setPhone("");
            view.setEmail("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);

            Contact temp = model.currentContact();
            view.setFirstName(temp.getFirstName());
            view.setLastName(temp.getLastName());
            view.setPhone(temp.getPhone());
            view.setEmail(temp.getEmail());
        }
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.currentBook().size() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().size()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.getFirstName());
                view.setLastName(contact.getLastName());
                view.setPhone(contact.getPhone());
                view.setEmail(contact.getEmail());
            }
        }
    }

    public void prev() {
        if (model.currentBook().size() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.getFirstName());
                view.setLastName(contact.getLastName());
            }
        }
    }
}
