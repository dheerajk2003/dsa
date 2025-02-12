#include<stdio.h>
#include<stdlib.h>
#define max 5
int q[100],front=-1,rear=-1;


void enqueue();
void dequeue();
void display();
int main(){
    int ch;
    while(1){
        printf("Enter choice : \n 1) enque \n 2) deque \n 3) display \n 4) exit \n");
        scanf("%d",&ch);
        switch (ch) {
            case 1: enqueue();
                break;
            case 2: dequeue();
                break;

            case 3: display();
                break;
            default: exit(1);
        }
    }
    return 0;
}

void enqueue(){
    int data;
    if((rear == max-1 && front == 0) || rear == front-1){
        printf("\nOverflow \n");
        return;
    }
    printf("Enter the data that you want to insert : ");
    scanf("%d",&data);
    if(rear == -1)
        rear = front = 0;
    else if(rear == max-1){
        rear = 0;
    } 
    else{
        rear++;
    }
    q[rear] = data;
}

void dequeue(){
    if(front == -1){
        printf("\n Underflow : \n");
        return;
    }
    else if(front == rear){
        printf("\ndata = %d\n",q[front]);
        front = rear = -1;
    }
    else if(front == max-1){
        printf("\ndata = %d\n",q[front]);
        front = 0;
    }
    else{
        printf("\ndata = %d\n",q[front]);
        front++;
    }
}

void display(){
    int i;
    int big = (rear > max-1) ? rear : max-1;
    printf("\n");
    if(rear < front){
        for(i=front; i<max; i++){
            printf("-> %d \n",q[i]);
        }
        for(i=0; i<=rear; i++){    
            printf("-> %d \n",q[i]);
        }
    }
    else{
        for(i=front; i<=rear; i++){     
            printf("-> %d \n",q[i]);
        }
    }
    printf("\n");
}