package medtech.comnet.sockets;

import java.io.*;
import java.net.*;

public class ChatClient {
	private Socket socket;
	private BufferedReader fromServer;
	private BufferedReader fromUser;
	private PrintWriter toServer;
	private InetAddress serverIP;
	private final int port = 4000;

	public ChatClient() {
	}

	public void init() {
		socket = null;
		fromServer = null;
		fromUser = null;
		toServer = null;
		serverIP = null;
	}

	public void setup() {
		try {
			if (serverIP == null)
				socket = new Socket(InetAddress.getLocalHost(), port);

			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			fromUser = new BufferedReader(new InputStreamReader(System.in));
			toServer = new PrintWriter(socket.getOutputStream(), true);

		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exec() {
		String Usrmsg = "";
		String Srvmsg = "";
		System.out.println("Type \"bye\" to quit");
		while (true) {
			System.out.print("Enter msg to server : ");
			try {
				Usrmsg = fromUser.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (Usrmsg == null || Usrmsg.equals("bye")) {
				toServer.println("bye");
				break;
			} else
				toServer.println(Usrmsg);
			try {
				Srvmsg = fromServer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(Srvmsg);
		}
	}

	public void close() {
		try {
			fromUser.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fromServer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		toServer.close();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		try {
			client.setup();
			client.exec();
		} finally {
			client.close();
		}
	}
}