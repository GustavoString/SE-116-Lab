import java.util.ArrayList;

public class lab5 {
    
}

class Test{
    public static void main(String[] args) {
        ArrayList<Player> players=new ArrayList<Player>();

        ArrayList<Character> p1Characters=new ArrayList<Character>();

        Mage p1Mage=new Mage("Aral", 50, "Female");
        p1Characters.add(p1Mage);

        Warrior p1Warrior=new Warrior("WILLIAM THE GIGACHAD WARRIOR", 10000, "Man");
        p1Characters.add(p1Warrior);

        Player p1=new Player("William", "superSecurePassword", p1Characters);

        ArrayList<Character> p2Characters=new ArrayList<Character>();

        Mage p2Mage=new Mage("Raven", 100, "Female");
        p2Characters.add(p2Mage);

        Warrior p2Warrior=new Warrior("Golden Knight", 5000, "Male");
        p2Characters.add(p2Warrior);

        Player p2=new Player("Aykan", "I_AmTheBestDevEver", p2Characters);

        players.add(p1);
        players.add(p2);

        for (Player player : players) {
            System.out.println("Player name: "+player.getName()+"\n");
            for (Character character : player.getCharacters()) {
                character.printInfo();
                System.out.println();
                character.attack();
                System.out.println();
                character.printInfo();
                System.out.println();
                character.regeneratePower();
                System.out.println();
                character.printInfo();
                System.out.println("\n\n\n");
            }
        }



        double highestTotalDamage=0;
        int highestTotalDamageIndex=0;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getTotalDamage()>highestTotalDamage){
                highestTotalDamage=players.get(i).getTotalDamage();
                highestTotalDamageIndex=i;
            }
        }

        System.out.println("Player with highest total damage: "+players.get(highestTotalDamageIndex).getName());
    }
}

class Character{
    private String name;
    private double hitPoints;
    private String gender;

    public Character(){
        this.name="Undefined";
        this.hitPoints=1;
        this.gender="Undefined";
    }

    public Character(String name, double hitPoints, String gender){
        this.name=name;
        if(this.hitPoints<0){
            System.out.println("Invalid hitpoint value.");
        } else{
            this.hitPoints=hitPoints;
        }
        this.gender=gender;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setHitPoints(double hitPoints){
        if(hitPoints<0){
            System.out.println("Invalid hitpoint value.");
            return;
        }
        this.hitPoints=hitPoints;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public String getName(){
        return this.name;
    }

    public double getHitPoints(){
        return this.hitPoints;
    }

    public String getGender(){
        return this.gender;
    }

    public double calculateDamage(){
        return this.getHitPoints();
    }

    public void attack(){
        System.out.println("Attacking... damage is: "+this.calculateDamage());
    }

    public void regeneratePower(){
        System.out.println("Regenerating power");
    }

    public void printInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("HP: "+this.hitPoints);
        System.out.println("Gender: "+this.gender);
    }
}

class Warrior extends Character{
    private int energy;

    public Warrior(){
        super();
        this.energy=20;
    }

    public Warrior(String name, double hitPoints, String gender){
        super(name, hitPoints, gender);
        this.energy=20;
    }

    public int getEnergy(){
        return this.energy;
    }

    public void setEnergy(int energy){
        if(energy<0){
            System.out.println("Invalid energy value.");
        } else{
            this.energy=energy;
        }
    }

    private void rest(){
        this.energy+=20;
        System.out.println("Energy: "+this.energy);
    }

    @Override
    public void regeneratePower(){
        this.rest();
    }

    @Override
    public double calculateDamage(){
        return this.getHitPoints()*1.2;
    }

    @Override
    public void attack(){
        if(this.energy<10){
            System.out.println("“Not enough energy. Get rest…");
        } else{
            this.energy-=10;
            super.attack();
            System.out.println("Energy: "+this.energy);
        }
    }

    @Override
    public void printInfo(){
        System.out.println("Type: Warrior\n");
        super.printInfo();
        System.out.println("Energy: "+energy);
    }
}

class Mage extends Character{
    private int mana;

    public Mage(){
        super();
        this.mana=10;
    }

    public Mage(String name, double hitPoints, String gender){
        super(name, hitPoints, gender);
        this.mana=10;
    }

    public int getMana(){
        return this.mana;
    }

    public void setMana(int mana){
        if(mana<0){
            System.out.println("Invalid mana value.");
        } else{
            this.mana=mana;
        }
    }

    private void drinkPotion(){
        this.mana+=10;
        System.out.println("Mana: "+this.mana);
    }

    @Override
    public double calculateDamage(){
        return this.getHitPoints()*0.8;
    }

    @Override
    public void regeneratePower(){
        this.drinkPotion();
    }

    @Override
    public void attack(){
        if(mana<5){
            System.out.println("Not enough mana. Drink potion…");
        } else{
            this.mana-=5;
            super.attack();
            System.out.println("Mana: "+this.mana);
        }
    }

    @Override
    public void printInfo(){
        System.out.println("Type: Warrior\n");
        super.printInfo();
        System.out.println("Mana: "+this.mana);
    }
}

class Player{
    private String name;
    private String password;
    private ArrayList<Character> characters;

    public Player(){
        this.name="Undefined";
        this.password="Password";
        this.characters=new ArrayList<Character>();
    }

    public Player(String name, String password){
        this.name=name;
        this.password=password;
        this.characters=new ArrayList<Character>();
    }

    public Player(String name, String password, ArrayList<Character> characters){
        this.name=name;
        this.password=password;
        this.characters=characters;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public ArrayList<Character> getCharacters(){
        return this.characters;
    }

    public String setName(String name){
        return this.name;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setCharacters(ArrayList<Character> characters){
        this.characters=characters;
    }

    public Character getCharacter(int index){
        return this.characters.get(index);
    }

    public void addCharacter(Character character){
        this.characters.add(character);
    }

    public void printPlayerInfo(){
        System.out.println("Player name: "+this.name);
        System.out.println("Password: "+this.password);
        for (int i = 0; i < this.characters.size(); i++) {
            System.out.println("Character "+i+1+":\n");
            this.characters.get(i).printInfo();
            System.out.println("\n\n");
        }
    }

    public double getTotalDamage(){
        double totalDamage=0;

        for (int i = 0; i < this.characters.size(); i++) {
            totalDamage+=this.characters.get(i).calculateDamage();
        }

        return totalDamage;
    }
}
