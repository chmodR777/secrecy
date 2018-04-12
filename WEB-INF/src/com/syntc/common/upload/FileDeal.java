////////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2006 SYNTC CORPORATION
//
// ALL RIGHTS RESERVED BY SYNTC CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS
// FURNISHED BY SYNTC CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF SYNTC CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
//
//////////////////////////////////////////////////////////////

// Source File Name:   FileDeal.java
package com.syntc.common.upload;

import java.io.*;

public class FileDeal
{

    public FileDeal()
    {
    }

    public static void move(String input, String output)
        throws Exception
    {
        File inputFile = new File(input);
        File outputFile = new File(output);
        try
        {
            inputFile.renameTo(outputFile);
        }
        catch(Exception ex)
        {
            throw new Exception(String.valueOf(String.valueOf((new StringBuffer("Can not mv")).append(input).append(" to ").append(output).append(ex.getMessage()))));
        }
    }

    public static boolean copy(String input, String output)
        throws Exception
    {
        int BUFSIZE = 0x10000;
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);
        try
        {
            byte buf[] = new byte[BUFSIZE];
            int s;
            while((s = fis.read(buf)) > -1) 
                fos.write(buf, 0, s);
        }
        catch(Exception ex)
        {
            throw new Exception("makehome".concat(String.valueOf(String.valueOf(ex.getMessage()))));
        }
        finally
        {
            fis.close();
            fos.close();
        }
        return true;
    }

    public static void makehome(String home)
        throws Exception
    {
        File homedir = new File(home);
        if(!homedir.exists())
            try
            {
                homedir.mkdirs();
            }
            catch(Exception ex)
            {
                throw new Exception(String.valueOf(String.valueOf((new StringBuffer("Can not mkdir :")).append(home).append(" Maybe include special charactor!"))));
            }
    }

    public static void CopyDir(String sourcedir, String destdir)
        throws Exception
    {
        File dest = new File(destdir);
        File source = new File(sourcedir);
        String files[] = source.list();
        try
        {
            makehome(destdir);
        }
        catch(Exception ex)
        {
            throw new Exception("CopyDir:".concat(String.valueOf(String.valueOf(ex.getMessage()))));
        }
        for(int i = 0; i < files.length; i++)
        {
            String sourcefile = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(source)))).append(File.separator).append(files[i])));
            String destfile = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(dest)))).append(File.separator).append(files[i])));
            File temp = new File(sourcefile);
            if(!temp.isFile())
                continue;
            try
            {
                copy(sourcefile, destfile);
            }
            catch(Exception ex)
            {
                throw new Exception("CopyDir:".concat(String.valueOf(String.valueOf(ex.getMessage()))));
            }
        }

    }

    public static void recursiveRemoveDir(File directory)
        throws Exception
    {
        if(!directory.exists())
            throw new IOException(String.valueOf(String.valueOf(directory.toString())).concat(" do not exist!"));
        String filelist[] = directory.list();
        File tmpFile = null;
        for(int i = 0; i < filelist.length; i++)
        {
            tmpFile = new File(directory.getAbsolutePath(), filelist[i]);
            if(tmpFile.isDirectory())
            {
                recursiveRemoveDir(tmpFile);
                continue;
            }
            if(!tmpFile.isFile())
                continue;
            try
            {
                tmpFile.delete();
            }
            catch(Exception ex)
            {
                throw new Exception(String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(tmpFile.toString())))).append(" can not be deleted ").append(ex.getMessage()))));
            }
        }

        try
        {
            directory.delete();
        }
        catch(Exception ex)
        {
            throw new Exception(String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(directory.toString())))).append(" can not be deleted ").append(ex.getMessage()))));
        }
        finally
        {
            filelist = null;
        }
    }
}
