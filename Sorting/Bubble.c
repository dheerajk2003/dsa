#include<stdio.h>
#include<stdlib.h>
#define max 5
void main(){
    int i, j, t;

    int arr[max];

    for(i=0; i<max;i++){
        printf("Enter Number %d:", i+1);
        scanf("%d", &arr[i]);
    }

    for(i=0;i<max-1;i++){
        for(j=0;j<max-i-1;j++){
            if(arr[j]>arr[j+1]){
                t=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=t;
            }
        }
    }

    printf("Sorted Array: ");
    for(i=0;i<max;i++){
        printf("%d, ", arr[i]);
    }
}