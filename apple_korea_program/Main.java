import java.util.Scanner; //the scanner function.

public class Main {

  public static void main(String[] args) { // main function.
    int i = 1; // for checking the while loop.

    Scanner sc = new Scanner(System.in); // scanner sc.

    while (i == 1) { // if i = 1, continue the loop. If not, stop the loop.
      System.out.println("==== Welcome to Apple Korea ===="); // the choices for the user.
      System.out.println("What do you want to buy?");
      System.out.println("Choose 1 for Macbook");
      System.out.println("Choose 2 for iPhone");
      System.out.println("Choose 3 for AirPods");
      System.out.println("Choose 0 for Exit");
      System.out.printf("Please enter your choice: ");
      int input = sc.nextInt(); // get the user input.
      System.out.println("======================");

      if (input == 1) { // Macbook
        Macbook macbook = new Macbook(1000, 0, "0", 0); // Create an object of Macbook.
        macbook.getUserSelection();
      } // get the user's selection of the macbook.

      else if (input == 2) { // iPhone
        iPhone iphone = new iPhone(800, 0, "0", 0); // Create an object of iPhone.
        iphone.getUserSelection();
      } // get the user's selection of the iphone.

      else if (input == 3) { // AirPods
        AirPods airpods = new AirPods(120, 0, "0", 0); // Create an object of AirPods.
        airpods.getUserSelection();
      } // get the user's selection of the airpods.

      else if (input == 0) { // Exit
        System.out.println("Thank you for your purchase!"); // end of the program.
        System.exit(0);
      }

      System.out.printf("Do you want to purchase something else (Yes: 1, No: 0): ");
      i = sc.nextInt(); // User chooses whether keep choosing or not.
      System.out.println("\n");
    }
    sc.close();
    System.out.println("Thank you for your purchase!"); // end of the program.
  }
}
