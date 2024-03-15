public class RevisedPyramid {
    private String colour;
    private double height;
    private Rectangle base;
    private static int numberOfPyramids;

    public RevisedPyramid(){
        this.colour="White";
        this.height=1;
        Rectangle r1=new Rectangle(1, 1);
        this.base=r1;
        numberOfPyramids++;
    }

    public RevisedPyramid(String colour, double height, Rectangle base){
        this.colour=colour;
        if(height<=0){
            System.out.println("Invalid height.");
        } else{
            this.height=height;
        }
        this.base=base;
        numberOfPyramids++;
    }

    public void setHeight(double height){
        if(height<=0){
            System.out.println("Invalid height.");
        } else{
            this.height=height;
        }
    }

    public void setBase(Rectangle base){
        this.base=base;
    }

    public void setColour(String colour){
        this.colour=colour;
    }

    public double getHeight(){
        return this.height;
    }

    public Rectangle getBase(){
        return this.base;
    }

    public String getColour(){
        return this.colour;
    }

    public double getVolume(){
        return this.base.getArea()*this.height/3;
    }

    public static int getAmountOfPyramids(){
        return numberOfPyramids;
    }

    public static void printAmountOfPyramids(){
        System.out.println("Total number of revised pyramids: "+numberOfPyramids);
        System.out.println();
    }

    public void printInfo(){
        System.out.println("Colour: "+this.getColour());
        System.out.println("Height: "+this.getHeight());
        System.out.println("Base area: "+this.base.getArea());
        System.out.println("Volume: "+this.getVolume());
        System.out.println();
    }
}
