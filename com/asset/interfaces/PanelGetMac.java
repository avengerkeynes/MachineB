package com.asset.interfaces;

import com.asset.DBIP;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PanelGetMac {


    public PanelGetMac()
    {
        try
        {
            JFrame jFrame=new JFrame();
            jFrame.setLayout(null);
            graphMac graphMac=new graphMac();
            graphMac.setBounds(0,0,600,800);

            graphMac.setBounds(0,0,600,800);
            graphMac.setLayout(null);

            JLabel yzm=new JLabel("验证码:");
            yzm.setFont(new Font("",Font.PLAIN,18));
            yzm.setBounds(25,25,100,25);
            graphMac.add(yzm);

            JPasswordField yzm0=new JPasswordField();
            yzm0.setBounds(125,25,100,25);
            graphMac.add(yzm0);

            JButton ck=new JButton("查看");
            ck.setFont(new Font("仿宋",Font.PLAIN,18));
            ck.setBounds(275,25,75,25);
            graphMac.add(ck);

            JLabel sbs=new JLabel("设备数:0 台");
            sbs.setFont(new Font("仿宋",Font.PLAIN,18));
            sbs.setBounds(400,25,150,25);
            graphMac.add(sbs);

            String[] header={"二级部门","三级部门","使用人","MAC","编号","型号"};
            DefaultTableModel tbmodel=new DefaultTableModel()
            {
                public boolean isCellEditable(int row,int col)
                {
                    return false;
                }
            };
            for(int i=0;i<header.length;i++)
            {
                tbmodel.addColumn(header[i]);
            }
            JTable table=new JTable();
            table.getTableHeader().setFont(new Font("仿宋",Font.PLAIN,20));
            table.setFont(new Font("仿宋",Font.PLAIN,18));
            table.setModel(tbmodel);
            table.setRowHeight(25);
            table.setBackground(Color.WHITE);
            table.setPreferredScrollableViewportSize(new Dimension(525,300));
            JScrollPane jsp_table=new JScrollPane(table);
            jsp_table.setBounds(25, 75,525,625);
            graphMac.add(jsp_table);

            ck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try
                    {
                        Connection connection = null;
                        String ryjbm=new String();
                        OracleDataSource ods = new OracleDataSource();
                        ods.setURL(DBIP.DBIP);
                        ods.setUser(DBIP.DBUSER);
                        ods.setPassword(DBIP.DBPASSWORD);
                        connection = ods.getConnection();
                        Statement statement = connection.createStatement();
                        ResultSet resultSet1=statement.executeQuery("select DEPARTMENT from asset.CODE where CODE='"+yzm0.getText()+"'");
                        while (resultSet1.next())
                        {
                            ryjbm=resultSet1.getString(1);
                        }
                        System.setProperty("Department",ryjbm);
                        resultSet1.close();
                        ResultSet resultSet2=statement.executeQuery("select 二级部门,三级部门,使用人,MAC,编号,型号 from asset.MACHINE where 一级部门='"+ryjbm+"'");
                        ArrayList<String[]> d=new ArrayList<String[]>();
                        while (resultSet2.next())
                        {
                            String[] data=new String[6];
                            data[0]=resultSet2.getString(1);
                            data[1]=resultSet2.getString(2);
                            data[2]=resultSet2.getString(3);
                            data[3]=resultSet2.getString(4);
                            data[4]=resultSet2.getString(5);
                            data[5]=resultSet2.getString(6);
                            d.add(data);
                        }
                        resultSet2.close();
                        statement.close();
                        connection.close();
                        tbmodel.setRowCount(d.size());

                        if(d.size()==0)
                        {
                            JOptionPane.showMessageDialog(null,"加载完成，不存在符合条件的项！","提示",JOptionPane.WARNING_MESSAGE);
                            sbs.setText("设备数: 0 台");
                        }
                        else {
                            sbs.setText("设备数:" + d.size() + " 台");
                            for (int i = 0; i < d.size(); i++) {
                                String[] value = d.get(i);
                                for (int j = 0; j < value.length; j++) {
                                    table.setValueAt(value[j], i, j);
                                }
                            }
                        }
                    }
                    catch (Exception e1)
                    {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null,"查看过程异常！","警告",JOptionPane.WARNING_MESSAGE);
                    }

                }
            });

            JButton xz=new JButton("确定");

        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int width=dimension.width;
        int height=dimension.height;
        jFrame.add(graphMac);
            jFrame.setBounds(width/2,height/2-400,600,800);
            jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jFrame.setTitle("MAC在线查看");
            jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/res/Capsule.png"));
            jFrame.setVisible(true);
            //表单动作
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int r=table.getSelectedRow();
                    System.setProperty("MACvalue",table.getValueAt(r,3).toString());
                    System.setProperty("EJBM",table.getValueAt(r,0).toString());
                    System.setProperty("SJBM",table.getValueAt(r,1).toString());
                    System.setProperty("SYZ",table.getValueAt(r,2).toString());
                    System.setProperty("ZCBH",table.getValueAt(r,4).toString());
                }
            });

        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }


}
