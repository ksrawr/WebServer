package configurationReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ConfigurationReader {
	
	private File file = null;
	private String fileName = "";
	private Scanner scan = null;
	//ArrayList<String> requestStrs;
	
	public ConfigurationReader( String fileName ) {
		try {
			this.fileName = fileName;
			//requestStrs = new ArrayList<String>();
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
			//scan.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean hasMoreLines() {
		while(this.scan != null) {
			System.out.println("scan not null!");
			if(this.scan.hasNextLine()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public String nextLine() throws IOException {
		//System.out.println(this.scan.next());
		return this.scan.nextLine();
	}
	
	public abstract void load() throws IOException;
}
