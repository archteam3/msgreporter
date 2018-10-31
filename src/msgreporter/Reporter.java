package msgreporter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reporter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int defaultPort = 11111;
		String ip = null;

		if( args.length == 1 ) {
			ip = args[0];
		} else if( args.length >= 2) {
			ip = args[0];
			defaultPort = Integer.parseInt(args[1]);
		} else {
			System.out.println("== Usage ==============================");
			System.out.println(" java -jar [jarName] [ip] (port)");
			System.out.println("---------------------------------------");
			return;
		}
		Socket s = new Socket(ip, defaultPort);
		BufferedReader input =
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(input.readLine());
		System.out.println(input.readLine());
		input.close();
		s.close();
	}
}
