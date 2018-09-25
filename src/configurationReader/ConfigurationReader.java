package configurationReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class ConfigurationReader {
	
	private File file = null;
	private String fileName = "";
	private Scanner scan = null;
	private String line;
	
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
	
	public boolean hasMoreLines() throws IOException{
		try {
			line = this.scan.nextLine();
		}
		catch (NoSuchElementException e) {
			return false;
		}
		
		
		//line = this.scan.nextLine();
		
		if(line != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String nextLine() throws IOException {
		//System.out.println(this.scan.next());
		/*
		String nextLine = this.scan.nextLine();
		if( this.hasMoreLines() && (nextLine != "")) {
			System.out.println("nextLine: " + nextLine);
			return nextLine;
		} */
		/*if( this.hasMoreLines() ) {
			String nextLine = this.scan.nextLine();
			System.out.println("nextLine: " + nextLine );
			if( nextLine != "" ) {
				return nextLine;
			}
		}
		return " ";*/
		return this.line;
	}
	
	public abstract void load() throws IOException;
}
