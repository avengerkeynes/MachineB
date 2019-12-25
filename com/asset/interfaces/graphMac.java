package com.asset.interfaces;

import javax.swing.*;
import java.awt.*;

public class graphMac extends JPanel {
     public graphMac()
    {
        this.setLayout(null);
    }
    public void paintComponent(Graphics g)
    {
        ImageIcon icon=new ImageIcon(System.getProperty("user.dir")+"/res/background.jpg");
        g.drawImage(icon.getImage(),0,0,this);
    }
}
