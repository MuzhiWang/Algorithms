/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 *
 * @author Muzhi
 */
public class Assignment9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RemoveDuplicatedLetters question1 = new RemoveDuplicatedLetters();
        String str = "aaabbbbcccacccdddbbba";
        System.out.println("After remove the duplicated and adjacent letters, the string is: ");
        char[] result1 = question1.removeDuplicatedLetters(str);
        int index = 0;
        for (index = 0; index < str.length(); index++) {
            System.out.print(result1[index]);
        }
        System.out.println();
        
        ReplaceTheSpace question2 = new ReplaceTheSpace();
        String inputStr = "hollow_world_memeda"; 
        char[] input = inputStr.toCharArray();
        char[] result2 = question2.repalceTheSpace(input);
        System.out.println("After repalce the '_', the string is:");
        for (index = 0; index < result2.length; index++) {
            System.out.print(result2[index]);
        }
        System.out.println();
        
        ReverseTheString reverseWord = new ReverseTheString();
        String str3 = "MuzhiWang"; 
        char[] result3 = reverseWord.reverseAWord(str3);
        System.out.println("After reverse the word is:");
        for (index = 0; index < result3.length; index++) {
            System.out.print(result3[index]);
        }
        System.out.println();
        
        ReverseTheString reverseSentence = new ReverseTheString();
        String str4 = "I love you more than you love me";
        char[] result4 = reverseSentence.reverseSentence(str4);
        for (index = 0; index < result4.length; index++) {
            System.out.print(result4[index]);
        }
        System.out.println();
        
        DeDuplicateAdjacentLetter deDuplicate = new DeDuplicateAdjacentLetter();
        String str5 = "abbbbbbaaaz";
        String str6 = "abaabbccaazz";
        String str7 = "";
        char[] result5 = deDuplicate.deDuplicate(str5);
        System.out.println("De-duplicate adjacent letter: ");
        if (result5 == null) {
            System.out.print("null");
        } else {
            for (index = 0; index < result5.length; index++) {
                System.out.print(result5[index]);
            }
        }
        System.out.println();
        
        
    }
    
}
