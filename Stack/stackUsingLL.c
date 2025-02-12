#include "stdio.h"
#include "stdlib.h"

typedef struct Node {
    int data;
    struct Node* next;
}Node;


void push(Node**);
void pop(Node**);
void display(Node*);

int main(){
    int in;
    Node *top = NULL;

    while(1){
        printf("\n1)Push \n2)Pop \n3)Display \n4)Exit");
        printf("\nEnter Choice:");
        scanf("%d", &in);

        switch(in){
            case 1: push(&top);
                break;
            case 2: pop(&top);
                break;
            case 3: display(top);
                break;
            case 4: exit(1);

            default: printf("Invalid Choice");
        }
    }
    return 0;
}

void push(Node** top) {
    Node* p;
    p = (Node*) malloc(sizeof(struct Node));

    printf("Enter Data:");
    scanf("%d", &p->data);


    p->next = *top;
    *top = p;
}

void pop(Node** top) {
    Node* p = *top;

    if(*top == NULL){
        printf("Underflow");
        return;
    }

    printf("Popped: %d", p->data);

    *top = p->next;
    free(p);
}

void display(Node* top){
    Node* p = top;

    if(top == NULL){
        printf("Stack is empty");
        return;
    }

    while(p != NULL){
        printf("%d\n", p->data);
        p = p->next;
    }
}