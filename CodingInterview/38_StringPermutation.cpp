///
///面试题38：字符串的排列
/// 题目：输入一个字符串，打印出该字符串中字符的所有排列
///

///思路：把这个问题看成两部分.
///1、求出所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换；
///2、固定第一个字符，求出后面所有字符的排列；
/// 基于这种思想，通过递归可以完成；

#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

//排列
void printStringPermutation(char *str, char *begin);

//组合
void printStringCombination(char *str, int length, vector<char> &result);

int main()
{
    char str[10] = "abc";

    vector<char> result;
    int length = strlen(str);
    for (int i = 1; i <= length; i++)
    {
        printStringCombination(str, i, result);
    }
    return 0;
}

void printStringPermutation(char *str, char *begin)
{
    if (str == NULL || begin == NULL)
        return;
    if (*begin == '\0')
    {
        cout << str << endl;
    }
    else
    {
        for (char *ch = begin; *ch != '\0'; ch++)
        {
            char temp;
            temp = *ch;
            *ch = *begin;
            *begin = temp;

            printStringPermutation(str, begin + 1);

            temp = *ch;
            *ch = *begin;
            *begin = temp;
        }
    }
}

//组合
void printStringCombination(char *str, int length, vector<char> &result)
{
    if (length == 0)
    {
        for (int i = 0; i < result.size(); i++)
        {
            cout << result.at(i);
        }
        cout << endl;
        return;
    }
    if (*str == '\0')
        return;
    result.push_back(*str);
    printStringCombination(str + 1, length - 1, result);
    result.pop_back();
    printStringCombination(str + 1, length, result);
}