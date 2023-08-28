package addressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public aspect Logger {
	pointcut updatePointcut(Contact contact):
        execution(void Contact.set*(String)) && target(contact);

	pointcut deletePointcut(Contact contact):
        execution(void AddressBook.deleteContact(Contact)) && args(contact);

	before(Contact contact) : updatePointcut(contact) {
		logChange("Record Updated: " + contact.toString());
	}

	before(Contact contact) : deletePointcut(contact) {
		logChange("Record Deleted: " + contact.toString());
	}

	private void logChange(String message) {
	    String currentDirectory = System.getProperty("user.dir");
	    String filePath = currentDirectory + File.separator + "log.txt";
	    File logFile = new File(filePath);	    
	    try {
	        if (!logFile.exists()) {
	            logFile.createNewFile();
	        }
	        Files.write(Paths.get(filePath), Arrays.asList(message), StandardOpenOption.APPEND);
	        System.out.println("Successfully logged " + message);
	    } catch (IOException e) {
	        System.out.println("Error writing account information to file: " + e.getMessage());
	    }
	}
}
