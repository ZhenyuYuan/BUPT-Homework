package homework7;

public class _14211529_Ԭ����_7_PricingStrategyFactory {
	/*���Թ����� ����ģʽ�� ����ģʽ*/
	 private static _14211529_Ԭ����_7_PricingStrategyFactory instance;
	 private _14211529_Ԭ����_7_StrategyCatalog catalog;

	 private _14211529_Ԭ����_7_PricingStrategyFactory(){
		 //this.catalog=catalog;
	 }
	    
	 public static _14211529_Ԭ����_7_PricingStrategyFactory getInstance(){
	     /* ����ģʽ����ֻ֤��һ��ʵ�� */
	     if(instance==null){
	         instance = new _14211529_Ԭ����_7_PricingStrategyFactory();
	     }
	     return instance;
	 }

	 public _14211529_Ԭ����_7_IPricingStrategy getPricingStrategy(_14211529_Ԭ����_7_BookType bookType){ 
		 /* ����������ͷ��ز�ͬ���� */  
		 _14211529_Ԭ����_7_IPricingStrategy strategy = catalog.getStrategies().get(bookType);
		 if(strategy!=null){
	         return strategy;
	     }
	     else return new _14211529_Ԭ����_7_NoDiscountStrategy();
	 }

	 public void setCatalog(_14211529_Ԭ����_7_StrategyCatalog catalog){
	     this.catalog=catalog;
	 }
}
