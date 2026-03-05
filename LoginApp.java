import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

// when the class object is call automaically run this constructor

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(id + " - " + name + " - Rs." + price);
    }
}

public class LoginApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = scan.nextLine();

        System.out.print("Enter Password: ");
        String password = scan.nextLine();

        // Email validation
        boolean isEmailValid = email.matches("^[A-Za-z0-9+_.-]+@(.+)$");

        // Password validation
        boolean isPasswordValid = password.length() >= 6;

        if (isEmailValid && isPasswordValid) {

            System.out.println("\nLogin Successful!\n");

            // Product List
            Product p1 = new Product(1, "Laptop", 50000);
            Product p2 = new Product(2, "Mouse", 500);
            Product p3 = new Product(3, "Keyboard", 1500);

            System.out.println("----- PRODUCT LIST -----");
            p1.display();
            p2.display();
            p3.display();

        } else {
            System.out.println("\nInvalid Email or Password!");
        }

        scan.close();
    }
}