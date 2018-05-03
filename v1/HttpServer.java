package v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HttpServer {

	public static void main(String[] args) {
		
		
		try {
			ServerSocket server = new ServerSocket(8081);
			while (true) {
				Socket socket = server.accept();
				
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				Request request = new Request(input);
				Response response = new Response(output);
		
				String url = request.getURL();
				System.out.println("request url : " + url);
				response.sendContext(url);
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
