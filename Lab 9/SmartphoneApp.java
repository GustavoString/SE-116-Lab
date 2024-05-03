import java.util.Scanner;

public class SmartphoneApp {
    

    public static  void displayMenu(Phone phone, Scanner s1){
        System.out.println("1-Music player");
        System.out.println("2-Radio");
        System.out.println("3-GPS");
        System.out.println("4-Weather app");
        System.out.print("\nEnter the number corresponding to the app your would like to open: ");
        //Scanner s1=new Scanner(System.in);
        int input=s1.nextInt();
        s1.nextLine();
        try{
            switch(input){
                case 1:
                    //music player
                    System.out.println("1-Play");
                    System.out.println("2-Stop");
                    System.out.println("3-Next");
                    System.out.println("4-Previous");
                    int input2=s1.nextInt();
                    s1.nextLine();
                    switch(input2){
                        case 1:
                            phone.play();
                            break;
                        case 2:
                            phone.stop();
                            break;
                        case 3:
                            phone.next();
                            break;
                        case 4:
                            phone.prev();
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;
                case 2:
                    //radio
                    System.out.println("Program name: "+phone.getProgramName()+", Channel: "+phone.getChannelName()+", Volume: "+phone.getVolumeLevel());
                    break;
                case 3:
                    //gps
                    System.out.println("Coordinates: ");
                    phone.getCoordinates();
                    System.out.println("Time to destination: ");
                    System.out.println("Hours: "+phone.getHour());
                    System.out.println("Minutes: "+phone.getMinutes());
                    break;
                case 4:
                    //weather
                    System.out.println("City: "+phone.getCity());
                    System.out.println("Current forecast: ");
                    phone.getCurrentForecast();
                    System.out.println("\nTomorrows forecast: ");
                    phone.getTomorrowsForecast();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            //s1.close();
        }
        //s1.close();
    }

    public static void main(String[] args) {
        MusicPlayer player=new MusicPlayer("Radiohead", "Kid A", "How to disappear completely");
        Radio radio1=new Radio("BBC 2", "Top Gear", 100);
        GPSApp gps1=new GPSApp(100, 200, 14, 34);
        WeatherApp weather1=new WeatherApp("London", Forecast.Stormy, Forecast.Stormy);
        Phone phone1=new Phone("S23 Ultra", 2023, player, radio1, gps1, weather1);
        
        Scanner s2=new Scanner(System.in);
        while(true){
            displayMenu(phone1, s2);
            System.out.print("\n\n\nTo exit enter 0, to continue enter any other digit.");
            int input=s2.nextInt();
            if(input==0){
                //s2.close();
                break;
            }
            //s2.close();
        }
    }
}
