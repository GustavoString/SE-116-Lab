public class Animal {
    public String name;
    public  String sound;

    public String getname(){
        return name;
    }
    public String getsound(){
        return sound;
    }


    public Animal(String name, String sound){
            this.name = name;
            this.sound = sound;
    }
    
    public void makeASound(){
        System.out.println(this.name  +"-" + this.sound);
    }

}
