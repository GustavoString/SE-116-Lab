public class Pyramid {
    private String colour;
    private double length;
    private double width;
    private double height;
    private static int numberOfPyramids;

    public Pyramid(){
        this.colour="white";
        this.length=1;
        this.width=1;
        this.height=1;
        numberOfPyramids++;
    }

    public Pyramid(String colour, double length, double width, double height){
        if(length<=0||width<=0||height<=0){
            System.out.println("Invalid value(s).");
        } else{
            this.colour=colour;
            this.length=length;
            this.width=width;
            this.height=height;
        }
        numberOfPyramids++;
    }

    public void setColour(String colour){
        this.colour=colour;
    }

    public void setLength(double length){
        if(length<=0){
            this.length=1;
        } else{
            this.length=length;
        }
    }

    public void setWidth(double width){
        if(width<=0){
            this.width=1;
        } else{
            this.width=width;
        }
    }

    public void setHeight(double height){
        if(height<=0){
            this.height=1;
        } else{
            this.height=height;
        }
    }

    public String getColour(){
        return this.colour;
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public double getVolume(){
        return this.length*this.height*this.width/3;
    }

    public static int getAmountOfPyramids(){
        return numberOfPyramids;
    }

    public static void printAmountOfPyramids(){
        System.out.println("Total number of pyramids: "+numberOfPyramids);
        System.out.println();
    }

    public void printInfo(){
        System.out.println("Colour: "+this.getColour());
        System.out.println("Length: "+this.getLength());
        System.out.println("Width: "+this.getWidth());
        System.out.println("Height: "+this.getHeight());
        System.out.println("Volume: "+this.getVolume());
        System.out.println();
    }
}
