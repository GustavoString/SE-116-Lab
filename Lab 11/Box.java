public class Box<T> {
    private T item;
    private String label;

    public Box(){
        this.item=null;
        this.label="Undefined";
    }

    public Box(T item, String label) {
        this.item = item;
        this.label = label;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString(){
        return this.item.toString();
    }

    public void printInfo(){
        System.out.println(this.item.toString());
        System.out.println("Label: "+this.label);
    }
}
