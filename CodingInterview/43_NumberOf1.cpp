///
///面试题43：1~n整数中1出现的次数
///题目：输入一个整数n,求1~n这n个整数的十进制表示中1出现的次数。
///

///思路：
///1、遍历n个数，统计每个数中1出现的次数，时间复杂度O(nlongn)，此方法不是最优

///2、设数字n的为3456,为了计算从1到n这个n个数中1出现的次数，假想这四个数字是一个转筒，每一个位置每转一圈出现1次数为其权重，个位的权重为1，十位的权重为10.……；
///  数字0000转到3456，对于个位6而言，要达到3456，需要转345圈，得到3450，由于6大于1，还需要转一圈，所以总共转（345+1）= 346圈；
///  对于十位5，要达到3456，需要转34圈，3400，由于5大于1，还需要转一圈，所以总共转（34+1）= 35圈；
///  对于百位4，要达到3456，需要转3圈，3000，由于4大于1，还需要转一圈，所以总共转（3+1）= 4圈；
///  对于千位3，只需转1圈，（因为没有高位，1圈每转满）
///  最总出现的次数为 对应位上的圈数乘以权重，然后给位圈数之和就是最总答案，时间复杂度位O(logn)。

#include <iostream>
using namespace std;

//思路1
int number1Between1AndNMethod1(int n);

//计算每个数字中1的个数
int number1OfN(int n);

//思路2
int number1Between1AndNMethod2(int n);

int main()
{
    int numbers1 = number1Between1AndNMethod1(11111);
    int numbers2 = number1Between1AndNMethod2(11111);
    if (numbers1 != -1)
    {
        cout << "The numbers of 1  in 1~n is " << numbers1 << endl;
        cout << "The numbers of 1  in 1~n is " << numbers2 << endl;
    }
    else
    {
        cout << "The input value is invalid!" << endl;
    }
    return 0;
}

//思路1
int number1Between1AndNMethod1(int n)
{
    if (n <= 0)
        return -1;

    int numbers = 0;
    for (int i = 0; i <= n; i++)
    {
        numbers += number1OfN(i);
    }
    return numbers;
}

//思路2
int number1Between1AndNMethod2(int n)
{
    if (n < 0)
        return -1;
    int weight = 1;
    int numbers = 0;

    int high = n;
    while (high > 0)
    {
        //高位
        high = n / (weight * 10);
        //低位
        int low = n % weight;
        //当前位
        int bit = ((n - low) / weight) % 10;
        if (bit > 1)
        {
            numbers += (high + 1) * weight;
        }
        else if (bit == 1)
        {
            numbers += high * weight + low + 1;
        }
        weight *= 10;
    }
    return numbers;
}

//计算每个数字中1的个数
int number1OfN(int n)
{
    int numbers = 0;
    while (n > 0)
    {
        if (n % 10 == 1)
        {
            numbers++;
        }
        n = n / 10;
    }
    return numbers;
}