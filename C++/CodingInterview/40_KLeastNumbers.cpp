///
///面试题40：最小k个数
///题目：输入n个整数，找出其中最小的k个数
///

///思路：
///1、如果输入的数组可以改变，则基于第K个数来调整，是第k个数左边的数都小于第k个数，右边的数都大于第k个数

///2、如果输入的数据不可以改变，且有很多数据时，可以用最大堆来装k个数
///   当没装满时，往里面装数；当满了时候，取出最大堆中最大的数和下一个数比较，如果下一个数比最大堆最大数小，就更新最大堆，否则继续；

#include <iostream>
#include <set>
using namespace std;

//快排中的Partition
int partition(int arr[], int length, int start, int end);

//思路1
void printKMinNumberByMethod1(int arr[], int length, int k);

//思路2
void printKMinNumberByMethod2(int arr[], int length, int k);

int main()
{
    int arr[10] = {5, 2, 8, 3, 1, 4, 9, 7, 10, 6};

    printKMinNumberByMethod2(arr, 10, 4);
}

//思路1
void printKMinNumberByMethod1(int arr[], int length, int k)
{
    if (arr == NULL || length <= 0 || k <= 0 || k > length)
    {
        return;
    }

    int start = 0;
    int end = length - 1;
    int index = partition(arr, length, start, end);
    while (index != k - 1)
    {
        if (index > k - 1)
        {
            end = index - 1;
            index = partition(arr, length, start, end);
        }
        else
        {
            start = index + 1;
            index = partition(arr, length, start, end);
        }
    }
    for (int i = 0; i < k; i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
}

//思路2
void printKMinNumberByMethod2(int arr[], int length, int k)
{
    if (arr == NULL || length <= 0 || k <= 0 || k > length)
    {
        return;
    }

    multiset<int, greater<int> > kMinSet;
    for (int i = 0; i < length; i++)
    {
        if (kMinSet.size() < k)
        {
            kMinSet.insert(arr[i]);
        }
        else
        {
            int top = *(kMinSet.begin());
            if (top > arr[i])
            {
                kMinSet.erase(kMinSet.begin());
                kMinSet.insert(arr[i]);
            }
        }
    }

    //最大堆
    multiset<int, greater<int> >::iterator itr = kMinSet.begin();
    for (; itr != kMinSet.end(); itr++)
    {
        cout << *itr << ",";
    }
    cout << endl;
}

//快排中的Partition
int partition(int arr[], int length, int start, int end)
{

    if (arr == NULL || length <= 0)
    {
        return -1;
    }

    int value = arr[start];
    while (start < end)
    {
        while (start < end && arr[end] >= value)
        {
            end--;
        }
        if (start < end)
        {
            arr[start] = arr[end];
        }

        while (start < end && arr[start] <= value)
        {
            start++;
        }

        if (start < end)
        {
            arr[end] = arr[start];
        }
    }
    arr[start] = value;
    return start;
}