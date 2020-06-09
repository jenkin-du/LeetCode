///
///题目：定义栈的数据结构，请在该类型上实现栈的最小元素的min函数。在该栈中，调用min、push、pop的时间复杂杜都为O(1)
///

///思路：用双栈实现，一个用于装数据，一个用于装最小值

#include <iostream>
#include <stack>
using namespace std;

template <typename T>
class MinStack
{
private:
    stack<T> data;
    stack<T> minData;

public:
    //放入数据
    void push(T t);
    //获取数据
    void pop();
    //获取最小值
    T min();
};

template <typename T>
void MinStack<T>::push(T t)
{
    data.push(t);
    if (minData.size() == 0 || minData.top() > t)
    {
        minData.push(t);
    }
    else
    {
        minData.push(minData.top());
    }
}

template <typename T>
void MinStack<T>::pop()
{
    if (data.size() > 0)
    {
        data.pop();
        minData.pop();
    }
}

template <typename T>
T MinStack<T>::min()
{
    if (minData.size() > 0)
    {
        return minData.top();
    }
    else
    {
        return -1;
    }
}

int main()
{
    MinStack<int> minStack;
    minStack.push(3);
    minStack.push(2);
    minStack.push(1);
    minStack.push(4);
    minStack.push(3);
    int min = minStack.min();
    cout << "min:" << min << endl;

    minStack.pop();
    minStack.pop();
    minStack.pop();
    min = minStack.min();
    cout << "min:" << min << endl;
    return 0;
}