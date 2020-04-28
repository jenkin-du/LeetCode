#include <iostream>

using namespace std;

int getNumOfOneInBinary1(int num);

int getNumOfOneInBinary2(int num);

int main()
{

    int count = getNumOfOneInBinary2(9);
    cout << "num of 1:" << count << endl;

    return 0;
}

int getNumOfOneInBinary1(int num)
{

    int count = 0;
    unsigned int flag = 1;
    while (flag)
    {
        if (num & flag)
        {
            count++;
        }
        flag = flag << 1;
    }

    return count;
}

int getNumOfOneInBinary2(int num)
{

    int count = 0;
    while (num)
    {
        count++;
        num = (num - 1) & num;
    }

    return count;
}