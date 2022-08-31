package cop2805;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Geovanie Ruiz
 *
 */
public class DataSort {
	/**
	 * Read a file and return contents as a List
	 * 
	 * @param file the path of the file to be read
	 * @return List containing contents of the file
	 */
	public static List<Double> ReadFile(String file) {
		List<Double> content = new ArrayList<Double>();
		List<String> readLines = null;

		try {
			readLines = Files.readAllLines(Paths.get(file));
			for(String str : readLines)
				content.add(Double.parseDouble(str));
			}
		catch(IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	/**
	 * Write data to a file
	 * 
	 * @param data the contents to write into the file
	 * @param file the path for the file being created
	 */
	public static void WriteFile(List<Double> data, String file) {		
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Double line : data) {
				printWriter.println(line.toString());
			}		
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read a file's content, sort it, and output the result to a new file
	 */
	public static void main(String[] args) {
		// Read data in the data.txt file located in the project root
		List<Double> content = ReadFile("data.txt");
		// Sort data in ascending order
		Collections.sort(content);
		// Create data-sorted.txt file with organized data
		WriteFile(content, "data-sorted.txt");
	}

}
