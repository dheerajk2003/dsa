#include<stdio.h>
#define max 5
#define inf 999
#define max_heap_size 100

typedef struct node{
    int value;
    int index;
} node;

node heap[max_heap_size];
int size = 0;

int graph[max][max] = {
0,5,3,0,2,  
5,0, 1,0,0,
3,1, 0,4,0,
0,0,4,0,2,
2,0,0,2,0};
int visited[max] = {0};
int distance[max] = {0};

void add(int, int);
node remv();
void adjust_UP(int);
void adjust_Down(int);
void swap(node*, node*);

int main(){
    int min=inf, idx=0, i=1;
    //init visited
    for(i=1; i<max; i++)
        distance[i] = inf;

    add(0, 0);
    while(size>0){
        node first = remv();
        int i = first.index;
        if(visited[i]) continue;
        visited[i] = 1;
        
        for(int j=0; j<max; j++){
            if(graph[i][j] != 0 && visited[j] != 1){
                if(distance[j] > distance[i] + graph[i][j]){
                    distance[j] = distance[i] + graph[i][j];
                    add(graph[i][j], j);
                }
            }
        }
    }

    for(i=0; i<max; i++)
        printf("%d ", distance[i]);

    return 0;
}

void add(int value, int index){
    node item = {value, index};
    heap[size] = item;
    adjust_UP(size);
    size++;
}

node remv(){
    node nd = heap[0];
    heap[0] = heap[--size];
    adjust_Down(0);
    return nd;
}

void swap(node* nd1, node* nd2){
    node temp = *nd1;
    *nd1 = *nd2;
    *nd2 = temp;
}

void adjust_UP(int index){
    if(index == 0)
        return;
    if(heap[index].value < heap[(index-1)/2].value){
        swap(&heap[index] , &heap[(index-1)/2]);
        adjust_UP((index-1)/2);
    }
    return;
}

void adjust_Down(int index){
    if(index >= size)
        return;
    int left = 2*index+1;
    int right = 2*index+2;
    int min;
    if(left < size && heap[left].value < heap[right].value)
        min = left;
    else if(right < size)
        min = right;
    else 
        return;
    if(heap[index].value > heap[min].value){
        swap(&heap[index], &heap[min]);
        adjust_Down(min);
    }
}