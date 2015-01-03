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
public class ReplaceTheSpace {
    public char[] repalceTheSpace(char[] input) {
        assert input != null;
        int index = 0;
        int spaceCounter = 0;
        for (index = 0; index < input.length; index++) {
            if (input[index] == '_') {
                spaceCounter++;
            }
        }
        char[] result = new char[input.length + spaceCounter * 2];
        
        int indexResult = result.length - 1;
        for (index = input.length - 1; index >= 0; index-- ) {
            if (input[index] == '_') {
                result[indexResult] = '%';
                result[indexResult - 1] = '0';
                result[indexResult - 2] = '2';
                indexResult -= 3;
            } else {
                result[indexResult] = input[index];
                indexResult--;
            }
        }
        return result;
    }
    
}
