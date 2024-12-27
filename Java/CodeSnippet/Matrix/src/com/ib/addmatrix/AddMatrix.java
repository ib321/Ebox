package com.ib.addmatrix;

import com.ib.PrintMatrix;

public class AddMatrix {

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = { { 7, 8, 9 }, { 6, 3, 2 }, { 2, 5, 7 } };
		int[][] matrix3 = new int[3][3];

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}

		PrintMatrix.printMatrix(matrix3);
	}
}
