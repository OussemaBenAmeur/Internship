#include <stdio.h>
#include <stdlib.h>

int maxSubarraySum(int* arr, int n, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += arr[i];
    }
    int max_sum = sum;

    for (int i = k; i < n; i++) {
        sum += arr[i] - arr[i - k];
        if (sum > max_sum) {
            max_sum = sum;
        }
    }
    return max_sum;
}
int main() {
    int n,k;
    printf("Enter the size of the array and the size of the subarray : ");

    scanf("%d %d",&n,&k);
    int *tab= (int *)malloc(sizeof(int)*10);
    for (int i = 0; i < n; i++) {
        printf("Enter the value of element %d : ",i+1);
        scanf("%d",&tab[i]);

    }
printf("the maximum sum of any contiguous subarray of size %d is : %d",k,maxSubarraySum(tab,n,k));

    return 0;
}
