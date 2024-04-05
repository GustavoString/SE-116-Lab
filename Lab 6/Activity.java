abstract class Activity{
    protected static int completionPercentage;
    protected static double timeLeft;
    protected static int energy;

    public Activity(){
        completionPercentage=0;
        timeLeft=12.0;
        energy=100;
    }

    public Activity(int completionPercentage, double timeLeft, int energy){
        if(completionPercentage<0||completionPercentage>100){
            System.out.println("Invalid completionPercentage value.");
        } else{
            Activity.completionPercentage=completionPercentage;
        }

        if(timeLeft<0){
            System.out.println("Invalid timeLeft value.");
        } else{
            Activity.timeLeft=timeLeft;
        }

        if(energy<0){
            System.out.println("Invalid energy value.");
        } else{
            Activity.energy=energy;
        }
    }

    public static void setCompletionPercentage(int completionPercentage){
        if(completionPercentage<0||completionPercentage>100){
            System.out.println("Invalid completionPercentage value.");
        } else{
            Activity.completionPercentage=completionPercentage;
        }
    }

    public static void setTimeLeft(double timeLeft){
        if(timeLeft<0){
            System.out.println("Invalid timeLeft value.");
        } else{
            Activity.timeLeft=timeLeft;
        }
    }

    public static void setEnergy(int energy){
        if(energy<0){
            System.out.println("Invalid energy value.");
        } else{
            Activity.energy=energy;
        }
    }

    public static int getCompletionPercentage(){
        return Activity.completionPercentage;
    }    

    public static double getTimeLeft(){
        return Activity.timeLeft;
    }

    public static int getEnergy(){
        return Activity.energy;
    }

    abstract void completed();

    public static boolean canContinue(){
        if(Activity.timeLeft<=0||Activity.energy<=0){
            return false;
        } else{
            return true;
        }
    }

    public static boolean isCompleted(){
        if(Activity.completionPercentage>=100){
            return true;
        } else{
            return false;
        }
    }
}