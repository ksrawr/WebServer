import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ConfigurationReader {
	
	File file = null;
	static String fileName = "";
	static Scanner classScan = null;
	Scanner scan = null;
	ArrayList<String> requestStrs;
	
	public ConfigurationReader( String fileName ) {
		try {
			ConfigurationReader.fileName = fileName;
			requestStrs = new ArrayList<String>();
			file = new File(fileName);
			/*
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null ) {
				stringBuffer.append(line);
				requestStrs.add(stringBuffer.toString());
				stringBuffer.delete(0, stringBuffer.length());
			}
			*/
			scan = new Scanner(file);
			classScan = scan;
			scan.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean hasMoreLines() {
		classScan = scan;
		while(classScan != null) {
			if(classScan.hasNextLine()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public String nextLine() {
		classScan = scan;
		while(classScan != null) {
			return classScan.nextLine();
		}
		return "";
	}
	
	public abstract void load() throws IOException;
}
