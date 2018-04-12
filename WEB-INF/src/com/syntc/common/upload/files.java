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

// Source File Name:   files.java

package com.syntc.common.upload;

import java.util.Hashtable;

// Referenced classes of package xiaoxiang.fileUpload:
//            file

public class files
{

    private Hashtable hFiles;
    private long totalSize;
    private int count;

    protected files()
    {
        hFiles = new Hashtable();
        count = 0;
        totalSize = 0L;
    }

    protected void addFile(file pFile)
    {
        hFiles.put(new Integer(count), pFile);
        count++;
        totalSize += pFile.getSize();
    }

    public file getFile(int pCount)
        throws Exception
    {
        if(pCount >= count || pCount <= -1)
        {
            throw new Exception("²ÎÊý´íÎó");
        } else
        {
            file tempFile = (file)hFiles.get(new Integer(pCount));
            return tempFile;
        }
    }

    public int getCount()
    {
        return count;
    }

    public long getSize()
    {
        return totalSize;
    }
}
