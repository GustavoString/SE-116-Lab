public class Utensil {
    private String type;
    private String material;

    
    
    public Utensil() {
        this.type="Undefined";
        this.material="Undefined";
    }

    public Utensil(String type, String material) {
        this.type = type;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String toString(){
        return "Type of item: Utensil\nType of utensil: "+this.type+"\nMaterial: "+this.material;
    }
}
