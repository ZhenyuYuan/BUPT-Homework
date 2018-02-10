package homework7;

public class _14211529_Ԭ����_7_CompositeBestForCustomer extends _14211529_Ԭ����_7_CompositeStrategy {
    _14211529_Ԭ����_7_CompositeBestForCustomer(int strategyNumber){
        super(strategyNumber);
    }

    public double getSubTotal(_14211529_Ԭ����_7_SaleLineItem saleLineItem) {
        double lowestMoney = Double.MAX_VALUE;
        for (_14211529_Ԭ����_7_IPricingStrategy strategy : strategies) {
            double money = strategy.getSubTotal(saleLineItem);
            lowestMoney = Double.min(money, lowestMoney);
        }
        return lowestMoney;
    }
}