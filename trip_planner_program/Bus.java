import java.util.Scanner;

public class Bus 
extends PublicTransport{
  
  Station busStation = new Station(0, 0);

  public Bus(String model, double baseFare, double totalFare, double baseRate) { //the contructor
    super(model, baseFare, totalFare, baseRate);

    Scanner sc = new Scanner(System.in);

    /*information of the train.*/
    System.out.printf("Enter transport name: ");
    model = sc.next();
    setModel(model);

    System.out.printf("Enter base fare: ");
    baseFare = sc.nextDouble();
    setBaseFare(baseFare);

    System.out.printf("Enter fare per station (for extra stations): ");
    busStation.farePerStation = sc.nextDouble();
    busStation.setFarePerStation(busStation.farePerStation);

    System.out.printf("Enter number of stations: ");
    busStation.nStations = sc.nextInt();
    busStation.setNStations(busStation.nStations);
  }

  public void calculatePayment() { //override
    if(busStation.nStations <= 5){ //if number of stations <= 5
      totalFare = baseFare;}
    else if(busStation.nStations > 5){ //if number of stations > 5
      totalFare = (baseFare) + (busStation.nStations - 5) * (busStation.farePerStation);}
    else{ //error
      throw new IllegalArgumentException("Number of stations should be >= 0");}
    }
}


