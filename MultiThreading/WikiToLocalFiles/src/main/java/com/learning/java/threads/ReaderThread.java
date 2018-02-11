package com.learning.java.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Reads Wiki and starts Writer thread
 * 
 * @author shvetap
 *
 */
public class ReaderThread implements Callable<String> {

	private String searchWord;
	JSONParser parser = new JSONParser();

	public ReaderThread(String searchWord) {
		super();
		this.searchWord = searchWord;
	}

	@Override
	public String call() throws Exception {
		String data = "";
		Logger logger = Logger.getLogger(ReaderThread.class.getName());
		String url = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
				+ searchWord.replaceAll(" ", "%20");
		try (InputStream in = new URL(url).openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));) {
			Object obj = parser.parse(br.readLine());
			JSONObject jsonObject = (JSONObject) obj;
			data = findExtract(jsonObject);

		} catch (IOException | ParseException e) {
			 logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return data;
	}

	/**
	 * Find value corresponding key "extract" in JSON
	 * 
	 * @param jsonObject
	 *            json object to be read
	 * @return value corresponding key "extract" in JSON
	 * @param jsonObject
	 */
	private String findExtract(JSONObject jsonObject) {
		Set<?> keys = jsonObject.keySet();
		String result = "";
		for (Object object : keys) {
			if ("extract".equals(object.toString())) {
				return jsonObject.get(object).toString();
			}
			if (jsonObject.get(object) instanceof JSONObject) {
				result = findExtract((JSONObject) jsonObject.get(object));
			}
		}
		return result;

	}

}
