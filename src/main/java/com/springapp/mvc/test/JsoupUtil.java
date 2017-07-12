package com.springapp.mvc.test;

import com.alibaba.fastjson.util.IOUtils;
import com.sun.deploy.net.HttpUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther f4o823hv9
 * @since  2017/6/28.
 */
@Service("jsoupUtil")
public class JsoupUtil {
    private static RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setSocketTimeout(5000)
            .setConnectTimeout(5000)
            .setConnectionRequestTimeout(5000)
            .build();
    private static RequestConfig defaultRequestProxyConfig = RequestConfig.custom()
//            .setProxy()
            .setSocketTimeout(5000)
            .setConnectTimeout(5000)
            .setConnectionRequestTimeout(5000)
            .build();


    /**
     *
     * 请求页面
     *
     * @param url 请求地址
     * @return
     */
    public Document get(String url) {
        Document parse = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            parse = Jsoup.parse(realUrl, 10000);
            Jsoup.connect(url).ignoreContentType(true).get();
        } catch (Exception e) {

        }

        return parse;

    }

    /**
     * 用于模拟ajax get请求，获取后台数据
     *
     * @param uri 请求地址
     * @param isProxyisProxy 是否需要代理
     *
     * @return
     */
    public String get (String uri, boolean isProxyisProxy) {
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(client);
        }
        return result;

    }

    public String post(String url) {

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("User-Agent", "Mozilla/5.0");
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("userName", "PankajKumar"));
        CloseableHttpResponse httpResponse = null;
        String result= null;
        try {
            HttpEntity entity = new UrlEncodedFormEntity(urlParameters);
            httpPost.setEntity(entity);
            httpResponse = client.execute(httpPost);
            HttpEntity entity1 = httpResponse.getEntity();
            result = EntityUtils.toString(entity1);
        } catch (Exception e) {
            System.out.println("post exception !" + e.toString());
        } finally {
            HttpClientUtils.closeQuietly(client);
            HttpClientUtils.closeQuietly(httpResponse);
        }
        return result;

    }

}
