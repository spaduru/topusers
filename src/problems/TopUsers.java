package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sharathpaduru
 * Class to build and retrieve top users
 */
public class TopUsers {
    private PriorityQueue<IpFrequency> ipFreqHeap;
    private Map<String, Integer> ipFreqMap;
    private Integer topK;
    
    /**
     * @param topK users
     */
    public TopUsers(Integer topK) {
    	this.ipFreqHeap = new PriorityQueue<>(topK, new Comparator<IpFrequency>() {
			@Override
			public int compare(IpFrequency o1, IpFrequency o2) {
				if (o1.getFreq() < o2.getFreq())
					return -1;
				else if (o1.getFreq() > o2.getFreq())
					return 1;
				else
					return 0;
			}
		});
    	this.ipFreqMap = new HashMap<>();
    	this.topK = topK;
    }

	/**
	 * @param ip
	 * Updates HashMap and PriorityQueue with this IP and updated frequency for this IP
	 */
	public void buildTopK(String ip) {
		if (ipFreqMap.containsKey(ip))
			ipFreqMap.put(ip, ipFreqMap.get(ip)+1);
		else
			ipFreqMap.put(ip,1);
		
		IpFrequency ipFrequency = new IpFrequency(ip,ipFreqMap.get(ip));
		if (ipFreqHeap.contains(ipFrequency)) {
			ipFreqHeap.remove(ipFrequency);
			ipFreqHeap.add(ipFrequency);			
		}
		else {
			if (ipFreqHeap.size()<topK)
				ipFreqHeap.add(ipFrequency);
			else {
				if (ipFreqHeap.peek().getFreq() < ipFrequency.getFreq()) {
					ipFreqHeap.remove();
					ipFreqHeap.add(ipFrequency);
				}
			}
		}
	}
	
	/**
	 * @return Sorted List of top K user IPs in decreasing order of frequencies
	 */
	public ArrayList<IpFrequency> getTopUsers() {
		ArrayList<IpFrequency> topUsers = new ArrayList<>();
		Iterator<IpFrequency> itr = ipFreqHeap.iterator();
		while (itr.hasNext())
			topUsers.add(itr.next());

		Collections.sort(topUsers, new Comparator<IpFrequency>() {
			@Override
			public int compare(IpFrequency o1, IpFrequency o2) {
				if (o1.getFreq() < o2.getFreq())
					return 1;
				else if (o1.getFreq() > o2.getFreq())
					return -1;
				else
					return 0;
			}
		});
		return topUsers;
	}
}
