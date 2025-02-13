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

    for(i=0;i<max;i++){
        for(j=i+1;j<max;j++){
            if(arr[j]<arr[i]){
                t=arr[j];
                arr[j]=arr[i];
                arr[i]=t;
            }
        }
    }

    printf("Sorted Array: ");
    for(i=0;i<max;i++){
        printf("%d, ", arr[i]);
    }
}