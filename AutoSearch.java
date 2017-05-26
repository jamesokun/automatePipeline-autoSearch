package autoSearch;

/**
 * Starts the application.
 * 
 * @authors jbelmont, njooma
 */
public class AutoSearch {

	public AutoSearch() {
		//Set look and feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} 
	    catch (Exception e) {
	    	e.printStackTrace();
		}
		
		//Instantiate application
		new MainForm();
	}

	public static void main(String[] args) {
		new AutoSearch();
	}

}