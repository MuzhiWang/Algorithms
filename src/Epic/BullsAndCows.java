/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.HashMap;

/**
 *
 * @author Muzhi
 */

/*
There’s a word guessing game. 
One person think a word, and the other one guess a word, both words have the same length. 
The person should return the number of bulls and cows for the guessing. 
Bulls represent the number of same characters in the same spots, 
whereas cows represent the number of characters guessed right but in the wrong spots. 
Write a program with two input strings, return the number of bulls and cows.
*/
public class BullsAndCows {
    public static class BullsCows {
        int Bulls;
        int Cows;
        public BullsCows(int bulls, int cows) {
            Bulls = bulls;
            Cows = cows;
        }
    }
    
    public BullsCows getBullsAndCows(String word, String guessWord) {
        assert word != null && guessWord != null && word.length() == guessWord.length();
        if (word.length() == 0)
            return new BullsCows(0, 0);
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            if (hash.containsKey(word.charAt(i)))
                hash.put(word.charAt(i), hash.get(word.charAt(i)) + 1);
            else
                hash.put(word.charAt(i), 1);
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == guessWord.charAt(i)) {
                bulls++;
                hash.put(word.charAt(i), hash.get(word.charAt(i)) - 1);
            } else if (hash.containsKey(guessWord.charAt(i)) && hash.get(guessWord.charAt(i)) > 0) {
                cows++;
                hash.put(guessWord.charAt(i), hash.get(guessWord.charAt(i)) - 1);
            }
        }
        return new BullsCows(bulls, cows);
    }
    
    public static void main(String... args) {
        BullsAndCows bc = new BullsAndCows();
        BullsCows res = bc.getBullsAndCows("epic", "epci");
        System.out.printf("Bulls number is %d , cows number is %d ", res.Bulls, res.Cows);
        
    }
}
