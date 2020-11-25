import java.util.*;

class UndergroundSystem {

    List<Rider> currRiders = new ArrayList<>();
    List<Trip> trips = new ArrayList<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        currRiders.add(new Rider(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Rider myRider = null;
        for(int i = 0; i < currRiders.size(); i++){
            if(id == currRiders.get(i).id){
                myRider = currRiders.get(i);
                currRiders.remove(i);
            }
        }
        Trip myTrip = null;
        int index = trips.indexOf(new Trip(myRider.startStation, stationName));
        if(index < 0){
            System.out.println("Trip does not exist, making new trip");
            myTrip = new Trip(myRider.startStation, stationName);
            trips.add(myTrip);
        } else{
            myTrip = trips.get(index);
        }
        myTrip.updateAverage(t - myRider.startTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int index = trips.indexOf(new Trip(startStation, endStation));
        if(index < 0){
            System.out.println("Trip Not Found");
            return 0;
        }
        return trips.get(index).avgTime;
    }
}

class Trip {

    String startStation;
    String endStation;
    int totalTrips;
    int totalTime;
    double avgTime;

    public Trip(String start, String end){
        startStation = start;
        endStation = end;
        totalTrips = 0;
        avgTime = 0;
    }

    public void updateAverage(int tripTime){
        totalTrips++;
        totalTime += tripTime;
        avgTime = (double)totalTime/(double)totalTrips;
    }

    @Override
    public boolean equals(Object o){
        Trip toComp = (Trip)o;
        return toComp.startStation.equals(this.startStation) && toComp.endStation.equals(this.endStation);
    }
}

class Rider {

    int id;
    String startStation;
    int startTime;

    public Rider(int id, String stationName, int t){
        this.id = id;
        startStation = stationName;
        startTime = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
 