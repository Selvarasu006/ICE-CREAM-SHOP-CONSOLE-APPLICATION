import java.util.*;

public class IceCreamShop {
    static Scanner scanner = new Scanner(System.in);

    static String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Butterscotch", "Mango", "Pista"};
    static double[] prices = {40.0, 50.0, 45.0, 55.0, 42.0, 48.0};
    static List<String> orderItems = new ArrayList<>();
    static List<Double> orderPrices = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        System.out.println("Welcome to the Ice Cream Shop!");
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Show Ice Creams");
            System.out.println("2. Place Order");
            System.out.println("3. View Bill");
            System.out.println("4. Search Ice Cream");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showIceCreams();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    viewBill();
                    break;
                case 4:
                    searchIceCream();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void showIceCreams() {
        System.out.println("\nAvailable Ice Creams:");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ". " + flavors[i] + " - ₹" + prices[i]);
        }
    }

    static void placeOrder() {
        showIceCreams();
        System.out.print("Enter ice cream number to order: ");
        int item = scanner.nextInt();
        if (item < 1 || item > flavors.length) {
            System.out.println("Invalid selection.");
        } else {
            orderItems.add(flavors[item - 1]);
            orderPrices.add(prices[item - 1]);
            System.out.println(flavors[item - 1] + " added to your order.");
        }
    }

    static void viewBill() {
        if (orderItems.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("\nYour Order:");
        double total = 0;
        for (int i = 0; i < orderItems.size(); i++) {
            System.out.println(orderItems.get(i) + " - ₹" + orderPrices.get(i));
            total += orderPrices.get(i);
        }
        System.out.println("Total Amount: ₹" + total);
    }

    static void searchIceCream() {
        System.out.print("Enter flavor name to search: ");
        String search = scanner.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("\nSearch Results:");
        for (int i = 0; i < flavors.length; i++) {
            if (flavors[i].toLowerCase().contains(search)) {
                System.out.println((i + 1) + ". " + flavors[i] + " - ₹" + prices[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching ice cream flavor found.");
        }
    }
}
