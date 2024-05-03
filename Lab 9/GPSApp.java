public class GPSApp implements Trackable {

    private float xCoordinate;
    private float yCoordinate;
    private int hour;
    private int minutes;

    public GPSApp(){
        this.xCoordinate=0;
        this.yCoordinate=0;
        this.hour=0;
        this.minutes=0;
    }

    public GPSApp(float x, float y, int hour, int minutes){
        this.xCoordinate=x;
        this.yCoordinate=y;
        this.hour=hour;
        this.minutes=minutes;
    }

    public float getXCoordinate() {
        return this.xCoordinate;
    }

    public void setXCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getYCoordinate() {
        return this.yCoordinate;
    }

    public void setYCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    
    public void getCoordinates(){
        System.out.println("x: "+this.xCoordinate);
        System.out.println("y: "+this.yCoordinate);
    }
}
