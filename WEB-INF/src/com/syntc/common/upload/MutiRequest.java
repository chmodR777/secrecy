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

// Source File Name:   Request.java

package com.syntc.common.upload;

import java.util.Enumeration;
import java.util.Hashtable;

public class MutiRequest
{

    private Hashtable m_parameters;
    private int m_counter;

    MutiRequest()
    {
        m_parameters = new Hashtable();
        m_counter = 0;
    }

    protected void putParameter(String name, String value)
    {
        if(name == null)
            throw new IllegalArgumentException("The name of an element cannot be null.");
        if(m_parameters.containsKey(name))
        {
            Hashtable hashtable = (Hashtable)m_parameters.get(name);
            hashtable.put(new Integer(hashtable.size()), value);
        } else
        {
            Hashtable hashtable1 = new Hashtable();
            hashtable1.put(new Integer(0), value);
            m_parameters.put(name, hashtable1);
            m_counter++;
        }
    }

    public String getParameter(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("Form's name is invalid or does not exist (1305).");
        Hashtable hashtable = (Hashtable)m_parameters.get(s);
        if(hashtable == null)
            return null;
        else
            return (String)hashtable.get(new Integer(0));
    }

    public Enumeration getParameterNames()
    {
        return m_parameters.keys();
    }

    public String[] getParameterValues(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("Form's name is invalid or does not exist (1305).");
        Hashtable hashtable = (Hashtable)m_parameters.get(s);
        if(hashtable == null)
            return null;
        String as[] = new String[hashtable.size()];
        for(int i = 0; i < hashtable.size(); i++)
            as[i] = (String)hashtable.get(new Integer(i));

        return as;
    }
}
