import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Text{
    protected String text;

    public Text(String text){
        this.text=text;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text=text;
    }

    public void addText(String text){
        this.text+=text;
    }

    public String extractEmail(){
        String pattern="[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}";

        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(this.text);

        if(m.find()){
            return m.group();
        } else 
            return null;

        
    }

    abstract int countLetterFrequency(char letter);

    abstract void reverseText();
}