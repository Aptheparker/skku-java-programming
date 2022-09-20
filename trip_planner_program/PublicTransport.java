public abstract class PublicTransport
implements Payable{ //the abstract class for Bus, Taxi, Train. Has the interface Payable.

  String model; //Basic variables for the transports.
  double baseFare;
  double totalFare;
  double baseRate; //the extra functionality.

  //Constructor
  public PublicTransport(String model, double baseFare, double totalFare, double baseRate) {
    this.model = model;
    this.baseFare = baseFare;
    this.totalFare = totalFare;
    this.baseRate = baseRate;
  }
	public double getBaseRate() {
		return this.baseRate;
	}

	public void setBaseRate(double baseRate) {
		this.baseRate = baseFare / totalFare * 100;
	}

  /*get and set */
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getBaseFare() {
		return this.baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	public double getTotalFare() {
		return this.totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

  //empty method. To override in the transport classes.
  public abstract void calculatePayment();

}
