package ClientLengthText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientLengthApplication
{
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientLengthFrame clientLengthFrame = new ClientLengthFrame();
		clientLengthFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientLengthFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current date
		String currentWord = bufferedReader.readLine();
		clientLengthFrame.updateServerWord(currentWord);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}
}
