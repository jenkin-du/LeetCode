///
///题目：二叉搜索数的后续遍历序列
///    输入一个整肃数组，判断该数组是不是某个二叉搜索树的后续遍历结果。如果是则返回true，否则返回false。假如输入的数组中任意两个数字都不相同.
///

///思路：
///1、二叉搜索树的特点：根节点的左子树的所有节点的值都比根节点的值小，右子树的所有节点的值都比根节点的值大；
///2、后续遍历的特点：左、右、根，所以遍历结果的最后一个节点一定是根节点，根据搜索二叉树的特点，遍历结果的前半段一定比根节点的值小，后边段一定比根节点的值大；
///   根据这个特点，可以通过递归的方式来判断序列是否正确；

#include <iostream>
using namespace std;

//判断是二叉搜索树的后续遍历结果
bool isSequenceOfBST(int *sequence, int startIndex, int rootIndex);

int main()
{
    int squence[] = {5, 7, 6, 9, 11, 10, 8};
    bool isSequence = isSequenceOfBST(squence, 0, 6);
    if (isSequence)
    {
        cout << " the sequnce is right!" << endl;
    }
    else
    {
        cout << " the sequnce is wrong!" << endl;
    }
    return 0;
}

//判断是二叉搜索树的后续遍历结果
bool isSequenceOfBST(int *sequence, int startIndex, int rootIndex)
{
    if (sequence == NULL || rootIndex < 0)
    {
        return false;
    }

    int rootValue = sequence[rootIndex];
    int index = startIndex;
    //找出前半段，及对应左子树节点
    for (; index < rootIndex - 1; index++)
    {
        if (sequence[index] > rootValue)
        {
            break;
        }
    }
    //验证后半段，及对应右子树节点
    int i = index;
    for (; i < rootIndex - 1; i++)
    {
        if (sequence[i] < rootValue)
        {
            return false;
        }
    }
    bool left = true;
    if (index > 0)
    {
        left = isSequenceOfBST(sequence, 0, index - 1);
    }

    bool right = true;
    if (index < rootIndex)
    {
        right = isSequenceOfBST(sequence, index, rootIndex - 1);
    }

    return (left && right);
}