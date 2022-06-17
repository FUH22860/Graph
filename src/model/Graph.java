package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
//	private static int[][] adjacent = { {0,1,0}, 
//									  	{1,0,1}, 
//									  	{0,1,0} };
	
	private static int[][] adjacent = { {0,1,1,1,0}, 
									  	{1,0,0,1,1}, 
									  	{1,0,0,1,0},
									  	{1,1,1,0,0},
									  	{0,1,0,0,0} };
	
	private static int[][] distance = { {0,1,2}, 
		  								{1,0,1}, 
		  								{2,1,0} };
	
	private static int[] eccentricities = {2,1,2}; // max Number from each individual Array in the distance Array
	
	private static int diameter = 2; // max Number in eccentricities
	
	private static int radius = 1; // half of the diameter
	
	private static int center = 2; // Every Knoten were eccentricities == radius
	
	private static int component[][] = { {1,2}, {2,3} };
	
	// Articulations, Bridges
	
	public Graph() {
		
	}
	
	public static int[][] calculateAdjacent2(int[][] adjacent) {
		
		int[][] adjacent2 = new int[adjacent.length][adjacent.length];
		
		for(int row = 0; row < adjacent.length; row++) {
			for(int col = 0; col < adjacent.length; col++) {    
				adjacent2[row][col] = 0; // Initialize Array
				for(int pos = 0; pos < adjacent.length; pos++) { // Position in Array
					adjacent2[row][col] += adjacent[row][pos] * adjacent[pos][col]; // row * col
				}
			}
		}
		
		return adjacent2;
	}
	
    public static void getAdjacent2() {
    	int[][] adjacent2 = calculateAdjacent2(adjacent);
    	
        System.out.println("A²(G):");
        if (adjacent.length > 0)
        {
            for (int i = 0; i < adjacent.length; i++) {
            	for (int j = 0; j < adjacent.length; j++) {
            		System.out.print(adjacent2[i][j] + ", ");
            	}
            	System.out.println("\n");
            }
        }
        else
        {
            System.out.println("Empty Array");
        }
    }
    
	public static int[][] calculateAdjacent3(int[][] adjacent, int[][] adjacent2) {
		
		int[][] adjacent3 = new int[adjacent.length][adjacent.length];
		
		for(int row = 0; row < adjacent.length; row++) {
			for(int col = 0; col < adjacent.length; col++) {    
				adjacent2[row][col] = 0; // Initialize Array
				for(int pos = 0; pos < adjacent.length; pos++) {
					adjacent3[row][col] += adjacent2[row][pos] * adjacent[pos][col];
				}
			}  
		}
		
		return adjacent3;
	}
    
    public static void getAdjacent3() {
    	int[][] adjacent3 = calculateAdjacent3(adjacent, calculateAdjacent2(adjacent));
    	
        System.out.println("A³(G):");
        if (adjacent.length > 0)
        {
            for (int i = 0; i < adjacent.length; i++) {
            	for (int j = 0; j < adjacent.length; j++) {
            		System.out.print(adjacent3[i][j] + ", ");
            	}
            }
        }
        else
        {
            System.out.println("Empty Array");
        }
    }
	
//	public boolean receiveValues() throws GraphException {
//		try (BufferedReader br = new BufferedReader(new FileReader(""))) { // filePath von application.RootBorderPane.importCSV()
//			String zeile;
//			String[] zeilenTeile;
//			String sep = ";"; // erwartetes Trennzeichen in der csv-Datei 
//			int rowLength = 0;
//
//			
//			zeile = br.readLine(); // wenn keine Zeile gefunden, dann return null
//
//			while(zeile != null) {
//				rowLength++;
//			}
//			
//		} catch (FileNotFoundException e) {
//			throw new GraphException("Datei-Fehler bei receiveValues(): " + e.getMessage());
//		} catch (IOException e) {
//			throw new GraphException("Datei-Fehler bei receiveValues(): " + e.getMessage());
//		}
//		return false;
//	}
	
	
	
}
