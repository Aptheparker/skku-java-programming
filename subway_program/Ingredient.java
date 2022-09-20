import java.util.Scanner; //import scanner

public class Ingredient
extends Food{ //the Class Ingredient (with List). Inherited Food Class

  Scanner sc = new Scanner(System.in);
  int choice; //the user input

  public Ingredient(int type, double cost) {
    super(type, cost);

    //the menu message
    System.out.println("===========================");
    System.out.println("Select Ingredients:");
    System.out.println("1. Lettuce - (+0 won)");
    System.out.println("2. Tomatoes - (+0 won)");
    System.out.println("3. Cucumbers - (+50 won)");
    System.out.println("4. Olives - (+50 won))");
    System.out.println("0. Skip");
    System.out.printf("Select (1-4): ");
    choice = sc.nextInt(); //user input
    calculatePayment(); //calculate the cost of ingredient
  }


  @Override
  public void calculatePayment() { //calculate the cost and set the cost with setCost() method
    if(choice == 1){
      setCost(0);
    }
    else if(choice == 2){
      setCost(0);
    }
    else if(choice == 3){
      setCost(50); 
    }
    else if(choice == 4){
      setCost(50);
    }
  }
}