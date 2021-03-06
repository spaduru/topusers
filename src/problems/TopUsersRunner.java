package problems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopUsersRunner {
	public static void main(String[] args) throws IOException {
			BufferedReader br = null;
		    String line;
		    Integer topK = 3;
		    TopUsers topusers = new TopUsers(topK);
		    br = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Enter file path");
		    
		    String file = br.readLine();

		    try {
		        br = new BufferedReader(
		        	new InputStreamReader(new FileInputStream(file))
		        );
		        while ((line = br.readLine()) != null)
		        	topusers.buildTopK(line);
		    } catch (IOException ioException) {
		    	throw ioException;
		    } finally {
		    	br.close();
		    }
		    for (IpFrequency ipfreq : topusers.getTopUsers())
		    	System.out.println(ipfreq.getIp() + " : " + ipfreq.getFreq());
	}

}
