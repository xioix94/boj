#include <stdio.h>

int main(void) {
    size_t i;
    size_t j;
    int X;
    int temp_i = 1;
    int count = 0;

    scanf("%d", &X);
    if (X == 1) {
        j = 1;
        goto END;
    }

    for (i = 1; i < 10000; ++i) {
        if (i % 2 == 0){
            temp_i = 1;
            for (j = i; j > 0; --j) {
                ++count;
                if (count == X) {
                    goto END;
                }
                ++temp_i;     
            }
        } else {   
            temp_i = i;
            for (j = 1; j < i + 1; ++j) {
                ++count;
                if (count == X) {
                    goto END;
                }
                --temp_i;     
                }
        }
    }
END:
    printf("%d/%d\n", temp_i, j);

    return 0;
}