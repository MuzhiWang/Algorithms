/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author Muzhi
 */
public class PrintSubsetWithDu {
    
    /*******  Wrong solution... from YouTube...  *******/
    public void printSubset(String str) {
        for (int i = 0; i < str.length(); ++i) {
            boolean[] ifPrint = new boolean[str.length()];
            printSubset(str, ifPrint, 0, i);
        }
    }
    
    private void printSubset(String str, boolean[] ifPrint, int start, int remain) {
        if (remain == 0) {
            for (int i = 0; i < ifPrint.length; ++i) {
                if (ifPrint[i]) System.out.print(str.charAt(i) + " , ");
            }
            System.out.println();
        } else {
            if (start + remain > str.length()) {
                
            } else {
                for (int i = start; i < str.length(); ++i) {
                    if (!ifPrint[i]) {
                        ifPrint[i] = true;
                        printSubset(str, ifPrint, i + 1, remain - 1);
                        ifPrint[i] = false;
                    }
                }
            }
        }
    }
    
    /*********** Own solution DFS ************/
    public void printSubsetWithDu(String str) {
        if (str.isEmpty()) return;
        StringBuilder res = new StringBuilder();
        printSubsetHelper(str, res, 0);
    }
    
    private void printSubsetHelper(String str, StringBuilder res, int layer) {
            if (layer >= str.length()) {
                System.out.println(res.toString());
                return;
            }
            
            int index = layer, count = 0;
            if (index < str.length() - 1 && str.charAt(index) == str.charAt(index + 1)) {
                ++index;
                while (index < str.length() && str.charAt(index) == str.charAt(index - 1)) {
                    ++index;
                    ++count;
                }
                for (int j = count; j >= 0; --j) {
                    res.append(str.charAt(layer));
                    printSubsetHelper(str, res, index);
                }
                res.delete(res.length() - count - 1, res.length());
                printSubsetHelper(str, res, index);
            } else {
                res.append(str.charAt(layer));
                printSubsetHelper(str, res, layer + 1);
                res.deleteCharAt(res.length() - 1);
                printSubsetHelper(str, res, layer + 1);
            }
    }

    public static void main(String[] args) {
        String str = "aabbbcccc";
        PrintSubsetWithDu p = new PrintSubsetWithDu();
        //p.printSubset(str);
        p.printSubsetWithDu(str);
    }
}
