
///
///题目：匹配包括含‘.’和‘*’的正则表达式，要求全匹配，其中‘.’表示匹配任意字符，‘*’表示匹配0次或则多次。
///如：“aaa”匹配“a*a”和“a.a”
///

#include <iostream>
using namespace std;

//匹配函数
bool match(char *str, char *pattern);
//匹配核心函数
bool matchCore(char *str, char *parttern);

int main()
{

    bool isMathch = match("abcd", "a.*c");
    cout << "is match:" << isMathch << endl;

    return 0;
}

bool match(char *str, char *pattern)
{

    if (str == NULL || pattern == NULL)
    {
        return false;
    }

    return matchCore(str, pattern);
}

bool matchCore(char *str, char *pattern)
{

    if (*str == '\0' && *pattern == '\0')
    {
        return true;
    }

    if (*str != '\0' && *pattern == '\0')
    {
        return false;
    }

    if (*(pattern + 1) == '*')
    {
        //对*做0次或多次匹配
        if (*pattern == *str || (*pattern == '.' && *str != '\0'))
        {
            //对*做了一次匹配，后面继续匹配
            return matchCore(str + 1, pattern + 2)
                   //对*做多次匹配，后面继续匹配当前模式
                   || matchCore(str + 1, pattern)
                   //匹配*0次，后面继续匹配
                   || matchCore(str, pattern + 2);
        }
        else
        {
            //匹配*0次，后面继续匹配
            return matchCore(str, pattern + 2);
        }
    }

    if(*pattern == *str || (*pattern == '.' && *str != '\0')){
        return matchCore(str + 1, pattern + 1);
    }

    return false;
}