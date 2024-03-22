import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Product toothbrush=new Product(100, "Toothbrush", 3.5, "Blue", "A brush for keeping your teeth clean");
        Product toothpaste=new Product(101, "Toothpaste", 9.99, "White", "A paste for keeping your teeth clean");
        Product mouthwash=new Product(102, "Mouthwash", 15, "Cyan", "A liquid that keeps your mouth clean");
        Product braces=new Product(103, "Braces", 500, "Metallic silver", "Braces to straighten your teeth");
        Product invisAlign=new Product(104, "InvisAlign", 3000, "Clear", "An invisible alternative to braces");
        Product toothpick=new Product(105, "Toothpick", 0.01, "Yellowish brown", "Toothpicks for cleaning your teeth");
        Product floss=new Product(106, "Floss", 0.2, "White", "Floss for cleaning between your teeth.");
        
        Item toothbrushSinglePack=new Item(1000, toothbrush, 1);
        Item toothbrushDoublePack=new Item(1001, toothbrush, 2);
        Item toothbrushFamilyPack=new Item(1002, toothbrush, 4);
        Item topBottomBraces=new Item(1003, braces, 2);
        Item topBottomInvisalign=new Item(1004, invisAlign, 2);
        Item toothpasteSinglePack=new Item(1005, toothpaste, 1);
        Item toothpasteFamilyPack=new Item(1006, toothpaste, 4);
        Item mouthwashSingle=new Item(1007, mouthwash, 1);
        Item mouthwashDouble=new Item(1008, mouthwash, 2);
        Item toothPickPacket=new Item(1008, toothpick, 1000);
        Item flossPacket=new Item(1009, floss, 40);

        ArrayList<Item> orthodontistItems=new ArrayList<Item>();

        orthodontistItems.add(topBottomBraces);
        orthodontistItems.add(topBottomInvisalign);
        orthodontistItems.add(toothbrushFamilyPack);
        orthodontistItems.add(toothpasteFamilyPack);
        orthodontistItems.add(flossPacket);
        orthodontistItems.add(mouthwashDouble);
        orthodontistItems.add(toothPickPacket);

        Order orthodontistClinic=new Order(1, orthodontistItems, 5);

        orthodontistClinic.printInfo();

        ArrayList<Item> familyItems=new ArrayList<Item>();

        familyItems.add(toothbrushFamilyPack);
        familyItems.add(toothpasteFamilyPack);
        familyItems.add(mouthwashDouble);
        familyItems.add(toothPickPacket);
        familyItems.add(flossPacket);

        Order familyHomeOrder=new Order(2, familyItems, 1);

        familyHomeOrder.printInfo();

        ArrayList<Item> studentDormRoomItems=new ArrayList<Item>();

        studentDormRoomItems.add(toothbrushSinglePack);
        studentDormRoomItems.add(toothbrushDoublePack);
        studentDormRoomItems.add(toothpasteSinglePack);
        studentDormRoomItems.add(toothPickPacket);
        studentDormRoomItems.add(mouthwashSingle);

        Order studentDormRoomOrder=new Order(3, studentDormRoomItems, 2);

        studentDormRoomOrder.printInfo();

        ArrayList<Order> orderList=new ArrayList<Order>();
        orderList.add(orthodontistClinic);
        orderList.add(familyHomeOrder);
        orderList.add(studentDormRoomOrder);
        double highestPrice=orderList.get(0).getHighestPrice();
        int lowestQuantity=orderList.get(0).getLowestQuantity();
        for (int i = 1; i < orderList.size(); i++) {
            if(orderList.get(i).getHighestPrice()>highestPrice){
                highestPrice=orderList.get(i).getHighestPrice();
            }
            if(orderList.get(i).getLowestQuantity()<lowestQuantity){
                lowestQuantity=orderList.get(i).getLowestQuantity();
            }
        }
        System.out.println("\n\nThe highest priced product has a price of $"+highestPrice);
        System.out.println("\nThe lowest quantity item has a quantity of "+lowestQuantity);
        System.out.println("\nThe order with the highest number of installments has an installment count of "+Order.getHighestNumberOfInstallments(orderList));
    }
}
