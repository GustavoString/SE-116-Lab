public class MP3_Test {
    public static void main(String[] args) {
        // just wrote this to test, not very well written but works well as a test.

        MP3[] songs=new MP3[4];
        MP3 song1=new MP3(128, "1:30", "Uriah Heep", "Demons and Wizards", "The Wizard", 1988);
        MP3 song2=new MP3(128, "1:30", "Uriah Heep", "Demons and Wizards", "Traveller in Time", 1988);
        MP3 song3=new MP3(128, "1:30", "Jethro Tull", "Heavy Horses", "Heavy Horses", 1988);
        MP3 song4=new MP3(128, "1:30", "Rainbow", " Ritchie Blackmores Rainbow", "The Temple of the King", 1988);

        songs[0]=song1;
        songs[1]=song2;
        songs[2]=song3;
        songs[3]=song4;

        MP3[][] sortedSongs=MP3.albumSorter(songs);

        int albumCount=1;

        for (int i = 0; i < sortedSongs.length; i++) {
            try{
                System.out.println("\nAlbum "+(albumCount++)+" name: "+sortedSongs[i][0].AlbumName+"\n"+"Artist: "+sortedSongs[i][0].ArtistName+"\n");
            } catch(Exception e){

            }
            for (int j = 0; j < sortedSongs[i].length; j++) {
                try{
                    if(sortedSongs[i][j].SongName!=null){
                        System.out.println("Song "+(j+1)+" name: "+sortedSongs[i][j].SongName);
                    }
                } catch(Exception e){

                }
            }
        }
    }
}
