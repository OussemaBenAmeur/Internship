#include <stdio.h>
#include <stdlib.h>

int getMinimum(int arr[],int size) {
    int i=0;
    int min=0;
    while (i<size) {
        if (arr[i]>0) {
            min=arr[i];
            break;
        }
        i++;
     }
    while (i<size) {
        if(arr[i]<min & arr[i]>0) {
            min=arr[i];
        }
        i++;
    }
    if (min>0) return min;
    else return -1;
}
int coinChange(int coins[],int n, int size,int start) {
    int i=0;
    int x=0;
    int y=0;
    i=start;
    while (n>0 && i<size) {
        if( (n/coins[i])>0 && (n>=coins[i])) {
            x=n/coins[i];
            y=x+y;
            n=n-(coins[i]*x);
        }
        i++;
    }
    if(n==0) return y;
    else return -1;
}
int numberOfCoins(int coins[], int n, int size) {
    int number[size];
    for (int i=0; i<size; i++) {
        number[i]=coinChange(coins,n,size,i);
    }
    return getMinimum(number,size);
}
int main() {
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    int const coins[size];
    for (int i=0; i<size; i++) {
        printf("donner %d valeur \n",i);
        scanf("%d",&coins[i]);
    }
    int n;
    printf("donner la valeur\n");
    scanf("%d", &n);
    printf("You entered: %d\n", n);
    if (numberOfCoins(coins,n,size) == -1) {
        printf("you can't\n");
    }
    else
    printf("the minimum number of coins required is %d\n",numberOfCoins(coins,n,size));
    return 0;
}
