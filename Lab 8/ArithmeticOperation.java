public class ArithmeticOperation{
    private int operand1;
    private int operand2;

    public ArithmeticOperation(){
        this.operand1=1;
        this.operand2=1;
    }

    public ArithmeticOperation(int operand1, int operand2){
        this.operand1=operand1;
        this.operand2=operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }



    public int add(){
        if(operand1<0||operand2<0){
            throw new ArithmeticException("The operands must be non negative integers.");
        }
        return this.operand1+this.operand2;
    }

    public int subtract(){
        if(operand1<0||operand2<0){
            throw new ArithmeticException("The operands must be non negative integers.");
        }
        return this.operand1-this.operand2;
    }

    public int multiply(){
        if(operand1==0||operand2==0){
            throw new ArithmeticException("The operands must not be equal to 0.");
        }
        return this.operand1*this.operand2;
    }

    public int divide(){
        if(operand1==0||operand2==0){
            throw new ArithmeticException("The operands must not be equal to 0.");
        }
        return this.operand1/this.operand2;
    }
}