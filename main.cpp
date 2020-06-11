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

#include <iostream>
#include <stdio.h>

#include <stdbool.h>

#include <string.h>
#include <string>

#include <cstdlib>
//#include <ctime>


const int EIGHT = 8;

void outputBoard(int board[EIGHT][EIGHT]){

    if (EIGHT != 8){
        std::cout<<"OOPS!"<<std::endl;
    }
    else {
        for (int i = 0; i < EIGHT; i++){
            for (int j = 0; j < EIGHT; j++){
                std::cout<<board[i][j]<< "\t";
            }
            std::cout<<std::endl;
        }
    }
}

bool checkBounds(int possibleX, int possibleY){
    if (possibleX >= 0 && possibleX < 8 && possibleY >= 0 && possibleY < 8 ){
        return true;
    }
    else{
        return false;
    }
}
bool checkVisited(int possibleX, int possibleY, int board[EIGHT][EIGHT]) {
    if (board[possibleX][possibleY] == 0) {
        return true;
    }
    else {
        return false;
    }
}

int tryNext(int row, int col, int board[EIGHT][EIGHT], int counter, int movesX[EIGHT], int movesY[EIGHT]){

    if (counter == 65){
        return 1;
    }
    for (int i = 0; i < 8; i++){
        int newRow = row + movesX[i];
        int newCol = col + movesY[i];
        if (checkBounds(newRow, newCol) == true && checkVisited(newRow, newCol, board) == true){
            board[newRow][newCol] = counter;
            if (tryNext(newRow, newCol, board, counter+1, movesX, movesY) == 1){
                return 1;
            }
            else{
                board[newRow][newCol] = 0;
            }
        }
    }
    return 0;
}

int tourBoard(int rX, int rY){
    int row = 0;
    int col = 0;
    int movesX[8] = {2, 1, -1, -2, -2, -1, 1, 2};
    int movesY[8] = {1, 2, 2, 1, -1, -2, -2, -1};

    int board[8][8];
    for (int i = 0; i < 8; i++){
        for (int j = 0; j < 8; j++){
            board[i][j] = 0;
        }
    }

    int counter = 1;
    board[rX][rY] = counter;
    if (tryNext(rX, rY, board, counter+1, movesX, movesY) == 1){
        outputBoard(board);
    }
    else{
        std::cout << "No solution!" << std::endl;
    }
    return 1;

}

int main(){


//        srand((unsigned) time(0));
//        int rX = rand() % 8;
//        int rY = rand() % 8;
            int rX = 0;
            int rY = 0;
            tourBoard(rX, rY);

    return 0;
}

