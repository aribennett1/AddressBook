package addressBook;

import java.util.Scanner;

public class UI {
	public static AddressBook addressBook = new AddressBook();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			processChoice(getUserChoice());
		}
	}

	private static int getUserChoice() {
		System.out.println("Select an option:");
		System.out.println("1. Add a contact");
		System.out.println("2. Delete a contact");
		System.out.println("3. Update a contact");
		System.out.println("4. Display the address book");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");

		boolean validInput = false;
		int choice = -1;

		while (!validInput) {
			try {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline
				validInput = true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer choice.");
				scanner.nextLine(); // Consume the invalid input
			}
		}
		return choice;
	}

	private static void processChoice(int choice) {
		switch (choice) {
		case 1:
			addContact();
			break;
		case 2:
			deleteContact();
			break;
		case 3:
			updateContact();
			break;
		case 4:
			displayAddressBook();
			break;
		case 5:
			System.exit(0);
		default:
			System.out.println("Invalid choice. Please enter a valid option.");
		}
	}

	private static void addContact() {
		Contact contact = new Contact(askString("Enter name: "), askString("Enter street: "), askString("Enter city: "), getValidState("Enter state: "), getValidZip("Enter 5-digit zip: "), getValidPhoneNum("Enter 10-digit phone number: "));
		addressBook.addContact(contact);

		System.out.println("Contact added successfully.");
	}

	private static void deleteContact() {
		Contact contactToDelete = getExistingContactByID("Enter contact ID to delete: ");
		if (contactToDelete == null) {
			return;
		}
		addressBook.deleteContact(contactToDelete);
	}

	private static void updateContact() {
		Contact contactToUpdate = getExistingContactByID("Enter contact ID to update: ");
		if (contactToUpdate == null) {
			return;
		}
		System.out.println("Select data to update:");
		System.out.println("1. Name");
		System.out.println("2. Street");
		System.out.println("3. City");
		System.out.println("4. State");
		System.out.println("5. Zip");
		System.out.println("6. Phone Number");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline

		switch (choice) {
		case 1:
			contactToUpdate.setName(askString("Enter new name: "));
			break;
		case 2:
			contactToUpdate.setStreet(askString("Enter new street: "));
			break;
		case 3:
			contactToUpdate.setCity(askString("Enter new city: "));
			break;
		case 4:
			contactToUpdate.setState(getValidState("Enter new state: "));
			break;
		case 5:
			contactToUpdate.setZip(getValidState("Enter new 5-digit zip: "));
			break;
		case 6:
			contactToUpdate.setPhoneNumber(getValidPhoneNum("Enter new 10-digit phone number: "));
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
	}

	private static void displayAddressBook() {
		addressBook.displayAddressBook();
	}

	private static Contact getExistingContactByID(String msg) {
		int contactID;
		Contact contact;
		while (true) {
			System.out.print(msg);
			contactID = scanner.nextInt();
			contact = addressBook.getContactByID(contactID);			
			if (contact != null) {
				return contact;
			} else {
				System.out.println("Contact with ID " + contactID + " not found.");
				System.out.print("Do you want to try again with a new ID? (Y/N): ");
				if (!scanner.next().equalsIgnoreCase("Y")) {
					return null;
				}
			}
		}
	}

	// Helper method to ask for a string input
	private static String askString(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.out.println("Invalid input. Please enter a non-empty string.");
			}
		}
	}

	// Helper method to get a valid 10-digit phone number
	private static String getValidPhoneNum(String prompt) {
		String phoneNum;
		while (true) {
			phoneNum = askString(prompt);
			if (phoneNum.length() == 10 && phoneNum.matches("\\d{10}")) {
				break;
			}
			System.out.println("Invalid phone number.");
		}
		return phoneNum;
	}

	// Helper method to get a valid 5-digit zip
	private static String getValidZip(String prompt) {
		String zip;
		while (true) {
			zip = askString(prompt);
			if (zip.length() == 5 && zip.matches("\\d{5}")) {
				break;
			}
			System.out.println("Invalid zip.");
		}
		return zip;
	}

	// Helper method to get a valid 2-char state
	private static String getValidState(String prompt) {
		String state;
		while (true) {
			state = askString(prompt);
			if (state.length() == 2 && state.matches("[A-Za-z]{2}")) {
				break;
			}
			System.out.println("Invalid state abbreviation.");
		}
		return state.toUpperCase();
	}

}
