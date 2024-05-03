import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab9Test implements Serializable{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        Radio radio1=new Radio("BBC 1", "Top Gear", 80);
        Radio radio2=new Radio("BBC 1", "Top Gear", 80);
        Radio radio3=new Radio("BBC 1", "Top Gear", 80);
        Radio radio4=new Radio("BBC 1", "Top Gear", 80);
        Radio radio5=new Radio("BBC 1", "Top Gear", 80);

        MusicPlayer mp1=new MusicPlayer("Radiohead", "Kid A", "Everything in its right place");
        MusicPlayer mp2=new MusicPlayer("Radiohead", "Kid A", "Everything in its right place");
        MusicPlayer mp3=new MusicPlayer("Radiohead", "Kid A", "Everything in its right place");
        MusicPlayer mp4=new MusicPlayer("Radiohead", "Kid A", "Everything in its right place");
        MusicPlayer mp5=new MusicPlayer("Radiohead", "Kid A", "Everything in its right place");

        FileOutputStream fileOut=new FileOutputStream("radios.ser");
        ObjectOutputStream out=new ObjectOutputStream(fileOut);
        out.writeObject(radio1);
        out.writeObject(radio2);
        out.writeObject(radio3);
        out.writeObject(radio4);
        out.writeObject(radio5);

        fileOut=new FileOutputStream("musicPlayers.ser");
        out=new ObjectOutputStream(fileOut);
        out.writeObject(mp1);
        out.writeObject(mp2);
        out.writeObject(mp3);
        out.writeObject(mp4);
        out.writeObject(mp5);

        FileInputStream fileIn=new FileInputStream("radios.ser");
        ObjectInputStream in=new ObjectInputStream(fileIn);
        Radio r1=(Radio) in.readObject();
        Radio r2=(Radio) in.readObject();
        Radio r3=(Radio) in.readObject();
        Radio r4=(Radio) in.readObject();
        Radio r5=(Radio) in.readObject();

        fileIn=new FileInputStream("musicPlayers.ser");
        in=new ObjectInputStream(fileIn);
        MusicPlayer mp_1=(MusicPlayer) in.readObject();
        MusicPlayer mp_2=(MusicPlayer) in.readObject();
        MusicPlayer mp_3=(MusicPlayer) in.readObject();
        MusicPlayer mp_4=(MusicPlayer) in.readObject();
        MusicPlayer mp_5=(MusicPlayer) in.readObject();

        ArrayList<Phone> phones=new ArrayList<Phone>();
        
        GPSApp gps1=new GPSApp(100, 200, 14, 34);
        WeatherApp weather1=new WeatherApp("London", Forecast.Stormy, Forecast.Stormy);
        Phone phone1=new Phone("S23 Ultra", 2023, mp_1, r1, gps1, weather1);
        Phone phone2=new Phone("S23 Ultra", 2023, mp_2, r2, gps1, weather1);
        Phone phone3=new Phone("S23 Ultra", 2023, mp_3, r3, gps1, weather1);
        Phone phone4=new Phone("S23 Ultra", 2023, mp_4, r4, gps1, weather1);
        Phone phone5=new Phone("S23 Ultra", 2023, mp_5, r5, gps1, weather1);

        phones.add(phone1);
        phones.add(phone2);
        phones.add(phone3);
        phones.add(phone4);
        phones.add(phone5);

        Scanner s2=new Scanner(System.in);
        for (Phone phone : phones) {
            while(true){
                SmartphoneApp.displayMenu(phone, s2);
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
}
