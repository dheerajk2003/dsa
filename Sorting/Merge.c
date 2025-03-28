#include<stdio.h>
#include<stdlib.h>

int ar[] = {5,3,4,1, 2};

void merge(int* ar, int left, int mid, int right){
    int * ptr = (int*)malloc(sizeof(int) * right-left);
    int i=left, j=mid+1, k = 0;
    while(i<=mid && j<=right){
        if(ar[i] < ar[j]){
            ptr[k] = ar[i];
            k++;
            i++;
        }
        else{
            ptr[k] = ar[j];
            k++;
            j++;
        }
    }
    while(i<=mid){
        ptr[k] = ar[i];
        k++;
        i++; 
    }
    while(j<=right){
        ptr[k] = ar[j];
        k++;
        j++;
    }
    for(i=left, k=0; i<=right; i++, k++){
        ar[i] = ptr[k];
    }
}

void divide(int ar[], int left, int right){
    if(left >= right)
        return;
    int mid = left + (right-left)/2;
    divide(ar, left, mid);
    divide(ar, mid+1, right);
    merge(ar, left, mid, right);
}

int main(){
    divide(ar, 0, 4);
    for(int i=0; i<5; i++){
        printf("%d ",ar[i]);
    }
    return 0;
}