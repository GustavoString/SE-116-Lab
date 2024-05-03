public class Phone {
    private String model;
    private int modelYear;
    private MusicPlayer player;
    private Radio radio;
    private GPSApp gps;
    private WeatherApp weather;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        if(this.modelYear>2024){
            System.out.println("Invalid model year");
        } else{
            this.modelYear=modelYear;
        }
    }

    public MusicPlayer getPlayer() {
        return player;
    }

    public void setPlayer(MusicPlayer player) {
        this.player = player;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public GPSApp getGps() {
        return gps;
    }

    public void setGps(GPSApp gps) {
        this.gps = gps;
    }

    public WeatherApp getWeather() {
        return weather;
    }

    public void setWeather(WeatherApp weather) {
        this.weather = weather;
    }

    public Phone(){
        this.model="Undefined";
        this.modelYear=2020;
        this.player=new MusicPlayer();
        this.radio=new Radio();
        this.gps=new GPSApp();
        this.weather=new WeatherApp();
    }

    public void play(){
        this.player.play();
    }

    public void stop(){
        this.player.stop();
    }

    public void next(){
        this.player.next();
    }

    public void prev(){
        this.player.prev();
    }

    public String getChannelName(){
        return this.radio.getChannelName();
    }

    public String getProgramName(){
        return this.radio.getProgramName();
    }

    public int getVolumeLevel(){
        return this.radio.getVolumeLevel();
    }

    public void getCoordinates(){
        this.gps.getCoordinates();
    }

    public int getHour(){
        return this.gps.getHour();
    }

    public int getMinutes(){
        return this.gps.getMinutes();
    }

    public String getCity(){
        return this.weather.getCity();
    }

    public void getCurrentForecast(){
        weather.getCurrentForecast();
    }

    public void getTomorrowsForecast(){
        weather.getTomorrowsForecast();
    }

    public Phone(String model, int modelYear, MusicPlayer player, Radio radio, GPSApp gps, WeatherApp weather){
        this.model=model;
        if(this.modelYear>2024){
            System.out.println("Invalid model year");
        } else{
            this.modelYear=modelYear;
        }
        this.player=player;
        this.radio=radio;
        this.gps=gps;
        this.weather=weather;
    }
}
