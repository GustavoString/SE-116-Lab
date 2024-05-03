import java.io.Serializable;

public class MusicPlayer implements Playable, Serializable {
    private String artistName;
    private String albumName;
    private String songName;

    public MusicPlayer(){
        this.artistName="Undefined";
        this.albumName="Undefined";
        this.songName="Undefined";
    }

    public MusicPlayer(String artistName, String albumName, String songName){
        this.artistName=artistName;
        this.albumName=albumName;
        this.songName=songName;
    }

    public String getArtistName(){
        return this.artistName;
    }

    public String getAlbumName(){
        return this.albumName;
    }

    public String getSongName(){
        return this.songName;
    }

    public void setArtistName(String artistName){
        this.artistName=artistName;
    }

    public void setAlbumName(String albumName){
        this.albumName=albumName;
    }

    public void setSongName(String songName){
        this.songName=songName;
    }

    public void play(){
        System.out.println("Now playing "+this.artistName+" - "+this.songName);
    }

    public void stop(){
        System.out.println("Stopping music...");
    }

    public void next(){
        System.out.println("Playing next song...");
    }

    public void prev(){
        System.out.println("Playing previous song...");
    }
}
