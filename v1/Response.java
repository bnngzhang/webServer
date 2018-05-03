package v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Response {
	private OutputStream output;
	public Response(OutputStream output) {
		this.output = output;
	}
	
	public void sendContext(String url) {
		String filepath = ".\\src\\files\\index.html";
		
		File file = new File(filepath);
		BufferedWriter bw = new BufferedWriter(new PrintWriter(output));
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = "";
			bw.write("http1.1 200 OK\n");
			bw.write("Content-Type:text/html \n");
			bw.write("\n\r");
			while ((s=br.readLine()) != null) {
				bw.write(s);
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
