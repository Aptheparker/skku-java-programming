import java.util.Scanner; //import Scanner

public class Taxi 
extends PublicTransport{ //class Taxi

  double farePerKm; //the variable for fare per kilometer.
  double distance; //the distance variable

  public Taxi(String model, double baseFare, double totalFare, double baseRate) { //the contructor
    super(model, baseFare, totalFare, baseRate);

    Scanner sc = new Scanner(System.in); //define sc as the scanner variable.

    /*information of the train.*/
    System.out.printf("Enter transport name: ");
    model = sc.next();
    setModel(model);

    System.out.printf("Enter base fare: ");
    baseFare = sc.nextFloat();
    setBaseFare(baseFare);

    System.out.printf("Enter fare per km: ");
    farePerKm = sc.nextDouble();
    setFarePerKm(farePerKm);;
    
    System.out.printf("Enter distance (in km): ");
    distance = sc.nextDouble();
    setDistance(distance);
  }

  /*get and set*/
	public double getFarePerKm() {
		return this.farePerKm;
	}

	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

  public void calculatePayment() { //override
    totalFare = (baseFare) + distance * (farePerKm);
  }




}
