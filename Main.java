// Caitlin Mooney
// Course: CS-280 Kapleau
// Start Date: 05/22/20
// Due Date: 06/08/20
// Final Submission:
// Assignment: Project 1 - Knight's Tour
// Sources: Thank you to:
//      geeksforgeeks ( https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/ )
//      tutorialspoint ( https://www.tutorialspoint.com/The-Knight-s-tour-problem )
//      V. Anton Spraul ( https://youtu.be/gBC_Fd8EE8A )
//      Numberphile ( https://youtu.be/ab_dY3dZFHM )
//      BitDegree ( https://www.bitdegree.org/learn/random-number-generator-cpp )
package com.company;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static int EIGHT = 8;

    public static void outputBoard(int board[][]){
        if (EIGHT != 8) {
            System.out.println("OOPS!");
        }
        else {
            for (int i = 0; i < EIGHT; i++) {
                for (int j = 0; j < EIGHT; j++) {
                    System.out.print(board[i][j] + " \t");
                }
                System.out.print("\n");
            }
        }
    }

    public static boolean checkBounds(int possibleX, int possibleY){
        if (possibleX >= 0 && possibleX < 8 && possibleY >= 0 && possibleY < 8 ){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checkVisited(int possibleX, int possibleY, int board[][]){
        if (board[possibleX][possibleY] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int tryNext(int row, int col, int[][] board, int counterS, int[] movesX, int[] movesY){
        if (counterS == 65){
            return 1;
        }
        for (int i = 0; i < 8; i++){
            int newRow = row + movesX[i];
            int newCol = col + movesY[i];
            if (checkBounds(newRow, newCol) && checkVisited(newRow, newCol, board)){
                board[newRow][newCol] = counterS;
                if (tryNext(newRow, newCol, board, counterS+1, movesX, movesY) == 1){
                    return 1;
                }
                else{
                    board[newRow][newCol] = 0;
                }
            }
        }
        return 0;
    }

    public static int tourBoard(int rX, int rY, int[][] board, int counterS){
        int movesX[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int movesY[] = {1, 2, 2, 1, -1, -2, -2, -1};

        //int intArray[][];
       // intArray = new board[8][8];
        //int counterS = 1;

        //for (int i = 0; i < 8; i++) {
        //    for (int j = 0; j < 8; j++) {
        //        board[i][j] = 0;
        //    }
        //}

        board[rX][rY] = counterS;

        if (tryNext(rX, rY, board, counterS+1, movesX, movesY) == 1){
            outputBoard(board);
        }
        else{
            System.out.print("No solution!");
        }
        return 1;

    }

    public static void main(String[] args) {
        int rX = 0;
        int rY = 0;

        int board[][] = new int[8][8];
        int counterS = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
        tourBoard(rX,rY, board, counterS);
    }

}
