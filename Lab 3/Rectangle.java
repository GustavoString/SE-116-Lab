public class Rectangle {
    private double length;
    private double width;

    public Rectangle(){
        this.length=1;
        this.width=1;
    }

    public Rectangle(double length, double width){
        if(length<=0||width<=0){
            System.out.println("Invalid value(s).");
        } else{
            this.length=length;
            this.width=width;
        }
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
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

    public double getArea(){
        return this.length*this.width;
    }
}
