import java.util.Scanner; //import the java scanner

public class Cheese 
extends Food{ //the class Cheese.  Inherited Food Class

  Scanner sc = new Scanner(System.in);
  int choice; //the choice chosen by the user

  public Cheese(int type, double cost) {
    super(type, cost);

    //message of menu
    System.out.println("===========================");
    System.out.println("Select Cheese Type:");
    System.out.println("1. American Cheese - (+0 won)");
    System.out.println("2. Swiss - (+100 won)");
    System.out.println("3. Cheddar - (+0 won)");
    System.out.printf("Select Cheese (1-3): ");
    choice = sc.nextInt(); //user input
    calculatePayment(); //calculate the cost of Cheese
  }

  @Override
  public void calculatePayment() { //calcualte the cost and set it with setCost() method 
    if(choice == 1){
      setCost(0);
    }
    else if(choice == 2){
      setCost(100);
    }
    else if(choice == 3){
      setCost(0);
    }
  }
}
