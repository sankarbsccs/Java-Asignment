import java.util.Scanner;

class Item {
    int id;
    String name;
    double unitPrice;

    Item(int id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }
}

class Bill {
    Item[] items;
    int[] quantity;

    Bill(Item[] items, int[] quantity) {
        this.items = items;
        this.quantity = quantity;
    }

    double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            total = total + (items[i].unitPrice * quantity[i]);
        }
        return total;
    }

    void printBill() {
        System.out.println("\n----- BILL DETAILS -----");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].name + " x " + quantity[i] +  " = " + (items[i].unitPrice * quantity[i]));
        }
        System.out.println("Total Amount: " + calculateTotal());
    }
}

public class BillingEngine {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of items purchased: ");
        int n = scan.nextInt();
        scan.nextLine();

        Item[] items = new Item[n];
        int[] quantity = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Item " + (i + 1));

            System.out.print("Item ID: ");
            int id = scan.nextInt();
            scan.nextLine();

            System.out.print("Item Name: ");
            String name = scan.nextLine();

            System.out.print("Unit Price: ");
            double price = scan.nextDouble();

            System.out.print("Quantity: ");
            int qty = scan.nextInt();
            scan.nextLine();

            items[i] = new Item(id, name, price);
            quantity[i] = qty;
        }

        Bill bill = new Bill(items, quantity);
        bill.printBill();

        scan.close();
    }
}