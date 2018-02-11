#include<stdio.h>
#include<stdlib.h>
struct listNode{
	int data;
	struct listNode *nextptr;
};
typedef struct listNode LISTNODE;
typedef LISTNODE *LISTNODEPTR;
LISTNODEPTR CreatList()/*������������һ������������*/
{
	int num;
	LISTNODEPTR listptr=NULL,lastptr=NULL,currentptr=NULL;
	listptr=malloc(sizeof(LISTNODE));/*�������ڴ�*/
	if(listptr!=NULL)/*����ͷ���*/
	{
		listptr->nextptr=NULL;
		lastptr=listptr;
	}
	scanf("%d",&num);/*�����һ������*/
	while(num!=-1)
	{
		currentptr=malloc(sizeof(LISTNODE));/*�������ڴ�*/
		if(currentptr!=NULL)
		{
			currentptr->data=num;
			currentptr->nextptr=NULL;
			lastptr->nextptr=currentptr;/*��ǰ��������½��*/
			lastptr=currentptr;/*����lastPtrԤ���´�ѭ��*/
		}
		scanf("%d",&num);
	}
	return listptr;/*����ͷ���*/
}

int Judge(LISTNODEPTR head1,LISTNODEPTR head2)/*�жϺ���*/
{
    LISTNODEPTR ptr1,ptr2,startptr;
    startptr=head1;/*startptr��סÿ�˱Ƚ�������head1�Ŀ�ʼ���*/ 
    ptr1=head1;/*ptr1������head1�Ĺ���ָ��*/
    ptr2=head2;/*ptr2������head2�Ĺ���ָ��*/
    while(ptr1!=NULL&&ptr2!=NULL)
    {
    	if(ptr1->data==ptr2->data)/*���ֵ��ͬ*/
    	{
    		ptr1=ptr1->nextptr;
    	    ptr2=ptr2->nextptr;
		}
		else
		{
			startptr=startptr->nextptr;/*����head1�Ŀ�ʼ���ָ����һ���*/
			ptr1=startptr;/*ptr1ָ����һ��ʼ���startptr*/
			ptr2=head2;/*ptr2ָ��head2��ͷ���*/
		} 
    }
    if(ptr2==NULL)/*�������head2�жϽ���*/ 
       return 1;
    else
       return 0;
}

main()
{
	LISTNODEPTR head1,head2,ptr1,ptr2;

	printf("Please input list A(end by -1):");
	head1=CreatList();
	printf("Please input list B(end by -1):");
	head2=CreatList();
    
	if(Judge(head1->nextptr,head2->nextptr)==1)
	   printf("ListB is the sub sequence of A\n");
    else
	   printf("ListB is not the sub sequence of A\n");
	
	system("pause");
	return 0;	
} 
