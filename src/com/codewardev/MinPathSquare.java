package com.codewardev;


// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath;
	private static int distanceFromBeginning;
	
	public static int minPath(int[][] grid, int x, int y) {
		minPath = -1;
		distanceFromBeginning = 0;
		int[][] newGrid = formNewGrid(grid, x, y);
		printGrid(newGrid);
		//System.out.println("Start construct");
		//long current = System.currentTimeMillis();
		constructGridNode(newGrid, 0, 0, x, y);
		//System.out.println("end construct in "+(System.currentTimeMillis()-current)+" milliseconds");
		System.out.println("MinPath is: "+minPath);
		return minPath;
	}


	private static int[][] formNewGrid(int[][] grid, int x, int y) {
		int[][] newGrid = new int[y+1][x+1];
		for(int i=0; i<=y; i++) {
			for(int j=0; j<=x; j++) {
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


	private static void constructGridNode(int[][] grid, int i, int j, int x, int y) {
		distanceFromBeginning += grid[i][j];
		if(i == y && j == x) {
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

}
