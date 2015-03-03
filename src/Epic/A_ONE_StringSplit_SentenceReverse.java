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

/*	From a given string, replace all instances of 'a' with 'one' and 
 *	'A' with 'ONE'.
 *	Example input: "A boy is playing in a garden";
 *	Example output: "ONE boy is playing in one garden"
 *	Note that 'A' and 'a' are to be replaced only when they are single
 *	characters.
 */
/*	Given a string, replace the words whose length >=4 and is even, 
 *	with a space between the two equal halves of the word. Consider
 *	only alphabets for finding the evenness of the word.
 *	
 *	Example,
 *	input: "A person can't walk in this street";
 *	output: "A per son ca n't walk in th is str eet";
 */
/*	Reverse words in a sentence. 
 *	Example: This is great.
 *	Output: great is This.
 *
 */

public class A_ONE_StringSplit_SentenceReverse {
    public String a_one(String str) {
        if (str == null || str.length() == 0)
            return null;
        String replace_a = "one ";
        String replace_A = "ONE ";
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ' && str.charAt(i - 1) == 'a' || (i == str.length() - 1 && str.charAt(i) == 'a' && str.charAt(i - 1) == ' ')) {
                res.deleteCharAt(res.length() - 1);
                res.append(replace_a);
            }
            else if (str.charAt(i) == ' ' && str.charAt(i - 1) == 'A' || (i == str.length() - 1 && str.charAt(i) == 'A' && str.charAt(i - 1) == ' ')) {
                res.deleteCharAt(res.length() - 1);
                res.append(replace_A);
            }
            else
                res.append(str.charAt(i));
        } 
        return res.toString();
    }
    
    public String strSplitInMiddle(String str) {
        if (str == null || str.length() == 0)
            return null;
        String[] strParts = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strParts.length; ++i) {
            if (checkLengthWithOnlyAlphabets(strParts[i]) % 2 == 0) {
                res.append(strParts[i].substring(0, strParts[i].length() / 2));
                res.append(" ");
                res.append(strParts[i].substring(strParts[i].length() / 2) + " ");
            } else
                res.append(strParts[i] + " ");
        }
        return res.toString();
    }
    
    private int checkLengthWithOnlyAlphabets(String word) {
        int len = word.length();
        for (int i = 0; i < len; ++i) {
            if ((word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'z' <= 0) || (word.charAt(i) - 'A' >= 0 && word.charAt(i) - 'Z' <= 0))
                continue;
            else
                len--;
        }
        return len;
    }
    
    public String sentenceReverse(String sentence) {
        assert sentence != null && sentence.length() > 0;
        String[] senParts = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = senParts.length - 1; i >= 0; --i) {
            res.append(senParts[i] + " ");
        }
        return res.toString();
    }
    
    public static void main(String... args) {
        A_ONE_StringSplit_SentenceReverse aOne = new A_ONE_StringSplit_SentenceReverse();
        String str = "a boy is A mana.";
        System.out.println(aOne.a_one(str));
        
        String str2 = "A person can't walk in this street";
        System.out.println(aOne.strSplitInMiddle(str2));
        
        System.out.println(aOne.checkLengthWithOnlyAlphabets("can't"));
        
        String str3 = "how to reverse the sentence.";
        System.out.println(aOne.sentenceReverse(str3));
    }
}
