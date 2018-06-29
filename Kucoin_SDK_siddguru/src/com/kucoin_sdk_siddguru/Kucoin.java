package com.kucoin_sdk_siddguru;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 
 * @author Taimoor Siddiqui (siddguru)
 * @email siddguru75@gmail.com
 *
 */

public class Kucoin {
	
	private static final String API_SERVER = "https://api.kucoin.com";
	private String KC_API_KEY;
	private String KC_API_SIGNATURE;
	
	private Kucoin(KCBuilder builder){
		this.setApiKey(builder.KC_API_KEY);
		this.setApiSignature(builder.KC_API_SIGNATURE);
	}
		
	public String getApiKey() {
		return this.KC_API_KEY;
	}
	
	public void setApiKey(String KC_API_KEY) {
		this.KC_API_KEY = KC_API_KEY;
	}

	public String getApiSignature() {
		return this.KC_API_SIGNATURE;
	}
	
	public void setApiSignature(String KC_API_SIGNATURE) {
		this.KC_API_SIGNATURE = KC_API_SIGNATURE;
	}

	public String rateOfCoins(String... coins){
		String endpoint = "/v1/open/currencies";
		String queryStr = "?coins=";
		if (coins.length == 0)
			queryStr = "";
		else{
			for(String coin: coins){
				queryStr = queryStr + coin + ",";
			}
			queryStr = queryStr.substring(0, queryStr.length()-1);
		}
		
		try {
			Document doc = Jsoup.connect(API_SERVER + endpoint + queryStr)
					.ignoreContentType(true)
					.get();
			return doc.body().toString().split("\\n")[1];
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static final class KCBuilder {
		private String KC_API_KEY;
		private String KC_API_SIGNATURE;
		
		public KCBuilder(){
		}
		
		public KCBuilder apiKey(String apiKey) {
            this.KC_API_KEY = apiKey;
            return this;
        }
		
		public KCBuilder apiSignature(String apiSignature) {
            this.KC_API_SIGNATURE = apiSignature;
            return this;
        }
		
		public Kucoin build() {
			return new Kucoin(this);
		}
		
	}
	
}
