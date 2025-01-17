#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;
  struct node *next;
};

void insert(struct node **head) {
  int val;
  struct node *ptr, *temp;
  ptr = *head;
  temp = (struct node *)malloc(sizeof(struct node));
  printf("enter after which you want to insert : ");
  scanf("%d", &val);
  while (ptr != NULL && ptr->data != val) {
    ptr = ptr->next;
  }
  if (ptr == NULL) {
    printf("Value not found \n");
    free(temp);
    return;
  } else {
    printf("Enter value to be inserted : ");
    scanf("%d", &val);
    temp->data = val;
    temp->next = ptr->next;
    ptr->next = temp;
  }
}

void append(struct node **head) {
  struct node *ptr = *head;
  struct node *temp = (struct node *)malloc(sizeof(struct node));
  printf("Enter value to be inserted : ");
  scanf("%d", &temp->data);
  temp->next = NULL;
  if (*head == NULL){
    *head = temp;
    return;
  }
  while (ptr->next != NULL) {
    ptr = ptr->next;
  }
  ptr->next = temp;
}

void display(struct node *head) {
  printf("\n\n");
  while (head != NULL) {
    printf("%d \n", head->data);
    head = head->next;
  }
  printf("\n\n");
}

void insertBeg(struct node **head){
  int d;
  struct node * temp = (struct node *) malloc (sizeof(struct node));
  printf("Enter value to be inserted : ");
  scanf("%d", &d);
  temp->data = d;
  temp->next = *head;
  *head = temp;
}

void deleteEnd(struct node **head){
  if(*head == NULL){
    printf("\n List is empty \n");
    return;
  }
  else if((*head)->next == NULL){
    *head = NULL;
    return;
  }
  struct node * ptr = *head;
  struct node *temp = NULL;
  while(ptr->next != NULL){
    temp = ptr;
    ptr = ptr->next;
  }
  temp->next = NULL;
  free(ptr);
}

void deleteAny(struct node **head){
  int val;
  printf("Enter element that you want to delete : ");
  scanf("%d", &val);
  struct node * ptr, * temp;
  ptr = *head;
  temp = NULL;
  while(ptr != NULL && ptr->data != val){
    temp = ptr;
    ptr = ptr->next;
  }
  if(ptr != NULL){
    temp->next = ptr->next;
    free(ptr);
  }
}

int main() {
  int ch;
  struct node *head = NULL;
  while (1) {

    printf("Enter your choice : ");
    scanf("%d", &ch);

    switch (ch) {
    case 1:
      insert(&head);
      break;

    case 2:
      display(head);
      break;

    case 3:
      append(&head);
      break; 

    case 4: 
      insertBeg(&head);
      break;

    case 5:
      deleteEnd(&head);
      break;

    case 6:
      deleteAny(&head);
      break;
    }
  }
  return 0;
}
