import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class User {
    String email;
    String password;
    String name;
    String surname;
    int age;
    String country;

    public User(String email, String password, String name, String surname, int age, String country) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
    }

    public void display() {
        System.out.println("Email: " + email);
        System.out.println("Name: " + name + " " + surname);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
    }
}

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public UserManager() {
        // Adding default users
        users.add(new User("bmutalov90@gmail.com", "beh123mut1195", "Behruz", "Mutalov", 15, "Uzbekistan"));
        users.add(new User("omutalov@gmail.com", "Brendtel1881", "Oybek", "Mutalov", 41, "Uzbekistan"));
        users.add(new User("ymutalova90@gmail.com", "yuh123mut1195", "Yulduz", "Mutalova", 12, "Uzbekistan"));
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter country: ");
        String country = scanner.nextLine();

        users.add(new User(email, password, name, surname, age, country));
        System.out.println("Registration successful!");
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (Objects.equals(user.email, email) && Objects.equals(user.password, password)) {
                System.out.println("Login successful! Welcome, " + user.name + " " + user.surname + "!");
                return user;
            }
        }

        System.out.println("Incorrect email or password.");
        return null;
    }

    public void displayAllUsers() {
        for (User user : users) {
            user.display();
            System.out.println();
        }
    }
}
