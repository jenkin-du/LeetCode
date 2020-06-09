///字符串倒序

///薯队长带着小红薯参加密室逃脱团建游戏，首先遇到了反转游戏，小红薯们根据游戏提示收集了多个单词线索，并将单词按要求加一个空格组 成了句子，
///最终要求把句子按单词反转解密。 说明：收集的时候单词前后可能会有多个空格，反转后单词不能有多个空格，具体见输入输出样例。

///输入一个字符串。包含空格和可见字符。长度<=100000。

///输出一个字符串，表示反转后结果。

#include <iostream>
#include <stack>
#include <stdio.h>
#include <stdlib.h>
#include <cstring>
using namespace std;

int main()
{
    char word[100000];
    cin.getline(word, 100000);
    int start = -1, end = -1;
    bool inAWord = false;
    int newStartIndex = 0;

    stack<char *> data;

    for (char *str = word; *(str - 1) != '\0'; str++)
    {
        start++;
        if (*str == ' ' && !inAWord)
        {
            end = -1;
            continue;
        }

        if (*str != ' ' && !inAWord)
        {
            inAWord = true;
            end = start;
            newStartIndex = start;
            continue;
        }

        if ((*str == ' ' || *str == '\0') && inAWord)
        {
            int length = end - newStartIndex + 1;
            char *newChar = (char *)malloc(sizeof(char) * length + 1);

            char *pStart = str - length;
            char *newStart = newChar;
            for (int i = 0; i < length; i++)
            {
                *newStart = *pStart;
                newStart++;
                *pStart++;
            }
            *newStart = '\0';

            data.push(newChar);

            end = -1;
            newStartIndex = -1;
            inAWord = false;
            continue;
        }

        if (*str != ' ' && inAWord)
        {
            end++;
        }
    }

    while (!data.empty())
    {
        char *str = data.top();
        cout << str;
        data.pop();

        if (!data.empty())
        {
            cout << " ";
        }
    }
    cout << endl;
}