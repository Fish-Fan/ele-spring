package com.ele.util;

import com.ele.pojo.ResponseMsg;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanfeng-mac on 2017/7/4.
 */
public class WeChatUtil {
    public static String getSha1(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8',
                '9','a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j*2];
            int k = 0;
            for(int i = 0;i < j; i++){
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String,String> xmlToMap(HttpServletRequest request){
        Map<String,String> map = new HashMap<String,String>();
        SAXReader reader = new SAXReader();
        try {
            ServletInputStream is = request.getInputStream();
            Document document = reader.read(is);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for(Element e : elements){
                map.put(e.getName(), e.getText());
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
    //将Map转成xml
    public static String textToXML(ResponseMsg tm){
        XStream xStream = new XStream();
        //将xml文件的根节点表示为xml,默认是com.chinasofti.vo.TextMessage
        xStream.alias("xml", tm.getClass());
        return xStream.toXML(tm);
    }
}
