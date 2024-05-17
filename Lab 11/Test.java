public class Test {
    public static void main(String[] args) {
        Book book1=new Book("LOTR","the person who wrote LOTR");
        Book book2=new Book("Harry potter spoilers","4chan users");
        Book book3=new Book("Family guy funniest moments","YouTube Shorts");

        Clothing c1=new Clothing(Clothing.TypeEnum.HAT, "White");
        Clothing c2=new Clothing(Clothing.TypeEnum.DRESS, "White");
        Clothing c3=new Clothing(Clothing.TypeEnum.JACKET, "Red");

        Utensil u1=new Utensil("Fork", "Metal");
        Utensil u2=new Utensil("Spoon", "Wood");
        Utensil u3=new Utensil("Knife", "Metal");

        Inventory storage=new Inventory();

        storage.storeItem(book1);
        storage.storeItem(book2);
        storage.storeItem(book3);
        storage.storeItem(c1);
        storage.storeItem(c2);
        storage.storeItem(c3);
        storage.storeItem(u1);
        storage.storeItem(u2);
        storage.storeItem(u3);

        storage.listAllItems();
    }
}
