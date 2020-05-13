///
///题目：两个大数相加（只考虑正数），输入：三行，第一行输入相加两数的最大位数N,后两行分别输入一个大数
///

#include <iostream>
#include <stdio.h>
using namespace std;

//两个字符串表示的大数相加
char *addBigNumber(char *num1, char *num2, int maxLength);

//打印字符窜表示的数字
void printCharNumber(char *number, int length);

int main()
{
    cout << "input three line:N:max bit and two big number" << endl;
    int N = 0;
    cin >> N;
    char *num1 = new char[N + 1];
    char *num2 = new char[N + 1];
    cin >> num1;
    cin >> num2;

    char *sum = addBigNumber(num1, num2, N);
    if (sum != NULL)
    {
        cout << "sum:";
        printCharNumber(sum, N + 1);
    }
    return 0;
}

//两个字符串表示的大数相加
char *addBigNumber(char *num1, char *num2, int maxLength)
{
    if (maxLength <= 0)
    {
        return NULL;
    }

    int index1 = 0, index2 = 0;
    for (; num1[index1] != '\0'; index1++)
    {
        if (!(num1[index1] >= '0' && num1[index1] <= '9'))
        {
            cout << "invalid input!" << endl;
            return NULL;
        }
    }

    for (; num2[index2] != '\0'; index2++)
    {
        if (!(num2[index2] >= '0' && num2[index2] <= '9'))
        {
            cout << "invalid input!" << endl;
            return NULL;
        }
    }
    index1--;
    index2--;

    int max = index1 > index2 ? index1 : index2;
    if (maxLength < max)
    {
        cout << "invalid input!" << endl;
        return NULL;
    }

    //预留一位，防止溢出
    char *sum = new char[maxLength + 2];
    sum[maxLength + 1] = '\n';
    int takeOver = 0;
    for (int i = maxLength; i >= 0; i--)
    {
        int n1 = 0, n2 = 0;
        if (index1 >= 0)
        {
            n1 = num1[index1] - '0';
        }
        if (index2 >= 0)
        {
            n2 = num2[index2] - '0';
        }

        int temp = n1 + n2 + takeOver;
        if (temp >= 10)
        {
            temp -= 10;
            takeOver = 1;
            sum[i] = temp + '0';
        }
        else
        {
            sum[i] = temp + '0';
            takeOver = 0;
        }
        index1--;
        index2--;
    }

    return sum;
}

//打印字符窜表示的数字
void printCharNumber(char *number, int length)
{
    bool isBeginPrint = false;
    for (int i = 0; i < length; i++)
    {
        if (!isBeginPrint && number[i] != '0')
        {
            isBeginPrint = true;
        }
        if (isBeginPrint)
        {
            cout << number[i];
        }
    }
    cout << endl;
}