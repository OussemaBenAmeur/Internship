#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int n;
char* reverse(const char* str){
    char *str_rev;
    str_rev =(char*)malloc((n+1)*sizeof(char));
    for(int j =0;j<strlen(str); j++ ) {
        str_rev[j] = str[strlen(str)-j-1];
    }
    str_rev[strlen(str)] = '\0';
    return str_rev;
}
int isPalindrome(const char* str){
    if (strcmp(str,reverse(str)) == 0) {
        return 1;
    }
    else {
        return 0;
    }
}
int main(void) {
    printf("enter the length of the string you want to reverse\n");
    scanf("%d",&n);
    char *str;
    str =(char*)malloc((n+1)*sizeof(char));
    printf("enter the string\n");
    scanf("%s",str);
    printf("Your string is : %s \n", str);
    printf("your string reversed is :  %s \n", reverse(str));
    if ( isPalindrome(str) == 1) {
        printf("your string is palindrome");
    }
    else {printf("your string is not palindrome");}
    return 0;
}
