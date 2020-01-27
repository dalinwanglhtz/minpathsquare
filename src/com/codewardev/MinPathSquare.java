package com.codewardev;


// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath;
	private static int distanceFromBeginning;
	private static int shortestI;
	private static int shortestJ;
	private static int partialMinPath;
	private static int finalMinPath;
	
	public static int minPath(int[][] grid, int x, int y) {
		minPath = -1;
		distanceFromBeginning = 0;
		partialMinPath = -1;
		finalMinPath = 0;
		int[][] newGrid = formNewGrid(grid, 0, 0, x, y);
		printGrid(newGrid);
		System.out.println("Start construct");
		long current = System.currentTimeMillis();
		findPartialMinPath(newGrid, 0, 0);
		finalMinPath += partialMinPath;
		partialMinPath = -1;
		constructGridNode(newGrid, shortestI, shortestJ, x, y);
		System.out.println("MinPath is: "+minPath);
		finalMinPath += minPath;
		
		System.out.println("end construct in "+(System.currentTimeMillis()-current)+" milliseconds");
		System.out.println("finalMinPath is: "+finalMinPath);
		return minPath;
	}


	private static void findPartialMinPath(int[][] newGrid, int x, int y) {
		int j = newGrid.length-1;
		for(int i=0; i<newGrid.length; i++) {
			constructGridNode(newGrid, x, y, i, j);
			System.out.print("Minpath: "+minPath+" i:"+i+" j:"+j);
			if(partialMinPath == -1 || partialMinPath > minPath) {
				partialMinPath = minPath;
				shortestI = j;
				shortestJ = i;
			}
			System.out.println(" with value: "+newGrid[i][j]);
			j--;
			minPath = -1;
		}
		partialMinPath -= newGrid[shortestI][shortestJ];
		System.out.println("ShortestI: "+shortestI+" ShortestJ: "+shortestJ+" finalMin: "+partialMinPath);
	}


	private static int[][] formNewGrid(int[][] grid, int startX, int startY, int x, int y) {
		int[][] newGrid = new int[y+1][x+1];
		for(int i=startY; i<=y; i++) {
			for(int j=startX; j<=x; j++) {
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
