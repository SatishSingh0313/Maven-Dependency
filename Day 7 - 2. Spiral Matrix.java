package day9;

//Spiral Matrix

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7] */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
    public static int[] spiralMatrix(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        // Convert List<Integer> to int[]
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
    
    public static void main(String[] args) {
    	
        Solution solution = new Solution();

        // Example 1
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result1 = solution.spiralMatrix(matrix1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1)); // Output should be [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Example 2
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] result2 = solution.spiralMatrix(matrix2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2)); // Output should be [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
