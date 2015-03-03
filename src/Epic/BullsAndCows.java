/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

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
    public class BullsCows {
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
        Hash
        
    }
}
