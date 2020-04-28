#include<stdio.h>
#include<stdlib.h>

typedef struct ListNode{
	int val;
	struct ListNode* next;
}ListNode; 

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    
    struct ListNode* h= (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode* p= h;
    int t=0; 
    while(l1&&l2){
    	
    	p->val=(l1->val+l2->val+t)%10;
    	t=(l1->val+l2->val+t)/10;
    	
    	struct ListNode* node= (struct ListNode*)malloc(sizeof(struct ListNode));
    	p->next=node;
    	p=p->next;
    	
    	l1=l1->next;
    	l2=l2->next;
	}
	while(l1){
		p->val=(l1->val+t)%10;
		t=(l1->val+t)/10;
		
		struct ListNode* node= (struct ListNode*)malloc(sizeof(struct ListNode));
    	p->next=node;
    	p=p->next;
    	
    	l1=l1->next;
	}
	
	while(l2){
		p->val=(l2->val+t)%10;
		t=(l2->val+t)/10;
		
		struct ListNode* node= (struct ListNode*)malloc(sizeof(struct ListNode));
    	p->next=node;
    	p=p->next;
    	
    	l2=l2->next;
	}
	
	if(t!=0){
		p->val=t;
		p->next=NULL;
	}else{
		struct ListNode* q = h;
		while(q->next!=p){
			q=q->next;
		}
		free(p);
		q->next=NULL;
	}
	
	
	return h;
}

int main(){
	
	ListNode* l1=(ListNode*)malloc(sizeof(ListNode));
	ListNode* p=l1;
	
	ListNode* l2=(ListNode*)malloc(sizeof(ListNode));
	int i=0;
	int val;
	scanf("%d",&val);
	p->val=val;
	while(i < 1){
		ListNode* node=(ListNode*)malloc(sizeof(ListNode));
		scanf("%d",&val);
		node->val=val;
		p->next=node;
		p=node;
		i++;
	}
	p->next=NULL;
	
	
	p=l1;
	while(p){
		printf("%d",p->val);
		p=p->next;
	}
	printf("\n");
	
	
	i=0;
	p=l2;
	scanf("%d",&val);
	p->val=val;
	while(i < 2){
		ListNode* node=(ListNode*)malloc(sizeof(ListNode));
		scanf("%d",&val);
		node->val=val;
		p->next=node;
		p=node;
		i++;
	}
	p->next=NULL;
	
	p=l2;
	while(p){
		printf("%d",p->val);
		p=p->next;
	}
	printf("\n");
	
	
	struct ListNode* h=addTwoNumbers(l1, l2);
	while(h){
		printf("%d",h->val);
		h=h->next;
	}
} 
