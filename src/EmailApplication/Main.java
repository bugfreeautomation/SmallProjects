package EmailApplication;

public class Main {

	public static void main(String[] args) {

		Email e1 = new Email("neha", "jain", "sales");
		Email e2 = new Email("rita", "dixit", "development");
		Email e3 = new Email("tina", "bhardwaj", "accounting");
		Email e4 = new Email("divyaa", "sinha", "");

		e1.generateEmail();
		e2.generateEmail();
		e3.generateEmail();
		e4.generateEmail();
		
		e4.getAllAccounts();

		String oldpassword = e1.getPassword("neha.jain@sales.company.com");
		
		System.out.println("Old password: " + oldpassword);
		e1.changePassword("neha.jain@sales.company.com",oldpassword);
		
		
		String newPassword = e1.getPassword("neha.jain@sales.company.com");
		System.out.println("New password: " + newPassword);


		
		//verify neha's password is updated
		e4.getAllAccounts();
		
		
		//get mailbox capacity
		
		System.out.println(Email.getMailboxSize());


	}

}
