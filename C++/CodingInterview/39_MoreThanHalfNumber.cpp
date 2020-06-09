///
///面试题39：数组中出现次数超过一半的数字
///题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
///
  
///思路：
///1、如果这个数组有序，遍历一边并记录出现次数最多的数字，然后判断是否是出现的次数超过数组长度的一半；先排序再找，时间复杂度为O(nlogn)
///
///2、如果这个数组有序，那么数组中间的数字一定是出现次数超过一半的；按照快排的思路，将数组排序，找到排在数组中间的数即可，当然还是要判断是否是出现的次数超过数组长度的一半，时间复杂度为O(n)；
///
///3、从头遍历数组，记录重复的数字出现的次数，当出现重复的数字时，就加一，当遇到不是重复的数字时，就减一，当数字减到0时，再重新计数；
///由于其中一个数字出现次数超过一半，那么最后重复计数减到1的数字就是我们要找的数字；时间复杂度为O(n)

#include <iostream>
using namespace std;

//思路1
int findNumberMethod1(int arr[], int length);

//思路2
int findNumberMethod2(int arr[], int length);

//思路3
int findNumberMethod3(int arr[], int length);

//检查是否超过一半
bool checkMoreThanHalf(int arr[], int length, int number);

//快排中的Partition
int partition(int arr[], int length, int start, int end);

//快排
void fastSort(int arr[], int length, int start, int end);

int main()
{
    int arr[10] = {2, 2, 3, 7, 3, 4, 3, 4, 3, 3};

    int number = findNumberMethod3(arr, 10);

    if (number != -1)
    {
        cout << "the find number is:" << number << endl;
    }
    else
    {
        cout << "this is no number that meets the requirement." << endl;
    }
}

//思路1
int findNumberMethod1(int arr[], int length)
{
    if (arr == NULL || length <= 0)
    {
        return -1;
    }

    fastSort(arr, length, 0, length - 1);
    int number = arr[length / 2];
    if (checkMoreThanHalf(arr, length, number))
    {
        return number;
    }
    else
    {
        return -1;
    }
}

//思路2
int findNumberMethod2(int arr[], int length)
{
    if (arr == NULL || length <= 0)
    {
        return -1;
    }

    int start = 0;
    int end = length - 1;
    int index = partition(arr, length, start, end);
    int middle = length >> 1;
    while (index != middle)
    {
        if (index > middle)
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
    int number = arr[index];
    if (checkMoreThanHalf(arr, length, number))
    {
        return number;
    }
    else
    {
        return -1;
    }
}

//思路3
int findNumberMethod3(int arr[], int length)
{
    if (arr == NULL || length <= 0)
    {
        return -1;
    }
    int number = arr[0];
    int times = 1;
    for (int i = 1; i < length; i++)
    {
        if (times == 0)
        {
            times++;
            number = arr[i];
            continue;
        }

        if (number == arr[i])
        {
            times++;
        }
        else
        {
            times--;
        }
    }

    if (checkMoreThanHalf(arr, length, number))
    {
        return number;
    }
    else
    {
        return -1;
    }
}

//检查是否超过一半
bool checkMoreThanHalf(int arr[], int length, int number)
{
    if (arr == NULL || length <= 0)
        return false;

    int times = 0;
    for (int i = 0; i < length; i++)
    {
        if (arr[i] == number)
            times++;
    }
    if (times > (length >> 1))
    {
        return true;
    }
    return false;
}

//快排
void fastSort(int arr[], int length, int start, int end)
{
    if (arr == NULL || length <= 0)
    {
        return;
    }

    if (start < end)
    {
        int index = partition(arr, length, start, end);
        fastSort(arr, length, start, index - 1);
        fastSort(arr, length, index + 1, end);
    }
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