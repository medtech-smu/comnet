package medtech.comnet.sockets;

import java.net.*;
import java.io.*;

public class EchoClient {



	public static void main(String[] args) {
		try {
			Socket skt = new Socket("localhost", 1234);
			BufferedReader in = new BufferedReader(new
					InputStreamReader(skt.getInputStream()));
			System.out.print("Received string: '");
			while (!in.ready()) {}
			System.out.println(in.readLine());
			System.out.print("'\n");
			in.close();
			skt.close();
		}
		catch(Exception e) {
			System.out.print("Whoops! It didn't work!\n");
		}
	}
}
