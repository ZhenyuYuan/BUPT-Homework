package homework7;

public class _14211529_Ԭ����_7_NoDiscountStrategy implements _14211529_Ԭ����_7_IPricingStrategy{
	public double getSubTotal(_14211529_Ԭ����_7_SaleLineItem saleLineItem) {
		return saleLineItem.prodSpec.getPrice();
	}

	public int getStrategyNumber() {
		return 0;
	}

	public int getStrategyType() {
		// TODO Auto-generated method stub
		return 3;
	}
	public String toString(){
	    return "�޲���";
	}
}
