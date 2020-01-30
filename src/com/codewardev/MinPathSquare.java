package com.codewardev;

import java.util.HashMap;
import java.util.Map;

// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath;
	private static Map<String, Integer> shortestPaths;
	
	public static int minPath(int[][] grid, int y, int x) {
		minPath = -1;
		
		printGrid(grid);
		shortestPaths = new HashMap<String, Integer>();

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(i-1 >= 0 && j-1 < 0) {
					//System.out.println("Coord: "+i+""+j+" left: none up: "+shortestPaths.get((i-1)+""+j)+" value: "+grid[i][j]);
					minPath = shortestPaths.get((i-1)+""+j) + grid[i][j];
				} else
				if(i-1 < 0 && j-1 >= 0) {
					//System.out.println("Coord: "+i+""+j+" left: "+shortestPaths.get(i+""+(j-1))+" up: none value: "+grid[i][j]);
					minPath = shortestPaths.get(i+""+(j-1)) + grid[i][j];
				} else
				if(i-1 >=0 && j-1 >= 0) {
					if(shortestPaths.get(i+""+(j-1)) < shortestPaths.get((i-1)+""+j)) {
						//System.out.println("Coord: "+i+""+j+" left(less): "+shortestPaths.get(i+""+(j-1))+" up: "+shortestPaths.get((i-1)+""+j)+" value: "+grid[i][j]);
						minPath = shortestPaths.get(i+""+(j-1)) + grid[i][j];
					} else {
						//System.out.println("Coord: "+i+""+j+" left: "+shortestPaths.get(i+""+(j-1))+" up(less): "+shortestPaths.get((i-1)+""+j)+" value: "+grid[i][j]);
						minPath = shortestPaths.get((i-1)+""+j) + grid[i][j];
					}
				} else {
					//System.out.println("Coord: "+i+""+j+" left: none up: none value: "+grid[i][j]);
					minPath = grid[i][j];
				}
				
				shortestPaths.put(i+""+j, minPath);
				
				minPath = -1;
			}
		}
		
		
		System.out.println("finalMinPath is: "+shortestPaths.get(x+""+y));
		return shortestPaths.get(x+""+y);
	}


	private static void printGrid(int[][] grid) {
		System.out.println("Grid:");
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

}
