import java.util.ArrayList;

public class Inventory {
    private ArrayList<Box<?>> storage;

    public Inventory(){
        this.storage=new ArrayList<Box<?>>();
    }

    public Inventory(ArrayList<Box<?>> storage) {
        this.storage = storage;
    }

    public <T> String labelGenerator(T item){
        return item.getClass().getSimpleName();
    }

    public <T> void storeItem(T item){
        storage.add(new Box<>(item, this.labelGenerator(item)));
    }

    public void listAllItems() {
        int itemNo=1;
        for (Box<?> box : storage) {
            System.out.println("Item number "+itemNo);
            box.printInfo();
            itemNo++;
            System.out.println();
        }
    }

    public ArrayList<Box<?>> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<Box<?>> storage) {
        this.storage = storage;
    }
}
