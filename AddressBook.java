package addressBook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private static List<Contact> contacts;

	public AddressBook() {
		contacts = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void deleteContact(Contact contact) {
		contacts.remove(contact);
	}

	public void displayAddressBook() {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

	public Contact getContactByID(int contactID) {
		for (Contact contact : contacts) {
			if (contactID == contact.getId()) {
				return contact;
			}
		}
		return null;
	}
}
