#include <stdio.h>
int countOnes(int n) {
    int count = 0;
    while (n) {
        n = n & (n - 1);
        count++;
    }
    return count;
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    int result = countOnes(num);
    printf("Number of 1s in %d is %d\n", num, result);

    return 0;
}
