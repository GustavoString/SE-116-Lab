import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        Beverage water=new Beverage("water", 0.5);
        Beverage coffee=new Beverage("coffee", 2);
        Beverage tea=new Beverage("tea", 1.5);
        Beverage soda=new Beverage("soda", 3);
        Snack cracker=new Snack("cracker", 4);
        Snack sandwich=new Snack("sandwich", 6);
        Snack cookie=new Snack("cookie", 3);
        Snack chocolate=new Snack("chocolate", 5);

        
        int beveragesSold=0;
        int snacksSold=0;

        while(true){
            System.out.println("Beverage options are:\n"+water.getDetails()+coffee.getDetails()+tea.getDetails()+soda.getDetails());
            System.out.println("Snack options are:\n"+cracker.getDetails()+sandwich.getDetails()+cookie.getDetails()+chocolate.getDetails());
            System.out.print("Please enter your choice of beverage or snack\nor to exit, enter 'exit':");
            Scanner s1=new Scanner(System.in);
            String input=(s1.nextLine()).toLowerCase();
            boolean isExit=false;
            switch(input){
                case "exit":
                    isExit=true;
                    break;
                case "water":
                    beveragesSold++;
                    water.purchase();
                    break;
                case "coffee":
                    beveragesSold++;
                    coffee.purchase();
                    break;
                case "tea":
                    beveragesSold++;
                    tea.purchase();
                    break;
                case "soda":
                    beveragesSold++;
                    soda.purchase();
                    break;
                case "cracker":
                    snacksSold++;
                    cracker.purchase();
                    break;
                case "sandwich":
                    snacksSold++;
                    sandwich.purchase();
                    break;
                case "cookie":
                    snacksSold++;
                    cookie.purchase();
                    break;
                case "chocolate":
                    snacksSold++;
                    chocolate.purchase();
                    break;
                default:
                    System.out.println("There are no beverages/snacks with that name.");
                    break;
            }
            if(isExit) {
                s1.close();
                break;
            }
        }
        double totalPrice=Beverage.beverageTotalPrice+Snack.snackTotalPrice;
        

        Beverage[] beveragesArray={water, coffee, tea, soda};
        
        

        Snack[] snacksArray={cracker, sandwich, cookie, chocolate};

        System.out.println("The most bought beverage is: "+Beverage.mostBought(beveragesArray).getName()+" Having been bought "+Beverage.mostBought(beveragesArray).getBuyCount()+" times.");
        System.out.println("\nThe most bought snack is "+Snack.mostBought(snacksArray).getName()+" Having been bought "+Snack.mostBought(snacksArray).getBuyCount()+" times.");
        System.out.println("\nThe least bought beverage is: "+Beverage.leastBought(beveragesArray).getName()+" Having been bought "+Beverage.leastBought(beveragesArray).getBuyCount()+" times.");
        System.out.println("\nThe least bought snack is: "+Snack.leastBought(snacksArray).getName()+" Having been bought "+Snack.leastBought(snacksArray).getBuyCount()+" times.");
        System.out.println("\nTotal amount of money spent: "+totalPrice);
        System.out.println("\nAmount of beverages sold: "+beveragesSold+"\nAmount of snacks sold: "+snacksSold);
    }
}
