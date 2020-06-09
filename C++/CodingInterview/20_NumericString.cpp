///
/// 题目：判断一个字符串是否是数值类型，数值的匹配模式为A[.[B]][e|EC]或则.[B][e|EC]
/// 其中，A表示整数部分数字，可以带‘+’或‘-’，B表示小数部分数字，不能带正负，C表示指数部分数字，可以带‘+’或‘-’
///

//注意点
//1.如果要改变函数中传入指针的值，必须将传入二级指针

#include <iostream>
using namespace std;

//判断是否是数字
bool isNumberic(char *str);

//判断是否是整数
bool scanInteger(char **str);

//判断是否是无符号整数
bool scanUnsignedInteger(char **str);

int main()
{
    bool isNum = isNumberic("124.45e-34");
    cout << "is Num:" << isNum << endl;
    return 0;
}

//判断是否是数字
bool isNumberic(char *str)
{

    if (str == NULL)
    {
        return false;
    }

    //扫描整数部分
    bool isNum = scanInteger(&str);
    //扫描小数部分
    if (*str == '.')
    {
        str++;

        // ||的含义
        // A部分可以没有如.123 表示0.123
        // B部分也可以没有123. 表示123.0
        isNum = scanUnsignedInteger(&str) || isNum;
    }
    //扫描指数部分
    if (*str == 'e' || *str == 'E')
    {
        str++;
        // &&的含义
        // 整数和小数部分必须有
        // C部分必须有，
        isNum = isNum && scanInteger(&str);
    }

    return isNum && *str == '\0';
}

//判断是否是整数
bool scanInteger(char **str)
{

    if (**str == '+' || **str == '-')
    {
        (*str)++;
    }
    return scanUnsignedInteger(str);
}

//判断是否是无符号整数
bool scanUnsignedInteger(char **str)
{
    char *before = *str;
    while (**str != '\0' && **str >= '0' && **str <= '9')
    {
        (*str)++;
    }
    return before < *str;
}