package com.codewardev;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath;
	private static int distanceFromBeginning;
	private static Map<String, Integer> shortestPaths = new HashMap<String, Integer>();
	
	public static int minPath(int[][] grid, int y, int x) {
		minPath = -1;
		distanceFromBeginning = 0;
		int[][] newGrid = formNewGrid(grid, 0, 0, x, y);
		
		System.out.println("Size of map: "+shortestPaths.size());
		
		printGrid(grid);
		
		if(!shortestPaths.isEmpty() && grid[0][0] != shortestPaths.get("00")) {
			shortestPaths = new HashMap<String, Integer>();
		}
		
		if(!shortestPaths.containsKey(x+""+y)) {
			for(int i=0; i<grid.length; i++) {
				for(int j=0; j<grid[i].length; j++) {
					if(i-1 >= 0 && j-1 < 0) {
						System.out.println("Coord: "+i+""+j+" left: none up: "+shortestPaths.get((i-1)+""+j)+" value: "+grid[i][j]);
						minPath = shortestPaths.get((i-1)+""+j) + grid[i][j];
					} else
					if(i-1 < 0 && j-1 >= 0) {
						System.out.println("Coord: "+i+""+j+" left: "+shortestPaths.get(i+""+(j-1))+" up: none value: "+grid[i][j]);
						minPath = shortestPaths.get(i+""+(j-1)) + grid[i][j];
					} else
					if(i-1 >=0 && j-1 >= 0) {
						if(shortestPaths.get(i+""+(j-1)) < shortestPaths.get((i-1)+""+j)) {
							System.out.println("Coord: "+i+""+j+" left(less): "+shortestPaths.get(i+""+(j-1))+" up: "+shortestPaths.get((i-1)+""+j)+" value: "+grid[i][j]);
							minPath = shortestPaths.get(i+""+(j-1)) + grid[i][j];
						} else {
							System.out.println("Coord: "+i+""+j+" left: "+shortestPaths.get(i+""+(j-1))+" up(less): "+shortestPaths.get((i-1)+""+j)+" value: "+grid[i][j]);
							minPath = shortestPaths.get((i-1)+""+j) + grid[i][j];
						}
					} else {
						System.out.println("Coord: "+i+""+j+" left: none up: none value: "+grid[i][j]);
						minPath = grid[i][j];
					}
					
					shortestPaths.put(i+""+j, minPath);
					
					minPath = -1;
					//if(!shortestPaths.containsKey(i+""+j)) {
						//constructGridNode(newGrid, 0, 0, i, j);
					//	shortestPaths.put(i+""+j, minPath);
						//System.out.println("Key: "+i+""+j+" Value: "+minPath);
						//minPath = -1;
						//distanceFromBeginning = 0;
					//}
				}
			}
		}
		
//		for(Entry<String, Integer> set: shortestPaths.entrySet()) {
//			System.out.println("Key: "+set.getKey()+" minPath: "+set.getValue());
//		}
		
		System.out.println("finalMinPath is: "+shortestPaths.get(x+""+y));
		return shortestPaths.get(x+""+y);
	}


	private static void constructGridNode(int[][] grid, int i, int j, int x, int y) {
		distanceFromBeginning += grid[i][j];
		if(i == x && j == y) {
			if(minPath == -1 || minPath > distanceFromBeginning) {
				minPath = distanceFromBeginning;
			}
			distanceFromBeginning -= grid[i][j];
			return;
		}
		int rIndex = j+1;
		int dIndex = i+1;
		if(rIndex < grid[i].length) {
			constructGridNode(grid, i, rIndex, x, y);
		}
		
		if(dIndex < grid.length) {
			constructGridNode(grid, dIndex, j, x, y);
		}
		
		distanceFromBeginning -= grid[i][j];
	}
	

	private static int[][] formNewGrid(int[][] grid, int startX, int startY, int x, int y) {
		int[][] newGrid = new int[x+1][y+1];
		for(int i=startX; i<=x; i++) {
			for(int j=startY; j<=y; j++) {
				newGrid[i][j] = grid[i][j];
			}
		}
		return newGrid;
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
