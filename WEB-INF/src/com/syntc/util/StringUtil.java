///////////////////////////////////////////////////////////// 
//
// COPYRIGHT (C) 2010 zq CORPORATION
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
 * CLASS      ： StringUtil
 * DESC       :  字符处理共通类
 * VERSION    ： 0.00
 * DATE       ： 2010-08-25
 * AUTHOR     ： deargod1981@sohu.com
 * HISTORY    ： 2010-08-25
 */
package com.syntc.util;

import java.io.*;
import java.util.*;
import java.text.*;

public class StringUtil{

        /**
         * iso-8859-1字符集名称
         */
         public static final String ISO_8859_1="iso-8859-1";
        /**
         * GBK字符集名称
         */
         public static final String GBK="GBK";
         /**
         * GB2312字符集名称
         */
         public static final String GB2312="gb2312";

  private static Hashtable escapeChar;
  private static final char[] hexDigit = {
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      'A',
      'B',
      'C',
      'D',
      'E',
      'F'
  };
  private static final String specialSaveChars = "=: \t\r\n\f#!";

  static {
    escapeChar = new Hashtable(9);
    escapeChar.put("&", "&#38;");
    escapeChar.put("'", "&#39;");
    escapeChar.put("\"", "&#34;");
    escapeChar.put("<", "&#60;");
    escapeChar.put(">", "&#62;");

    escapeChar.put("&#38;", "&");
    escapeChar.put("&#39;", "'");
    escapeChar.put("&#34;", "\"");
    escapeChar.put("&#60;", "<");
    escapeChar.put("&#62;", ">");
  }

        /**
         * 字符集转换
         * @param s 要转换的字符串
         * @param charSetName 字符集
         * @param defaultCharSet 默认字符集
         * @return String 转换字符串
         */
        public static String CharSetConvert(String s,String charSetName,String defaultCharSetName){
                String newString=null;
                try{
                        newString = new String(s.getBytes(charSetName),defaultCharSetName);
                }catch(UnsupportedEncodingException  e){

                }catch(NullPointerException nulle){

                }
                return newString;
        }

        /**
         * 把Exception堆栈信息转化为String.
         * <li><i>StackTraceElement[] ste = e.getStackTrace(); 应用于jdk1.4
         * @param Exception 异常堆栈
         * @return String 异常信息
         */
        public static String ObjectToString(Exception e){
                StringBuffer sb = new StringBuffer();
                /*
                StackTraceElement[] ste = e.getStackTrace();
                sb.append(e).append("\n");
                for(int i = 0; i < ste.length; i++){
                        sb.append(ste[i].toString()).append("\n");
                }
                */
                sb.append(e.getMessage()).append("\n");

                return sb.toString();
        }

        /**
         * 按分隔符分割字符串
         */
        public static String[] split(String str, String delim){
    if (str==null)
    {
      return null;
    }
                StringTokenizer st = new StringTokenizer(str, delim);
    int size = st.countTokens();
    String[] result = new String[size];
    for(int i=0; i<size; i++)
    {
      result[i] = st.nextToken();
    }
                return result;
        }


  /**
   * 将ISO8859-1编码的字符串转为GBK编码
   *
   * @param str <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String ISO2GB2312(String str) {
    return convertEncode(str, "ISO-8859-1", "GBK");
  }

  /**
   * 将ISO8859-1编码的字符串转为GBK编码
   *
   * @param str <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String GB23122ISO(String str) {
    return convertEncode(str, "GBK", "ISO-8859-1");
  }

  /**
   * @param str <!-- 请描述方法的参数信息 -->
   * @param srcEnc <!-- 请描述方法的参数信息 -->
   * @param dstEnc <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   * @deprecated 方法名“convertCode”不规范，请使用 {@link #convertEncode(String, String, String)},
   *             同时可参考使用{@link #convertEncode(String, String)}和 {@link #ISO2GB2312(String)}
   */
  public static String convertCode(String str, String srcEnc, String dstEnc) {
    return convertEncode(str, srcEnc, dstEnc);
  }

  /**
   * 将字符串转为指定的编码
   *
   * @param str <!-- 请描述方法的参数信息 -->
   * @param dstEnc <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String convertEncode(String str, String dstEnc) {
    try {
      return new String(str.getBytes(), dstEnc);
    }
    catch (Exception e) {
      return str;
    }
  }

  /**
   * 将字符串从特定的编码转换到指定的编码
   *
   * @param str <!-- 请描述方法的参数信息 -->
   * @param srcEnc <!-- 请描述方法的参数信息 -->
   * @param dstEnc <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String convertEncode(String str, String srcEnc, String dstEnc) {
    try {
      return new String(str.getBytes(srcEnc), dstEnc);
    }
    catch (Exception e) {
      return str;
    }
  }

  /**
   * 将字符串中的"&#38;"，"&#39;"，"&#34;"，"&#60;"，"&#62;"转为"&#38;#38;"，"&#38;#39;"，"&#38;#34;"，"&#38;#60;"，"&#38;#62;"
   *
   * @param to_process <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String escape(String to_process) {
    if ( (to_process == null) || (to_process.length() == 0)) {
      return "";
    }

    StringBuffer bs = new StringBuffer();
    StringCharacterIterator sci = new StringCharacterIterator(to_process);
    String tmp = null;

    for (char c = sci.first(); c != CharacterIterator.DONE; c = sci.next()) {
      tmp = String.valueOf(c);

      if (escapeChar.containsKey(tmp)) {
        tmp = (String) escapeChar.get(tmp);
      }

      bs.append(tmp);
    }

    return (bs.toString());
  }

  /**
   * 将字符串转换为&#92;uXXXX的UNICODE表示方法
   *
   * @param theString <!-- 请描述方法的参数信息 -->
   * @param escapeSpace <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String nativeToAscii(String theString, boolean escapeSpace) {
    int len = theString.length();
    StringBuffer outBuffer = new StringBuffer(len * 2);

    for (int x = 0; x < len; x++) {
      char aChar = theString.charAt(x);

      switch (aChar) {
        case ' ':

          if ( (x == 0) || escapeSpace) {
            outBuffer.append('\\');
          }

          outBuffer.append(' ');

          break;

        case '\\':
          outBuffer.append('\\');
          outBuffer.append('\\');

          break;

        case '\t':
          outBuffer.append('\\');
          outBuffer.append('t');

          break;

        case '\n':
          outBuffer.append('\\');
          outBuffer.append('n');

          break;

        case '\r':
          outBuffer.append('\\');
          outBuffer.append('r');

          break;

        case '\f':
          outBuffer.append('\\');
          outBuffer.append('f');

          break;

        default:

          if ( (aChar < 0x0020) || (aChar > 0x007e)) {
            outBuffer.append('\\');
            outBuffer.append('u');
            outBuffer.append(toHex( (aChar >> 12) & 0xF));
            outBuffer.append(toHex( (aChar >> 8) & 0xF));
            outBuffer.append(toHex( (aChar >> 4) & 0xF));
            outBuffer.append(toHex(aChar & 0xF));
          }
          else {
            if (specialSaveChars.indexOf(aChar) != -1) {
              outBuffer.append('\\');
            }

            outBuffer.append(aChar);
          }
      }
    }

    return outBuffer.toString();
  }

  /**
   * 将字符串中的"&#38;#38;"，"&#38;#39;"，"&#38;#34;"，"&#38;#60;"，"&#38;#62;"转为"&#38;"，"&#39;"，"&#34;"，"&#60;"，"&#62;"
   *
   * @param to_process <!-- 请描述方法的参数信息 -->
   * @return <!-- 请描述方法的返回信息 -->
   */
  public static String unescape(String to_process) {

/*
    to_process = replace(to_process,"&#38;", "&");
    to_process = replace(to_process,"&#39;", "'");
    to_process = replace(to_process,"&#34;", "\"");
    to_process = replace(to_process,"&#60;", "<");
    to_process = replace(to_process,"&#62;", ">");
    return to_process;
*/
    if ( (to_process == null) || (to_process.length() == 0)) {
      return "";
    }

    StringBuffer bs = new StringBuffer();
    StringBuffer tmp = new StringBuffer();
    StringCharacterIterator sci = new StringCharacterIterator(to_process);
    boolean flag = false;

    for (char c = sci.first(); c != CharacterIterator.DONE; c = sci.next()) {
      if (c == '&') {
        flag = true;

        if (tmp.length() > 0) {
          bs.append(tmp);
          tmp.delete(0, tmp.length());
        }
      }

      if (flag) {
        tmp.append(c);

        if (c == ';') {
          if (escapeChar.containsKey(tmp.toString())) {
            bs.append(escapeChar.get(tmp.toString()));
          }
          else {
            bs.append(tmp);
          }

          tmp.delete(0, tmp.length());
          flag = false;
        }
      }
      else {
        bs.append(c);
      }

    }

    if (tmp.length() > 0) {
      bs.append(tmp);
    }

    return (bs.toString());

  }

    public static char toHex(int nibble) {
      return hexDigit[ (nibble & 0xF)];
    }

	public static String convertNull(String str) {
		return (str == null ? "" : str.trim());
	}

    public static String convertNull(String str, String value) {
        String strRet = "";
        if (str == null || str.equals("")){
                strRet = value;
        }
        else{
                strRet = str.trim();
        }
            return (strRet);
    }

        public static String getRequestData(String str){
            String str_Rtn = "";
            str_Rtn = convertNull(str);
            try {
                str_Rtn = new String(str_Rtn.getBytes("8859_1"), "UTF-8");
            }
            catch (Exception e) {
                System.out.println("getRequestData Error " + e.toString());
            }

            return str_Rtn;
        }

        public static String getRequestData(String str, String value){
            String str_Rtn = "";
                str_Rtn = convertNull(str, value);
                try {
                        str_Rtn = new String(str_Rtn.getBytes("8859_1"), "UTF-8");
            }
            catch (Exception e) {
                System.out.println("getRequestData Error " + e.toString());
            }
            return str_Rtn;
        }

	/**
	 * 字符串替换
	 * 
	 * @param strSource 没有改变的源字符串
	 * @param strFrom 要替换的字符串
	 * @param strTo 替换为的字符串
	 * @return 替换后的字符串
	 */
	public static String replace(String strSource, String strFrom, String strTo) {
		StringBuffer strDest = new StringBuffer();
		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest.append(strSource.substring(0, intPos));
			strDest.append(strTo);
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest.append(strSource);
		String returnvalue = strDest.toString();
		strDest.delete(0, strDest.length());
		return returnvalue;
	}

    public static int getLength(String str) {
      char ch;
      int strLen;
      int byteLen;

      if(str==null){
        return 0;
      }

      strLen = str.length();
      byteLen = 0;

      for (int i = 0; i <strLen; i++) {
        if((java.net.URLEncoder.encode(""+str.charAt(i))).length()>=4) {
          // 汉字
          byteLen+=2;
        }
        else {
          // 字符
          byteLen+=1;
        }
      }

      return byteLen;
    }

    /**
     *  超长字符串省略号补齐
     *
     *@param  strText 源字符串
     *@param  iLen    限制的长度
     *@return         结果字符串
     */
    public static String limitText(String stText, int iLen){
        char ch;
        int iNextCharSize = 0;
        int iTextLen = 0;
        int iChPos = 0;
        String stReturn = "";
        if ( iLen > stText.length() ) {
            iLen = stText.length();
        }

        try{
            for (int i = 0; i < stText.length(); i++) {
                iChPos++;
                ch = stText.charAt(i);
                if(i==stText.length()-1){
                    iNextCharSize = 0;
                }
                else{
//                    if((java.net.URLEncoder.encode(""+stText.charAt(i+1), "GBK")).length()>=4) {
                    if((java.net.URLEncoder.encode(""+stText.charAt(i+1))).length()>=4) {
                        iNextCharSize = 2;
                    }
                    else {
                        iNextCharSize = 1;
                    }
                }

                //if ((ch > '\u4e00' && ch < '\u9fa5') || (ch > '\uf900' && ch < '\ufa2d')) { //CJK
//                if((java.net.URLEncoder.encode(""+ch, "GBK")).length()>=4) {
                if((java.net.URLEncoder.encode(""+ch)).length()>=4) {
                    iTextLen+=2;
                }
                else {
                    iTextLen+=1;
                }
                if ( (iTextLen + iNextCharSize) > iLen*2 ) {
                    break;
                }
            }
        }
        catch(Exception ex)
        {
        }


        if ( (iTextLen + iNextCharSize) > iLen*2 ) {
            stReturn = stText.substring(0, iChPos) + (iTextLen%2==1?" ":"") + "…";
        }
        else {
            stReturn = stText;
        }

        return stReturn;

        }
    public static int random(int n){
        int a;
        a=(int)(Math.random()*n);

        return Math.abs(a)% n;
    }

}
