package com.ib.subtmatrix;

import com.ib.PrintMatrix;

public class SubtMatrix {

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 2, 3}, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = { { 7, 8, 9 }, { 6, 3, 2 }, { 2, 5, 7 } };
		int rows = matrix1.length;
        int cols = matrix1[0].length;
		int[][] matrix3 = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		PrintMatrix.printMatrix(matrix3,rows,cols);
	}
}
