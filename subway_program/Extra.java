import java.util.Scanner; //import scanner

public class Extra 
extends Food{ //the class Food. Inherited Food Class

  Scanner sc = new Scanner(System.in);
  int choice; //the user input

  public Extra(int type, double cost) {
    super(type, cost);

    //the menu message
    System.out.println("===========================");
    System.out.println("Select Extras:");
    System.out.println("1. Cookies - 1,500 won");
    System.out.println("2. French Fries - 1,300 won");
    System.out.println("3. Chips - 1,700 won");
    System.out.println("0. Skip");
    System.out.printf("Select Extras (1-3): ");
    choice = sc.nextInt(); //the user input
    calculatePayment(); //the cost of the extra menu
    if(choice == 0){ // if the choice is 0, skip the choice and set the cost as 0
      setCost(0);
    }
  }

  @Override
  public void calculatePayment() { //calculate the cost of the extra and set the cost with setCost() method.
    if(choice == 1){
      setCost(1500);
    }
    else if(choice == 2){
      setCost(1300);
    }
    else if(choice == 3){
      setCost(1700);
    }
  }
}
