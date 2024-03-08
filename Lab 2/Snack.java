public class Snack {
    private String name;
    private double price;
    private int buyCount;
    public static int snackTotalPrice=0;

    public Snack(String name,double price){
        this.name=name;
        this.price=price;
        this.buyCount=0;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getBuyCount(){
        return this.buyCount;
    }

    public void purchase(){
        this.buyCount++;
        System.out.println(this.name+" has been purchased for $"+this.price);
        snackTotalPrice++;
    }

    public String getDetails(){
        return " "+this.name+", $"+this.price+"\n";
    }

    public static Snack mostBought(Snack[] snacks){
        int highest=0;
        int highestIndex=-1;
        for (int i = 0; i < snacks.length; i++) {
            if(snacks[i].getBuyCount()>highest){
                highest=snacks[i].buyCount;
                highestIndex=i;
            }
        }
        Snack lowestBoughtSnack;
        if(highestIndex!=-1){
            lowestBoughtSnack=snacks[highestIndex];
        } else{
            lowestBoughtSnack=new Snack("None", 0);
        }
        return lowestBoughtSnack;
    }

    public static Snack leastBought(Snack[] snacks){
        int lowest=snacks[0].getBuyCount();
        int lowestIndex=-1;
        for (int i = 1; i < snacks.length; i++) {
            if(snacks[i].getBuyCount()<lowest){
                lowest=snacks[i].buyCount;
                lowestIndex=i;
            }
        }
        Snack lowestBoughtSnack;
        if(lowestIndex!=-1){
            lowestBoughtSnack=snacks[lowestIndex];
        } else{
            lowestBoughtSnack=new Snack("None", 0);
        }
        return lowestBoughtSnack;
    }
}
