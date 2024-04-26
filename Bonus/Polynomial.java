
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;


public class Polynomial{

    LinkedList<X> variables;
    int degree;

    public Polynomial(LinkedList<X> variables){
        this.variables=variables;
        this.degree=variables.get(0).power;
        for (int i = 1; i < this.variables.size(); i++) {
            if(variables.get(i).power>this.degree){
                this.degree=variables.get(i).power;
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
            this.variables=new LinkedList<X>();
            return;
        } else{
            this.variables=new LinkedList<X>();
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
                X tempX=new X(power, coefficient);
                this.variables.add(tempX);
            }
            s1.close();
            this.degree=this.variables.get(0).power;
            for (int i = 1; i < this.variables.size(); i++) {
                if(this.variables.get(i).power>this.degree){
                    this.degree=this.variables.get(i).power;
                }
            }
            this.cleanVariables();
        }
    }

    public int getDegree(){
        return this.degree;
    }

    public void setVariables(LinkedList<X> variables){
        this.variables=variables;
    }

    public double getValue(double x){
        double value=0;
        if(this.degree==0){
            return 0;
        }
        for (int i = 0; i < this.variables.size(); i++) {
            value+=this.variables.get(i).getValue(x);
        }
        return value;
    }

    public void scalarMultiplication(double a){
        for (int i = 0; i < this.variables.size(); i++) {
            this.variables.get(i).coefficient*=a;
        }
    }

    public void addCoefficient(int index, X variable){
        if(this.variables.get(index).getPower() != variable.getPower()){
            System.out.println("Powers don't match at addCoefficient.\nthis.variables.get(index).getPower() = "+this.variables.get(index).getPower());
            System.out.println("variable.getPower() = "+variable.getPower());
            return;
        }
        X temp=new X(variable.getPower(), this.variables.get(index).getCoefficient()+variable.getCoefficient());
        this.variables.set(index, temp);
    }

    public void add(Polynomial p){
        LinkedList<X> toAdd = new LinkedList<X>();

        for (X pTerm : p.variables) {
            boolean matched=false;
            for (int i = 0; i < this.variables.size(); i++) {
                if(this.variables.get(i).power==pTerm.power){
                    this.addCoefficient(i, pTerm);
                    matched=true;
                    break;
                }
            }
            if (!matched) {
                toAdd.add(new X(pTerm.power, pTerm.coefficient));
            }
        }

        this.variables.addAll(toAdd);


        //call the clean function here after revising it
    }

    public void multiply(Polynomial p){
        //rewrite this!!!!!!!
        LinkedList<X> tempArrayList=new LinkedList<X>();
        for (X x1 : this.variables) {
            for (X x2 : p.variables) {
                X tempX=new X(x1.getPower()+x2.getPower(), x1.getCoefficient()*x2.getCoefficient());
                tempArrayList.add(tempX);
            }
        }
        this.setVariables(tempArrayList);
        //write function that adds the same power terms together to clean the polynomial up and call the function below
        this.cleanVariables();
    }

    public void cleanVariables() {
        // Temporary list to hold consolidated variables
        LinkedList<X> consolidatedVariables = new LinkedList<>();
    
        // Iterate through each term in the original list
        for (X originalTerm : this.variables) {
            boolean found = false;
    
            // Check if the term's power is already in the consolidated list
            Iterator<X> iterator = consolidatedVariables.iterator();
            while (iterator.hasNext()) {
                X consolidatedTerm = iterator.next();
                if (consolidatedTerm.getPower() == originalTerm.getPower()) {
                    // If found, update the coefficient and mark as found
                    consolidatedTerm.setCoefficient(consolidatedTerm.getCoefficient() + originalTerm.getCoefficient());
                    found = true;
                    break; // No need to check further
                }
            }
    
            // If the term's power wasn't found in the consolidated list, add it
            if (!found) {
                consolidatedVariables.add(new X(originalTerm.getPower(), originalTerm.getCoefficient()));
            }
        }

        // Replace the original list with the consolidated list
        this.variables = consolidatedVariables;

        for (int i = 0; i < this.variables.size(); i++) {
            if(this.variables.get(i).getCoefficient()==0){
                this.variables.remove(i);
            }
        }  
    }

    public void printPolynomial(){
        if(this.variables.isEmpty()){
            System.out.println("Polynomial is empty.");
            return;
        }

        if(this.variables.get(0).getCoefficient()%(double)1==0){
            if(this.variables.get(0).getPower()==0){
                System.out.print((int)this.variables.get(0).getCoefficient());
            } else if(this.variables.get(0).getPower()==1){
                System.out.print((int)this.variables.get(0).getCoefficient()+"x");
            } else{
                System.out.print((int)this.variables.get(0).getCoefficient()+"x^"+this.variables.get(0).getPower());
            }
        } else{
            if(this.variables.get(0).getPower()==0){
                System.out.print(this.variables.get(0).getCoefficient());
            } else if(this.variables.get(0).getPower()==1){
                System.out.print(this.variables.get(0).getCoefficient()+"x");
            } else{
                System.out.print(this.variables.get(0).getCoefficient()+"x^"+this.variables.get(0).getPower());
            }
        }
        for (int i = 1; i < this.variables.size(); i++) {
            if(this.variables.get(i).getCoefficient()%(double)1==0){
                if(this.variables.get(i).getPower()==0){
                    if(this.variables.get(i).getCoefficient()<0){
                        System.out.print((int)this.variables.get(i).getCoefficient());
                    } else{
                        System.out.print("+"+(int)this.variables.get(i).getCoefficient());
                    }
                } else if(this.variables.get(i).getPower()==1){
                    if(this.variables.get(i).getCoefficient()<0){
                        System.out.print((int)this.variables.get(i).getCoefficient()+"x");
                    } else{
                        System.out.print("+"+(int)this.variables.get(i).getCoefficient()+"x");
                    }
                } else{
                    if(this.variables.get(i).getCoefficient()<0){
                        System.out.print((int)this.variables.get(i).getCoefficient()+"x^"+this.variables.get(i).getPower());
                    } else{
                        System.out.print("+"+(int)this.variables.get(i).getCoefficient()+"x^"+this.variables.get(i).getPower());
                    }
                }
            } else{
                if(this.variables.get(i).getPower()==0){
                    if(this.variables.get(i).getCoefficient()<0){
                        System.out.print(this.variables.get(i).getCoefficient());
                    } else{
                        System.out.print("+"+this.variables.get(i).getCoefficient());
                    }
                } else if(this.variables.get(i).getPower()==1){
                    if(this.variables.get(i).getCoefficient()<0){
                        System.out.print(this.variables.get(i).getCoefficient()+"x");
                    } else{
                        System.out.print("+"+this.variables.get(i).getCoefficient()+"x");
                    }
                } else{
                    if(this.variables.get(i).getCoefficient()<0){
                        System.out.print(this.variables.get(i).getCoefficient()+"x^"+this.variables.get(i).getPower());
                    } else{
                        System.out.print("+"+this.variables.get(i).getCoefficient()+"x^"+this.variables.get(i).getPower());
                    }
                }
            }
        }
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
        if(coefficient==0){
            System.out.println("Invalid coefficient value. 0 will just cancel the coefficient out of the polynomial and is unnecessary.");
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