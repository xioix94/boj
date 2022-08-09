#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>

int main(void) {
    int X;
    int N;
    size_t i;
    int count = 0;
    int sum = 0;

    scanf("%d", &X);
    scanf("%d", &N);
    
    int* a = malloc(N * sizeof(int));
    int* b = malloc(N * sizeof(int));

    for (i = 0; i < N; ++i) {
        scanf("%d %d", a + i, b + i);
        sum += *(a + i) * *(b + i);
    }

    if (X == sum) {
        printf("Yes");
    } else {
        printf("No");
    }

    free(a);
    free(b);

    return 0;
}