import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args){
        Animal cat = new Animal("cat","meow");
        Animal dog = new Animal("dog","hav");
        Animal bird = new Animal("bird","cik");
        Animal pig = new Animal("pig","oink");
        Animal sheep = new Animal("sheep","mee");

        Animal[] animals={cat,dog,bird,pig,sheep};

        Choir(animals);
    }




    public static void Choir(Animal[] animals){
        ArrayList<Animal> animalsAL=new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {
            animalsAL.add(animals[i]);
        }

        Random r1=new Random(System.currentTimeMillis());

        for (int i = 0; i < animals.length; i++) {
            int rand=r1.nextInt(animals.length-i);
            animalsAL.get(rand).makeASound();
            animalsAL.remove(rand);
        }


    }
}
