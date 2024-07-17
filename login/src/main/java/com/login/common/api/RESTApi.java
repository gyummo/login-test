package com.login.common.api;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;

	public class RESTApi {

	    public static void main(String[] args) throws IOException {
	        // REST API 엔드포인트 URL
	        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

	        // URL 객체 생성
	        URL url = new URL(apiUrl);

	        // HttpURLConnection 객체 생성 및 설정
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Accept", "application/json");

	        // HTTP 응답 코드 확인
	        int responseCode = connection.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            // 응답 데이터 읽기
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();

	            // JSON 데이터 출력
	            System.out.println(response.toString());
	        } else {
	            System.out.println("GET request failed: HTTP error code " + responseCode);
	        }
	    }
	}
