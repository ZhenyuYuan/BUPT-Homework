/*ɾ��ע��*/
#include<stdio.h>
#include<stdlib.h>
void DeleteNote(FILE *,FILE *);/*ɾ��ע�ͺ���ԭ��*/
main()
{
	char ch;
	FILE *sfPtr = NULL , *dfPtr = NULL;/*���������ļ�ָ��*/

	printf("Delete Note\n");
	
	if(( sfPtr = fopen( "source.c" , "r" )) == NULL )/*��ֻ����ʽ��Դ�ļ�source.c*/
	  printf("can't open the source file\n");
    else{
	    if(( dfPtr = fopen( "desk.c" , "w" )) == NULL)/*��ֻд��ʽ���ļ�desk.c*/
	        printf("can't open the desk file\n");
	    else
	    	DeleteNote( sfPtr , dfPtr );/*�����Ӻ���*/ 
	}	
	fclose(sfPtr);/*�ر��ļ�*/
	fclose(dfPtr);
	
	system("pause");
	return 0;
}
void DeleteNote( FILE *sfPtr , FILE *dfPtr )/*ɾ��ע�ͺ�������*/
{
    int i=0;
	char ch;
    ch = fgetc(sfPtr);
	while( !feof (sfPtr) ){	
		switch(i){
			case 0:
			  if( ch == '/' )  i=2;
			  else {
			    if( ch == '"' )  i=1;
			  	fputc(ch,dfPtr);
			  }	
			  ch = fgetc(sfPtr);
			  break;
			case 1:
			  while( ch != '"' ){
			    fputc(ch,dfPtr);
			    ch = fgetc(sfPtr);
		      }  
			  fputc(ch,dfPtr);
		      i=0;
		      ch = fgetc(sfPtr);
		      break;
		    case 2:
		      if( ch == '/'){
			    while( ch != '\n' )
				  ch = fgetc(sfPtr);
				i=0;
			  }	  
			  else 
			   if( ch == '*' ){
			  	 i=3;
			     ch = fgetc(sfPtr);
			   }
			   else{
			     fputc(ch,dfPtr);
			     i=0;
			     ch = fgetc(sfPtr);
			   }
			  break;
			case 3:
			  while( ch != '*' )
			    ch = fgetc(sfPtr);			  
			  if(( ch = fgetc(sfPtr)) == '/')  i=0;
			  else i=3;
			  break;			  			  
		}
	    
	}
}
