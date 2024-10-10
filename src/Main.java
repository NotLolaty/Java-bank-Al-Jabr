import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        BankCardManager bankCardManager = new BankCardManager();
        Scanner scanner = new Scanner(System.in);

        User currentUser = null;

        while (currentUser == null) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                userManager.register();
            } else if (option == 2) {
                currentUser = userManager.login();
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        while (true) {
            System.out.println("\n1. Add New Card");
            System.out.println("2. Check Balance");
            System.out.println("3. Show All Cards");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                bankCardManager.addCard(currentUser.name + " " + currentUser.surname);
            } else if (option == 2) {
                bankCardManager.checkBalance();
            } else if (option == 3) {
                bankCardManager.showAllCards();
            } else if (option == 4) {
                bankCardManager.transferMoney();
            } else if (option == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
