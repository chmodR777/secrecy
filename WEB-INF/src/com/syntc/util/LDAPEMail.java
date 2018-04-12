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

/*
 * CLASS      ： LDAPEMail
 * VERSION    ： 0.00
 * DESC       :  LDAP 登录验证
 * DATE       ： 2006/07/07
 * AUTHOR     ： jinghuizhen@hotmail.com
 * HISTORY    ： 2006/07/07 0.00 作成
 */
package com.syntc.util;

import java.io.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

public class LDAPEMail {

    private static String ou       = "ou=people";
    private static String ldapHost = "202.107.117.26";
    private static int    ldapPort = 389;
    private static String baseDN   = "o=neusoft.com,o=neusoft.com";
    private DirContext ctx	   = null;
    private String INITCTX         = "com.sun.jndi.ldap.LdapCtxFactory";
    private int    SCOPE           = SearchControls.SUBTREE_SCOPE;

    public LDAPEMail() {
    }

    public boolean check(String username,String password) throws Exception
    {
        String userName = "uid=" + username + ",ou=people,o=neusoft.com,o=neusoft.com";
        Object o = (Object) userName;
        StringBuffer jndiHost = new StringBuffer ();
        jndiHost.append( "ldap://" );
        jndiHost.append(ldapHost);
        jndiHost.append( ":" );
        jndiHost.append( ldapPort );

        Hashtable env = new Hashtable();
        env.put( Context.INITIAL_CONTEXT_FACTORY, INITCTX             );
        env.put( Context.PROVIDER_URL,            jndiHost.toString() );
        env.put( Context.SECURITY_AUTHENTICATION, "simple"            );
        env.put( Context.SECURITY_PRINCIPAL,      "uid=" + username + ",ou=people,o=neusoft.com,o=neusoft.com" );
        env.put( Context.SECURITY_CREDENTIALS,    password            );
        boolean isPass = false;
        try{
            ctx = new InitialDirContext(env);

            Attributes attrs = ctx.getAttributes(userName);
            if (attrs != null) {
                isPass = true;
            }

        }
        catch (NamingException e) {
            System.err.println("Problem getting attribute:" + e);
        }
        return isPass;
    }
}
