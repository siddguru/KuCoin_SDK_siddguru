# KuCoin_SDK_siddguru
This Kucoin SDK jar file is created just for the proof of concept, it provides basic methods, i.e, exchange rate of coins, etc

### Installation
-- Add this SDK jar file into your project build path.<br />
-- Add Jsoup-librar maven dependeny in your pom.xml OR add Jsoup jar file (https://jsoup.org/packages/jsoup-1.11.3.jar) ino your project build path.

### Usage
```java
// Maven : Add this dependency to your pom.xml (java6+) Or Add directly jsoup library jar file into your project
// <dependency>
//  		<groupId>org.jsoup</groupId>
//  		<artifactId>jsoup</artifactId>
//  		<version>1.11.3</version>
// </dependency>

import com.kucoin_sdk_siddguru.Kucoin;

public static void main(String[] args){
		
    Kucoin.KCBuilder kc_builder = new Kucoin.KCBuilder();
		
    Kucoin kc = kc_builder
	     .apiKey("59c5ecfe18497f5394ded813")
	     .apiSignature("fd83147802c361575bbe72fef32ba90dcb364d388d05cb909c1a6e832f6ca3ac")
	     .build();
		
    //gives default coin(BTC) rates in JSON formatted string
    String default_rate_response = kc.rateOfCoins();
    
    //gives ETH coin rates in JSON formatted string
    String eth_rate_response = kc.rateOfCoins("ETH"); 
		
    //gives ETH, BTC and ONT coins rates in JSON formatted string
    String response = kc.rateOfCoins("ETH", "BTC", "ONT");
    
    System.out.println(response);
		
}
```
