public class Eat extends Activity {
    @Override
    void completed() {
        if(Activity.timeLeft-0.5<0){
            Activity.timeLeft=0;
        } else{
            Activity.timeLeft-=0.5;
        }

        if(energy+10>100){
            Activity.energy=100;
        } else{
            Activity.energy+=10;
        }
    }
}
