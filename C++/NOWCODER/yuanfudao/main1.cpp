#include <stdio.h>

int fun1(int i) {
    return i <= 1 ? 1 : fun1(i - 1) + fun1(i - 3);
}

int fun2(unsigned int i) {
    return ((i >> 8) & 0x64) & (((i << 8) & 0x9346) >> 8);
}

int main() {
    int m=fun1(101);
    printf("%d\n",m);
    int n = fun2(m) % 4;
    printf("%d", n);
    // printf("hello world!");
    return 0;
}