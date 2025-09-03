package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
	String path="";
	
	public ReadWriteFile(String path) {
		this.path=path;
	}
	
	public String fileReader() {
		String output="";
		try {
			BufferedReader reader=new BufferedReader(new FileReader(path));
			String line;
			while((line=reader.readLine())!=null) {
				output=output+line;
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	//newFile- true or false (true - append content with old content, false -write content with new by removing old content)
	public void fileWriter(String content, boolean newFile) {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(path,newFile));
			if(!(fileReader().isEmpty())) {
				writer.newLine();
			}
			writer.write(content);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileDelete(File fileName) {
		fileName.delete();
	}
}
