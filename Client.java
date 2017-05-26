package autoSearch;

/**
 * This class represents an AutoUpdate Client
 * 
 * @authors jbelmont, njooma
 */
public class Client {

	private String _name;
	private int _priority;
	
	public Client(String name, int priority) {
		_name = name;
		_priority = priority;
	}
	
	//==================== ACCESSORS AND MUTATORS ====================\\
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setPriority(int priority) {
		_priority = priority;
	}
	
	public int getPriority() {
		return _priority;
	}

}
