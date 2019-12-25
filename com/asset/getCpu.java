package com.asset;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class getCpu
{
    private String cpu=new String();
    public String getCpu()
    {
        try
        {
            Process process=Runtime.getRuntime().exec("cmd /k wmic cpu get name");
            InputStream inputStream=process.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
            String line="";
            while(true)
            {
                line=bufferedReader.readLine();
                line=line.replace(" ","");
                if(line.length()>20)
                {
                    cpu=line;
                    break;
                }
            }
            inputStream.close();
            bufferedReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            cpu="";
        }
        return cpu;
    }
}
