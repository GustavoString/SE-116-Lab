import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Polynomial{

    X[] variables;
    int degree;

    public Polynomial(X[] variables){
        this.variables=variables;
        this.degree=variables[0].power;
        for (int i = 1; i < this.variables.length; i++) {
            if(variables[i].power>this.degree){
                this.degree=variables[i].power;
            }
        }
        this.cleanVariables();
    }

    public Polynomial(int amountOfTerms){
        if(amountOfTerms<0){
            System.out.println("Invalid amount of terms.");
            return;
        } else if(amountOfTerms==0){
            this.degree=0;
            this.variables=new X[0];
            return;
        } else{
            this.variables=new X[amountOfTerms];
            Scanner s1=new Scanner(System.in);
            for (int i = 0; i < amountOfTerms; i++) {
                System.out.print("Enter the coefficient of term number "+(i+1)+":");
                double coefficient=s1.nextDouble();
                System.out.print("Enter the power of term number "+(i+1)+":");
                int power=s1.nextInt();
                if(power<0){
                    System.out.println("Invalid power value.");
                    i--;
                    continue;
                }
                this.variables[i]=new X(power, coefficient);
            }
            s1.close();
            this.degree=this.variables[0].power;
            for (int i = 1; i < this.variables.length; i++) {
                if(this.variables[i].power>this.degree){
                    this.degree=this.variables[i].power;
                }
            }
            this.cleanVariables();
        }
    }

    public int getDegree(){
        return this.degree;
    }

    public double getValue(double x){
        double value=0;
        if(this.degree==0){
            return 0;
        }
        for (int i = 0; i < this.variables.length; i++) {
            value+=this.variables[i].getValue(x);
        }
        return value;
    }

    public void scalarMultiplication(double a){
        for (int i = 0; i < this.variables.length; i++) {
            this.variables[i].coefficient*=a;
        }
    }

    public void add(Polynomial p){
        LinkedList<X> Q=new LinkedList<X>();
        for (int i = 0; i < this.variables.length; i++) {
            Q.add(this.variables[i]);
        }


        LinkedList<X> P=new LinkedList<X>();
        for (int i = 0; i < p.variables.length; i++) {
            P.add(p.variables[i]);
        }


        for (int i = 0; i < Q.size(); i++) {
            for (int j = 0; j < P.size(); j++) {
                if(Q.get(i).power==P.get(j).power){
                    X temp=Q.get(i);
                    temp.coefficient+=P.get(i).coefficient;
                    Q.set(i, temp);
                    P.remove(j);
                    break;
                }
            }
        }


        if(P.size()>0){
            for (int i = 0; i < P.size(); i++) {
                Q.add(P.get(i));
            }
        }

        X[] temp=new X[Q.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=Q.get(i);
        }

        this.variables=temp;
    }

    public void multiply(Polynomial p){
        ArrayList<X> temp=new ArrayList<X>();
        for (int i = 0; i < this.variables.length; i++) {
            for (int j = 0; j < p.variables.length; j++) {
                X tempX=new X(this.variables[i].power+p.variables[i].power, this.variables[i].coefficient*p.variables[i].coefficient);
                temp.add(tempX);
            }
        }

        X[] returnTemp=new X[temp.size()];

        for (int i = 0; i < returnTemp.length; i++) {
            returnTemp[i]=temp.get(i);
        }

        //write function that adds the same power terms together to clean the polynomial up and call the function below

        this.variables=returnTemp;
        this.cleanVariables();
    }

    public void cleanVariables(){
        LinkedList<X> tempLinkedList=new LinkedList<X>();
        for (int i = 0; i < this.variables.length; i++) {
            tempLinkedList.add(this.variables[i]);
        }


        //there could be a bug below, look here in testing if you encounter issues

        boolean hasChanged=false;

        for (int i = 0; i < tempLinkedList.size()-1; i++) {
            for (int j = i+1; j < tempLinkedList.size(); j++) {
                if(tempLinkedList.get(i).power==tempLinkedList.get(j).power){
                    hasChanged=true;
                    X temp=new X(tempLinkedList.get(i).power, tempLinkedList.get(i).coefficient+tempLinkedList.get(j).coefficient);
                    tempLinkedList.set(i, temp);
                    tempLinkedList.remove(j);
                }
            }
        }

        if(!hasChanged){
            return;
        }

        X[] temp=new X[tempLinkedList.size()];
        
        for (int i = 0; i < temp.length; i++) {
            temp[i]=tempLinkedList.get(i);
        }

        this.variables=temp;

        //don't forget to call this function in the constructors and in multiply()
    }
} 

class X{

    int power;
    double coefficient;

    public X(int power, double coefficient){
        if(power<0){
            System.out.println("Invalid power value.");
            return;
        }
        this.power=power;
        this.coefficient=coefficient;
    } 

    public double getValue(double x){
        return this.coefficient*Math.pow(x, this.power);
    }

    public int getPower(){
        return this.power;
    }

    public double getCoefficient(){
        return this.coefficient;
    }

    public void setPower(int power){
        this.power=power;
    }

    public void setCoefficient(double coefficient){
        this.coefficient=coefficient;
    }
}