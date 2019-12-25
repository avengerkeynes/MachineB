package com.asset;

import com.asset.interfaces.Panel1;
import com.asset.interfaces.Panel2;
import javax.swing.*;
import java.awt.*;


public class Display
{
    Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
    int width=dimension.width;
    int height=dimension.height;

    public Display()
    {
        JFrame jFrame=new JFrame();
        Panel1 jPanel1=new Panel1();
        Panel2 jPanel2=new Panel2();
        JTabbedPane jTabbedPane=new JTabbedPane();
        jTabbedPane.addTab("新建设备信息",jPanel1);
        jTabbedPane.addTab("修改设备信息",jPanel2);
        jTabbedPane.setBackgroundAt(0,Color.white);
        jTabbedPane.setBackgroundAt(1,Color.white);
        jTabbedPane.setFont(new Font("仿宋",Font.PLAIN,18));
        jFrame.add(jTabbedPane);
        jFrame.setBounds(width/4-300,height/2-400,600,800);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/res/Capsule.png"));
        jFrame.setTitle("固定资产Beta");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
