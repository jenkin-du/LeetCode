#include <stdio.h>

///
///题目：打印1到n位的最大数（考虑大数问题，用字符串来表示数字）
///

void print1toNMaxRecursively(int n);

//字符窜表示的数字自增1,返回值表示是否溢出
bool charNumberIncrease(char *number, int length);

//打印字符窜表示的数字
void printCharNumber(char *number, int length);

int main()
{
  print1toNMaxRecursively(5);
  return 0;
}

void print1toNMaxRecursively(int n)
{
  if (n <= 0)
  {
    return;
  }

  char *number = new char[n + 1];
  for (int i = 0; i < n; i++)
  {
    number[i] = '0';
  }
  number[n] = '\0';
  while (!charNumberIncrease(number, n))
  {
    printCharNumber(number, n);
  }
}

//字符窜表示的数字自增1
bool charNumberIncrease(char *number, int length)
{

  bool isOverflow = false;
  int takeOver = 0;
  int sum = 0;
  for (int i = length - 1; i >= 0; i--)
  {
    sum = number[i] - '0' + takeOver;
    if (i == length - 1)
    {
      sum++;
    }
    if (sum >= 10)
    {
      if (i == 0)
      {
        isOverflow = true;
      }
      else
      {
        sum -= 10;
        takeOver = 1;
        number[i] = sum + '0';
      }
    }
    else
    {
      number[i] = sum + '0';
      break;
    }
  }

  return isOverflow;
}

//打印字符窜表示的数字
void printCharNumber(char *number, int length)
{
  bool isBeginPrint = false;
  for (int i = 0; i < length; i++)
  {
    if (!isBeginPrint && number[i] != '0')
    {
      isBeginPrint = true;
    }
    if (isBeginPrint)
    {
      printf("%c", number[i]);
    }
  }
  printf(",");
}