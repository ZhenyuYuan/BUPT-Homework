package homework7;

public class _14211529_Ԭ����_7_SaleLineItem {
	int copies;
	_14211529_Ԭ����_7_BookSpecification prodSpec;
	_14211529_Ԭ����_7_IPricingStrategy strategy;
	
	public _14211529_Ԭ����_7_SaleLineItem(int copies, _14211529_Ԭ����_7_BookSpecification prodSpec, _14211529_Ԭ����_7_IPricingStrategy strategy){
		this.copies = copies;
		this.prodSpec = prodSpec;
		this.strategy = strategy;
	}
	
	public double getSubTotal() {
		return strategy.getSubTotal(this)*copies;
	}
}
