/*Extra functionalities:  1) baseRate 
                          2) User's Name */

import java.util.Scanner; //import Scanner

public class Main { //the main class with the extra functionality BaseRate.
  public static void main(String[] args) { //the main function

    int transfer; //number of transports.
    int choice; //the choice of the transport.
    int i; //the index number for the for loop.
    double total = 0; //the total fare.
    String name; //name of the user. (extra functionality)

    Scanner sc = new Scanner(System.in);

    System.out.println("======== Welcome to Trip Planner =======");
    System.out.printf("Your Name: ");
    name = sc.next();
    System.out.printf("Number of transfers: ");
    transfer = sc.nextInt();

    PublicTransport[] transport = new PublicTransport[transfer]; //new array with transport.

    for(i = 1; i <= transfer; i++) { //for loop: to receive the infomation of each transport. Starting from 1 to the number of transports.
      System.out.println("================================");
      System.out.println("Choose transport " + i + ": ");
      System.out.println("1. Taxi (Enter 1)");
      System.out.println("2. Bus (Enter 2)");
      System.out.println("3. Train (Enter 3)");
      System.out.println("0. For canceling trip (Enter 0)");
      System.out.printf("Enter your choice: ");
      choice = sc.nextInt();
  
      if(choice == 1){ //taxi
        transport[i-1] = new Taxi("0", 0, 0, 0);
        transport[i-1].calculatePayment();
        transport[i-1].setBaseRate(0);}
      else if(choice == 2){ //bus
        transport[i-1] = new Bus("0", 0, 0, 0);
        transport[i-1].calculatePayment();
        transport[i-1].setBaseRate(0);}
      else if(choice == 3) { //train
        transport[i-1] = new Train("0", 0, 0, 0);
        transport[i-1].calculatePayment();
        transport[i-1].setBaseRate(0);}
      else if(choice == 0){ //cancel the trip.
        System.out.println("Trip is canceled."); //end of the program.
        System.exit (0);}
      else{ //error: should choose from 0 to 3.
        throw new IllegalArgumentException("Choose from the choice");}
    }
    sc.close(); //close the scanner.

    System.out.println("======= " + name + "'s Trip Plan ======="); //the trip plan list (with the user's name)
    /*the for loop: to print the information of the transports
    starting from index 1 to the number of transfer.*/
    for (i = 1; i <= transfer; i++ ) {
      System.out.println("Transport " + i + ": " + transport[i-1].getModel());
      System.out.printf("Fare: %.2f (Base Rate: %.1f%%)\n", transport[i-1].getTotalFare(), transport[i-1].getBaseRate()); //with baseRate.
      total += transport[i-1].getTotalFare();}
    System.out.println("================================");
    System.out.printf("Total Trip Fare: %.2f\n", total);
    System.out.println("================================");
    System.out.println("Info: if the number of stations are more than 5, there will be extra charge for each extra stations.");
    System.out.println("===== Have a wonderful trip! =====");

  }
}