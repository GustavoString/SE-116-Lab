public class PlainText extends Text{
    

    public PlainText(String text){
        super(text);
    }

    public int countLetterFrequency(char letter){
        int count=0;
        for (int i = 0; i < this.getText().length(); i++) {
            if(this.text.charAt(i)==letter){
                count++;
            }
        }

        return count;
    }

    public void reverseText(){
        for (int index = this.getText().length()-1; index >= 0; index--) {
            System.out.print(this.text.charAt(index));
        }
        System.out.println();
    }
}
