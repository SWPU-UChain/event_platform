package com.dataht.event.service.impl;

import com.dataht.event.service.EventAnalyseService;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.net.URLEncoder;


@Service
public class EventAnalyseServiceImpl implements EventAnalyseService {

    private CloseableHttpClient httpClient;
    private RequestConfig requestConfig;

    @Value("${url.tag}")
    private String tag_url;
    @Value("${url.emotion}")
    private String emotion_url;
    @Value("${url.abstract}")
    private String abstract_url;
    @Value("${url.keyword}")
    private String keyword_url;

    private String path;

    @Autowired
    public EventAnalyseServiceImpl(CloseableHttpClient httpClient, RequestConfig requestConfig) {
        this.httpClient = httpClient;
        this.requestConfig = requestConfig;
    }

    public String getEventTag(String sentence) throws Exception {
        path = tag_url + URLEncoder.encode(sentence, "utf-8");
        return this.HttpApiService(path);

    }

    public String getEventEmotion(String sentence) throws Exception {
        path = emotion_url + URLEncoder.encode(sentence, "utf-8");
        return this.HttpApiService(path);
    }

    public String getEventAbstract(String sentence) throws Exception {
        path = abstract_url + URLEncoder.encode(sentence, "utf-8");
        return this.HttpApiService(path);
    }

    public String getEventKeyword(String sentence) throws Exception {
        path = keyword_url + URLEncoder.encode(sentence, "utf-8");
        return this.HttpApiService(path);
    }

    private String HttpApiService(String path) throws URISyntaxException, Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(path);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            String respStr = null;
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                respStr = EntityUtils.toString(entity, "utf-8");
                return respStr;
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            response.close();
        }
        return null;
    }



}
