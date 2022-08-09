#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>

int main(void) {
    int peases[7];
    int trueIntPeases[7] = {1, 1, 2, 2, 2, 8, INT_MIN};
    int* trueInts = trueIntPeases;
    size_t i;

    for (i = 0; i < 6; ++i) {
        scanf("%d", &peases[i]);
    }

    for (i = 0; i < 6; ++i) {
        printf("%d ", *trueInts - peases[i]);
        ++trueInts;
    }
    return 0;
}