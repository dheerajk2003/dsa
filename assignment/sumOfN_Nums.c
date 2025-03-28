#include<stdio.h>
#include<stdlib.h>

int len;
int *arr;
int count=0;
int num;
void cal(int sum, int i){
	if(i >= len)
		return;
	int val = arr[i];
	if(num == sum + val)
		count++;
	cal(sum, i+1);
	cal(sum+val, i+1);
}

int main(){
	printf("Enter length of array : ");
	scanf("%d", &len);
	arr = (int*)malloc(sizeof(int) * len);
	for(int i = 0; i< len; i++){
		scanf("%d", (arr+i));
	}
	printf("Enter number to check : ");
	scanf("%d", &num);
	for(int i=0; i<len; i++){
		cal(arr[i], i+1);
	}
	printf("\n%d", count);	
	return 0;
}
