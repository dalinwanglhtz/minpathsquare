package com.codewardev;


// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath;
	private static int distanceFromBeginning;
	
	public static int minPath(int[][] grid, int x, int y) {
		minPath = -1;
		distanceFromBeginning = 0;
		int[][] newGrid = new int[y+1][x+1];
		newGrid = formNewGrid(grid, x, y);
		//printGrid(newGrid);
		//System.out.println("Start construct");
		//long current = System.currentTimeMillis();
		GridNode gNode = constructGridNode(newGrid, 0, 0, x, y);
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


	private static GridNode constructGridNode(int[][] grid, int i, int j, int x, int y) {
		GridNode aNode = new GridNode(grid[i][j], i+""+j);
		distanceFromBeginning += aNode.getValue();
		aNode.setDistance(distanceFromBeginning);
		if(i == y && j == x) {
			if(minPath == -1 || minPath > aNode.getDistance()) {
				minPath = aNode.getDistance();
			}
		}
		int rIndex = j+1;
		int dIndex = i+1;
		if(rIndex < grid[i].length) {
			aNode.setRight(constructGridNode(grid, i, rIndex, x, y));
		}
		
		if(dIndex < grid.length) {
			aNode.setDown(constructGridNode(grid, dIndex, j, x, y));
		}
		
		distanceFromBeginning -= aNode.getValue();
		return aNode;
	}

}


class GridNode {
	private int value;
	private String key;
	private int distance;
	private GridNode right;
	private GridNode down;
	
	GridNode(int value, String key){
		this.value = value;
		this.key = key;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public GridNode getRight() {
		return right;
	}
	public void setRight(GridNode right) {
		this.right = right;
	}
	public GridNode getDown() {
		return down;
	}
	public void setDown(GridNode down) {
		this.down = down;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
