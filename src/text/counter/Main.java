/**
 * Simple Java text counter.
 *
 * Input: user generated text
 * Output:
 *      - number of sentences in given input
 *      - number of words in given input
 *      - number of letters in given input
 *      - number of numbers (not digits) in given input
 *      - number of digits in given input
 *      - number of symbols (not letters or digits) in given input
 */

package text.counter;
import java.util.Scanner;

/**
 * Author: todyerutz@plainintricacy.wordpress.com
 */

public class Main {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String digits = "0123456789";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your text:");
        String input = in.nextLine();
        in.close();
        System.out.println();
        System.out.println("Number of sentences: " + calc_sen(input));
        System.out.println("Number of words: " + calc_words(input));
        System.out.println("Number of letters: " + calc_letters(input));
        System.out.println("Number of numbers: " + calc_nums(input));
        System.out.println("Number of digits: " + calc_digs(input));
        System.out.println("Number of symbols: " + calc_sym(input));
        System.out.println();

    }

    public static int calc_sen(String q){
        int sum=0;
        for(int i=0; i<q.length(); i++){
            if(q.charAt(i)=='.'||q.charAt(i)=='!'||q.charAt(i)=='?'){
                sum++;
            }
        }
        return sum;
    }

    public static int calc_words(String q){
        int sum=0;
        String[] parts = q.toUpperCase().split(" ");
        for(int i=0; i<parts.length; i++){
            if(alphabet.contains(parts[i].substring(0,1))){
                sum++;
            }
        }
        return sum;
    }

    public static int calc_letters(String q){
        String temp = q.toUpperCase();
        int sum=0;
        for(int i=0; i<temp.length(); i++){
            if(alphabet.indexOf(temp.charAt(i))!=-1){
                sum++;
            }
        }
        return sum;
    }

    public static int calc_nums(String q){
        int sum=0;
        for(int i=0; i<q.length()-1; i++){
            if(digits.indexOf(q.charAt(i))!=-1&&digits.indexOf(q.charAt(i+1))==-1){
                sum++;
            }
        }
        return sum;
    }

    public static int calc_digs(String q){
        int sum=0;
        for(int i=0; i<q.length(); i++){
            if(digits.indexOf(q.charAt(i))!=-1){
                sum++;
            }
        }
        return sum;
    }

    public static int calc_sym(String q){
        int sum=0;
        String temp = q.toUpperCase();
        for(int i=0; i<temp.length(); i++){
            if(alphabet.indexOf(temp.charAt(i))==-1&&digits.indexOf(temp.charAt(i))==-1&&temp.charAt(i)!=' '){
                sum++;
            }
        }
        return sum;
    }

}
