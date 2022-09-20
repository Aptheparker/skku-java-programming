import java.util.Scanner; //the scanner funciton.

public class AirPods
    extends Product { // inherit the Product class. (inherited field: basePrice, totalCost, model,
                      // quantity)

  public AirPods(int basePrice, int totalCost, String model, int quantity) { // the constructor.
    super(basePrice, totalCost, model, quantity);
  }

  public void getUserSelection() { // get the user's choice of the airpods.
    int modelextra = 0; // initialize the extra charge on each field.

    Scanner sc = new Scanner(System.in);
    System.out.println("Base Cost of the AirPods: $" + basePrice); // show the basePrice first.

    System.out.printf("Which model do you want (AirPods3, AirPodsPro, AirPodsMax): "); // get the information of the
                                                                                       // model. (store the extra cost
                                                                                       // and change the totalCost)
    model = sc.next();
    if (model.equals("AirPods3")) { // AirPods3 (base)
      modelextra = 0;
      totalCost += 0;
    } else if (model.equals("AirPodsPro")) { // AirPodsPro
      modelextra = 100;
      totalCost += 100;
      setModel("AirPodsPro");
    } else if (model.equals("AirPodsMax")) { // AirPodsMax
      modelextra = 200;
      totalCost += 200;
      setModel("AirPodsMax");
    } else {
      System.out.println("Invalid");
    }

    System.out.printf("How many do you want to buy: "); // get the quantity.
    quantity = sc.nextInt();

    System.out.println("====== check ======"); // to show the extra charge of each field. (if the extra charge is 0, do
                                               // not show it)
    if (modelextra != 0) {
      System.out.println("Model (" + getModel() + ") ------ +$" + modelextra);
    }
    setTotalCost(totalCost);
    setQuantity(quantity);
    System.out.printf("\nTotal Cost for one Airpods: $%.2f\n", super.calculateCost()); // show the totalCost of one
                                                                                       // product.
    System.out.printf("Total Cost (quantity x %d): $%.2f\n", quantity, calculateCost()); // show the totalCost of the
                                                                                         // products chosen.
  }

  public float calculateCost() { // the formula for calculating the totalCost.
    return (basePrice + totalCost) * quantity;
  }

}
