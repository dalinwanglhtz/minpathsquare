package com.codewardev.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codewardev.MinPathSquare;

class SolutionTest {

	private static int[][] smallSquare = new int[][]
            {
                { 1, 2, 3, 6, 2, 8, 1 },
                { 4, 8, 2, 4, 3, 1, 9 },
                { 1, 5, 3, 7, 9, 3, 1 },
                { 4, 9, 2, 1, 6, 9, 5 },
                { 7, 6, 8, 4, 7, 2, 6 },
                { 2, 1, 6, 2, 4, 8, 7 },
                { 8, 4, 3, 9, 2, 5, 8 }
            };
            
	@Test
	public void smallTests() {
		assertEquals(1, MinPathSquare.minPath(smallSquare, 0, 0));
	//	assertEquals(5, MinPathSquare.minPath(smallSquare, 0, 1));
	//	assertEquals(11, MinPathSquare.minPath(smallSquare, 2, 2));
	//	assertEquals(24, MinPathSquare.minPath(smallSquare, 4, 2));
	//	assertEquals(39, MinPathSquare.minPath(smallSquare, 6, 6));
	//	assertEquals(24, MinPathSquare.minPath(smallSquare, 4, 5));
	}
}
