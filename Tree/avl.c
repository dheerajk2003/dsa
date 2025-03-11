#include<stdio.h>
#include<stdlib.h>


typedef struct node{
	int val;
	struct node * left;
	struct node * right;
} node;

void createTree(node **, int);
void printing(node*);

int main(){
	node * root = NULL;
	int d;
	while(1){
		printf("Enter \n1 for insert: \n2 for display: \n3 for delete \n9 for exit");
		scanf("%d",&d);
		if(d == 1){
			printf("Enter a value : ");
			scanf("%d",&d);
			createTree(&root, d);
		}
		else if(d == 2)
			printing(root);
		else if(d == 9)
			break;
		else
			printf("Wrong Choice : \n");
	}
	return 0;
}


void createTree(node ** root, int data){
	if(*root == NULL){
		*root = (node*)malloc(sizeof(node));
		(*root)->val = data;
		(*root)->left = NULL;
		(*root)->right = NULL;
		return;
	}
	else if((*root)->val > data){
		if((*root)->left == NULL){
			node * temp = (node*)malloc(sizeof(node));
			temp->val = data;
			temp->left = NULL;
			temp->right = NULL;
			(*root)->left = temp;
		}
		else{
			createTree(&(*root)->left, data);
		}
		return;
	}
	else{
		if((*root)->right == NULL){	
			node * temp = (node*)malloc(sizeof(node));
			temp->val = data;
			temp->left = NULL;
			temp->right = NULL;
			(*root)->right = temp;
		}
		else
			createTree(&(*root)->right, data);
		return;
	}	
}


void printing(node * root){
	if(root == NULL)
		return;
	printing(root->left);
	printf("%d \n",root->val);
	printing(root->right);
}

int isAvl(node * root, int depth){
	if(root == NULL)
		return depth;
	int left = isAvl(root.left, depth+1);
	int right = isAvl(root.right, depth+1);
	int res = left - right;
	if(res < -1 || res > 1)
		return false;
	return false;	
}
