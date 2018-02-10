package homework7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class _14211529_Ԭ����_7_MainUI extends JFrame implements ActionListener,_14211529_Ԭ����_7_ObserverForMainUI {
    private _14211529_Ԭ����_7_Controller controller;
    private JPanel mainPanel = new JPanel();
    private ModelTable modelTable = new ModelTable();
    private JTable table = new JTable(modelTable);
    private JScrollPane scrollPane = new JScrollPane(table);
    private JButton buttonAddBook = new JButton("���ͼ����Ϣ");
    private JButton buttonStrategies = new JButton("�����ۿ۲���");
    private JButton buttonBuy = new JButton("����ѡ��ͼ��");

    _14211529_Ԭ����_7_MainUI() {
        setTitle("ͼ������ϵͳ");
        mainPanel.add(scrollPane);
        mainPanel.add(buttonAddBook);
        mainPanel.add(buttonStrategies);
        mainPanel.add(buttonBuy);

        controller = new _14211529_Ԭ����_7_Controller();
        controller.registerObserver(this);
        if(JOptionPane.showConfirmDialog(null, "�����Ƿ�Ҫ�Զ������Ϣ�أ�", "ͼ������ϵͳ", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            initialize();

        buttonBuy.addActionListener(this);
        buttonAddBook.addActionListener(this);
        buttonStrategies.addActionListener(this);

        _14211529_Ԭ����_7_ShoppingCartUI shoppingCartUI = new _14211529_Ԭ����_7_ShoppingCartUI(controller.getSale());

        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        setResizable(false);
        setSize(500, 400);
        setLocation((screenWidth - 100) / 2, (screenHeight - 400) / 2);
        setVisible(true);
    }

    class ModelTable extends DefaultTableModel {
        private Vector TableData;
        private Vector TableTitle;

        public ModelTable() {
            TableData = new Vector();
            TableTitle = new Vector();
            setDataVector(TableData, TableTitle);
            TableTitle.add("����");
            TableTitle.add("ISBN");
            TableTitle.add("����");
            TableTitle.add("�۸�");
        }

        public void addBook(_14211529_Ԭ����_7_BookSpecification book) {
            ArrayList line = new ArrayList();
            line.add(book.getTitle());
            line.add(book.getIsbn());
            String bookTypeStr ="";
            switch (book.getType()){
                case NONCOMPUTER:
                    bookTypeStr = "�ǽ̲�������ͼ��";
                    break;
                case TEXTBOOK:
                    bookTypeStr = "�̲���ͼ��";
                    break;
                case HEALTH:
                    bookTypeStr = "������ͼ��";
                    break;
                case COMIC:
                    bookTypeStr = "��������ͼ��";
                    break;
                case OTHER:
                    bookTypeStr = "������ͼ��";
                    break;
            }
            line.add(bookTypeStr);
            line.add(book.getPrice());
            TableData.add(line);
            table.repaint();
            table.updateUI();
        }

        public String getISDN(int rowIndex) {
            ArrayList list = (ArrayList) this.TableData.get(rowIndex);
            return (String) list.get(1);
        }

        public void updateUI() {
            TableData.clear();
            for (_14211529_Ԭ����_7_BookSpecification bookSpecification : controller.getBookCatalog().getBooks()) {
                addBook(bookSpecification);
            }
        }

        public int getColumnCount() {
            return TableTitle.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            ArrayList list = (ArrayList) this.TableData.get(rowIndex);
            return list.get(columnIndex);
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAddBook){
            _14211529_Ԭ����_7_AddBookUI addBookUI = new _14211529_Ԭ����_7_AddBookUI(controller);
            addBookUI.setVisible(true);
        }
        else if(e.getSource()==buttonBuy){
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "��ѡ��Ҫ������鼮��", "����", JOptionPane.ERROR_MESSAGE);
            } else {
                _14211529_Ԭ����_7_BuyUI buyUI = new _14211529_Ԭ����_7_BuyUI(controller,modelTable.getISDN(table.getSelectedRow()));
                buyUI.setVisible(true);
            }
        }
        else if(e.getSource()==buttonStrategies){
            _14211529_Ԭ����_7_StrategiesUI strategiesUI = new _14211529_Ԭ����_7_StrategiesUI(controller);
            strategiesUI.setVisible(true);
        }
    }

    public void update(){
        modelTable.updateUI();
    }

    public void initialize(){
        controller.addBook(new _14211529_Ԭ����_7_BookSpecification("978-7-302-2", 18, "UML��ģʽӦ��", _14211529_Ԭ����_7_BookType.TEXTBOOK));
        controller.addBook(new _14211529_Ԭ����_7_BookSpecification("978-7-312-3", 34, "Java��ģʽ", _14211529_Ԭ����_7_BookType.NONCOMPUTER));
        controller.addBook(new _14211529_Ԭ����_7_BookSpecification("986-6-302-1", 58, "Head First���ģʽ", _14211529_Ԭ����_7_BookType.NONCOMPUTER));
        controller.addBook(new _14211529_Ԭ����_7_BookSpecification("958-1-302-2", 30, "����˿���ռ�", _14211529_Ԭ����_7_BookType.COMIC));
        controller.addBook(new _14211529_Ԭ����_7_BookSpecification("900-7-392-2", 20, "������ȫ", _14211529_Ԭ����_7_BookType.HEALTH));
        controller.addStrategy(0,1, _14211529_Ԭ����_7_BookType.TEXTBOOK,String.valueOf(1));
        controller.addStrategy(1,2, _14211529_Ԭ����_7_BookType.COMIC,String.valueOf(7));
        controller.addStrategy(1,3, _14211529_Ԭ����_7_BookType.NONCOMPUTER,String.valueOf(3));
        controller.addStrategy(2,4, _14211529_Ԭ����_7_BookType.HEALTH,"1|3");
    }
}