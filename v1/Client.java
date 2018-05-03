package v1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		for (int i=1;i<6;i++) {
			try {
				Socket socket = new Socket("localhost", 8081);
				//socket.connect(endpoint);
				OutputStream out = socket.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
				bw.write("get /url" + i + " http1.1");
				bw.flush();
				socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
