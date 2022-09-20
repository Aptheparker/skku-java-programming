import java.util.Scanner;

public class Beverage 
extends Food{ //the Class Beverage.  Inherited Food Class

  Scanner sc = new Scanner(System.in);
  Boolean ice; //check true or false about ice
  int checkIce; //user input
  String string4Ice; //for output showing with or without 
  int choice; //user input

  public Beverage(int type, double cost, Boolean ice) {
    super(type, cost);
    this.ice = ice;

    //menu message 
    System.out.println("===========================");
    System.out.println("Select Beverages:");
    System.out.println("1. Cola - 1,000 won");
    System.out.println("2. Fanta - 1,100 won");
    System.out.println("3. Chilsung Cider - 900 won");
    System.out.println("4. Zero Cola - 1,200 won");
    System.out.println("5. Coffee - 2,000 won");
    System.out.println("0. Skip");
    System.out.printf("Select Beverage (1-5): ");
    choice = sc.nextInt(); //user input
    calculatePayment(); //calculate the cost of beverage

    if(choice != 0){ //if the choice is not 0, then ask the user with or without ice
      System.out.println("===========================");
      System.out.printf("With ice? (0 [no] or 1 [yes]):");
      checkIce = sc.nextInt();

       //check if with or without Ice.
      if(checkIce == 0){
        ice = false;
      }
      else if(checkIce == 1){
        ice = true;
      }
      if(ice == false)
        string4Ice = "without";
      else if(ice == true)
        string4Ice = "with";
    }
  }

	public Boolean getIce() {
		return this.ice;
	}

	public void setIce(Boolean ice) {
		this.ice = ice;
	}

  @Override
  public void calculatePayment() { //calculate the cost of the beverage and set the cost with setCost() method
    if(choice == 1){
      setCost(1000);
    }
    else if(choice == 2){
      setCost(1100);
    }
    else if(choice == 3){
      setCost(900);
    }
    else if(choice == 4){
      setCost(1200);
    }
    else if(choice == 5){
      setCost(2000);
    }
  }
}
