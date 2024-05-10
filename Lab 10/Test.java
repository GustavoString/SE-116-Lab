public class Test {
    public static void main(String[] args) {
        PlainText plainText=new PlainText("Welcome to the SE 116 course. The e-mail address of the course is the following: Se116Spring2023@ieu.edu.tr");

        HTMLText htmlText=new HTMLText("<html><head><title>Welcome to the SE 116 course.</title></head><body><p> The e-mail address of the course is the following: Se116Spring2023@ieu.edu.tr</p> </body> </html>");

        System.out.println("Email extracted from plain text: "+plainText.extractEmail());
        System.out.println("Email extracted from HTML text: "+htmlText.extractEmail());

        System.out.println("Count of letter 's' in plain text: "+plainText.countLetterFrequency('s'));
        System.out.println("Count of letter 's' in HTML text: "+htmlText.countLetterFrequency('s'));

        System.out.print("Plain text in reverse: ");
        plainText.reverseText();
        System.out.print("HTML text in reverse: ");
        htmlText.reverseText();
    }
}
