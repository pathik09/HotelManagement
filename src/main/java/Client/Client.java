package Client;

import java.util.Scanner;

import com.staah.hotelmanagement.command.AvailibilityCommand;
import com.staah.hotelmanagement.command.SearchCommand;

public class Client {

	public static void main(String[] args) {
		while (true) {
			System.out.print("Please enter your input");

			Scanner scanner = new Scanner(System.in);
			String message = scanner.nextLine();
			if (message.startsWith("Availability")) {

				AvailibilityCommand availibilityCommand = new AvailibilityCommand();
				message = message.replace("Availability", "");
				message = message.replace("(", "");
				message = message.replace(")", "");
				String messages[] = message.split(",");

				System.out.println(availibilityCommand.queryForAvailibility(messages[0].trim(), messages[1].trim(),
						messages[2].trim()) + " rooms available");
				;
			} else if (message.startsWith("Search")) {
				SearchCommand searchCommand = new SearchCommand();
				message = message.replace("Search", "");
				message = message.replace("(", "");
				message = message.replace(")", "");
				String messages[] = message.split(",");
				searchCommand.searchQuery(messages[0].trim(), Integer.parseInt(messages[1].trim()), messages[2].trim());
			} else if (message.equals("")) {
				System.exit(0);
			} else {
				System.out.println("Invalid innput");
			}
		}

		// if-else-if ladder to check the value of i

	}

}
