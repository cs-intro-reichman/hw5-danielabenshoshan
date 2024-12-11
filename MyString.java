import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(countChar("aaa", 'a'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
        System.out.println(subsetOf("sap", "sspace"));
        System.out.println(subsetOf("spa", "space"));
        System.out.println(spacedString("daniela"));
        System.out.println(randomStringOfLetters(3));
        System.out.println(remove("committee", "meet"));
        System.out.println(remove("abc", "b"));
        System.out.println(insertRandomly('s', "cat"));


    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        //// Replace the following statement with your code
        int counter = 0;
        if (str.length() == 0){
            return 0;
        }
        for(int i = 0; i < str.length(); i++){
            if( str.charAt(i) == ch){
                counter++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         //// Replace the following statement with your code
         boolean match = true;
         for ( int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            int times1 = countChar(str1, ch);
            int times2 = countChar(str2, ch);
            if (times1 > times2){
                match = false;
                break;
            }
        }
            if(match){
                return true;
            }
        
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        //// Replace the following statement with your code
        String output = ""; //if length equals 1 so the letter is first amd last means no spaces.
        if(str.length() == 0){
            return output;
        }
        for(int i = 0; i < str.length(); i++){
            char letter = str.charAt(i);
            if( i == str.length()-1){
                output += letter;
            }else{
                output += letter + " ";
            }
        }
        return output;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        //// Replace the following statement with your code
        Random random = new Random();
        String str = "";
        if (n == 0){
            return str;
        }
        while ( n > 0){
            int lowerRange = 97 + random.nextInt(122 - 97 + 1);
            char ch = (char) lowerRange;
            str += ch;
            n --;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("committee","meet") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       //// Replace the following statement with your code
       String output = "";
       if(str1.length() == 0){
        return output;
       } 
       if( str2.length() == 0){
        return str1;
       }
       if( str1.length() == str2.length()){
        return output;
       }
       String str2Copy = str2;
       for ( int i = 0; i < str1.length(); i++){
           char ch = str1.charAt(i);
           boolean match = false;
            for ( int j = 0; j < str2Copy.length() ; j++){
                if(ch == str2Copy.charAt(j)){
                    match = true;
                    str2Copy = str2Copy.substring(0, j) + str2Copy.substring(j + 1);
                    break;
                }
            }
            if( !match){
                output += ch;
            }
       }
        return output;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
