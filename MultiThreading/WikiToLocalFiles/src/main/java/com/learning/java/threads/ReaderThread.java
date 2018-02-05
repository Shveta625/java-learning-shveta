package com.learning.java.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReaderThread implements Runnable {

	private String searchWord;
	JSONParser parser = new JSONParser();

	public ReaderThread(String searchWord) {
		super();
		this.searchWord = searchWord;
	}

	@Override
	public void run() {

		try {
					URL url = new URL(
							"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
									+ searchWord.replaceAll(" ", "%20"));
					URLConnection urlConnection = url.openConnection();
					InputStreamReader in=new InputStreamReader(urlConnection.getInputStream());
					BufferedReader br = new BufferedReader(in);
					Object obj = parser.parse(br.readLine());
					JSONObject jsonObject = (JSONObject) obj;
					String data = findExtract(jsonObject);
						Thread thread = new Thread(new WriterThread(searchWord, data));
					thread.start();
					in.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	private String findExtract(JSONObject jsonObject) {
		Set<?> keys = jsonObject.keySet();
		String result="";
		for (Object object : keys) {
			if (object.toString().equals("extract")) {
				return jsonObject.get(object).toString();
			}
			if(jsonObject.get(object) instanceof JSONObject) {
				result=findExtract((JSONObject) jsonObject.get(object));
			}
		}
		return result;

	}

}
