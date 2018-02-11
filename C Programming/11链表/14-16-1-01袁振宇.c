/*����Ľ��������ҡ��������ͷš�����ɾ��*/ 
#include<stdio.h>
#include<stdlib.h>
struct listNode{
	int data;
	struct listNode *nextPtr;
};
typedef struct listNode LISTNODE;
typedef LISTNODE *LISTNODEPTR;
LISTNODEPTR creatFIFOList();
void printList(LISTNODEPTR);
void deleteNode(LISTNODEPTR);
main()
{    
    LISTNODEPTR headPtr;   
	
	printf("Please input a series of integers:");/*����һ������,��-1����*/
    headPtr=creatFIFOList();	
    
	printf("The list is:");
	printList(headPtr);
   
    deleteNode(headPtr);/*ɾ��ָ��Ԫ��*/
   
    system("pause");
    return 0;	
}

LISTNODEPTR creatFIFOList()/*������������һ������������*/ 
{
	int num;
	LISTNODEPTR listPtr=NULL,lastPtr=NULL,currentPtr=NULL;
	listPtr=malloc(sizeof(LISTNODE));/*�������ڴ�*/
	if(listPtr!=NULL)/*����ͷ���*/
	{
	  listPtr->nextPtr=NULL;
	  lastPtr=listPtr;
    }	  
	scanf("%d",&num);/*�����һ������*/
	while(num!=-1)
	{
	   currentPtr=malloc(sizeof(LISTNODE));/*�������ڴ�*/ 
	   if(currentPtr!=NULL)
	   {
	  		currentPtr->data=num;
	  		currentPtr->nextPtr=NULL;
	  		lastPtr->nextPtr=currentPtr;/*��ǰ��������½��*/
	  		lastPtr=currentPtr;/*����lastPtrԤ���´�ѭ��*/
	   }
	   scanf("%d",&num);
	}
	return listPtr;/*����ͷ���*/	 
}

void printList(LISTNODEPTR currentPtr)/*��ͷ��������ı���*/ 
{
	 currentPtr=currentPtr->nextPtr;/*����ͷ���*/
 	 
 	 while(currentPtr!=NULL)
 	 {
		printf("%d ",currentPtr->data);
		currentPtr=currentPtr->nextPtr;
	 }	
 	 printf("\n");
}

void deleteNode(LISTNODEPTR sPtr)/*ɾ��ָ��Ԫ��*/ 
{
     int value;
     LISTNODEPTR currentPtr,previousPtr;
     previousPtr=NULL;
         
     printf("Please input an integer you want to delete:");
     scanf("%d",&value); 
     
	 while(sPtr->data==value)
     {
        	currentPtr=sPtr;
        	sPtr=sPtr->nextPtr;
        	free(currentPtr);
     }
	 for(currentPtr=sPtr;currentPtr!=NULL;previousPtr=currentPtr,currentPtr=currentPtr->nextPtr)
     {
	    if(currentPtr->data==value)
        {  
	    	 previousPtr->nextPtr=currentPtr->nextPtr;    	     
			 free(currentPtr);
			 currentPtr=previousPtr;
        }
     }
     if(sPtr->nextPtr!=NULL)
     {
    	printf("The new list is:"); 
		printList(sPtr);		
     } 
     else
        printf("There is no item in the list");
}
