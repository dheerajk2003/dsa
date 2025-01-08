#include<stdio.h>
#include<stdlib.h>
#include"singlyLL.c"


int main(){
  struct node* start = (struct node *) malloc (sizeof(struct node));
  int i;
  struct node * ptr;
  start->data = 2; 
  start->next = NULL;
  append(start,4);
  append(start,6);
  append(start,8);
  append(start,10);
  ptr = start;
  for(i=0; ptr != NULL; i++){
    ptr = ptr->next;
  }
  int count = i;
  ptr = start;
  struct node ** ar = (struct node **) malloc(count * sizeof(struct node *));
  for(i=0; ptr != NULL; i++){
    ar[i] = ptr;
    ptr = ptr->next;
  }
  int j; 
  for(i=0,j=count -1; i<j; i++, j--){
    struct node * temp = ar[i]->next;
    ar[i]->next = ar[j];
    ar[j]->next = temp;
    printf("2 \n");
  }
  ar[i]->next = NULL;
  printAll(start);
  return 0;
}
