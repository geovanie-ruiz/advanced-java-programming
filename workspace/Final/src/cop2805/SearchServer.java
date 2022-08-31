package cop2805;

import java.net.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Geovanie Ruiz
 *
 */
/**
 * Scan a text file for the number of instances a keyword appears.
 * 
 * @param filename the keyword to be searched
 */
class WordSearcher {
	Integer lineCount = 0;
	List<String> fileCache = null;
	
	public WordSearcher(String filename) {
		fileCache = ReadFile(filename);
		lineCount = fileCache.size();
	}

	/**
	 * Create a pipe-delimited string as return to parse into line number
	 * and line text for the double-click feature.
	 */
	public List<String> Search(String word) {
		word = word.toUpperCase();
		
		List<String> matchIndex = new ArrayList<String>();

		for (int i = 0; i < lineCount; i++) {
			String line = fileCache.get(i);
			if (line.indexOf(word) >= 0) {
				String record = i + "|" + line;
				matchIndex.add(record);
			}
		}

		return matchIndex;
	}

	private List<String> ReadFile(String file) {
		List<String> readLines = null;

		try {
			readLines = Files.readAllLines(Paths.get(file));
			readLines.replaceAll(String::toUpperCase);
		} catch (IOException e){
			// Fatal error, we need a readable file
			e.printStackTrace();
			System.exit(-1);
		}

		return readLines;
	}
}

public class SearchServer {
	/**
	 * Runs the server. Loops until the user shutsdown, listening for 
	 * socket connections.
	 */
	public static void main(String[] args) {
		WordSearcher searcher = new WordSearcher("hamlet.txt");
		boolean shutdown = false;
		ServerSocket server = null;

		try {
			server = new ServerSocket(1236);
			System.out.println("Port #1236 bound. Accepting connections.");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		while (!shutdown) {
			Socket client = null;
			InputStream input = null;
			OutputStream os = null;
			ObjectOutputStream output = null;
			
			try {
				client = server.accept();
				input = client.getInputStream();
				os = client.getOutputStream();
				output = new ObjectOutputStream(os);

				int length = input.read();
				byte[] data = new byte[length];

				input.read(data);
				String clientInput = new String(data, StandardCharsets.UTF_8);

				List<String> searchResult = searcher.Search(clientInput);
				output.writeObject(searchResult); 
				client.close();

				if(clientInput.equalsIgnoreCase("shutdown")) {
					System.out.println("Shutting down...");
					shutdown = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}
