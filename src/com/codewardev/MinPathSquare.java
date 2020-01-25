package com.codewardev;

import java.util.Stack;

// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath = -1;
	private static Stack<GridNode> gridStack = new Stack<GridNode>();
	
	public static int minPath(int[][] grid, int x, int y) {
		GridNode gNode = constructGridNode(grid, 0, 0);
		traverseGridNode(gNode, y, x);
		//printStack();
		System.out.println("MinPath is: "+minPath);
		return 0;
	}

	private static void printStack() {
		for(int i=0; i<gridStack.size(); i++) {
			System.out.println("Key: "+gridStack.get(i).getKey()+" and Value: "+gridStack.get(i).getValue());
		}
		
	}

	private static void traverseGridNode(GridNode gNode, int x, int y) {
		gridStack.add(gNode);
		if(gNode.getKey().equalsIgnoreCase(x+""+y)) {
			int totalPath = 0;
			for(int i=0; i<gridStack.size(); i++) {
				System.out.println("Key: "+gridStack.get(i).getKey()+" and Value: "+gridStack.get(i).getValue());
				totalPath += gridStack.get(i).getValue();
			}
			if(minPath == -1 || minPath > totalPath) {
				minPath = totalPath;
			}
			return;
		}
		if(gNode.getRight() != null) traverseGridNode(gNode.getRight(), x, y);
		if(gNode.getDown() != null) traverseGridNode(gNode.getDown(), x, y);
		gridStack.pop();
	}

	private static GridNode constructGridNode(int[][] grid, int i, int j) {
		GridNode aNode = new GridNode(grid[i][j], i+""+j);
		int rIndex = j+1;
		int dIndex = i+1;
		if(rIndex < grid[i].length) {
			aNode.setRight(constructGridNode(grid, i, rIndex));
		}
		
		if(dIndex < grid.length) {
			aNode.setDown(constructGridNode(grid, dIndex, j));
		}
		
		return aNode;
	}

}


class GridNode {
	private int value;
	private String key;
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
	
	
}
