package com.asset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getMac
{
    private String zjm=new String();
    private String ms=new String();
    private String wldz=new String();
    public String getWldz()
    {
        try {
            Process process = Runtime.getRuntime().exec("cmd /k ipconfig /all");
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line = "";
            int co=0;//循环跳出开关
            while (true) {
                line = bufferedReader.readLine();
                Pattern pattern = Pattern.compile("物理地址.*");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String t_wldz = matcher.group();
                    t_wldz = t_wldz.replace(":", "");
                    t_wldz = t_wldz.replace(".", "");
                    t_wldz = t_wldz.replace(" ", "");
                    t_wldz = t_wldz.replace("物理地址", "");
                    wldz = t_wldz;
                    break;
                }
                else
                {
                    co=co+1;
                    if(co>500)
                    {
                        JOptionPane.showMessageDialog(null,"认证失败,无法获取当前设备的MAC,请联系管理员","警告",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
            inputStream.close();
            bufferedReader.close();

        } catch (Exception ee) {
            ee.printStackTrace();
            wldz="";
        }
        return wldz;
    }
    public String getMs()
    {
        try
        {
            Process process = Runtime.getRuntime().exec("cmd /k ipconfig /all");
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line = "";
            int co=0;//循环跳出开关
            while(true)
            {
                line = bufferedReader.readLine();
                Pattern pattern=Pattern.compile("描述.*");
                Matcher matcher=pattern.matcher(line);
                if(matcher.find())
                {
                    String t_ms=matcher.group();
                    t_ms=t_ms.replace(":","");
                    t_ms=t_ms.replace(".","");
                    t_ms=t_ms.replace(" ","");
                    t_ms=t_ms.replace("描述","");
                    ms=t_ms;
                    break;
                }else
                {
                    co=co+1;
                    if(co>500)
                    {
                        JOptionPane.showMessageDialog(null,"认证失败,无法获取当前设备的MAC,请联系管理员","警告",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
            inputStream.close();
            bufferedReader.close();
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
            ms="";
        }
        return ms;
    }
    public String getZjm()
    {
        try {
            Process process = Runtime.getRuntime().exec("cmd /k ipconfig /all");
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line = "";
            int co=0;//循环跳出开关
            while(true) {
                line = bufferedReader.readLine();
                Pattern pattern = Pattern.compile("主机名.*");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String t_zjm = matcher.group();
                    t_zjm = t_zjm.replace(":", "");
                    t_zjm = t_zjm.replace(".", "");
                    t_zjm = t_zjm.replace(" ", "");
                    t_zjm = t_zjm.replace("主机名", "");
                    zjm = t_zjm;
                    break;
                }
                else
                {
                    co=co+1;
                    if(co>500)
                    {
                        JOptionPane.showMessageDialog(null,"认证失败,无法获取当前设备的MAC,请联系管理员","警告",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
        }catch (Exception ee)
        {
            ee.printStackTrace();
            zjm="";
        }
        return zjm;
    }
}
