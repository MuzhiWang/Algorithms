/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class Assignment5 {
    //BreathFirstSearch unaccomplished

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        Bipartite bipartiteGraph = new Bipartite();
        System.out.print("The graphOne is bipartite or not: ");
        System.out.println(bipartiteGraph.ifBipartite(graph.graphOne()));
        System.out.print("The graphTwo is bipartite or not: ");
        System.out.println(bipartiteGraph.ifBipartite(graph.graphTwo()));
        System.out.print("The graphThree is bipartite or not: ");
        System.out.println(bipartiteGraph.ifBipartite(graph.graphThree()));   
        
        
        FirstKElements kthElements = new FirstKElements();
        int[] input = {5,6,9,0,4,3,55,68,12,45,63,99};
        int[] output = kthElements.firstKElements(input);
        System.out.print("The smallest k-th elements are: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
        
        /*
        KthSmallestInMatrix kthInMatrix = new KthSmallestInMatrix();
        int[][] matrix = {
		{1, 3, 4, 8}, 
		{4, 5, 7, 13}, 
		{6, 6, 10, 14}, 
		{7, 8, 12, 15}
		};
        
        for (int k = 1; k <= 9; k++) {
            System.out.print(kthInMatrix.kth(matrix, k) + " ");
        }
        System.out.println();
        */
        KthSmallestInMatrix kthInMatrix = new KthSmallestInMatrix();
        int[][] matrix = {
		{1, 3, 4, 8}, 
		{4, 5, 7, 13}, 
		{6, 6, 10, 14}, 
		{7, 8, 12, 15}
		};
        int k = 17;
        int[] kthResult = kthInMatrix.kthSmallestInMatrix(matrix, k);
        System.out.print("The smallest k-th elements in matrix are: ");
        if (k > matrix.length * matrix.length) {
            k = matrix.length * matrix.length;
        }
        for (int i = 0; i < k; i++) {
            System.out.print(kthResult[i] + " ");
        }
        System.out.println();
        
        List<Tree> tree = new ArrayList<Tree>();
        Tree tree4 = new Tree(null, null);
        Tree tree5 = new Tree(null, null);
        Tree tree6 = new Tree(null, null);
        Tree tree7 = new Tree(null, null);
        Tree tree2 = new Tree(tree4, tree5);
        Tree tree3 = new Tree(tree6, tree7);
        Tree tree1 = new Tree(tree2, tree3);
        tree1.value = 5;
        tree2.value = 3;
        tree3.value = 7;
        tree4.value = 2;
        tree5.value = 4;
        tree6.value = 6;
        tree7.value = 9;
        BFSPrint bfsPrint = new BFSPrint();
        bfsPrint.treeBFSprint(tree1);

        
        
    
    }
    
}
