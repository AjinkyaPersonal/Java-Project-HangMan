import java.util.Scanner;

public class HangManMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting Game");

        String notused = "abcdefghijklmnopqrstuvwxyz";

        String words[] = {"computer" , "mouse" , "screen" , "display" , "language" };

        String randomWord = words[(int)Math.random() * words.length];

        System.out.println("The word has "+randomWord.length()+" letters.");

        char[] letters = new char[randomWord.length()];

        for (int i = 0; i < letters.length; i++) {
            letters[i] = '.';
        }

        int lives = 3;

        while(lives >0){
            System.out.print("Lives: ");

            for (int i = 0; i < lives; i++) {
                System.out.print("0");
            }

            System.out.println();
            System.out.println("Input: ");

            String input = sc.nextLine();

            char letter = input.charAt(0);



            boolean isGuessCorrect = false;

            for (int i = 0; i < randomWord.length(); i++) {
                char l = randomWord.charAt(i);

                if(l==letter){
                    letters[i] = l;
                    isGuessCorrect = true;
                }
            }

            if(!isGuessCorrect){
                lives--;
            }

            boolean isGameFinished = true;

            System.out.print("word: ");

            for (int i = 0; i < letters.length; i++) {
                if(letters[i] == '.'){
                    isGameFinished = false;
                }
                System.out.print(letters[i]);
            }

            System.out.println();

            notused = notused.replace(letter,'.');
            System.out.println("Not used: " + notused);

            System.out.println("---------------------");

            if( isGameFinished){
                System.out.println("You Won!");
                break;
            }
        }

        if(lives==0){
            System.out.println("You lost! The word was: " + randomWord);
        }
        System.out.println("Exiting Game");
    }
}
