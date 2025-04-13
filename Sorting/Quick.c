#include<stdio.h>

int QuickSort(int* ar, int start, int end){
	int pivot = start;
	int i = end;
	int leftDir = 1;
	while(pivot != i){
		if(leftDir == 1){
			while(i>pivot){
				if(ar[pivot] > ar[i]){
					int temp = ar[pivot];
					ar[pivot] = ar[i];
					ar[i] = temp;
					temp = pivot;
					pivot = i;
					i = temp;
					leftDir = 0;
					break;
				}
				i--;
			}
		}
		else{
			while(i<pivot){	
				if(ar[pivot] < ar[i]){
					int temp = ar[pivot];
					ar[pivot] = ar[i];
					ar[i] = temp;
					temp = pivot;
					pivot = i;
					i = temp;
					leftDir = 1;
					break;
				}
				i++;
			}
		}
	}
	return pivot;
}

void Quick(int*ar, int start, int end){
	if(start >= end)
		return;
	int pivot = QuickSort(ar, start, end);
	Quick(ar, start, pivot);
	Quick(ar, pivot+1, end);
}


int main(){
	int ar[] = {3,5,4,1,2,8,6,0};
	Quick(ar, 0, 7);
	for(int i=0; i<8; i++){
		printf("%d", ar[i]);
	}	
	return 0;
}
