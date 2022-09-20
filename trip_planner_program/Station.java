public class Station { //the class Station
  
  double farePerStation; /*variales for Bus and Train. */
  int nStations;

//Constructor
  public Station(double farePerStation, int nStations) {
    this.farePerStation = farePerStation;
    this.nStations = nStations;
  }


/*get and set */
	public double getFarePerStation() {
		return this.farePerStation;
	}

	public void setFarePerStation(double farePerStation) {
		this.farePerStation = farePerStation;
	}

	public int getNStations() {
		return this.nStations;
	}

	public void setNStations(int nStations) {
		this.nStations = nStations;
	}






}
