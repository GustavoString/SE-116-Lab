public class Study extends Activity {
    @Override
    void completed() {
        if(Activity.timeLeft-1.5<0){
            Activity.timeLeft=0;
        } else{
            Activity.timeLeft-=1.5;
        }

        if(Activity.energy-25<0){
            Activity.energy=0;
        } else{
            Activity.energy-=25;
        }

        if(Activity.completionPercentage+15>100){
            Activity.completionPercentage=100;
        } else{
            Activity.completionPercentage+=15;
        }
    }
}
