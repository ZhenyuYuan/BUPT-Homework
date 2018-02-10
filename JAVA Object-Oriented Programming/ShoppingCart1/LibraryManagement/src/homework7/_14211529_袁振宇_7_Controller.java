package homework7;

import java.util.ArrayList;
import java.util.HashMap;

public class _14211529_Ԭ����_7_Controller implements _14211529_Ԭ����_7_SubjectForMainUI {
    private _14211529_Ԭ����_7_BookCatalog bookCatalog; //���Ŀ¼
    private _14211529_Ԭ����_7_StrategyCatalog strategyCatalog; //����Ŀ¼
    private _14211529_Ԭ����_7_PricingStrategyFactory pricingStrategyFactory;
    private _14211529_Ԭ����_7_Sale sale;
    private ArrayList<_14211529_Ԭ����_7_ObserverForMainUI> observerForMainUIs; //ΪMainUI��ͼ���б���ӹ۲���ģʽ

    _14211529_Ԭ����_7_Controller() {
        bookCatalog = new _14211529_Ԭ����_7_BookCatalog();
        strategyCatalog = new _14211529_Ԭ����_7_StrategyCatalog();
        pricingStrategyFactory = _14211529_Ԭ����_7_PricingStrategyFactory.getInstance();
        pricingStrategyFactory.setCatalog(strategyCatalog);
        sale = new _14211529_Ԭ����_7_Sale();
        observerForMainUIs = new ArrayList<>();
    }

    void addBook(_14211529_Ԭ����_7_BookSpecification bookSpecification) {
        bookCatalog.addBook(bookSpecification);
        notifyObservers();

    }

    boolean addStrategy(int strategyType, int strategyNumber, _14211529_Ԭ����_7_BookType bookType, String content) {
        switch (strategyType) {
            case 0: //Flat
                int discountPerBook;
                try {
                    discountPerBook = Integer.parseInt(content);
                }
                catch (java.lang.NumberFormatException e1) {
                    System.out.println("���Flat����ʱ����discountPerBook�������֡�");
                    return false;
                }
                _14211529_Ԭ����_7_FlatRateStrategy flatRateStrategy = new _14211529_Ԭ����_7_FlatRateStrategy(strategyNumber, discountPerBook);

                if (strategyCatalog.getStrategies().containsKey(bookType) || strategyCatalog.hasStrategy(strategyNumber)) {
                    System.out.println("���Flat����ʱ����ָ��ͼ�����������Żݲ��Ի���Ժ��ظ���");
                    return false;
                }
                else {
                    strategyCatalog.getStrategies().put(bookType, flatRateStrategy);
                    return true;
                }
                //break;
            case 1://Percentage
                double percentageDiscount = 0;
                try {
                    percentageDiscount = Float.parseFloat(content) / 100;
                }
                catch (java.lang.NumberFormatException e1) {
                    System.out.println("���Percentage����ʱ����percentageDiscount�������֡�");
                    return false;
                }
                _14211529_Ԭ����_7_PercentageStrategy percentageStrategy = new _14211529_Ԭ����_7_PercentageStrategy(strategyNumber, percentageDiscount);
                if (strategyCatalog.getStrategies().containsKey(bookType) || strategyCatalog.hasStrategy(strategyNumber)) {
                    System.out.println("���Flat����ʱ����ָ��ͼ�����������Żݲ��Ի���Ժ��ظ���");
                    return false;
                }
                else {
                    strategyCatalog.getStrategies().put(bookType, percentageStrategy);
                    return true;
                }
                //break;

            case 2://Composite
                ArrayList<Integer> simpleStratagyNumber = new ArrayList<>();
                String[] strList = content.split("\\|");
                if (strList.length < 2) {
                    System.out.println("���ϲ��������ʽ����");
                    return false;
                }
                else {
                    for (String s : strList) {
                        try {
                            simpleStratagyNumber.add(Integer.parseInt(s));
                        }
                        catch (java.lang.NumberFormatException e1) {
                            System.out.println("���ϲ������ɴ��󣬼�⵽�������֡�");
                            return false;
                        }
                    }
                    if (strategyCatalog.getStrategies().containsKey(bookType) || strategyCatalog.hasStrategy(strategyNumber)) {
                        System.out.println(strategyCatalog.getStrategies().containsKey(bookType)+"   "+strategyCatalog.hasStrategy(strategyNumber));
                        System.out.println("���ϲ������ɴ���ָ��ͼ�����������Żݲ��Ի���Ժ��ظ���");
                        return false;
                    }
                    _14211529_Ԭ����_7_CompositeStrategy compositeStrategy = new _14211529_Ԭ����_7_CompositeBestForCustomer(strategyNumber);
                    for (Integer i : simpleStratagyNumber) {
                        if (!strategyCatalog.hasStrategy(i) || strategyCatalog.getStrategyTypeFromNumber(i) == 2) {
                            System.out.println("���ϲ������ɴ���ָ����һ���Ǽ򵥲��ԡ�");
                            return false;
                        }
                        _14211529_Ԭ����_7_IPricingStrategy strategy = strategyCatalog.getStrategies().get(strategyCatalog.getKeyFromNumber(i));
                        if(compositeStrategy.strategies.contains(strategy)){
                            System.out.println("���ϲ������ɴ���ָ�����ظ��Ĳ��ԡ�");
                            return false;
                        }
                        else {
                            compositeStrategy.add(strategy);
                        }
                    }
                    strategyCatalog.getStrategies().put(bookType, compositeStrategy);
                    return true;
                }
                //break;
            default:
                System.out.println("�������ʹ���");
                return false;
        }
    }

    boolean deleteStrategy(int strategyNumber) {
        HashMap<_14211529_Ԭ����_7_BookType, _14211529_Ԭ����_7_IPricingStrategy> strategies = strategyCatalog.getStrategies();
        _14211529_Ԭ����_7_BookType key = strategyCatalog.getKeyFromNumber(strategyNumber);
        strategies.remove(key);
        System.out.println(key.toString());
        return true;
    }
    
    boolean updateStrategy(int strategyType, int strategyNumber, _14211529_Ԭ����_7_BookType bookType, String content) {
        switch (strategyType) {
            case 0://Flat
                int discountPerBook = 0;
                try {
                    discountPerBook = Integer.parseInt(content);
                }
                catch (java.lang.NumberFormatException e1) {
                    return false;
                }
                if (strategyCatalog.getStrategies().containsKey(bookType)) {
                    _14211529_Ԭ����_7_FlatRateStrategy flatRateStrategy =
                            (_14211529_Ԭ����_7_FlatRateStrategy) strategyCatalog.getStrategies().get(bookType);
                    if(flatRateStrategy.getStrategyNumber()!= strategyNumber && strategyCatalog.hasStrategy(strategyNumber))
                        return false;
                    flatRateStrategy.setStrategyNumber(strategyNumber);
                    flatRateStrategy.setDiscountPerBook(discountPerBook);
                    return true;
                }
                else return false;
            case 1://Percentage
                double percentageDiscount = 0;
                try {
                    percentageDiscount = Float.parseFloat(content) / 100;
                }
                catch (java.lang.NumberFormatException e1) {
                    return false;
                }
                if (strategyCatalog.getStrategies().containsKey(bookType)) {
                    _14211529_Ԭ����_7_PercentageStrategy percentageStrategy =
                            (_14211529_Ԭ����_7_PercentageStrategy) strategyCatalog.getStrategies().get(bookType);
                    if(percentageStrategy.getStrategyNumber()!=strategyNumber && strategyCatalog.hasStrategy(strategyNumber))
                        return false;
                    percentageStrategy.setStrategyNumber(strategyNumber);
                    percentageStrategy.setDiscountPercentage(percentageDiscount);
                    return true;
                }
                else return false;

            case 2://Composite
                if (strategyCatalog.getStrategies().containsKey(bookType)) {
                    _14211529_Ԭ����_7_IPricingStrategy strategyBackup = strategyCatalog.getStrategies().get(bookType);
                    int strategyNumberOld = strategyBackup.getStrategyNumber();
                    if(strategyNumberOld!=strategyNumber && strategyCatalog.hasStrategy(strategyNumber))
                        return false;
                    if (!deleteStrategy(strategyNumberOld)) return false;
                    if (!addStrategy(strategyType, strategyNumber, bookType, content)) {
                        strategyCatalog.getStrategies().put(bookType, strategyBackup);
                        return false;
                    }
                    else return true;
                }
                else return false;
            default:
                return false;
        }
    }

    boolean buyBook(int copies, String isbn) {
        _14211529_Ԭ����_7_BookSpecification bookSpecification = bookCatalog.getBookSpecification(isbn);
        if (bookSpecification == null) {
            return false;
        }
        _14211529_Ԭ����_7_IPricingStrategy strategy =
                pricingStrategyFactory.getPricingStrategy(bookSpecification.getType());
        _14211529_Ԭ����_7_SaleLineItem saleLineItem =
                new _14211529_Ԭ����_7_SaleLineItem(copies, bookSpecification, strategy);
        sale.addSaleLineItem(saleLineItem);
        sale.notifyObservers();
        return true;
    }

    int getStrategyType(int strategyNumber) {
        return strategyCatalog.getStrategyTypeFromNumber(strategyNumber);
    }

    _14211529_Ԭ����_7_BookSpecification getBookSpecification(String isdn) {
        return bookCatalog.getBookSpecification(isdn);
    }

    ArrayList<_14211529_Ԭ����_7_IPricingStrategy> findCompsiteContainSimple(int strategyNumber) {
        return strategyCatalog.findCompsiteContainSimple(strategyNumber);
    }
    
    _14211529_Ԭ����_7_StrategyCatalog getStrategyCatalog() {
        return strategyCatalog;
    }

    _14211529_Ԭ����_7_Sale getSale() {
        return sale;
    }

    _14211529_Ԭ����_7_BookCatalog getBookCatalog() {
        return bookCatalog;
    }

    public void removeObserver(_14211529_Ԭ����_7_ObserverForMainUI observer) {
        if (observerForMainUIs.contains(observer)) {
            observerForMainUIs.remove(observer);
        }
    }

    public void registerObserver(_14211529_Ԭ����_7_ObserverForMainUI observer) {
        observerForMainUIs.add(observer);
    }

    public void notifyObservers() {
        for (_14211529_Ԭ����_7_ObserverForMainUI observerForMainUI : observerForMainUIs) {
            observerForMainUI.update();
        }
    }
}
