package FileRead;

import java.io.*;   // file io
import java.util.*;    // for Scanner

public class FileRead {

    static int qsum = 0;    // quantity sum
    static double ptotal = 0;   // price total

    public static void main(String[] args) {
        File dataFile = new File("src/fileread/inventory.txt"); // file
        try (Scanner input = new Scanner(new BufferedReader(new FileReader(dataFile)))) {
            input.useDelimiter("[|\n\r]");
            while (input.hasNext()) {
                try {
                    int product = input.nextInt();    // product
                    String description = input.next();    // description
                    double price = input.nextDouble();    // price
                    int quantity = input.nextInt();    // quantity
                    System.out.printf("%3d \t %-30s \t $%-4.2f \t %3d \n", product, description, price, quantity);    // text separated by tabs
                    qsum = qsum += quantity;    // set quantity sum
                    ptotal = ptotal += price;   // set price total
                } catch (Exception e) {
                    System.err.println(e);  // print exception
                    input.nextLine();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());    // print exception
        }
        printQandP();   // call printQandP method
    }
    
    public static void printQandP() {
        System.out.printf("Total Quantity: %d\n", qsum);    // print quantity sum
        System.out.printf("Total Price: $%.2f\n", ptotal);  // print price total
    }
}