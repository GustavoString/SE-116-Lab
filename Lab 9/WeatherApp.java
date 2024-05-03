public class WeatherApp implements Trackable {
    
    private String city;
    private Forecast currentForecast;
    private Forecast tomorrowsForecast;

    public WeatherApp() {
        this.city = "Undefined";
        this.currentForecast = Forecast.Sunny; // Default to Sunny
        this.tomorrowsForecast = Forecast.Sunny; // Default to Sunny
    }

    public WeatherApp(String city, Forecast currentForecast, Forecast tomorrowsForecast) {
        this.city = city;
        this.currentForecast = currentForecast;
        this.tomorrowsForecast = tomorrowsForecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void getCurrentForecast() {
        switch(this.currentForecast){
            case Snowy:
                System.out.println("Snowy");
                break;
            case Sunny:
                System.out.println("Sunny");
                break;
            case Rainy:
                System.out.println("Rainy");
                break;
            case Stormy:
                System.out.println("Stormy");
                break;
            case Cloudy:
                System.out.println("Cloudy");
                break;
            default:
                break;
        }
    }

    public void setCurrentForecast(Forecast currentForecast) {
        this.currentForecast = currentForecast;
    }

    public void getTomorrowsForecast() {
        switch(this.tomorrowsForecast){
            case Snowy:
                System.out.println("Snowy");
                break;
            case Sunny:
                System.out.println("Sunny");
                break;
            case Rainy:
                System.out.println("Rainy");
                break;
            case Stormy:
                System.out.println("Stormy");
                break;
            case Cloudy:
                System.out.println("Cloudy");
                break;
            default:
                break;
        }
    }

    public void setTomorrowsForecast(Forecast tomorrowsForecast) {
        this.tomorrowsForecast = tomorrowsForecast;
    }

    public void getCoordinates(){
        
    }
}

enum Forecast{
    Snowy, Sunny, Rainy, Stormy, Cloudy
}
