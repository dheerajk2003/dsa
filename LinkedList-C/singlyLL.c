#include<stdio.h>
#include<stdlib.h>

typedef struct node{
	int data;
	struct node * next;
} nod;

void append(struct node * ll, int data){
	struct node * newNode = (struct node *) malloc (sizeof(struct node));
	newNode->data = data;
	newNode->next = NULL;
	struct node * ptr = ll;
	while(ptr->next != NULL){
		ptr = ptr->next;
	}
	ptr->next = newNode;
}
void search(struct node * ll, int item){
	struct node * ptr = ll;
	while(ptr != NULL){
		if(ptr->data == item){
			printf("found item \n");
			break;
		}
		ptr = ptr->next;
	}	
}
void insert(struct node * ll, int pos, int data){
	int i;
	struct node * ptr = ll;
	for(i=1;i<pos-1;i++)
		ptr = ptr->next;
	struct node * nextNode = ptr->next;
	struct node * newNode = (struct node*) malloc (sizeof(struct node));
	newNode->data = data;
	ptr->next = newNode;
	newNode->next = nextNode;
}
void printAll(struct node * ll){
	struct node * ptr = ll;
	do{
		printf("printing all %d \n",ptr->data);
		ptr = ptr->next;
	}while(ptr != NULL);
}

void del(struct node * ll, int item){
	struct node * ptr = ll;
	struct node * temp = ptr;
	while(ptr != NULL){
		if(item == ptr->data){
			break;
		}
		temp = ptr;
		ptr = ptr->next;
	}
	if(ptr != NULL){
		temp->next = ptr->next;
		free(ptr);
	}
	else{
		printf("Item not found \n");
	}
}
