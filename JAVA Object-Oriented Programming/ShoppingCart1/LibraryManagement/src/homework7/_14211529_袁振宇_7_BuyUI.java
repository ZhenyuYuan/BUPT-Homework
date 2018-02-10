package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class _14211529_Ԭ����_7_BuyUI extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();
    private JLabel labelBookTitle = new JLabel();
    private JTextField textFieldCount = new JTextField();
    private JButton buttonOk = new JButton("ȷ��");
    private JButton buttonCancel = new JButton("ȡ��");
    private _14211529_Ԭ����_7_BookSpecification bookSpecification;
    private _14211529_Ԭ����_7_Controller controller;

    _14211529_Ԭ����_7_BuyUI(_14211529_Ԭ����_7_Controller controller, String isdn){
        this.controller=controller;
        bookSpecification=controller.getBookSpecification(isdn);

        setTitle("�����鼮");
        GridLayout grid=new GridLayout(3,2);
        mainPanel.setLayout(grid);
        mainPanel.add(new JLabel("������"));
        labelBookTitle.setText(bookSpecification.getTitle());
        mainPanel.add(labelBookTitle);
        mainPanel.add(new JLabel("������"));
        textFieldCount.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }
                else{
                    e.consume();
                }
            }
        });
        mainPanel.add(textFieldCount);
        mainPanel.add(buttonOk);
        mainPanel.add(buttonCancel);

        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);

        add(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        setResizable(false);
        setSize(300, 100);
        setLocation((screenWidth - 300) / 2, (screenHeight - 100) / 2);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonOk){
            int copies = 0;
            if(textFieldCount.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"δ��д������","����",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                try{
                    copies = Integer.parseInt(textFieldCount.getText());
                }
                catch (java.lang.NumberFormatException e1){
                    JOptionPane.showMessageDialog(null,"������д��ʽ����","����",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(controller.buyBook(copies,bookSpecification.getIsbn())){
                    JOptionPane.showMessageDialog(null,"�Ѽ��빺�ﳵ��","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null,"���빺�ﳵʱ�������⣬�����ԡ�","����",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        else if(e.getSource()==buttonCancel){
            setVisible(false);
            return;
        }
    }
}