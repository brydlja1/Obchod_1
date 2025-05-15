package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] groceryList = {
                "Milk", "Bread", "Ice-cream", "Cheesecake",
                "Chocolate", "Eggs", "Chicken", "Apple",
                "Banana", "Yogurt", "Potatoes", "Orange juice",
                "Cereal", "Cheese", "Coffee", "Vitamin C"
        };
        float[] unitPrices = {
                1.29f, 0.90f, 1.49f, 4.99f,
                0.59f, 5.49f, 1.09f, 0.89f,
                0.49f, 1.19f, 2.99f, 2.49f,
                0.99f, 1.90f, 2.50f, 8.49f,
        };

        for (int i = 0; i < groceryList.length; i++) {
            System.out.println(groceryList[i] + ": " + " $" + unitPrices[i]);
        }
        float totalPrize = 0;
        String item;
        ArrayList<String> purchasedItems = new ArrayList<>();
        System.out.println("Do you want to filter the items?");
        String answear = scanner.nextLine();
        if (answear.equals("yes")) {
            System.out.print("Enter price limit to filter items: ");
            float limit = scanner.nextFloat();
            scanner.nextLine();
            filterItemsBelowPrize(groceryList, unitPrices, limit);
        }
        else {}
        do {
            System.out.print("Enter an item to add (or type complete to finish): ");
            item = scanner.nextLine();

            if (!item.equalsIgnoreCase("complete")) {
                boolean found = false;
                for (int i = 0; i < groceryList.length; i++) {
                    if (groceryList[i].equalsIgnoreCase(item)) {
                        System.out.println("You added: " + item + " for $" + unitPrices[i]);
                        totalPrize += unitPrices[i];
                        purchasedItems.add(item);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Item not found in the list. Please try again.");
                }
            }
        } while (!item.equalsIgnoreCase("Complete"));
        System.out.println("Your items: " + purchasedItems);
        System.out.println("Your total cost is: $" + totalPrize);

        if (totalPrize > 100) {
            float discount = totalPrize * 0.10f;  // 10% discount
            float discountedTotal = totalPrize - discount;
            System.out.println("Original total: $" + totalPrize);
            System.out.println("Discount applied: 10%");
            System.out.println("Total after discount: $" + discountedTotal);
        }

        scanner.close();
    }

    public static int searchForAnItem(String item, String[] groceryList) {
        for (int i = 0; i < groceryList.length; i++) {
            if (groceryList[i].equalsIgnoreCase(item))
                return i;
        }
        return 0;
    }
    public static float calculeteAveragePrize(float[] prices) {
        float totalAveragePrize = 0;
        for (int i = 0; i < prices.length; i++) {
            totalAveragePrize = totalAveragePrize + prices[i];
        }
        return totalAveragePrize / prices.length;
    }
    public static void filterItemsBelowPrize(String[] groceryList, float[] unitPrices, float priceLimit) {
        System.out.println("Items cheaper than $" + priceLimit + ":");
        for (int i = 0; i < groceryList.length; i++) {
            if (unitPrices[i] < priceLimit) {
                System.out.println(groceryList[i] + ": $" + unitPrices[i]);
            }
        }
    }
}

