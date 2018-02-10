package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class _14211529_Ԭ����_7_AddBookUI extends JFrame implements ActionListener {
    private _14211529_Ԭ����_7_Controller controller;
    
    private JTextField textFieldPrice = new JTextField();
    private JTextField textFieldTitle = new JTextField();
    private JTextField textFieldISDN = new JTextField();
    private JComboBox comboBoxType = new JComboBox();
    private JButton buttonOk = new JButton("ȷ��");
    private JButton buttonClear = new JButton("���");



    _14211529_Ԭ����_7_AddBookUI(_14211529_Ԭ����_7_Controller controller){
        this.controller=controller;
        GridLayout grid=new GridLayout(5,2);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(grid);
        mainPanel.add(new JLabel("����:"));
        mainPanel.add(textFieldTitle);
        mainPanel.add(new JLabel("ISBN��"));
        mainPanel.add(textFieldISDN);
        mainPanel.add(new JLabel("�۸�"));
        mainPanel.add(textFieldPrice);
        mainPanel.add(new JLabel("���ͣ�"));
        mainPanel.add(comboBoxType);
        mainPanel.add(buttonOk);
        mainPanel.add(buttonClear);
        comboBoxType.addItem("�ǽ̲�������ͼ��");
        comboBoxType.addItem("�̲���ͼ��");
        comboBoxType.addItem("��������ͼ��");
        comboBoxType.addItem("������ͼ��");
        comboBoxType.addItem("����");
        pack();

        textFieldPrice.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 || keyChar == KeyEvent.VK_PERIOD){            
                }
                else{
                    e.consume();
                }
            }
        });

        textFieldISDN.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 || keyChar == KeyEvent.VK_MINUS){
                }
                else{
                    e.consume();
                }
            }
        });

        buttonOk.addActionListener(this);
        buttonClear.addActionListener(this);

        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        setTitle("����鼮��Ϣ");
        setResizable(false);
        setSize(300, 200);
        setLocation((screenWidth - 300) / 2, (screenHeight - 200) / 2);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonOk){
            if(textFieldPrice.getText().isEmpty() || textFieldISDN.getText().isEmpty() ||
                    textFieldTitle.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"����дȫ����Ϣ��","����",JOptionPane.ERROR_MESSAGE);
            }
            else{
                float price = 0;
                try{
                    price = Float.parseFloat(textFieldPrice.getText());
                }
                catch(java.lang.NumberFormatException e1){
                    JOptionPane.showMessageDialog(null,"�۸������ʽ����","����",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String title = textFieldTitle.getText();
                String isbn = textFieldISDN.getText();
                _14211529_Ԭ����_7_BookType bookType;
                switch (comboBoxType.getSelectedIndex()){
                    case 0:bookType= _14211529_Ԭ����_7_BookType.NONCOMPUTER;
                        break;
                    case 1:bookType= _14211529_Ԭ����_7_BookType.TEXTBOOK;
                        break;
                    case 2:bookType= _14211529_Ԭ����_7_BookType.COMIC;
                        break;
                    case 3:bookType= _14211529_Ԭ����_7_BookType.HEALTH;
                        break;
                    case 4:bookType= _14211529_Ԭ����_7_BookType.OTHER;
                        break;
                    default:
                        bookType= _14211529_Ԭ����_7_BookType.NOTEXIST;
                        break;
                }
                System.out.println(bookType.toString());
                controller.addBook(new _14211529_Ԭ����_7_BookSpecification(isbn,price,title,bookType));
                setVisible(false);
            }
        }
        else if(e.getSource()==buttonClear){
            textFieldISDN.setText("");
            textFieldTitle.setText("");
            textFieldPrice.setText("");
        }
    }
}