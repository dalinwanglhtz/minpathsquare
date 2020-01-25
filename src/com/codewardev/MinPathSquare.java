package com.codewardev;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

// https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

public class MinPathSquare {

	private static int minPath;
	private static Stack<Integer> gridStack;
	private static Map<Integer, Stack<Integer>> allStacks;
	
	public static int minPath(int[][] grid, int x, int y) {
		minPath = -1;
		gridStack = new Stack<Integer>();
		//allStacks = new HashMap<Integer, Stack<Integer>>();
		GridNode gNode = constructGridNode(grid, 0, 0);
		traverseGridNode(gNode, y, x);
		System.out.println("MinPath is: "+minPath);
		//printStack();
		return minPath;
	}

	private static void printStack() {
		Stack<Integer> minStack = allStacks.get(minPath);
		Iterator<Integer> iter = minStack.iterator();
		while(iter.hasNext()) {
			System.out.println("Integer: "+iter.next());
		}
		
	}

	private static void traverseGridNode(GridNode gNode, int x, int y) {
		gridStack.add(gNode.getValue());
		if(gNode.getKey().equalsIgnoreCase(x+""+y)) {
			int totalPath = gridStack.stream().mapToInt(Integer::valueOf).sum();
			if(minPath == -1 || minPath > totalPath) {
				//allStacks.put(totalPath, (Stack<Integer>) gridStack.clone());
				minPath = totalPath;
			}
			gridStack.pop();
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
