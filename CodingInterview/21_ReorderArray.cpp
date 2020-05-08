///
///题目：将数组中奇数放在前部分，偶数放在后部分
///

#include <iostream>
using namespace std;

//重排序，传入一个重排序判断函数
void reorder(int *arr, int length, bool (*func)(int));

//判断是否是偶数
bool isEven(int n)
{
    return (n & 0x1) == 0;
}

int main()
{
    int arr[] = {2, 4, 5, 3, 1, 5, 6, 9};
    reorder(arr, 8, isEven);

    for (int i = 0; i < 8; i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
}

//重排序，传入一个重排序判断函数
void reorder(int *arr, int length, bool (*func)(int))
{
    int begin = 0;
    int end = length - 1;
    while (begin < end)
    {
        while (begin < end && !func(arr[begin]))
        {
            begin++;
        }
        while (begin < end && func(arr[end]))
        {
            end--;
        }

        if (begin < end)
        {
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
        }
        begin++;
        end--;
    }
}