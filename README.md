# Address Book Application
The Address Book Application is a simple Java program that allows you to manage a digital address book. With features to add, delete, update, and display contacts, this application offers a convenient way to organize contact information. The program uses a straightforward text-based interface for ease of use.

## Features
1. Add Contacts: Easily add new contacts to your address book, including their Name, Street, City, State, ZIP, and phone number.
2. Delete Contacts: Remove unwanted contacts from your address book, keeping it up-to-date.
3. Update Contacts: Modify existing contact information, ensuring that your records are accurate and current.
4. Display Address Book: View your entire address book at a glance, making it simple to find the information you need.

## Usage
Upon running the application, you will be presented with a menu of options:
1. Add a Contact: Input the contact's details to add them to your address book.
2. Delete a Contact: Remove a contact by providing their unique ID.
3. Update a Contact: Modify contact information such as Name, Street, City, State, ZIP, or phone number.
4. Display the Address Book: View all contacts in your address book.
5. Exit: Terminate the application.

Follow the on-screen prompts to perform your desired action.

## Logging with AspectJ
This project employs AspectJ, a powerful aspect-oriented programming (AOP) framework. A custom aspect called Logger has been implemented to log changes made to the address book. When you update a contact, the previous data is recorded. Similarly, when you delete a contact, the contact's information is logged. These logs are stored in a text file for your reference.
