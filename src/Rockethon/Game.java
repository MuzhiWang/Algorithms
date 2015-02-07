/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rockethon;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 *
 * @author Muzhi
 */
public class Game {
    
    public String game(int[] input) {
        assert input.length == 4;
        assert input[2] > 1 && input[3] > 1;
        if (input[0] > input[1])
            return "First";
        else
            return "Second";
    }
    
    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        Game game = new Game();
        
        int[] input = new int[4];
        String temp[] = sc.nextLine().split(" ");
        for (int i = 0; i < 4; ++i) {
            input[i] = Integer.parseInt(temp[i]);
        }
        out.println(game.game(input));
        
        out.close();
    }
    
    
    public static PrintWriter out;
    
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
}
