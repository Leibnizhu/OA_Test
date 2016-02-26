package leibniz.hu.oatest.utils;

public class OaUtils {
	public static Long[] string2Longs(String str){
		String[] s = str.split(",");
		Long[] longs = new Long[s.length];
		int index = 0;
		for(String string:s){
			longs[index] = Long.valueOf(string);
			index++;
		}
		return longs;
	}
}
