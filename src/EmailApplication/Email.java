package EmailApplication;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class Email {

	private String firstname;
	private String lastname;
	private String department;
	private String password;
	private static HashMap<String, String> hmap;

	private final static int MAILBOX_SIZE = 100;

	

	public Email(String firstname, String lastname, String department) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;

		if (department.equalsIgnoreCase("sales") || department.equalsIgnoreCase("development")
				|| department.equalsIgnoreCase("accounting")) {
			this.department = department;

		} else {

			this.department = "";
		}

		hmap = new LinkedHashMap<String, String>();
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDepartment() {
		return department;
	}

	public String getPassword(String email) {

		if (hmap.containsKey(email)) {

			return hmap.get(email);

		} else {

			System.out.println("email not registered..........");
			return null;
		}

	}

	private String generatePassword() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String password = buffer.toString();
		System.out.println(password);
		return password;
	}

	public void changePassword(String email, String oldpassword) {

		if (hmap.containsKey(email)) {

			hmap.put(email, generatePassword());

			System.out.println("Password updated.....");
			
			

		} else {

			System.out.println("email not registered..........");
		}

	}

	public String generateEmail() {

		String email = this.firstname + "." + this.lastname + "@" + this.department + ".company.com";

		System.out.println(email);

		hmap.put(email, generatePassword());
		return email;

	}

	public HashMap<String, String> getAllAccounts() {

		System.out.println(hmap);
		return hmap;

	}
	
	
	
	public static int getMailboxSize() {
		return MAILBOX_SIZE;
	}

}
