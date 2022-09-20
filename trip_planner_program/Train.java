import java.util.Scanner; //import Scanner.

public class Train 
extends PublicTransport{

  Station trainStation = new Station(0, 0);
  
  //The Constructor
  public Train(String model, double baseFare, double totalFare, double baseRate) {
    super(model, baseFare, totalFare, baseRate);

    Scanner sc = new Scanner(System.in); //the scanner

    /*information of the train.*/
    System.out.printf("Enter transport name: ");
    model = sc.next();
    setModel(model);

    System.out.printf("Enter base fare: ");
    baseFare = sc.nextDouble();
    setBaseFare(baseFare);

    System.out.printf("Enter fare per station (for extra stations): ");
    trainStation.farePerStation = sc.nextDouble();
    trainStation.setFarePerStation(trainStation.farePerStation);

    System.out.printf("Enter number of stations: ");
    trainStation.nStations = sc.nextInt();
    trainStation.setNStations(trainStation.nStations);
  }

  public void calculatePayment() { //override
    if(trainStation.nStations <= 5){ //if number of stations <= 5
      totalFare = baseFare;}
    else if(trainStation.nStations > 5){ //if number of stations > 5
      totalFare = baseFare + (trainStation.nStations - 5) * trainStation.farePerStation;}
    else{ //error
      throw new IllegalArgumentException("Number of stations should be >= 0");}
  }
}
