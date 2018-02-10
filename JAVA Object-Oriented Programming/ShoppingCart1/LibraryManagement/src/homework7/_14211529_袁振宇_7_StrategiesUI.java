package homework7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class _14211529_Ԭ����_7_StrategiesUI extends JFrame implements ActionListener {
    private _14211529_Ԭ����_7_Controller controller;
    private int addType = 0;
    private int selectedStrategyNumber = 0;
    private int strategyType = 0;
    private _14211529_Ԭ����_7_BookType bookType = _14211529_Ԭ����_7_BookType.OTHER;
    
    private JPanel mainPanel = new JPanel();
    private JDialog dialogAdd = new JDialog();
    private JDialog dialogModify = new JDialog();
    private ModelTable modelTable = new ModelTable();
    private JTable table = new JTable(modelTable);
    private JScrollPane scrollPane = new JScrollPane(table);
    private JButton buttonAddFlat = new JButton("��Ӿ���ֵ�Żݲ���");
    private JButton buttonAddPerc = new JButton("��Ӱٷֱ��ۿ۲���");
    private JButton buttonAddComp = new JButton("�����ϲ���");
    private JButton buttonModify = new JButton("�޸Ĳ���");
    private JButton buttonDelete = new JButton("ɾ������");

    private JTextField textFieldNumber = new JTextField();
    private JTextField textFieldDetail = new JTextField();
    private JTextField textFieldNumber1 = new JTextField();
    private JTextField textFieldDetail1 = new JTextField();

    private JButton buttonOk = new JButton("ȷ��");
    private JButton buttonCancel = new JButton("ȡ��");
    private JButton buttonOk1 = new JButton("ȷ��");
    private JButton buttonCancel1 = new JButton("ȡ��");

    private JLabel labelDetail = new JLabel("���ݣ�");
    private JLabel labelDetail2 = new JLabel("���ݣ�");

    private JComboBox comboBoxType = new JComboBox();

    _14211529_Ԭ����_7_StrategiesUI(_14211529_Ԭ����_7_Controller controller) {
        this.controller = controller;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

        setTitle("���Թ���");
        mainPanel.add(scrollPane);
        mainPanel.add(buttonAddFlat);
        mainPanel.add(buttonAddPerc);
        mainPanel.add(buttonAddComp);
        mainPanel.add(buttonModify);
        mainPanel.add(buttonDelete);

        comboBoxType.addItem("�ǽ̲�������ͼ��");
        comboBoxType.addItem("�̲���ͼ��");
        comboBoxType.addItem("��������ͼ��");
        comboBoxType.addItem("������ͼ��");
        comboBoxType.addItem("����");

        GridLayout grid = new GridLayout(4, 2);
        dialogAdd.setLayout(grid);
        dialogAdd.add(new JLabel("���Ժţ�"));
        dialogAdd.add(textFieldNumber);
        dialogAdd.add(new JLabel("������ͣ�"));
        dialogAdd.add(comboBoxType);
        dialogAdd.add(labelDetail);
        dialogAdd.add(textFieldDetail);
        dialogAdd.add(buttonOk);
        dialogAdd.add(buttonCancel);
        dialogAdd.setSize(400, 300);
        dialogAdd.setLocation((screenWidth - 400) / 2, (screenHeight - 300) / 2);
        dialogAdd.setModal(true);
        dialogAdd.pack();
        textFieldNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if (keyChar <= KeyEvent.VK_0 || keyChar >= KeyEvent.VK_9) {
                	e.consume();
                }
            }
        });

        GridLayout grid1 = new GridLayout(3, 2);
        dialogModify.setLayout(grid1);
        dialogModify.add(new JLabel("���Ժ�"));
        dialogModify.add(textFieldNumber1);
        dialogModify.add(labelDetail2);
        dialogModify.add(textFieldDetail1);
        dialogModify.add(buttonOk1);
        dialogModify.add(buttonCancel1);
        dialogModify.setSize(400, 300);
        dialogModify.setLocation((screenWidth - 400) / 2, (screenHeight - 300) / 2);
        dialogModify.pack();
        dialogModify.setModal(true);
        textFieldNumber1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if (keyChar <= KeyEvent.VK_0 || keyChar >= KeyEvent.VK_9) {
                    e.consume();
                }
            }
        });

        buttonAddFlat.addActionListener(this);
        buttonAddPerc.addActionListener(this);
        buttonAddComp.addActionListener(this);
        buttonModify.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonOk.addActionListener(this);
        buttonOk1.addActionListener(this);
        buttonCancel.addActionListener(this);
        buttonCancel1.addActionListener(this);

        modelTable.updateUI();
        add(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        setSize(500, 350);
        setResizable(false);
        setLocation((screenWidth - 500) / 2, (screenHeight - 400) / 2);
    }

    public _14211529_Ԭ����_7_BookType int2BookType(int number) {
        switch (number) {
            case 0:
                return _14211529_Ԭ����_7_BookType.NONCOMPUTER;
            case 1:
                return _14211529_Ԭ����_7_BookType.TEXTBOOK;
            case 2:
                return _14211529_Ԭ����_7_BookType.COMIC;
            case 3:
                return _14211529_Ԭ����_7_BookType.HEALTH;
            default:
                return _14211529_Ԭ����_7_BookType.OTHER;
        }
    }

    class ModelTable extends DefaultTableModel {
        private Vector TableData;
        private Vector TableTitle;

        public ModelTable() {
            TableData = new Vector();
            TableTitle = new Vector();
            setDataVector(TableData, TableTitle);
            TableTitle.add("���");
            TableTitle.add("����");
            TableTitle.add("����");
            TableTitle.add("ͼ������");
        }

        public void addItem(_14211529_Ԭ����_7_BookType bookType, _14211529_Ԭ����_7_IPricingStrategy strategy) {
            ArrayList line = new ArrayList();
            line.add(strategy.getStrategyNumber());
            switch (strategy.getStrategyType()) {
                case 0:
                    line.add("����ֵ�Ż�");
                    break;
                case 1:
                    line.add("�ٷֱ��ۿ�");
                    break;
                case 2:
                    line.add("��ϲ���");
                    break;
                case 3:
                    line.add("�޲���");
                    break;
                default:
                    line.add("����");
            }
            line.add(strategy.toString());
            String bookTypeStr = "";
            switch (bookType) {
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
            TableData.add(line);
        }

        public int getSelectedStrategyNumber(int rowIndex) {
            ArrayList list = (ArrayList) this.TableData.get(rowIndex);
            return (int) list.get(0);
        }

        public void updateUI() {
            TableData.clear();
            for (HashMap.Entry<_14211529_Ԭ����_7_BookType, _14211529_Ԭ����_7_IPricingStrategy> entry : controller.getStrategyCatalog().getStrategies().entrySet()) {
                addItem(entry.getKey(), entry.getValue());
            }
            table.repaint();
            table.updateUI();
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
        if (e.getSource() == buttonAddFlat) {
            labelDetail.setText("ÿ�������");
            dialogAdd.setTitle("��Ӿ���ֵ�Żݲ���");
            textFieldDetail.setText("");
            textFieldNumber.setText("");
            addType = 1;
            dialogAdd.setVisible(true);
        }
        else if (e.getSource() == buttonAddPerc) {
            labelDetail.setText("�ٷֱ��ۿۣ�");
            dialogAdd.setTitle("��Ӱٷֱ��ۿ۲���");
            textFieldDetail.setText("");
            textFieldNumber.setText("");
            addType = 2;
            dialogAdd.setVisible(true);
        }
        else if (e.getSource() == buttonAddComp) {
            labelDetail.setText("����1|2|...�ĸ�ʽ������Ҫ��ϵĲ��ԣ�");
            dialogAdd.setTitle("�����ϲ���");
            textFieldNumber.setText("");
            textFieldDetail.setText("");
            addType = 3;
            dialogAdd.setVisible(true);
        }

        else if (e.getSource() == buttonDelete) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����", "����", JOptionPane.ERROR_MESSAGE);
            }
            else {
                selectedStrategyNumber = modelTable.getSelectedStrategyNumber(table.getSelectedRow());
                ArrayList<_14211529_Ԭ����_7_IPricingStrategy> list = controller.findCompsiteContainSimple(selectedStrategyNumber);
                if (!list.isEmpty()) {
                    String strList = "";
                    for (_14211529_Ԭ����_7_IPricingStrategy strategy : list) {
                        strList += String.valueOf(strategy.getStrategyNumber()) + " ";
                        controller.deleteStrategy(strategy.getStrategyNumber());
                    }
                    JOptionPane.showMessageDialog(null, "��ɾ��" + strList + "���ԣ���Ϊ��Щ���԰�����Ҫɾ���Ĳ��ԡ�", "����", JOptionPane.WARNING_MESSAGE);
                }
                controller.deleteStrategy(selectedStrategyNumber);
                modelTable.updateUI();
            }
        }
        else if (e.getSource() == buttonCancel) {
            textFieldNumber.setText("");
            textFieldDetail.setText("");
            dialogAdd.setVisible(false);
        }
        else if (e.getSource() == buttonCancel1) {
            textFieldDetail1.setText("");
            textFieldNumber1.setText("");
            dialogModify.setVisible(false);
        }
        else if (e.getSource() == buttonModify) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ��", "����", JOptionPane.ERROR_MESSAGE);
            }
            else {
                textFieldNumber1.setText("");
                textFieldDetail1.setText("");
                selectedStrategyNumber = modelTable.getSelectedStrategyNumber(table.getSelectedRow());
                strategyType = controller.getStrategyType(selectedStrategyNumber);
                textFieldNumber1.setText(String.valueOf(selectedStrategyNumber));
                bookType = controller.getStrategyCatalog().getKeyFromNumber(selectedStrategyNumber);
                dialogModify.setVisible(true);
            }
        }
        else if (e.getSource() == buttonOk) {
            if (textFieldNumber.getText().isEmpty() || textFieldDetail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "����дȫ����Ϣ��", "����", JOptionPane.ERROR_MESSAGE);
            }
            else {
                int number;
                try {
                    number = Integer.parseInt(textFieldNumber.getText());
                }
                catch (java.lang.NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����д���֡�", "����", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                switch (addType) {
                    case 1:
                        try {
                        	Integer.parseInt(textFieldDetail.getText());
                        }
                        catch (java.lang.NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "����д���֡�", "����", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (controller.addStrategy(0, number, int2BookType(comboBoxType.getSelectedIndex()), textFieldDetail.getText())) {
                            JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                            textFieldDetail.setText("");
                            textFieldNumber.setText("");
                            dialogAdd.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "���ʧ��,���Ժź�ͼ�����;������ظ���", "��ʾ", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    case 2:
                        double percentage;
                        try {
                            percentage = Float.parseFloat(textFieldDetail.getText());
                        }
                        catch (java.lang.NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "����д���֡�", "����", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (percentage > 100) {
                            JOptionPane.showMessageDialog(null, "�ۿ۲��ô���100%��", "����", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (controller.addStrategy(1, number, int2BookType(comboBoxType.getSelectedIndex()), textFieldDetail.getText())) {
                            JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                            textFieldDetail.setText("");
                            textFieldNumber.setText("");
                            dialogAdd.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "���ʧ��,���Ժź�ͼ�����;������ظ���", "��ʾ", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    case 3:
                        if (controller.addStrategy(2, number, int2BookType(comboBoxType.getSelectedIndex()), textFieldDetail.getText())) {
                            JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                            textFieldDetail.setText("");
                            textFieldNumber.setText("");
                            dialogAdd.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "���ʧ��,���Ժź�ͼ�����;������ظ������ܰ������ϲ��ԡ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "���ʧ��,������д����Ϣ�Ƿ���ȷ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                modelTable.updateUI();
                textFieldNumber.setText("");
                textFieldDetail.setText("");
            }
        }
        else if (e.getSource() == buttonOk1) {
            if (textFieldNumber1.getText().isEmpty() || textFieldDetail1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "����дȫ����Ϣ��", "����", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                int number;
                try {
                    number = Integer.parseInt(textFieldNumber1.getText());
                }
                catch (java.lang.NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����д���֡�", "����", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                switch (strategyType) {
                    case 0:
                        try {
                            Integer.parseInt(textFieldDetail1.getText());
                        }
                        catch (java.lang.NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "����д���֡�", "����", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (controller.updateStrategy(0, number, bookType, textFieldDetail1.getText())) {
                            JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                            textFieldDetail1.setText("");
                            textFieldNumber1.setText("");
                            dialogModify.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "�޸�ʧ��,���Ժź�ͼ�����;������ظ���", "��ʾ", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    case 1:
                        double perscentage;
                        try {
                            perscentage = Float.parseFloat(textFieldDetail1.getText());
                        }
                        catch (java.lang.NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "����д���֡�", "����", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (perscentage > 100) {
                            JOptionPane.showMessageDialog(null, "�ۿ۲��ܴ���100%��", "����", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (controller.updateStrategy(1, number, bookType, textFieldDetail1.getText())) {
                            JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                            textFieldDetail1.setText("");
                            textFieldNumber1.setText("");
                            dialogModify.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "�޸�ʧ��,���Ժź�ͼ�����;������ظ���", "��ʾ", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    case 2:
                        if (controller.updateStrategy(2, number, bookType, textFieldDetail1.getText())) {
                            JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                            textFieldDetail1.setText("");
                            textFieldNumber1.setText("");
                            dialogModify.setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "�޸�ʧ��,���Ժź�ͼ�����;������ظ������ܰ����������͡�", "��ʾ", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "�޸�ʧ�ܡ�", "����", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                modelTable.updateUI();
                textFieldNumber1.setText("");
                textFieldDetail1.setText("");
            }
        }
    }
}