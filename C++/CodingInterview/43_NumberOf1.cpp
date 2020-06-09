///
///面试题43：1~n整数中1出现的次数
///题目：输入一个整数n,求1~n这n个整数的十进制表示中1出现的次数。
///

///思路：
///1、遍历n个数，统计每个数中1出现的次数，时间复杂度O(nlongn)，此方法不是最优

///2、设数字n的为1456,为了计算从1到n这个n个数中1出现的次数，假想这四个数字是一个转筒，每一个位置每转一圈出现1次数为其权重，个位的权重为1，十位的权重为10.……；
///  数字0000转到1456，对于个位6而言，要达到1456，需要转145圈，得到1450，由于6大于1，还需要转过1，所以总共转（145+1）= 146圈；
///  对于十位5，要达到1456，需要转14圈，1400，由于5大于1，还需要转过1，所以总共转（14+1）= 15圈；
///  对于百位4，要达到1456，需要转1圈，1000，由于4大于1，还需要转过1，所以总共转（1+1）= 2圈；
///  对于千位1，没有高位，转不了一圈，同时本身为1，也转不过1（转过1表示由1变为2），所以千位上出现1的次数为低位加1，即（456+1）= 457；其他位为1的类似
///  每位出现1的次数位：圈数*权重+由于本身为1时存在的次数，然后计算这些位出现的次数总和，时间复杂度位O(logn)。
///

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
    int numbers1 = number1Between1AndNMethod1(1456);
    int numbers2 = number1Between1AndNMethod2(1456);
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