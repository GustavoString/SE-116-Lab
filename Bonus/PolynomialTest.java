import java.util.LinkedList;

public class PolynomialTest {
    public static void main(String[] args) {
        X[] temp=new X[3];
        temp[0]=new X(2, 4);
        temp[1]=new X(1, -8);
        temp[2]=new X(0, 4);
        LinkedList<X> tempLinkedList=new LinkedList<X>();
        for (int i = 0; i < temp.length; i++) {
            tempLinkedList.add(temp[i]);
        }
        Polynomial p=new Polynomial(tempLinkedList);
        Polynomial tempPolynomial=new Polynomial(tempLinkedList);
        System.out.println("p(x):\n");
        p.printPolynomial();
        temp[0]=new X(2, 1);
        temp[1]=new X(1, 2);
        temp[2]=new X(0, 1);
        tempLinkedList.clear();
        for (int i = 0; i < temp.length; i++) {
            tempLinkedList.add(temp[i]);
        }
        Polynomial q=new Polynomial(tempLinkedList);
        System.out.println("\n\n\nq(x):\n");
        q.printPolynomial();
        p.add(q);
        System.out.println("\n\n\np(x)+q(x):\n");
        p.printPolynomial();
        
        q.multiply(tempPolynomial);
        System.out.println("\n\n\np(x)*q(x):\n");
        q.printPolynomial();
        
    }
}
