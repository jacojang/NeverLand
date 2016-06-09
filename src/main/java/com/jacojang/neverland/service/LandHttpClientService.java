package com.jacojang.neverland.service;

import com.jacojang.neverland.domain.Home;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.apache.http.protocol.HTTP.USER_AGENT;

/**
 * Created by jacojang on 16. 6. 8.
 */
public class LandHttpClientService {
    private Log log = LogFactory.getLog(getClass());

    private StringBuffer getHttp(String uri) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        httpClient.close();
        return response;
    }

    private List<Home> getDomParse(String uri) {
        try {
            Document doc = Jsoup.connect(uri).get();
            Elements elems = doc.select("#depth4Content > fieldset > div > div> table > tbody > tr");

            int cnt=0;
            for(Element e: elems){
                if(cnt % 2 == 0) {
                    log.info(e.select("td > div > div").text());
                }
                cnt++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LandHttpClientService(){
    }

    public List<Home> get(String uri){

        this.getDomParse(uri);
        /*
        StringBuffer response = null;
        try {
            response = this.getHttp(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(response.toString());
        */


        return null;
    }
}
