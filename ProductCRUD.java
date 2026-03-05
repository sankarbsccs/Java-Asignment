import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int qty;

    Product(int id, String name, double price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    void display() {
        System.out.println(id + " | " + name + " | Rs." + price + " | Qty: " + qty);
    }
}

public class ProductCRUD {

    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- PRODUCT CRUD MENU ----");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1:
                    addProduct(scan);
                    break;

                case 2:
                    listProducts();
                    break;

                case 3:
                    updateProduct(scan);
                    break;

                case 4:
                    deleteProduct(scan);
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        scan.close();
    }

    // ADD
    static void addProduct(Scanner scan) {

        System.out.print("Enter Product ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Price: ");
        double price = scan.nextDouble(); 

        System.out.print("Enter Quantity: ");
        int qty = scan.nextInt();

        products.add(new Product(id, name, price, qty));

        System.out.println("Product Added Successfully!");
    }

    // LIST
    static void listProducts() {

        if (products.isEmpty()) {
            System.out.println("No Products Available.");
            return;
        }

        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            p.display();
        }
    }

    // UPDATE
    static void updateProduct(Scanner scan) {

        System.out.print("Enter Product ID to Update: ");
        int id = scan.nextInt();
        scan.nextLine();

        for (Product p : products) {
            if (p.id == id) {

                System.out.print("Enter New Name: ");
                p.name = scan.nextLine();

                System.out.print("Enter New Price: ");
                p.price = scan.nextDouble();

                System.out.print("Enter New Quantity: ");
                p.qty = scan.nextInt();

                System.out.println("Product Updated Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }

    // DELETE
    static void deleteProduct(Scanner scan) {

        System.out.print("Enter Product ID to Delete: ");
        int id = scan.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                products.remove(p);
                System.out.println("Product Deleted Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }
}