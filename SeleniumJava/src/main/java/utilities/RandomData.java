package utilities;

import java.util.Random;

public class RandomData {
	Random random=new Random();
	public String random(int length,String charTypes) {
		String randomString=null;
		if((charTypes.toLowerCase()).contains("alphabets")) {
			randomString=randomString(length);
		}
		else if((charTypes.toLowerCase()).contains("alphanum")){
			randomString=randomAlphaNum(length);
		}
		else if((charTypes.toLowerCase()).contains("numeric")){
			randomString=randomInteger(length);
		}
		
		return randomString;
	}
	
	public String randomString(int length) {
		String character="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder result=new StringBuilder();
		for(int i=0;i<length;i++) {
			result.append(character.charAt(random.nextInt(character.length())));
		}
		
		return result.toString();
	}
	
	public String randomAlphaNum(int length) {
		String character="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";
		StringBuilder result=new StringBuilder();
		for(int i=0;i<length;i++) {
			result.append(character.charAt(random.nextInt(character.length())));
		}
		
		return result.toString();
	}
	
	public String randomInteger(int length) {
		StringBuilder result=new StringBuilder();
		for(int i=0;i<length;i++) {
			result.append(random.nextInt(length));
		}
		
		return result.toString();
	}
}
