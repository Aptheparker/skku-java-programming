public abstract class Food
implements Payment{ //the abstract class for Burger, Beverage, Extra. Has the interface Payable.

	//all food have type and cost.
  int type;
  double cost = 0;

	//the constructor
  public Food(int type, double cost) {
    this.type = type;
    this.cost = cost;
  }

	/*getter and setter */
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

//empty method. To override in the transport classes.
  public abstract void calculatePayment();

}