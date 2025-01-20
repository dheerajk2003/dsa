#include<stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node * prev;
    struct node * next;
} node;

void createList(node ** head){
    node * ptr = *head, * temp = (node *) malloc (sizeof(node));
    int data ;
    printf("\nData that you want to insert : ");
    scanf("%d", &data);
    temp->data = data;
    if(*head == NULL){
        temp->next = temp;
        *head = temp;
        return;
    }
    while(ptr->next != *head)
        ptr = ptr->next;

    temp->next = ptr->next;
    ptr->next = temp;
}

void insertAtAny(node ** head){
    node * ptr = * head;
    int pos, data;
    node * temp = NULL;
    printf("After which value do you want to insert : ");
    scanf("%d", &pos);

    if(ptr == NULL){
        printf("\n Empty list \n");
        return;
    }

    while(ptr->next != *head){
        if(ptr->data == data){
           printf("Enter the data that you want to insert : ");
           scanf("%d", &data);
           temp = (node *) malloc (sizeof(node));
           temp->data = data;
           temp->next = ptr->next;
           ptr->next = temp;
           break;
        }
        ptr = ptr->next;
    }
    
    if((ptr)->data == pos){
                
        printf("Enter the data that you want to insert : ");
        scanf("%d", &data);
        temp = (node *) malloc (sizeof(node));
        temp->data = data;
        temp->next = ptr->next;
        ptr->next = temp;
        return;
    }
    else if(ptr->data != data)
        printf("Data not found \n");
}

void insertBeg(node ** head){
   node * ptr = *head, *temp = (node *)malloc(sizeof(node));
   printf("Enter the data that you want to insert : ");
   scanf("%d",&(temp->data));
   if(ptr == NULL){
        temp->next = temp;
        *head = temp;
        return;
   }
   
   while(ptr->next != *head)
        ptr = ptr->next;

    temp->next = *head;
   ptr->next = temp;
   *head = temp;
}

void delFromBeg(node **head){
    node *ptr = *head, *temp = *head;
    if(ptr == NULL){
        printf("Empty List \n");
        return;
    }
    else if(ptr->next == ptr){
        *head = NULL;
        return;
    }

    while(ptr->next != *head)
        ptr = ptr->next;

    *head = (*head)->next;
    ptr->next = (*head);
    free(temp);
}

void delAny(node **head){
    node *ptr = *head, *temp = NULL;
    int data;
    if(ptr == NULL){
        printf("Empty List \n");
        return;
    }
    printf("Enter data that you want to delete : ");
    scanf("%d", &data);
    
    if(ptr->data == data){
       delFromBeg(head);
       return; 
    }
    while((ptr->next) != *head && (ptr->next)->data != data)
       ptr = ptr->next; 

    if((ptr->next)->data == data){
       temp = ptr->next;
       ptr->next = (ptr->next)->next;
        free(temp);
    }
    else
        printf("Value not found : ") ;
}

void countNode(node * head){
    node *ptr = head;
    int count = 1;
    if(ptr == NULL){
        printf("\n Count = 0 \n");
        return;
    }

    while(ptr->next != head){
        ptr = ptr->next;
        count ++;
    }

    printf("\n Count = %d \n",count);
}

void search(node *head){
    node *ptr = head;
    int data, count = 0;
    if(ptr == NULL)
    {
        printf("\n List is empty \n");
    }
    printf("Enter value to search : ");
    scanf("%d", &data);
    while((ptr->next) != head){ 
        count ++;
        if(ptr->data == data){
            printf("\n Item found at pos %d \n", count);
            return;
        }
        ptr = ptr->next;
    }
    if(ptr->data == data)
        printf("\n Item found at pos %d \n", ++count);
    else
        printf("\n Item not found \n ");
}

void display(node * head){
    node * ptr = head;
    if(head == NULL){
        printf("\n List is empty -------- \n");
        return;
    }
    printf(" \n");
    while(ptr->next != head){
        printf("%d \n", ptr->data);
        ptr = ptr->next;
    }
    printf("%d \n ", ptr->data);
}

int main(){
    node * start = NULL;
    int ch;
    while(1){
        printf("\n 1 -> Append \n 2 -> Insert at any \n 3 -> Insert At Beg \n 4 -> Delete from Beg \n 5 -> Delete At Any \n 6 -> Search \n 7 -> Count \n 8 -> Display \n -> Exit \n");
        scanf("%d", &ch);
        switch(ch){
            case 1:
                createList(&start);
                break;

            case 2:
                insertAtAny(&start);
                break;

            case 3:
                insertBeg(&start);
                break;

            case 4:
                delFromBeg(&start);
                break;

            case 5: 
                delAny(&start);
                break;

            case 6:
                search(start);
                break;

            case 7:
                countNode(start);
                break;
                
            case 8:
                display(start);
                break;

            default:
                exit(1);
        }
    }
    return 0;
}