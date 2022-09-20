import java.util.Scanner; //the scanner funciton.

public class iPhone
    extends Product { // inherit the Product class. (inherited field: basePrice, totalCost, model,
                      // quantity)

  int memory; // the memory of the iphone.
  String color; // the color of the iphone.

  public iPhone(int basePrice, int totalCost, String model, int quantity) { // the constructor.
    super(basePrice, totalCost, model, quantity);
  }

  /* getter and setter */
  public int getMemory() {
    return this.memory;
  }

  public void setMemory(int memory) {
    this.memory = memory;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void getUserSelection() { // get the user's choice of the iphone.
    int modelextra = 0; // initialize the extra charge on each field.
    int colorextra = 0;
    int memoryextra = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Base Cost of the iPhone: $" + basePrice); // show the basePrice first.

    System.out.printf("Which model do you want (iPhone12 or iPhone13): "); // get the information of the model. (store
                                                                           // the extra cost and change the totalCost)
    model = sc.next();
    if (model.equals("iPhone12")) { // iPhone12 (base)
      modelextra = 0;
      totalCost += 0;
      setModel("iPhone12");
    } else if (model.equals("iPhone13")) { // iPhone13
      modelextra = 200;
      totalCost += 200;
      setModel("iPhone13");
    } else {
      System.out.println("Invalid");
    }

    System.out.printf("Color (base, Gold, Silver): "); // get the information of the color. (store the extra cost and
                                                       // change the totalCost)
    color = sc.next();
    if (color.equals("base")) { // base
      colorextra = 0;
      totalCost += 0;
      setColor("base");
    } else if (color.equals("Gold")) { // Gold
      colorextra = 20;
      totalCost += 20;
      setColor("Gold");
    } else if (color.equals("Silver")) { // Silver
      colorextra = 10;
      totalCost += 10;
      setColor("Silver");
    } else {
      System.out.println("Invalid");
    }

    System.out.printf("Memory (128, 256, 512): "); // get the information of the memory. (store the extra cost and
                                                   // change the totalCost)
    memory = sc.nextInt();
    if (memory == 64) { // 64 (base)
      memoryextra = 0;
      totalCost += 0;
      setMemory(64);
    } else if (memory == 128) { // 128
      memoryextra = 100;
      totalCost += 100;
      setMemory(128);
    } else if (memory == 256) { // 256
      memoryextra = 200;
      totalCost += 200;
      setMemory(256);
    } else if (memory == 512) { // 512
      memoryextra = 300;
      totalCost += 300;
      setMemory(512);
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
    if (colorextra != 0) {
      System.out.println("Color (" + getColor() + ") ------ +$" + colorextra);
    }
    if (memoryextra != 0) {
      System.out.println("Memory (" + getMemory() + ") ------ +$" + memoryextra);
    }

    System.out.printf("\nTotal Cost for one iPhone: $%.2f\n", super.calculateCost()); // show the totalCost of one
                                                                                      // product.
    System.out.printf("Total Cost (quantity x %d): $%.2f\n", quantity, calculateCost()); // show the totalCost of the
                                                                                         // products chosen.
  }

  public float calculateCost() { // the formula for calculating the totalCost.
    return (basePrice + totalCost) * quantity;
  }
}
