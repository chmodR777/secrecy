///////////////////////////////////////////////////////////// 
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
 * CLASS      ： IPUtils
 * DESC       :  IP地址访问限制类
 * VERSION    ： 0.00
 * DATE       ： 2006/10/13
 * AUTHOR     ： lizhonghua@syntc.com.cn
 * HISTORY    ： 2006/10/13 0.00 作成
 */
package com.syntc.util;

public class IPUtils {

    public static int[] IPsplit(String ip) {
        return IPsplit(ip,false);
    }
    /**
     * reutrn a int array with 4 size
     * 
     * @param ip
     * @return
     */
    public static int[] IPsplit(String ip,boolean max) {
        int[] inum = new int[4];
        try {
            String[] nums = ip.split("[.]");
            int len =nums.length;
            for (int i = 0; i < len; i++) {
                inum[i] = Integer.parseInt(nums[i]);
            }
            if(max) {//if max ,fill 256 to int[]
                if(len<inum.length) {
                    for (int j = len; j < inum.length; j++) {
                        inum[j]=256;
                    }
                }
            }
        } catch (Exception e) {
        }
        return inum;
    }

    public static boolean isBetween(String myIP, String ip) {
        return isBetween(myIP, ip, ip);
    }

    public static boolean arraySubTo(int[] a, int[] b) {
        return arraySubOne(a, b);
    }
    
    /**
     * return myIP is between ip1~ip2
     * 
     * @param myIP
     * @param ip1
     * @param ip2
     * @return
     */
    public static boolean isBetween(String myIP, String ip1, String ip2) {
        if (myIP == null) {
            return true;
        }
        if (null == ip1) {
            ip1 = "0.0.0.0";
        }
        if (null == ip2) {
            ip2 = "256.0.0.0";
        }
        int[] myIPs = IPsplit(myIP);

        return arraySub(myIPs, IPsplit(ip2,true)) && arraySub(IPsplit(ip1), myIPs);
    }

    private static boolean arraySub(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (b[i] - a[i] > 0) {
                return true;
            } else if (b[i] - a[i] < 0) {
                return false;
            } else {
                if(i+1==a.length) {//check is end
                    return true;
                }else {
                    continue;
                }
            }
        }
        return false;
    }
    
    private static boolean arraySubOne(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] - a[i] == 0) {
                if(i+1==a.length) {//check is end
                    return true;
                }else {
                    continue;
                }
            } else {
                return false;
            } 
        }
        return false;
    }

} 

