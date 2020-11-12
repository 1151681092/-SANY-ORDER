package com.sanyi.web.controller.tool;

import com.sanyi.common.constant.Constants;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;
import java.net.*;
import java.util.Map;

/**
 * @Author songJie.he
 * @Date 2020/11/11 19:52
 * @Version 1.0
 */
public class RestfulApi {

    private static final Logger log = LoggerFactory.getLogger(RestfulApi.class);

    /**
     * 发送 get请求
     * @param url 请求地址
     * @param param 请求参数  参数格式：“name=aa&sex=1”
     * @return
     */
    public static String sendGet(String url,String param){

        return sendGet(url, param, Constants.UTF8);
    }

    /**
     * 向指定URL发送GET请求
     * @param url 请求地址
     * @param param 请求参数  参数格式：“name=aa&sex=1”
     * @param contentType 编码方式
     * @return
     */
    public static String sendGet(String url,String param,String contentType){
        StringBuilder builder = new StringBuilder();
        BufferedReader in = null;
        String urlPath = url + "?" + param;
        log.info("sendGet-{}", urlPath);
        try {
            // 创建url对象
            URL realUrl = new URL(urlPath);
            // 打开连接
            URLConnection connection = realUrl.openConnection();
            // 设置请求头
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立连接
            connection.connect();
            // 获取字节流
            InputStream is = connection.getInputStream();
            // 转化为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(is, contentType);
            in = new BufferedReader(inputStreamReader);
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }
            log.info("recv-{}", builder);
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.info("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                log.info("调用in.close() Exception, url=" + url + ",param=" + param, e);
            }
        }
        return builder.toString();
    }

    /**
     * 向指定URL发送POST请求
     * @param url    请求地址
     * @param param  json格式
     * @return
     */
    public String sendJsonPost(String url, String param) {
        StringBuilder builder = new StringBuilder();
        BufferedReader in = null;
        OutputStream os = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoOutput(true);
            os = connection.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            writer.print(param);
            writer.flush();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), Constants.UTF8));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
