///
///题目：输出一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
///

/// 思路：从外向内，每一次打印顺时针打印一圈
/// 注意：停止打印的条件，某圈的次序要小于矩阵的行数和列数的一半，如果超过一半，就无法形成一个圈了

#include <iostream>
using namespace std;

//顺时针打印矩阵
void printMatrixCicle(int matrix[][4], int rows, int cols);

//打印某一全
void printOneCicle(int matrix[][4], int start, int rows, int cols);

int main()
{

    int matrix[4][4] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

    printMatrixCicle(matrix, 4, 4);
}

//顺时针打印矩阵
void printMatrixCicle(int matrix[][4], int rows, int cols)
{
    if (matrix == NULL || rows <= 0 || cols <= 0)
    {
        return;
    }

    int start = 0;
    while (start * 2 < rows && start * 2 < cols)
    {
        printOneCicle(matrix, start, rows, cols);
        start++;
    }
    cout << endl;
}

//打印某一全
void printOneCicle(int matrix[][4], int start, int rows, int cols)
{
    int startX = start;
    int endX = cols - start - 1;
    int startY = start;
    int endY = rows - start - 1;

    //打印第一行，
    if (startX < endX)
    {
        for (int i = startX; i <= endX; i++)
        {
            cout << matrix[startY][i] << ",";
        }
    }

    //打印右边的那一列，至少要有两行才行
    if (endY > startY)
    {
        for (int i = startY + 1; i <= endY; i++)
        {
            cout << matrix[i][endX] << ",";
        }
    }
    //打印下面的一行，至少要有两行两列才行
    if (startX < endX && endY > startY)
    {
        for (int i = endX - 1; i >= startX; i--)
        {
            cout << matrix[endY][i] << ",";
        }
    }
    //打印左边的一列，至少要有三行两列才可以
    if (startX < endX && endY > startY + 1)
    {
        for (int i = endY - 1; i > startY; i--)
        {
            cout << matrix[i][startX] << ",";
        }
    }
}