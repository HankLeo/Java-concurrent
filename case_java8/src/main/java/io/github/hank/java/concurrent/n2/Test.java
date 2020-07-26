package io.github.hank.java.concurrent.n2;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        //map.add("test", "type=greeting");
        putNonBlankParam(map, "type", "select_intent");
        putNonBlankParam(map, "text", "0b8213c4-c784-4639-ad67-eb96d9249eb1");
        newVirtualAgentMessage(map);
    }

    public static void newVirtualAgentMessage(MultiValueMap<String, String> inputs) throws UnsupportedEncodingException, URISyntaxException {
        String userInput = null;
        if (inputs != null) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
            uriComponentsBuilder.queryParams(inputs);
            userInput = uriComponentsBuilder.build().encode().toUriString().substring(2);
        }
        System.out.println(userInput);
        String encodedString = URLEncoder.encode(userInput, StandardCharsets.UTF_8.toString());
        System.out.println(encodedString);

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.addParameter("userInput", encodedString);
        System.out.println(uriBuilder.build());

    }

    private static void putNonBlankParam(final MultiValueMap<String, String> store, String key, String value) {
        store.add(key, value);
    }

}
