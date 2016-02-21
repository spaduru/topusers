package problems;

/**
 * @author sharathpaduru
 *
 */
public class IpFrequency {
	private String ip;
	private Integer freq;
	
	public IpFrequency(String ip, Integer freq) {
		this.ip = ip;
		this.freq = freq;
	}
	
	public String getIp() {
		return ip;
	}

	public Integer getFreq() {
		return freq;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IpFrequency other = (IpFrequency) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		return true;
	}
}
