import java.util.Scanner; //the scanner funciton.

public class Macbook // inherit the Product class. (inherited field: basePrice, totalCost, model,
                     // quantity)
    extends Product {

  int memory; // the memory of the macbook.
  int size; // the size of the macbook.
  String color; // the color of the macbook,

  public Macbook(int basePrice, int totalCost, String model, int quantity) { // the constructor.
    super(basePrice, totalCost, model, quantity);
  }

  /* getter and setter */
  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

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

  public void getUserSelection() { // get the user's choice of the macbook.
    int modelextra = 0; // initialize the extra charge on each field.
    int sizeextra = 0;
    int colorextra = 0;
    int memoryextra = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Base Cost of the MacBook: $" + basePrice); // show the basePrice first.

    System.out.printf("Which model do you want (Pro or Air): "); // get the information of the model. (store the extra
                                                                 // cost and change the totalCost)
    model = sc.next();
    if (model.equals("Air")) { // Air (base)
      modelextra = 0;
      totalCost += 0;
      setModel("Air");
    } else if (model.equals("Pro")) { // Pro
      modelextra = 200;
      totalCost += 200;
      setModel("Pro");
    } else {
      System.out.println("Invalid");
    }

    System.out.printf("Size (13, 15): "); // get the information of the size. (store the extra cost and change the
                                          // totalCost)
    int size = sc.nextInt();
    if (size == 13) { // 13
      sizeextra = 0;
      totalCost += 0;
      setSize(13);
    } else if (size == 15) { // 15
      sizeextra = 200;
      totalCost += 200;
      setSize(15);
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
    if (memory == 128) { // 128
      memoryextra = 0;
      totalCost += 0;
      setMemory(128);
    } else if (memory == 256) { // 256
      memoryextra = 100;
      totalCost += 100;
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
    if (sizeextra != 0) {
      System.out.println("Size (" + getSize() + ") ------ +$" + sizeextra);
    }
    if (colorextra != 0) {
      System.out.println("Color (" + getColor() + ") ------ +$" + colorextra);
    }
    if (memoryextra != 0) {
      System.out.println("Memory (" + getMemory() + ") ------ +$" + memoryextra);
    }

    System.out.printf("\nTotal Cost for one Macbook: $%.2f\n", super.calculateCost()); // show the totalCost of one
                                                                                       // product,
    System.out.printf("Total Cost (quantity x %d): $%.2f\n", quantity, calculateCost()); // show the totalCost of the
                                                                                         // products chosen.

  }

  public float calculateCost() {
    return (basePrice + totalCost) * quantity;
  }
}
