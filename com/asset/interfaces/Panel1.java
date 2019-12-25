package com.asset.interfaces;

import com.asset.DBIP;
import com.asset.getCpu;
import com.asset.getMac;
import com.asset.getMemory;
import jdk.nashorn.internal.scripts.JO;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Panel1 extends JPanel {
    public Panel1()
    {
        this.setLayout(null);
        JLabel yjbm11=new JLabel("验证码:");
        yjbm11.setFont(new Font("仿宋",Font.PLAIN,18));
        yjbm11.setBounds(25,25,100,25);
        this.add(yjbm11);

        JTextField yjbm1=new JTextField();
        yjbm1.setBounds(125,25,125,25);
        yjbm1.setFont(new Font("仿宋",Font.PLAIN,18));
        yjbm1.setVisible(false);
        this.add(yjbm1);

        JPasswordField yzm0=new JPasswordField();
        yzm0.setBounds(125,25,125,25);
        this.add(yzm0);


        JLabel ejbm=new JLabel("二级部门:");
        ejbm.setBounds(275,25,100,25);
        ejbm.setFont(new Font("仿宋",Font.PLAIN,18));
        this.add(ejbm);

        JTextField ejbm0=new JTextField();
        ejbm0.setFont(new Font("仿宋",Font.PLAIN,18));
        ejbm0.setBounds(375,25,150,25);
        this.add(ejbm0);

        JLabel sjbm=new JLabel("三级部门:");
        sjbm.setBounds(25,75,100,25);
        sjbm.setFont(new Font("仿宋",Font.PLAIN,18));
        this.add(sjbm);

        JTextField sjbm0=new JTextField();
        sjbm0.setFont(new Font("仿宋",Font.PLAIN,18));
        sjbm0.setBounds(125,75,125,25);
        sjbm0.setText("无");
        sjbm0.setEditable(false);
        this.add(sjbm0);

        JCheckBox sfxgsjbm=new JCheckBox("编辑",false);
        sfxgsjbm.setFont(new Font("仿宋",Font.PLAIN,18));
        sfxgsjbm.setBounds(275,75,75,25);
        sfxgsjbm.setBackground(Color.WHITE);
        this.add(sfxgsjbm);

        sfxgsjbm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sfxgsjbm.isSelected())
                {
                    sjbm0.setEditable(true);
                    sjbm0.setText("");
                }
                else
                {
                    sjbm0.setEditable(false);
                    sjbm0.setText("无");
                }
            }
        });

        JLabel syr=new JLabel("使用人:");
        syr.setFont(new Font("仿宋",Font.PLAIN,18));
        syr.setBounds(25,125,150,25);
        this.add(syr);

        JTextField syr0=new JTextField();
        syr0.setBounds(125,125,125,25);
        syr0.setFont(new Font("仿宋",Font.PLAIN,18));
        this.add(syr0);

        JLabel xh=new JLabel("型号:");
        xh.setFont(new Font("仿宋",Font.PLAIN,18));
        xh.setBounds(275,125,125,25);
        this.add(xh);

        JTextField xh0=new JTextField();
        xh0.setFont(new Font("仿宋",Font.PLAIN,18));
        xh0.setBounds(375,125,125,25);
        this.add(xh0);

        JLabel bh=new JLabel("编号:");
        bh.setFont(new Font("仿宋",Font.PLAIN,18));
        bh.setBounds(25,175,150,25);
        this.add(bh);

        JTextField bh0=new JTextField();
        bh0.setFont(new Font("仿宋",Font.PLAIN,18));
        bh0.setBounds(125,175,125,25);
        this.add(bh0);

        JCheckBox sfxgxtxx=new JCheckBox("修改本机信息",false);
        sfxgxtxx.setFont(new Font("仿宋",Font.PLAIN,18));
        sfxgxtxx.setBounds(25,225,200,25);
        sfxgxtxx.setBackground(Color.WHITE);
        this.add(sfxgxtxx);

        JRadioButton zx=new JRadioButton("在线",true);
        zx.setFont(new Font("仿宋",Font.PLAIN,18));
        zx.setBounds(250,225,100,25);
        zx.setOpaque(false);
        this.add(zx);

        JRadioButton lx=new JRadioButton("离线");
        lx.setFont(new Font("仿宋",Font.PLAIN,18));
        lx.setBounds(425,225,100,25);
        lx.setOpaque(false);
        this.add(lx);

        ButtonGroup bg_zx_lx=new ButtonGroup();
        bg_zx_lx.add(zx);
        bg_zx_lx.add(lx);

        zx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(zx.isSelected())
                {
                    yjbm11.setText("验证码:");
                    yzm0.setVisible(true);
                    yjbm1.setVisible(false);
                }
            }
        });

        lx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lx.isSelected())
                {
                    yjbm11.setText("一级部门:");
                    yzm0.setVisible(false);
                    yjbm1.setVisible(true);
                }
            }
        });

        JLabel cpuxh=new JLabel("CPU型号:");
        cpuxh.setFont(new Font("仿宋",Font.PLAIN,18));
        cpuxh.setBounds(25,275,100,25);
        this.add(cpuxh);

        JTextField cpuxh0=new JTextField();
        cpuxh0.setFont(new Font("仿宋",Font.PLAIN,18));
        cpuxh0.setBounds(175,275,350,25);
        getCpu cpu=new getCpu();
        cpuxh0.setText(cpu.getCpu());
        cpuxh0.setEditable(false);
        this.add(cpuxh0);

        JLabel ncgs=new JLabel("内存个数:");
        ncgs.setFont(new Font("仿宋",Font.PLAIN,18));
        ncgs.setBounds(25,325,150,25);
        this.add(ncgs);

        JTextField ncgs0=new JTextField();
        ncgs0.setFont(new Font("仿宋",Font.PLAIN,18));
        ncgs0.setBounds(175,325,150,25);
        getMemory memory=new getMemory();
        memory.do_getMemory();
        ncgs0.setEditable(false);
        this.add(ncgs0);
        ncgs0.setText(String.valueOf(memory.getNumofMem()));

        JLabel ncxx=new JLabel("内存容量:");
        ncxx.setFont(new Font("仿宋",Font.PLAIN,18));
        ncxx.setBounds(25,375,150,25);
        this.add(ncxx);

        JTextArea ncxx0=new JTextArea();
        ncxx0.setFont(new Font("仿宋",Font.PLAIN,18));
        JScrollPane jScrollPane_nc=new JScrollPane(ncxx0);
        jScrollPane_nc.setBounds(175,375,350,75);
        ncxx0.setLineWrap(true);
        this.add(jScrollPane_nc);
        String mdata=new String();
        for(int i=0;i<memory.getA_Memsize().size();i++)
        {
            mdata=mdata+memory.getA_Memsize().get(i).toString()+"/";
        }
        mdata=mdata.substring(0,mdata.length()-1);
        mdata=mdata.replace(" ","");
        ncxx0.setEditable(false);
        ncxx0.setText(mdata);

        JLabel mac=new JLabel("MAC:");
        mac.setFont(new Font("仿宋",Font.PLAIN,18));
        mac.setBounds(25,475,150,25);
        this.add(mac);

        JTextField mac0=new JTextField();
        mac0.setFont(new Font("仿宋",Font.PLAIN,18));
        mac0.setBounds(175,475,250,25);
        getMac macc=new getMac();
        mac0.setText(macc.getWldz());
        mac0.setEditable(false);
        this.add(mac0);

        JLabel wkxh=new JLabel("网卡型号:");
        wkxh.setFont(new Font("仿宋",Font.PLAIN,18));
        wkxh.setBounds(25,525,150,25);
        this.add(wkxh);

        JTextField wkxh0=new JTextField();
        wkxh0.setFont(new Font("仿宋",Font.PLAIN,18));
        wkxh0.setBounds(175,525,350,25);
        wkxh0.setText(macc.getMs());
        wkxh0.setEditable(false);
        this.add(wkxh0);

        JLabel zjm=new JLabel("主机名:");
        zjm.setFont(new Font("仿宋",Font.PLAIN,18));
        zjm.setBounds(25,575,150,25);
        this.add(zjm);

        JTextField zjm0=new JTextField();
        zjm0.setBounds(175,575,350,25);
        zjm0.setFont(new Font("仿宋",Font.PLAIN,18));
        zjm0.setText(macc.getZjm());
        zjm0.setEditable(false);
        this.add(zjm0);

        JButton xjtj=new JButton("提交");
        xjtj.setFont(new Font("仿宋",Font.PLAIN,18));
        xjtj.setOpaque(false);
        xjtj.setMargin(new Insets(0,0,0,0));
        xjtj.setBounds(250,675,100,25);
        this.add(xjtj);

        JLabel jp1logo=new JLabel(new ImageIcon(System.getProperty("user.dir")+"/res/logo.jpg"));
        jp1logo.setBounds(425,675,150,40);
        this.add(jp1logo);

        JLabel jp1text=new JLabel("信息中心");
        jp1text.setFont(new Font("华文行楷",Font.PLAIN,10));
        jp1text.setBounds(500,715,100,25);
        this.add(jp1text);

        sfxgxtxx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sfxgxtxx.isSelected())
                {
                    cpuxh0.setEditable(true);
                    ncgs0.setEditable(true);
                    ncxx0.setEditable(true);
                    mac0.setEditable(true);
                    wkxh0.setEditable(true);
                    zjm0.setEditable(true);
                }
                else
                {
                    cpuxh0.setEditable(false);
                    ncgs0.setEditable(false);
                    ncxx0.setEditable(false);
                    mac0.setEditable(false);
                    wkxh0.setEditable(false);
                    zjm0.setEditable(false);
                }
            }
        });
        xjtj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(zx.isSelected())
                {
                    //在线新建设备
                    if(yzm0.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null,"验证码不得为空！","警告",JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        try {
                            String[] d = new String[13];
                            if (ejbm0.getText().length() > 0) {
                                d[1] = ejbm0.getText();
                            } else {
                                d[1] = "无";
                            }
                            d[2] = sjbm0.getText();
                            d[3] = syr0.getText();
                            d[4] = cpuxh0.getText();
                            d[5] = ncgs0.getText();
                            d[6] = ncxx0.getText();
                            d[7] = mac0.getText();
                            d[8] = bh0.getText();
                            d[9] = "sysdate";
                            d[10] = xh0.getText();
                            d[11] = zjm0.getText();
                            d[12] = wkxh0.getText();

                            Connection connection = null;
                            OracleDataSource ods = new OracleDataSource();
                            ods.setURL(DBIP.DBIP);
                            ods.setUser(DBIP.DBUSER);
                            ods.setPassword(DBIP.DBPASSWORD);
                            connection = ods.getConnection();
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("select DEPARTMENT from asset.CODE where CODE='" + yzm0.getText()+ "'");
                            String department = new String();
                            while (resultSet.next()) {
                                department = resultSet.getString(1);
                            }
                            d[0] = department;
                            if(d[0].length()==0)
                            {
                                JOptionPane.showMessageDialog(null,"验证码未获取到相应的部门！","警告",JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                            String sql = "insert into asset.machine values('" + d[0] + "','" + d[1] + "','" + d[2] + "','" + d[3] + "','" + d[4] + "'," + d[5] + ",'" + d[6] + "','" + d[7] + "','" + d[8] + "'," + d[9] + ",'" + d[10] + "','" + d[11] + "','" + d[12] + "')";
                            statement.execute(sql);
                            statement.close();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "新建设备成功！", "提示", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null, "连接数据库时出现异常！", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else if(lx.isSelected())
                {
                    //本地新建设备
                    try
                    {
                        FileSystemView fileSystemView=FileSystemView.getFileSystemView();
                        File desktop=fileSystemView.getHomeDirectory();
                        String filepath=desktop.getPath()+"\\计算机设备文件";

                        File fp=new File(filepath);
                        if(!fp.exists())
                        {
                            fp.mkdir();
                        }
                        String scriptaddress=filepath+"\\CreateScript.sql";
                        File fs=new File(scriptaddress);
                        if(!fs.exists())
                        {
                            fs.createNewFile();
                        }
                        int text=yjbm1.getText().length()*mac0.getText().length()*syr0.getText().length();
                        if(text==0)
                        {
                            JOptionPane.showMessageDialog(null,"信息不全请补全信息！","警告",JOptionPane.WARNING_MESSAGE);
                        }
                        else
                        {
                            Date now=new Date();
                            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E");
                            String nowd=dateFormat.format(now);
                            String[] d=new String[13];
                            d[0]=yjbm1.getText();
                            if(ejbm0.getText().length()>0) {d[1]=ejbm0.getText();}else{d[1]="无";}
                            d[2]=sjbm0.getText();
                            d[3]=syr0.getText();
                            d[4]=cpuxh0.getText();
                            d[5]=ncgs0.getText();
                            d[6]=ncxx0.getText();
                            d[7]=mac0.getText();
                            d[8]=bh0.getText();
                            d[9]="sysdate";
                            d[10]=xh0.getText();
                            d[11]=zjm0.getText();
                            d[12]=wkxh0.getText();

                            String sql="insert into asset.machine values('"+d[0]+"','"+d[1]+"','"+d[2]+"','"+d[3]+"','"+d[4]+"',"+d[5]+",'"+d[6]+"','"+d[7]+"','"+d[8]+"',"+d[9]+",'"+d[10]+"','"+d[11]+"','"+d[12]+"')";
                            FileWriter fwfs=new FileWriter(fs,true);
                            fwfs.write(sql+";--<"+nowd+">\n");
                            fwfs.flush();
                            fwfs.close();
                            JOptionPane.showMessageDialog(null,"离线数据写入成功!","成功",JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                    }
                    catch (Exception e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });

    }
    public void paintComponent(Graphics g)
    {
        ImageIcon icon=new ImageIcon(System.getProperty("user.dir")+"/res/background.jpg");
        g.drawImage(icon.getImage(),0,0,this);
    }

}
