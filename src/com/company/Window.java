package com.company;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class Window extends JFrame implements TableModelListener {
    Object[] columns = new String[]{"Part ID", "Part name", "Player", "Matches", "Score"};
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Matches> matches;
    JTable table;


    public Window() throws SQLException{
        setTitle("Chess");
        setBounds(300, 100, 800, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        JPanel panel = new JPanel();
    }

    public void run(){
        this.setVisible(true);
    }

    public void addVidgets(JPanel panel) throws SQLException{
        Object[][] data = new Object[0][];
        model = new DefaultTableModel(data, columns);
        model.addTableModelListener(this);
        table = new JTable(model);
        JScrollPane tableWithScroll = new JScrollPane(table);
        tableWithScroll.setBounds(5, 5, 740, 500);
        panel.add(tableWithScroll);
    }
    @Override
    public void tableChanged(TableModelEvent e) {

    }
}
