package com.codewardev;

//https://www.codewars.com/kata/5845e3f680a8cf0bad00017d/train/java

import java.util.HashMap;
import java.util.Map;

public class MinPathSquare {
	
	public static int minPath(int[][] grid, int y, int x) {
		int minPath = -1;
		Map<String, Integer> shortestPaths = new HashMap<String, Integer>();
		System.out.println("row: "+x+" column:"+y);

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				int left = j-1, up = i-1;
				if(up >= 0 && left < 0) {
					minPath = shortestPaths.get(up+""+j) + grid[i][j];
				} else
				if(up < 0 && left >= 0) {
					minPath = shortestPaths.get(i+""+left) + grid[i][j];
				} else
				if(up >= 0 && left >= 0) {
					minPath = grid[i][j] + (shortestPaths.get(i+""+left) < shortestPaths.get(up+""+j)? shortestPaths.get(i+""+left):shortestPaths.get(up+""+j));
				} else {
					minPath = grid[i][j];
				}
				
				shortestPaths.put(i+""+j, minPath);
			}
		}
		
		
		System.out.println("Size of map: "+shortestPaths.size());
		System.out.println("finalMinPath is: "+shortestPaths.get(x+""+y));
		return shortestPaths.get(x+""+y);
	}

}
