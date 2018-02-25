package quiz;

import java.util.*;

public class Quiz {
	String mQuestion;
	HashMap<String, Boolean> mOption;
	
	public Quiz() {
		mOption = new HashMap<>();
	}
	
	public void setQuestion(String q) {
		mQuestion = q;
	}
	
	public String getQuestion() {
		return mQuestion;
	}
	
	public void setOption(String opt, Boolean isAns) {
		mOption.put(opt, isAns);
	}
	
	public Boolean isAns(String item) {
		return mOption.get(item);
	}
	
	public String[] getRandomOption() {
		String[] s = new String[mOption.size()];
		mOption.keySet().toArray(s);
		for (int i = 0; i < s.length; i++) {
			int r = (int) Math.floor((Math.random() * s.length));
			String t = s[i];
			s[i] = s[r];
			s[r] = t;
		}
		return s;
	}
	
	public String toString() {
		String s = mQuestion;
		
		for (String key: mOption.keySet())
			s += " " + mOption.get(key);		
		return s;
	}
}
