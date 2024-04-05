public class Rest extends Activity {
    @Override
    void completed() {
        if(Activity.timeLeft-1<0){
            Activity.timeLeft=0;
        } else{
            Activity.timeLeft-=1;
        }

        if(Activity.energy+25>100){
            Activity.energy=100;
        } else{
            Activity.energy+=25;
        }
    }
}
