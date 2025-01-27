#include<stdlib.h>
#include<stack>
#include<stdio.h>

char expression[50] = "";
std::stack<char> stack;

int isOperand(char ch){
    return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
}

int precedence(char ch){
    switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;

        default:
            return 0;
    }
    return 0;
}

void inTpost(char * exp){
    int i=0,j=0;
    while(exp[i] != '\0'){
        printf("%c", exp[i]);
        if(isOperand(exp[i])){
            expression[j++] = exp[i];
        }
        else if(exp[i] == '('){
            stack.push('(');
        }
        else if(exp[i] == ')'){
            while(stack.top() != '('){
                expression[j++] = stack.top();
                stack.pop();
            }
            stack.pop();
        }
        else{
            while(!stack.empty() && precedence(stack.top()) > precedence(exp[i])){
                expression[j++] = stack.top();
                stack.pop();
            }
            stack.push(exp[i]);
        }
        i++;
    }
}
int main(){
    char ar[] = "((x+(y*z))-w)";
    inTpost(ar);
    printf("\n \n %s",expression);
    return 0;
}