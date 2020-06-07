///
///面试题44：数字序列中某一个的数字
///
///题目：数字以123456789101112…………的格式徐磊话得到一个字符序列。在这个序列中，第5位（从0开始计数）是5，第13位是1，第十九位是4。请写一个函数，求任意第n位对应的数字。

///分析：
///1、规律：0~9：一共有10x1=10位，10~99：一共有(100-10)x2=180位，100~999：一共有(1000-100)x3=2700位
///2、按照1中的规律，可以先求出n位所对应的数字段，然后求出n位该数字段中第几个数字，然后找出第几位

#include <iostream>
using namespace std;

//数字序列中第N位是哪个数字
int numberOfNbitInSequnce(int n);

int main()
{
    int number = numberOfNbitInSequnce(0);
    cout << "The number of n bit is " << number << endl;
    return 0;
}

int pow(int a, int r);

//数字序列中第N位是哪个数字
int numberOfNbitInSequnce(int n)
{
    if (n < 0)
        return -1;

    //由于n是从0开始计数的，要计算n位是第几个，要加一
    n += 1;
    //用bits代表n位的数字处于那个段
    int bits = 1;
    //用number代表n表示的数字
    int number = -1;
    while (number == -1)
    {
        //计算出某段的数字个数
        int numbers = bits == 1 ? 10 : (pow(10, bits) - pow(10, bits - 1)) * bits;
        if (numbers < n)
        {
            n -= numbers;
        }
        else
        {
            //除去前面有几个整数，还剩下几个位
            int reminder = n % bits;
            //当前段之中当前位所在数字的前面有多少个数字
            int leftNumber = reminder == 0 ? n / bits - 1 : n / bits;
            //当前位所在数字前面的数字,从1开始计数
            int leftNumbers = leftNumber + (bits == 1 ? -1 : pow(10, bits - 1) - 1);
            //当前位是那个数字
            int currentNumber = leftNumbers + 1;

            //当前位的数字
            number = reminder == 0 ? currentNumber % 10 : (currentNumber / (pow(10, (bits - reminder)))) % 10;
        }
        bits++;
    }
}

int pow(int a, int r)
{
    int sum = 1;
    for (int i = 0; i < r; i++)
    {
        sum *= a;
    }
    return sum;
}