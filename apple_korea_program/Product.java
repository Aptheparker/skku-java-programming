public class Product {
  int basePrice; // base price of each product.
  int totalCost; // the totalCost of the selected product.
  String model; // the model of the product,
  int quantity; // the numbers of the product chosen.

  public Product(int basePrice, int totalCost, String model, int quantity) { // constructor.
    this.basePrice = basePrice;
    this.totalCost = totalCost;
    this.model = model;
    this.quantity = quantity;
  }

  /* getter and setter of the fields. */
  public int getBasePrice() {
    return this.basePrice;
  }

  public void setBasePrice(int basePrice) {
    this.basePrice = basePrice;
  }

  public int getTotalCost() {
    return this.totalCost;
  }

  public void setTotalCost(int totalCost) {
    this.totalCost = totalCost;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) { // quantity must be greater than 0.
    if (quantity >= 0) {
      this.quantity = quantity;
    } else { // error if the quantity is not bigger than 0.
      throw new IllegalArgumentException("quantity must be >= 0");
    }
  }

  public void getUserSelection() { // the function for child classes to get the information from the user,
  }

  public float calculateCost() { // function to calculate the total cost of the product chosen.
    return basePrice + totalCost;
  }

}