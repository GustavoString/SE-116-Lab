import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Eat eat=new Eat();
        Rest rest=new Rest();
        Study study=new Study();
        double timeAtStart=Activity.getTimeLeft();
        Scanner s1=new Scanner(System.in);
        while(Activity.canContinue()&&!Activity.isCompleted()){
            System.out.println();
            System.out.println();
            System.out.println("Completion percentage: "+Activity.getCompletionPercentage()+"%");
            System.out.println("Time left: "+Activity.getTimeLeft()+" hour(s).");
            System.out.println("Energy: "+Activity.getEnergy());
            System.out.println();
            System.out.print("To rest enter 1, to study enter 2, to eat enter 3:");
            int input=s1.nextInt();
            switch (input) {
                case 1:
                    rest.completed();
                    break;
                
                case 2:
                    study.completed();
                    break;

                case 3:
                    eat.completed();
                    break;

                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        s1.close();
        System.out.println("\n\n------------------------------\n\n");
        System.out.println("Completion percentage of the task: "+Activity.getCompletionPercentage()+"%");
        if(Activity.isCompleted()){
            System.out.println("Time taken to complete task: "+(timeAtStart-Activity.getTimeLeft()));
        }
    }
}
