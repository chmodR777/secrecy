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

// Source File Name:   file.java

package com.syntc.common.upload;

import java.io.File;
import java.io.FileOutputStream;

// Referenced classes of package xiaoxiang.fileUpload:
//            UploadUtil

public class file
{

    private UploadUtil parentUploadUtil;
    private String fileExtName;
    private String subTypeMIME;
    protected String fileName;
    protected int size;
    protected int startData;
    protected int number;

    protected file(String pFileName, int pStartData, int pSize, int pNumber, String pSubTypeMIME, UploadUtil pParentUploadUtil)
    {
        fileName = pFileName;
        parentUploadUtil = pParentUploadUtil;
        startData = pStartData;
        size = pSize;
        number = pNumber;
        int extFrom = fileName.lastIndexOf(46) + 1;
        fileExtName = (fileName.substring(extFrom)).toLowerCase();
        subTypeMIME = pSubTypeMIME;
    }

    public String getName()
    {
        return fileName;
    }

    public long getSize()
    {
        return (long)size;
    }

    public int getNumber()
    {
        return number;
    }

    public void setName(String name)
    {
        fileName = name;
    }

    public String getExtName()
    {
        return fileExtName;
    }

    public String getSubTypeMIME()
    {
        return subTypeMIME;
    }

    public void saveAs()
        throws Exception
    {
        try
        {
            if(parentUploadUtil.realPath.equals("")){
       //         throw new Exception("在你使用file.saveAs()方法前，请先在UploadUtil中使用setRealPath()。");
            }
            File fileWrite = new File(parentUploadUtil.realPath + File.separator + fileName);
            if(!parentUploadUtil.isCover && fileWrite.exists())
                throw new Exception("本系统不允许同名覆盖，且您要上传的这个文件在服务器上已经存在：" + fileName);
            FileOutputStream fo = new FileOutputStream(fileWrite);
            fo.write(parentUploadUtil.m_binArray, startData, size);
            fo.close();
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public void saveAs(String pRealPath)
        throws Exception
    {
        try
        {
            File fileWrite = new File(pRealPath + File.separator + fileName);
            if(!parentUploadUtil.isCover && fileWrite.exists())
                throw new Exception("本系统不允许覆盖文件，且您要上传的这个文件在服务器上已经存在：" + fileName);
            FileOutputStream fo = new FileOutputStream(fileWrite);
            fo.write(parentUploadUtil.m_binArray, startData, size);
            fo.close();
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
