package homework7;

import java.util.ArrayList;


public class _14211529_Ԭ����_7_BookCatalog {
    private ArrayList<_14211529_Ԭ����_7_BookSpecification> books;

    _14211529_Ԭ����_7_BookCatalog(){
        books = new ArrayList<_14211529_Ԭ����_7_BookSpecification>();
    }

    void addBook(_14211529_Ԭ����_7_BookSpecification bookSpecification){
        books.add(bookSpecification);
    }


    _14211529_Ԭ����_7_BookSpecification getBookSpecification(String isdn) {
        for (_14211529_Ԭ����_7_BookSpecification bookSpecification : books) {
            if (bookSpecification.getIsbn() == isdn) {
                return bookSpecification;
            }
        }
        return null;
    }

    ArrayList<_14211529_Ԭ����_7_BookSpecification> getBooks(){
        return books;
    }
}
