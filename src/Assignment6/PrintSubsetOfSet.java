/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;


/**
 *
 * @author Muzhi
 */
public class PrintSubsetOfSet {
    /*
    public void subSet(String set) {
        assert set != null;
        StringBuilder builder = new StringBuilder();
        int index = 0;
        subSet(set, index, builder);
    }
    
    private void subSet(String set, int index, StringBuilder builder) {
        if (index == set.length()) {
            System.out.println(builder.toString());
        } else {
            subSet(set, index + 1, builder);
            subSet(set, index + 1, builder.append(set.charAt(index)));
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    
    public void anotherSubSet(String set) {
        assert set != null;
        StringBuilder builder = new StringBuilder();
        int index = 0;
        anotherSubSet(set, index, builder);
    }
    
    private void anotherSubSet(String set, int index, StringBuilder builder) {
        System.out.append(builder.toString());
        
        for (int i = 0; i < set.length(); i++) {
            builder.append(set.charAt(i));
            anotherSubSet(set, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    */
    public void printSubset(String str) {
        int length = str.length();
        assert str != null;
        if (str.isEmpty()) {
            return;
        }
        int index = 0;
        StringBuilder subSet = new StringBuilder();
        printSubsetHelper(str, subSet, index);
        System.out.println();
        
    }
    
    private void printSubsetHelper(String str, StringBuilder subSet, int level) {
        if (level == str.length()) {
            //System.out.println("what the hell");
            System.out.print(subSet.toString() + " ");
            return;
        }
        subSet.append(str.charAt(level));
        printSubsetHelper(str, subSet, level + 1);
        subSet.deleteCharAt(subSet.length() - 1);
        printSubsetHelper(str, subSet, level + 1);
    }
}
