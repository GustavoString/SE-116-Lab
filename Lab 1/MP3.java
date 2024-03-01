
public class MP3 {
    int CompressionRate;
    int DurationSeconds;
    String ArtistName;
    String AlbumName;
    String SongName;
    int AlbumYear;

    public MP3(int CompressionRate, String duration, String ArtistName, String AlbumName, String SongName, int AlbumYear){
        this.CompressionRate=CompressionRate;
        this.ArtistName=ArtistName;
        this.AlbumName=AlbumName;
        this.SongName=SongName;
        this.AlbumYear=AlbumYear;
        String[] tempString=duration.split(":");
        this.DurationSeconds=Integer.parseInt(tempString[0])*60+Integer.parseInt(tempString[1]);
    }

    public String getSize(){
        int sizeKB=this.CompressionRate*this.DurationSeconds;
        if(sizeKB<1024){
            return sizeKB+"KB";
        } else {
            return sizeKB/1024+"MB";
        }
    }

    public static MP3[][] albumSorter(MP3[] inputSongs){



        //starting from the first song, check if the other songs albums are the same as the one being checked,
        //and if so, add them to a list with the one being checked. Also add the name of the album being checked
        //to the albumsThatHaveBeenChecked string array. And while selecting the album name to check the others with
        //first check if it is in the albumsThatHaveBeenChecked array, and if yes, skip it.
       
        String[] albumsThatHaveBeenChecked=new String[inputSongs.length];

        int albumCount=0;

        for (int i = 0; i < inputSongs.length; i++) {

            boolean albumHasBeenChecked=false;

            for (int j = 0; j < albumsThatHaveBeenChecked.length; j++) {
                if(albumsThatHaveBeenChecked[j]!=null){
                    if(inputSongs[i].AlbumName.equals(albumsThatHaveBeenChecked[j])){
                        albumHasBeenChecked=true;
                        break;
                    }
                } else{
                    break;
                }
            }
            if(!albumHasBeenChecked){
                albumsThatHaveBeenChecked[albumCount++]=inputSongs[i].AlbumName;
            }
        }

        String[] albumNameList=new String[albumCount];
        for (int i = 0; i < albumNameList.length; i++) {
            albumNameList[i]=albumsThatHaveBeenChecked[i];
        }

        MP3[][] albums=new MP3[albumCount][inputSongs.length];

        for (int i = 0; i < albumNameList.length; i++) {
            for (int j = 0; j < inputSongs.length; j++) {
                if(albumNameList[i].equals(inputSongs[j].AlbumName)){
                    albums[i][0]=new MP3(inputSongs[j].CompressionRate, "1:30", inputSongs[j].ArtistName, inputSongs[j].AlbumName, inputSongs[j].SongName, inputSongs[j].AlbumYear);
                    break;
                }
            }
        }

        for (int i = 0; i < albums.length; i++) {
            int a=1;
            for (int j = 0; j < inputSongs.length; j++) {
                //make sure the song name is not the same
                if(albums[i][0].AlbumName.equals(inputSongs[j].AlbumName) && !albums[i][0].SongName.equals(inputSongs[j].SongName)){
                    albums[i][a++]=new MP3(inputSongs[j].CompressionRate, "1:30", inputSongs[j].ArtistName, inputSongs[j].AlbumName, inputSongs[j].SongName, inputSongs[j].AlbumYear);
                }
            }
        }
        
        return albums;
    }   
}
