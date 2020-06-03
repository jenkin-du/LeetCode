///
///面试题42：连续子数组的最大和
/// 题目：输入一个整型数组，数组里有正数也有负数。数组中的一个或者连续多个整型组成的一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)
///

///思路：
///如果通过枚举所有子数组的和，则时间复杂度为O(n^2);
///该问题可以通过动态规划来完成
///如果用f(i)表示以第i个数字结尾的子数组的最大和，那么我们需要求出max{f(i)},其中0 <= i <=n;
///则我们可以用递归公式求f(i)：
/// 若i=0或f(i-1)<=0；f(i)=arr[i];
/// 若i!=0或f(i-1)>0；f(i)=f(i-1)+arr[i];

#include <iostream>
using namespace std;

//数组中的子数组最大值
int maxSubSumInArray(int *arr, int length);

int main()
{
    int arr[8] = {1, -2, 3, 10, -4, 7, 2, -5};
    int maxSum = maxSubSumInArray(arr, 8);
    if (maxSum != -1)
    {
        cout << "The max sub sum is " << maxSum << endl;
    }
    else
    {
        cout << "The input arr is invalid!" << endl;
    }
    return 0;
}

int maxSubSumInArray(int *arr, int length)
{
    if (arr == NULL || length <= 0)
        return -1;

    int currentSum = -1;
    int maxSum = -1;
    for (int i = 0; i < length; i++)
    {
        if (currentSum < 0)
        {
            currentSum = arr[i];
        }
        else
        {
            currentSum += arr[i];
        }

        if (currentSum > maxSum)
            maxSum = currentSum;
    }
    return maxSum;
}