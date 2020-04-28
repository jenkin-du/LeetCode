#include<stdio.h>

void isPalindrome(int x);

int main(){
	
	long x;
	scanf("%d",&x);
	
	isPalindrome(x);
	return 0;
}

void isPalindrome(int x){

	int nums[20]={0};
   	int i=0;
	int num;
	while(x>0){
		num=x%10;
		nums[i]=num;
		x/=10;
		i++;
	}
	int k=0,n=i-1;
	int flag=0;
	for (;k<n;k++,n--){
		if(nums[k]!=nums[n]){
			flag=1;
			break;
		}
	}
	if(flag==1){
		printf("N");
	}else{
		printf("Y");
	}
}
 
