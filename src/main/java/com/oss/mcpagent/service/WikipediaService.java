package com.oss.mcpagent.service;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ContentType;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WikipediaService {

    public String searchSummary(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + encodedQuery;

            String response = Request.get(url)
                    .addHeader("Accept", "application/json")
                    .execute()
                    .returnContent()
                    .asString();

            JSONObject json = new JSONObject(response);
            return json.optString("extract", "No summary available.");

        } catch (Exception e) {
            return "Error fetching Wikipedia info: " + e.getMessage();
        }
    }
}

