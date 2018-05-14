#include<stdio.h>
#include<stdlib.h>


int* twoSum(int* nums, int numsSize, int target) {
    
    int *array=(int*)malloc(sizeof(int)*2);
    int i=0;
    for (;i<numsSize;i++){
    	int	j=i+1;
    	for(;j<numsSize;j++){
    		if(nums[i]+nums[j]==target){
    			array[0]=i;
    			array[1]=j;
    			break;
			}
		}
	}
	
	return array;
}

int main(){
	
	int nums[10]={2, 7, 11, 15};
	int *array=twoSum(nums,4,9);
	int i=0;
	for(;i<2;i++){
		printf("%d,",array[i]);
	}
} 
