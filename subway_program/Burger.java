import java.util.Scanner;

public class Burger 
extends Food{ //the Class Food.  Inherited Food Class

  Scanner sc = new Scanner(System.in);

  Cheese cheeseObject; //composition
  Ingredient[] ingredients; //composition (List)
  int choice; //the choice chosem by the user.

  public Burger(int type, double cost, Cheese cheeseObject, Ingredient[] ingredients) {
    super(type, cost); //the variables from Food Class
    this.cheeseObject = cheeseObject;
    this.ingredients = ingredients;

    //message of menu
    System.out.println("===========================");
    System.out.println("Choose burgers (sandwiches):");
    System.out.println("1. Egg Mayo - 4,000 won");
    System.out.println("2. Chicken Tikka - 5,000 won");
    System.out.println("3. Chicken Ham - 5,000 won");
    System.out.println("4. Roasted Chicken - 5,500 won");
    System.out.println("0. Cancel Order");
    System.out.printf("Select Burger (1-4): ");
    choice = sc.nextInt(); //choice by the user
    calculatePayment(); //calculate the cost of burger
    if(choice == 0){ //if choice is 0, exit the program.
      System.out.println("Order is canceled."); //cancel
      System.exit (0);
    }
    cheeseObject = new Cheese(0, 0 ); //Composition
    this.cost += cheeseObject.getCost(); //add the cost of cheese to the burger's cost

    ingredients = new Ingredient[4]; //composition
    for(int i = 0; i < 4; i ++){ //has 4 ingredients, so loop four times.
      ingredients[i] = new Ingredient(0,0);
      if(ingredients[i].choice== 0) //if the choice of ingredient is 0, break the loop.
        break;
      this.cost += ingredients[i].getCost(); //add the cost of each ingredient to the burger's cost
    }

}

public Cheese getCheeseObject() {
  return this.cheeseObject;
}

public void setCheeseObject(Cheese cheeseObject) {
  this.cheeseObject = cheeseObject;
}

public Ingredient[] getIngredients() {
  return this.ingredients;
}

public void setIngredients(Ingredient[] ingredients) {
  this.ingredients = ingredients;
}

  @Override
  public void calculatePayment() { //calculate the cost of the choice chosen, and use the setCost method to set the cost.
    if(choice == 1){
      setCost(4000);
    }
    else if(choice == 2){
      setCost(5000);
    }
    else if(choice == 3){
      setCost(5000);
    }
    else if(choice == 4){
      setCost(5500);
    }
    else{ //error
      throw new IllegalArgumentException("Not in the range");
    }
  }
}
