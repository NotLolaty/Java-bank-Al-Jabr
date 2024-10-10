import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class BankCard {
    String cardNumber;
    String cardHolderName;
    String expiryDate;
    String bankName;
    double balance;
    String pinCode;

    public BankCard(String cardNumber, String cardHolderName, String expiryDate, String bankName, double balance, String pinCode) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.bankName = bankName;
        this.balance = balance;
        this.pinCode = pinCode;
    }

    public void display() {
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder Name: " + cardHolderName);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Balance: $" + balance);
    }
}

public class BankCardManager {
    private ArrayList<BankCard> cards = new ArrayList<>();

    public BankCardManager() {
        // Adding default cards for existing users
        cards.add(new BankCard("1234-5678-9101-1121", "Behruz Mutalov", "12/25", "UzbekBank", 1000.0, "1234"));
        cards.add(new BankCard("2234-5678-9101-1121", "Oybek Mutalov", "05/26", "NationalBank", 1500.0, "5678"));
        cards.add(new BankCard("3234-5678-9101-1121", "Yulduz Mutalova", "08/24", "CapitalBank", 500.0, "9101"));
    }

    public void addCard(String cardHolderName) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter expiry date (MM/YY): ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter PIN code: ");
        String pinCode = scanner.nextLine();

        BankCard newCard = new BankCard(cardNumber, cardHolderName, expiryDate, bankName, balance, pinCode);
        cards.add(newCard);

        System.out.println("New card registered!");
    }

    public void checkBalance() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter PIN code: ");
        String pinCode = scanner.nextLine();

        boolean cardFound = false;

        for (BankCard card : cards) {
            if (Objects.equals(card.cardNumber, cardNumber) && Objects.equals(card.pinCode, pinCode)) {
                System.out.println("Card found! Balance: $" + card.balance);
                cardFound = true;
                break;
            }
        }

        if (!cardFound) {
            System.out.println("Card not found or incorrect PIN.");
        }
    }

    public void transferMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your card number: ");
        String fromCardNumber = scanner.nextLine();
        System.out.print("Enter your PIN code: ");
        String fromPinCode = scanner.nextLine();

        BankCard fromCard = null;
        for (BankCard card : cards) {
            if (Objects.equals(card.cardNumber, fromCardNumber) && Objects.equals(card.pinCode, fromPinCode)) {
                fromCard = card;
                break;
            }
        }

        if (fromCard == null) {
            System.out.println("Incorrect card number or PIN.");
            return;
        }

        System.out.print("Enter recipient's card number: ");
        String toCardNumber = scanner.nextLine();

        BankCard toCard = null;
        for (BankCard card : cards) {
            if (Objects.equals(card.cardNumber, toCardNumber)) {
                toCard = card;
                break;
            }
        }

        if (toCard == null) {
            System.out.println("Recipient's card not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (fromCard.balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            fromCard.balance -= amount;
            toCard.balance += amount;
            System.out.println("Transfer successful! $" + amount + " has been transferred to " + toCard.cardHolderName);
        }
    }

    public void showAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards registered yet.");
        } else {
            for (BankCard card : cards) {
                card.display();
                System.out.println();
            }
        }
    }
}
