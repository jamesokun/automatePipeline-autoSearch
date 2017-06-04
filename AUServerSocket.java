package autoSearch;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JOptionPane;

import modules.Params;

/**
 * This class creates a thread and constantly
 * listens for incoming connections. It then
 * accepts the connections and sends it to a
 * new thread that handles the client (AUClientThread).
 */
public class AUServerSocket extends Thread {
	
	private MainForm _mainForm;
	private Params _params;
	
	public AUServerSocket(MainForm mainForm, Params params) {
		super("AUServerSocket");
		_mainForm = mainForm;
		_params = params;
	}
	
	public void run() {
		boolean listening = true;
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(_params.getGlobalParam("SEQUEST.Port", "40002")));
			_mainForm.log("AutoSearch is listening on port " + serverSocket.getLocalPort());
			while(listening) {
				new AUClientThread(serverSocket.accept(), _mainForm).start();
			}
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Could not listen on designated port");
			JOptionPane.showMessageDialog(_mainForm, "Cannot open a socket on the designated port", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
