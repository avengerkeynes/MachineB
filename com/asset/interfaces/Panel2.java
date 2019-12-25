package com.asset.interfaces;

import com.asset.DBIP;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Panel2 extends JPanel{
    public Panel2()
    {
        this.setLayout(null);

        String[] header={"MAC","修改项","原值","现值"};

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
        jsp_table.setBounds(25, 25,525,300);
        this.add(jsp_table);

        JRadioButton zx=new JRadioButton("在线",true);
        zx.setFont(new Font("仿宋",Font.PLAIN,18));
        zx.setBounds(475,425,75,25);
        zx.setOpaque(false);
        this.add(zx);

        JRadioButton lx=new JRadioButton("离线");
        lx.setFont(new Font("仿宋",Font.PLAIN,18));
        lx.setBounds(475,475,75,25);
        lx.setOpaque(false);
        this.add(lx);

        ButtonGroup bg_zx_lx=new ButtonGroup();
        bg_zx_lx.add(zx);
        bg_zx_lx.add(lx);

        JLabel rmac=new JLabel("MAC:");
        rmac.setBounds(25,425,150,25);
        rmac.setFont(new Font("仿宋",Font.PLAIN,18));
        this.add(rmac);

        JTextField rmac0=new JTextField();
        rmac0.setFont(new Font("仿宋",Font.PLAIN,18));
        rmac0.setBounds(175,425,175,25);
        rmac0.setEditable(false);
        this.add(rmac0);

        JButton zr=new JButton("载入");
        zr.setFont(new Font("仿宋",Font.PLAIN,18));
        zr.setBounds(380,425,50,25);
        zr.setMargin(new Insets(0,0,0,0));
        this.add(zr);

        JLabel xgx=new JLabel("修改项:");
        xgx.setFont(new Font("仿宋",Font.PLAIN,18));
        xgx.setBounds(25,475,150,25);
        this.add(xgx);

        JComboBox xgx0=new JComboBox();
        xgx0.setFont(new Font("仿宋",Font.PLAIN,18));
        xgx0.setBounds(175,475,175,25);
        xgx0.addItem("更改一级部门");
        xgx0.addItem("更改二级部门");
        xgx0.addItem("更改三级部门");
        xgx0.addItem("更改使用者");
        xgx0.addItem("更改资产编号");
        this.add(xgx0);

        JButton inserttable=new JButton("修改添加");
        inserttable.setFont(new Font("仿宋",Font.PLAIN,18));
        inserttable.setBounds(425,575,100,25);
        inserttable.setOpaque(false);
        inserttable.setMargin(new Insets(0,0,0,0));
        this.add(inserttable);
        JButton deletetable=new JButton("删除数据");
        deletetable.setFont(new Font("仿宋",Font.PLAIN,18));
        deletetable.setBounds(125,350,100,25);
        deletetable.setOpaque(false);
        deletetable.setMargin(new Insets(0,0,0,0));
        this.add(deletetable);
        JButton droptable=new JButton("清空列表");
        droptable.setFont(new Font("仿宋",Font.PLAIN,18));
        droptable.setBounds(375,350,100,25);
        droptable.setOpaque(false);
        droptable.setMargin(new Insets(0,0,0,0));
        this.add(droptable);

        JLabel ysj=new JLabel("转出一级部门:");
        ysj.setFont(new Font("仿宋",Font.PLAIN,18));
        ysj.setBounds(25,525,150,25);
        this.add(ysj);

        JTextField ysj0=new JTextField();
        ysj0.setFont(new Font("仿宋",Font.PLAIN,18));
        ysj0.setBounds(175,525,175,25);
        ysj0.setEditable(false);
        this.add(ysj0);

        JButton jz=new JButton("查  看");
        jz.setFont(new Font("仿宋",Font.PLAIN,18));
        jz.setBounds(425,525,100,25);
        this.add(jz);

        JLabel xsj=new JLabel("转入一级部门:");
        xsj.setFont(new Font("仿宋",Font.PLAIN,18));
        xsj.setBounds(25,575,150,25);
        this.add(xsj);

        JTextField xsj0=new JTextField();
        xsj0.setFont(new Font("仿宋",Font.PLAIN,18));
        xsj0.setBounds(175,575,175,25);
        this.add(xsj0);

        JButton xgtj=new JButton("提交申请");
        xgtj.setBounds(200,650,150,25);
        xgtj.setFont(new Font("仿宋",Font.PLAIN,18));
        xgtj.setOpaque(false);
        xgtj.setMargin(new Insets(0,0,0,0));
        this.add(xgtj);

        zx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jz.setVisible(true);
                zr.setVisible(true);
                rmac0.setEditable(false);
                rmac0.setText("");
                ysj0.setEditable(false);
                ysj0.setText("");
                xsj0.setText("");
            }
        });

        lx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jz.setVisible(false);
                zr.setVisible(false);
                rmac0.setEditable(true);
                rmac0.setText("");
                ysj0.setEditable(true);
                ysj0.setText("");
                xsj0.setText("");
            }
        });

        JLabel jp2logo=new JLabel(new ImageIcon(System.getProperty("user.dir")+"/res/logo.jpg"));
        jp2logo.setBounds(425,675,150,40);
        this.add(jp2logo);

        JLabel jp2text=new JLabel("信息中心");
        jp2text.setFont(new Font("华文行楷",Font.PLAIN,10));
        jp2text.setBounds(500,715,100,25);
        this.add(jp2text);
        //插入数据
        inserttable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rmac0.getText().length()*xsj0.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null,"MAC地址和现值不得为空！","警告",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    if(!ysj0.getText().replace(" ","").equals(xsj0.getText().replace(" ",""))){
                        int rowcount=table.getRowCount();
                        rowcount=rowcount+1;
                        tbmodel.setRowCount(rowcount);
                        String[] insertdata=new String[4];
                        insertdata[0]=rmac0.getText();
                        insertdata[1]=xgx0.getSelectedItem().toString();
                        insertdata[2]=ysj0.getText();
                        insertdata[3]=xsj0.getText();
                        table.setValueAt(insertdata[0],rowcount-1,0);
                        table.setValueAt(insertdata[1],rowcount-1,1);
                        table.setValueAt(insertdata[2],rowcount-1,2);
                        table.setValueAt(insertdata[3],rowcount-1,3);
                        rmac0.setText("");
                        xgx0.setSelectedIndex(0);
                        ysj0.setText("");
                        xsj0.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"原值与现值不能相同！","警告",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        //删除数据
        deletetable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                    xgTabledata.clear();
                if(table.getRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null,"未发现有可删除数据！","警告",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    int rowselect=table.getSelectedRow();
                    tbmodel.removeRow(rowselect);
                }
            }
        });
        //清空列表
        droptable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbmodel.setRowCount(0);
            }
        });
        //修改项下拉
        xgx0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(xgx0.getSelectedItem().toString().equals("更改一级部门"))
                {
                    ysj.setText("转出一级部门:");
                    xsj.setText("转入一级部门:");
                }
                else if(xgx0.getSelectedItem().toString().equals("更改二级部门"))
                {
                    ysj.setText("转出二级部门:");
                    xsj.setText("转入二级部门:");
                }
                else if(xgx0.getSelectedItem().toString().equals("更改三级部门"))
                {
                    ysj.setText("转出三级部门:");
                    xsj.setText("转入三级部门:");
                }
                else if(xgx0.getSelectedItem().toString().equals("更改使用者"))
                {
                    ysj.setText("原使用人:");
                    xsj.setText("新使用人:");
                }
                else if(xgx0.getSelectedItem().toString().equals("更改资产编号"))
                {
                    ysj.setText("原资产编号:");
                    xsj.setText("新资产编号:");
                }

                if(zx.isSelected()) {
                    int selectedxgx = xgx0.getSelectedIndex();
                    switch (selectedxgx)
                    {
                        case 0:
                            ysj0.setText(System.getProperty("Department"));
                            break;
                        case 1:
                            ysj0.setText(System.getProperty("EJBM"));
                            break;
                        case 2:
                            ysj0.setText(System.getProperty("SJBM"));
                            break;
                        case 3:
                            ysj0.setText(System.getProperty("SYZ"));
                            break;
                        case 4:
                            ysj0.setText(System.getProperty("ZCBH"));
                            break;
                    }
                }
            }
        });
        //查看按钮
        jz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
                int width=dimension.width;
                int height=dimension.height;
                PanelGetMac g=new PanelGetMac();
            }
        });
        //提交申请
        xgtj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null,"不存在可以提交的项！","警告",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    if(zx.isSelected())
                    {
                        Connection connection=null;
                       try {
                           String sql = new String();
                           OracleDataSource ods=new OracleDataSource();
                           ods.setURL(DBIP.DBIP);
                           ods.setUser(DBIP.DBUSER);
                           ods.setPassword(DBIP.DBPASSWORD);
                           connection=ods.getConnection();
                           Statement statement=connection.createStatement();
                           for (int i = 0; i < table.getRowCount(); i++) {
                               sql = "insert into ASSET.ALTER_VALUE values('" + table.getValueAt(i, 0) + "','" + table.getValueAt(i, 1) + "','" + table.getValueAt(i, 2) + "','" + table.getValueAt(i, 3) + "',sysdate,'否')";
                               statement.execute(sql);
                           }
                           statement.close();
                           connection.close();
                           JOptionPane.showMessageDialog(null,"修改申请提交成功！","提示",JOptionPane.WARNING_MESSAGE);
                           tbmodel.setRowCount(0);
                       }
                       catch (Exception e1)
                       {
                           e1.printStackTrace();
                           JOptionPane.showMessageDialog(null,"数据提交过程中出现异常！","警告",JOptionPane.WARNING_MESSAGE);
                       }
                    }
                    else if(lx.isSelected())
                    {
                        FileSystemView fileSystemView=FileSystemView.getFileSystemView();
                        File desktop=fileSystemView.getHomeDirectory();
                        String filepath=desktop.getPath()+"\\计算机设备文件";
                        try{
                            File fp=new File(filepath);
                            if(!fp.exists())
                            {
                                fp.mkdir();
                            }
                            BufferedWriter bw=new BufferedWriter(new FileWriter(fp+"\\UpdateScript.sql"));
                            String sql=new String();
                            Date now=new Date();
                            SimpleDateFormat dateFormat_y=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E");
                            String nowd=dateFormat_y.format(now);

                            for(int i=0;i<table.getRowCount();i++)
                            {
                                sql="insert into ASSET.ALTER_VALUE values('"+table.getValueAt(i,0)+"','"+table.getValueAt(i,1)+"','"+table.getValueAt(i,2)+"','"+table.getValueAt(i,3)+"',sysdate,'否'); --<"+nowd+">\n";
                                bw.write(sql);
                            }
                            bw.close();
                            JOptionPane.showMessageDialog(null,"离线版数据脚本生成完毕！存于桌面计算机设备文件文件夹内","提示",JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                        catch (Exception e1)
                        {
                            e1.printStackTrace();
                        }
                    }

                }
            }
        });

        zr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rmac0.setText(System.getProperty("MACvalue"));
                xgx0.setSelectedIndex(0);

            }
        });
    }
    public void paintComponent(Graphics g)
    {
        ImageIcon icon=new ImageIcon(System.getProperty("user.dir")+"/res/background.jpg");
        g.drawImage(icon.getImage(),0,0,this);
    }
}
