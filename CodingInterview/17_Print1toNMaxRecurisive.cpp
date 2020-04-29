#include <stdio.h>

///
///题目：打印1到n位的最大数（考虑大数问题，用字符串来表示数字）,本次采用全排列的方式，遍历n位，通过递归完成
///

void print1toNMaxRecursively(int n);

//全排列打印的核心函数
void print1toNMaxRecursiveCore(char *number, int length, int index);

//打印字符窜表示的数字
void printCharNumber(char *number, int length);

int main()
{
    print1toNMaxRecursively(5);
    return 0;
}

void print1toNMaxRecursively(int n)
{

    if (n <= 0)
    {
        return;
    }

    char *number = new char[n + 1];
    for (int i = 0; i < n; i++)
    {
        number[i] = '0';
    }
    number[n] = '\0';
    for (int i = 0; i < 10; i++)
    {
        number[0] = i + '0';
        print1toNMaxRecursiveCore(number, n, 0);
    }

    delete[] number;
}

//全排列打印的核心函数
void print1toNMaxRecursiveCore(char *number, int length, int index)
{

    if (index == length - 1)
    {
        printCharNumber(number, length);
        return;
    }

    for (int i = 0; i < 10; i++)
    {
        number[index + 1] = i + '0';
        print1toNMaxRecursiveCore(number, length, index + 1);
    }
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
            printf("%c", number[i]);
        }
    }
    printf(",");
}