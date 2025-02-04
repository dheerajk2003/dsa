#include<stdio.h>
#include<string.h>


int main()
{
    int a, b, rem, res;
    printf("enter a number and a base ; ");
    scanf("%d %d",&a, &b);
    char str[100];
    char result[100];

    while(a > 0){
        str[rem++] = a%b+48;
        a /= b;
    }
    str[rem] = '\0';
    int i, j;
    for(i=0, j=rem-1; j>=0; i++, j--){
        result[i] = str[j];
    }
    result[i] = '\0';
    printf("%s", result);
    return 0;
}