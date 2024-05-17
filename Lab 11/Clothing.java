public class Clothing {
    private TypeEnum type;
    private String colour;

    enum TypeEnum{DRESS, T_SHIRT, JEANS, HAT, JACKET, SOCKS, UNDERWEAR}

    public Clothing(){
        this.colour="Undefined";
        this.type=null;
    }
    
    public Clothing(TypeEnum type, String colour) {
        this.type = type;
        this.colour = colour;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString(){
        String s;
        switch(this.type){
            case DRESS:
                s="Type of clothing: Dress";
                break;
            case T_SHIRT:
                s="Type of clothing: T-Shirt";
                break;
            case JEANS:
                s="Type of clothing: Jeans";
                break;
            case HAT:
                s="Type of clothing: Hat";
                break;
            case JACKET:
                s="Type of clothing: Jacket";
                break;
            case SOCKS:
                s="Type of clothing: Socks";
                break;
            case UNDERWEAR:
                s="Type of clothing: Underwear";
                break;
            default:
                s="The type for this clothing is undefined.";
                break;
        }
        return "Type of item: Clothing\n"+s+"\nColour: "+this.colour;
    }
} 
