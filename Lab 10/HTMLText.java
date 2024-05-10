public class HTMLText extends Text{


    public HTMLText(String text){
        super(text);
    }

    public int countLetterFrequency(char letter){
        String newText=removeHTMLTags(this.text);

        int count=0;
        for (int i = 0; i < newText.length(); i++) {
            if(newText.charAt(i)==letter){
                count++;
            }
        }

        return count;
    }

    public void reverseText(){
        String newText=removeHTMLTags(this.text);

        for (int index = newText.length()-1; index >= 0; index--) {
            System.out.print(newText.charAt(index));
        }
        System.out.println();
    }

    private String removeHTMLTags(String html) {
        return html.replaceAll("<[^>]*>", "");
    }
}
