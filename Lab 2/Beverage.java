public class Beverage{
    private String name;
    private double price;
    private int buyCount;
    public static int beverageTotalPrice=0;

    public Beverage(String name, double price){
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
        beverageTotalPrice++;
    }

    public String getDetails(){
        return " "+this.name+", $"+this.price+"\n";
    }

    public static Beverage mostBought(Beverage[] beverages){
        int highest=0;
        int highestIndex=-1;
        for (int i = 0; i < beverages.length; i++) {
            if(beverages[i].getBuyCount()>highest){
                highest=beverages[i].buyCount;
                highestIndex=i;
            }
        }
        Beverage lowestBoughtBeverage;
        if(highestIndex!=-1){
            lowestBoughtBeverage=beverages[highestIndex];
        } else{
            lowestBoughtBeverage=new Beverage("None", 0);
        }
        return lowestBoughtBeverage;
    }

    public static Beverage leastBought(Beverage[] beverages){
        int lowest=beverages[0].getBuyCount();
        int lowestIndex=-1;
        for (int i = 1; i < beverages.length; i++) {
            if(beverages[i].getBuyCount()<lowest){
                lowest=beverages[i].buyCount;
                lowestIndex=i;
            }
        }
        Beverage lowestBoughtBeverage;
        if(lowestIndex!=-1){
            lowestBoughtBeverage=beverages[lowestIndex];
        } else{
            lowestBoughtBeverage=new Beverage("None", 0);
        }
        return lowestBoughtBeverage;
    }
}