package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
	private InputStream input;
	private String method;
	private String url;
	private String protrol;
	
	public Request(InputStream inputStream) {
		this.input = inputStream;
	}
	
	
	
	public String getURL() {
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		try {
			String firstline  = br.readLine();
			//br.close();
			if (firstline!=null) {
				return firstline.split(" ")[1];
			} else {
				return "NOT http";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
