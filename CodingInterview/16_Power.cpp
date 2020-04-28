#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

///
///题目：求一个数值的幂，不使用库函数
///

//求幂
double power(double base, int exponent);
//求正数幂：常规求解法
double powerWithUnsignedExponent(double base, unsigned int exponent);
//求正数幂2：通过幂指数分解递归求解，加快求解速度
double powerWithUnsignedExponent2(double base, unsigned int exponent);
int main()
{
    double result = power(25, -3);
    cout << "power(25,-3):" << result << endl;
}

//求幂，主要考虑底数为0以及指数小于零的情况
double power(double base, int exponent)
{

    if (fabs(base - 0.0) < 0.00000001 && exponent < 0)
    {
        return 0;
    }

    unsigned int absExponent = (unsigned int)exponent;
    if (exponent < 0)
    {
        absExponent = (unsigned int)(-exponent);
    }
    double result = powerWithUnsignedExponent2(base, absExponent);
    if (exponent < 0)
    {
        result = 1.0 / result;
    }
    return result;
}
//求正数幂：常规求解法
double powerWithUnsignedExponent(double base, unsigned int exponent)
{

    double result = 1.0;
    for (int i = 0; i < exponent; i++)
    {
        result *= base;
    }
    return result;
}
//求正数幂2：通过幂指数分解递归求解，加快求解速度
double powerWithUnsignedExponent2(double base, unsigned int exponent)
{

    if (exponent == 0)
    {
        return 1;
    }
    if (exponent == 1)
    {
        return base;
    }
    //通过幂指数分解法递归求解
    double result = powerWithUnsignedExponent2(base, exponent >> 1);
    //判断奇偶
    if (exponent & 0x1 == 1)
    {
        result *= base;
    }
    return result;
}