public class Test {
    public static void main(String[] args) {
        final int arrayLength=3;
        System.out.println("Non revised pyramids: \n");
        Pyramid[] pyramidArray=new Pyramid[arrayLength];
        pyramidArray[0]=new Pyramid();
        pyramidArray[1]=new Pyramid("Black", 3, 4.2, 5.5);
        pyramidArray[2]=new Pyramid("Red", 6, 7.8, 9.3);
        for (int i = 0; i < pyramidArray.length; i++) {
            pyramidArray[i].printInfo();
        }
        Pyramid.printAmountOfPyramids();
        System.out.println("Revised pyramids: \n");
        Rectangle r1=new Rectangle(3, 4.2);
        Rectangle r2=new Rectangle(6, 7.8);
        RevisedPyramid[] revisedPyramidArray=new RevisedPyramid[arrayLength];
        revisedPyramidArray[0]=new RevisedPyramid();
        revisedPyramidArray[1]=new RevisedPyramid("Black",5.5 , r1);
        revisedPyramidArray[2]=new RevisedPyramid("Red", 9.3, r2);
        for (int i = 0; i < revisedPyramidArray.length; i++) {
            revisedPyramidArray[i].printInfo();
        }
        RevisedPyramid.printAmountOfPyramids();
    }
}
