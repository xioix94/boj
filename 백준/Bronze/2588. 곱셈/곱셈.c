#include <stdio.h>

int main(void) {
    int a, b, sum1, sum2, sum3;
    scanf("%d %d", &a, &b);
    sum1 = a * (b % 10);
    sum2 = a * ((b % 100) / 10);
    sum3 = a * (b / 100);
    
    printf("%d\n", sum1);
    printf("%d\n", sum2);
    printf("%d\n", sum3);
    printf("%d\n", sum1 + (sum2 * 10) + (sum3 * 100));
    
    return 0;
}