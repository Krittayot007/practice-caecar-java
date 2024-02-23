import java.util.Scanner;

public class Caeser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input words to encode :\t");
        String inputWords = scan.nextLine();
        System.out.print("Please input shift :\t");
        int shift = scan.nextInt();
        System.out.print("You want to Encode(1) or Decode(2) tell me with integer :\t");
        int userChoice = scan.nextInt();
        if (userChoice == 1) {
            System.out.println("Your input :" + inputWords);
            System.out.println("Your shift :" + shift);
            System.out.println("Your result :" + encode(inputWords, shift));
        } else if (userChoice == 2) {
            System.out.println("Your input :" + inputWords);
            System.out.println("Your shift :" + shift);
            System.out.println("Your result :" + decode(inputWords, shift));
        } else {
            System.out.println("Error please start new App");
        }

        scan.close();
    }

    private static boolean isEnglish(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public static String encode(String input, int shift) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isEnglish(ch)) {
                char encodeText;
                if (Character.isLowerCase(ch)) {
                    encodeText = (char) (((ch - 'a' + shift) % 26) + 'a');
                } else {
                    encodeText = (char) (((ch - 'A' + shift) % 26) + 'A');
                }
                output += encodeText;
            } else {
                output += "INVALID input";
            }
        }
        return output;
    }

    public static String decode(String input, int shift) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isEnglish(ch)) {
                char decodeText;
                if (Character.isLowerCase(ch)) {
                    decodeText = (char) (((ch - 'a' - shift) % 26) + 'a');
                } else {
                    decodeText = (char) (((ch - 'A' - shift) % 26) + 'A');
                }
                output += decodeText;
            } else {
                output += "INVALID input";
            }
        }
        return output;
    }
}