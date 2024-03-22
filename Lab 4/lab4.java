import java.util.ArrayList;

public class lab4 {
    
}

class Product{
    private int ID;
    private String name;
    private double price;
    private String colour;
    private String description;

    public Product(int ID, String name, double price, String colour, String description){
        this.ID=ID;
        this.name=name;
        if(price<=0){
            System.out.println("Invalid price value.");
        }else{
            this.price=price;
        }
        this.colour=colour;
        this.description=description;
    }

    public Product(){
        this.ID=0;
        this.name="Undefined";
        this.price=1;
        this.colour="White";
        this.description="Undefined";
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getColour(){
        return this.colour;
    }

    public String getDescription(){
        return this.description;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPrice(double price){
        if(price<=0){
            System.out.println("Invalid price value.");
        }else{
            this.price=price;
        }
    }

    public void setColour(String colour){
        this.colour=colour;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void printInfo(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.name);
        System.out.println("Price: $"+this.price);
        System.out.println("Colour: "+this.colour);
        System.out.println("Description: "+this.description);
    }

    public void printInfoWithoutPrice(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.name);
        System.out.println("Colour: "+this.colour);
        System.out.println("Description: "+this.description);
    }
}

class Item{
    private int itemID;
    private Product product;
    private int quantity;

    public Item(int itemID, Product product, int quantity){
        this.itemID=itemID;
        this.product=product;
        if(quantity<=0){
            System.out.println("Invalid quantity value.");
        }else{
            this.quantity=quantity;
        }
    }

    public Item(){
        this.itemID=0;
        this.product=new Product();
        this.quantity=1;
    }

    public int getItemID(){
        return this.itemID;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setItemID(int itemID){
        this.itemID=itemID;
    }

    public void setProduct(Product product){
        this.product=product;
    }

    public void setQuantity(int quantity){
        if(quantity<=0){
            System.out.println("Invalid quantity value.");
        }else{
            this.quantity=quantity;
        }
    }

    public void printInfo(){
        this.product.printInfoWithoutPrice();
        System.out.println("Price: $"+this.product.getPrice()*(double)quantity);
        System.out.println("Item ID: "+this.itemID);
        System.out.println("Quantity: "+this.quantity);
    }

    public double getPrice(){
        return this.product.getPrice()*(double)this.getQuantity();
    }
}

class Order{
    private static int numberOfOrders=0;

    private int orderID;
    private ArrayList<Item> itemList;
    private double totalPrice;
    private int installmentCount;

    public Order(int orderID, ArrayList<Item> itemList, int installmentCount){
        numberOfOrders++;
        this.orderID=orderID;
        this.itemList=itemList;
        if(installmentCount<0){
            System.out.println("Invalid installment count value.");
        }else{
            this.installmentCount=installmentCount;
        }
        this.totalPrice=0;
        for (int i = 0; i < itemList.size(); i++) {
            this.totalPrice+=itemList.get(i).getPrice();
        }
    }

    public Order(){
        numberOfOrders++;
        this.orderID=0;
        ArrayList<Item> items=new ArrayList<Item>();
        this.itemList=items;
        this.installmentCount=1;
        this.totalPrice=0;
    }

    public int getOrderID(){
        return this.orderID;
    } 

    public double getPrice(int index){
        return this.itemList.get(index).getPrice();
    }

    public int getInstallmentCount(){
        return this.installmentCount;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    public ArrayList<Item> getItemList(){
        return this.itemList;
    }

    public Item getItem (int index){
        return this.itemList.get(index);
    }

    public void addItem(Item newItem){
        this.itemList.add(newItem);
        this.totalPrice+=newItem.getPrice();
    }

    public void setOrderID(int orderID){
        this.orderID=orderID;
    }

    public void setInstallmentCount(int installmentCount){
        if(installmentCount<0){
            System.out.println("Invalid installment count value.");
        }else{
            this.installmentCount=installmentCount;
        }
    }

    public void printInfo(){
        System.out.println("\n------------------\nOrder ID: "+this.orderID+"\n");
        System.out.println("Installment count: "+this.installmentCount);
        System.out.println("Total price of order: "+this.totalPrice);
        for (int i = 0; i < this.itemList.size(); i++) {
            System.out.println("\nFor item number "+(i+1)+":\n");
            this.itemList.get(i).printInfo();
        }
        System.out.println("\nTotal number of orders until now: "+numberOfOrders);
    }

    public static int getNumberOfOrders(){
        return numberOfOrders;
    }

    public double getMonthlyInstallmentPrice(){
        return this.totalPrice/(double)installmentCount;
    }

    public double getHighestPrice(){
        double highestPrice=this.getItemList().get(0).getProduct().getPrice();
        for (int i = 1; i < this.itemList.size(); i++) {
            if(this.getItemList().get(i).getProduct().getPrice()>highestPrice){
                highestPrice=this.getItemList().get(i).getProduct().getPrice();
            }
        }
        return highestPrice;
    }

    public int getLowestQuantity(){
        int lowestQuantity=this.getItemList().get(0).getQuantity();
        for (int i = 1; i < this.itemList.size(); i++) {
            if(this.getItemList().get(i).getQuantity()<lowestQuantity){
                lowestQuantity=this.getItemList().get(i).getQuantity();
            }
        }
        return lowestQuantity;
    }

    public static int getHighestNumberOfInstallments(ArrayList<Order> orders){
        int highestNumberOfInstallments=orders.get(0).getInstallmentCount();
        for (int i = 1; i < orders.size(); i++) {
            if(orders.get(i).getInstallmentCount()>highestNumberOfInstallments){
                highestNumberOfInstallments=orders.get(i).getInstallmentCount();
            }
        }
        return highestNumberOfInstallments;
    }
}
