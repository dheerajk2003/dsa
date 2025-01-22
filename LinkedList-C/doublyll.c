#include<stdio.h>
#include<stdlib.h>


typedef struct node{
    struct node * prev, *next;
    int data;
} node;

void append(node **);
void countNode(node*);
void display(node*);
void search(node*);

int main(){
    int ch;
    node * start;
    while(1){
    printf("1) append \n 2)  \n 3)  \n 4) count node \n 5) search \n 6) display");
    scanf("%d", &ch);
    switch (ch) {
        case 1:
            append(&start);
            break;

        case 4:
            countNode(start);
            break;

        case 5: 
            search(start);
            break;

        case 6:
            display(start);
            break;
    }
    }
    return 0;
}

void append(node ** head){
    node * temp = (node*)malloc(sizeof(node));
    temp->next = NULL;
    printf("Enter data");
    scanf("%d",&temp->data);
    if(*head == NULL){
        *head = temp;
        return;
    }
    node * p = *head;
    while(p->next != NULL){
        p=p->next;
    }
    p->next = temp;

}


void countNode(node * head){
    node *ptr = head;
    int count = 0;
    if(ptr == NULL){
        printf("\n Count = 0 \n");
        return;
    }

    while(ptr != NULL){
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
    while(ptr != NULL){ 
        count ++;
        if(ptr->data == data){
            break;
        }
        ptr = ptr->next;
    }
    if(ptr != NULL)
        printf("\n Items found at  : %d \n", count);
    else
        printf("\n not found \n");
}

void display(node * head){
    node * ptr = head;
    if(head == NULL){
        printf("\n List is empty -------- \n");
        return;
    }
    printf(" \n");
    while(ptr != NULL){
        printf("%d \n", ptr->data);
        ptr = ptr->next;
    }
}