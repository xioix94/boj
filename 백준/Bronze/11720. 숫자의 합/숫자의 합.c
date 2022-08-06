#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int number;
    char* numberString = NULL;
    int sum = 0;
    char* temp = NULL;
    int count = 0;

    scanf("%d", &number);
    numberString = malloc((number + 2) * sizeof(char));
    scanf("%s", numberString);
    temp = malloc(2 * sizeof(char));
    while (*numberString != '\0') {
        strncpy(temp, numberString, 1);
        sum += atoi(temp);
        ++numberString;
        ++count;
    }
    printf("%d", sum);
    
    free(temp);
    free(numberString - count);
    return 0;
}
