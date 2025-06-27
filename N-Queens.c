#include <stdio.h>
#include <stdlib.h>

int solution_count = 0;
void printBoard(int *board, int N) {
    solution_count++;
    printf("Solution %d:\n", solution_count);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i] == j)
                printf("Q ");
            else
                printf(". ");
        }
        printf("\n");
    }
    printf("\n");
}
//
int isSafe(int *board, int row, int col) {
    for (int i = 0; i < row; i++) {

        if (board[i] == col || abs(board[i] - col) == abs(i - row))
            return 0;
    }
    return 1;
}
void solveNQueens(int *board, int row, int N) {
    if (row == N) {
        printBoard(board, N);
        return;
    }

    for (int col = 0; col < N; col++) {
        if (isSafe(board, row, col)) {
            board[row] = col;
            solveNQueens(board, row + 1, N);
        }
    }
}

int main() {
    int N;
    printf("Enter the value of N for the N-Queens problem: ");
    scanf("%d", &N);
// when N > 20 complexity explodes
    if (N < 1 || N > 20) {
        printf("Invalid N. Please enter a number between 1 and 20.\n");
        return 1;
    }
    int *board = (int *)malloc(N * sizeof(int));
    printf("\nSolving %d-Queens...\n\n", N);
    solveNQueens(board, 0, N);

    if (solution_count == 0)
        printf("No solutions found for N = %d.\n", N);
    else
        printf("Total solutions found: %d\n", solution_count);

    free(board);
    return 0;
}
