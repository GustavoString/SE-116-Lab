public class Radio implements Playable {
    
    private String channelName;
    private String programName;
    private int volumeLevel;

    public Radio(){
        this.channelName="Undefined";
        this.programName="Undefined";
        this.volumeLevel=0;
    }

    public Radio(String channelName, String programName, int volumeLevel){
        this.channelName=channelName;
        this.programName=programName;
        if(volumeLevel>100||volumeLevel<0){
            System.out.println("Invalid volumeLevel value.");
        } else{
            this.volumeLevel=volumeLevel;
        }
    }

    public String getChannelName(){
        return this.channelName;
    }

    public String getProgramName(){
        return this.programName;
    }

    public int getVolumeLevel(){
        return this.volumeLevel;
    }

    public void setChannelName(String channelName){
        this.channelName=channelName;
    }

    public void setProgramName(String programName){
        this.programName=programName;
    }

    public void setVolumeLevel(int volumeLevel){
        if(volumeLevel>100||volumeLevel<0){
            System.out.println("Invalid volumeLevel value.");
        } else{
            this.volumeLevel=volumeLevel;
        }
    }

    public void play(){
        
    }

    public void stop(){

    }

    public void next(){

    }

    public void prev(){
        
    }
}
