package com.asset;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class getMemory
{
    private int numofMem=0;
    private ArrayList a_Memsize=new ArrayList();

    public int getNumofMem()
    {
        return numofMem;
    }

    public ArrayList getA_Memsize()
    {
        return a_Memsize;
    }

    public void do_getMemory()
    {
        try
        {
            Process process=Runtime.getRuntime().exec("cmd /k wmic memorychip get Capacity");
            InputStream inputStream=process.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
            String line="";

            ArrayList a_line=new ArrayList();
            for(int i=0;i<5;i++)
            {
                line=bufferedReader.readLine();
                if(line.length()>0)
                {
                    a_line.add(line);
                }
            }
            numofMem=a_line.size()-1;

            for(int i=0;i<numofMem;i++) {
                a_Memsize.add(a_line.get(i+1));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
