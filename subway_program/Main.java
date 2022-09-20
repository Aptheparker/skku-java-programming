import java.util.Scanner; //import the scanner

/*Accoring to the video, first show the GUi Interface.
Then, show the terminal program.

Terminal: 
  1. the first example in the video selected: 1, 2, 1, 3, 4, 0, 1, 0, 0 
  2. the second example in the video selected: 2, 1, 1, 0, 0 ,2
  */
  

public class Main { //the main class

  public static void main(String[] args) { //the main function

    Scanner sc = new Scanner(System.in); //the scanner
    double totalCost = 0; //define the totalCost

    /*the first message and calling the function: Burger (composition: Cheese & Ingredient), Beverage, Extra*/
    System.out.println("==========================="); 
    System.out.println("Welcome to SKKU-SUBWAY!");
    Burger burger = new Burger(0, 0, null, null);
    Beverage beverage = new Beverage(0, 0, null);
    Extra extra = new Extra(0, 0);
  
    totalCost = burger.getCost() + beverage.getCost() + extra.getCost(); //adding the cost of the menus and calculate the totalCost.
    sc.close(); //close the scanner

    //the final check
    System.out.println("===========================");

    //show the menu that are choosen. If the menu was skiiped, then just don't show it
    if(burger.choice != 0){ 
    System.out.println("Burger (with cheese and ingredients): " + burger.getCost());
    }
    if(beverage.choice != 0){
    System.out.println("Beverage (" + beverage.string4Ice + " ice): " + beverage.getCost());
    }
    if(extra.choice != 0){
      System.out.println("Extra: " + extra.getCost());
    }
    System.out.println("TOTAL: " + totalCost); //to show the totalCost.
  }
}
