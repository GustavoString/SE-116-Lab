import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        try {
            ArithmeticOperation[] operations = new ArithmeticOperation[4];
            for (int i = 0; i < operations.length; i++) {
                System.out.print("Enter operand1 for object number "+(i+1)+":");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int a=s1.nextInt();
                System.out.print("Enter operand2 for object number "+(i+1)+":");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int b=s1.nextInt();
                operations[i] = new ArithmeticOperation(a,b);
            }

            try {
                System.out.println(operations[0].getOperand1()+" + "+operations[0].getOperand2()+" = "+operations[0].add());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Enter operand1:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int a=s1.nextInt();
                System.out.print("Enter operand2:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int b=s1.nextInt();
                ArithmeticOperation op1=new ArithmeticOperation(a,b);
                System.out.println(op1.getOperand1()+" + "+op1.getOperand2()+" = "+op1.add());
            }

            try {
                System.out.println(operations[1].getOperand1()+" - "+operations[1].getOperand2()+" = "+operations[1].subtract());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Enter operand1:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int a=s1.nextInt();
                System.out.print("Enter operand2:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int b=s1.nextInt();
                ArithmeticOperation op1=new ArithmeticOperation(a,b);
                System.out.println(op1.getOperand1()+" - "+op1.getOperand2()+" = "+op1.subtract());
            }

            try {
                System.out.println(operations[2].getOperand1()+" * "+operations[2].getOperand2()+" = "+operations[2].multiply());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Enter operand1:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int a=s1.nextInt();
                System.out.print("Enter operand2:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int b=s1.nextInt();
                ArithmeticOperation op1=new ArithmeticOperation(a,b);
                System.out.println(op1.getOperand1()+" * "+op1.getOperand2()+" = "+op1.multiply());
            }

            try {
                System.out.println(operations[3].getOperand1()+" / "+operations[3].getOperand2()+" = "+operations[3].divide());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Enter operand1:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int a=s1.nextInt();
                System.out.print("Enter operand2:");
                if(!s1.hasNextInt()){
                    throw new NumberFormatException("The entered input is not an integer.");
                }
                int b=s1.nextInt();
                ArithmeticOperation op1=new ArithmeticOperation(a,b);
                System.out.println(op1.getOperand1()+" / "+op1.getOperand2()+" = "+op1.divide());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            if(s1!=null){
                s1.close();
            }
        }
    }
}
