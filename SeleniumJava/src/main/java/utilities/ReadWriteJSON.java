package utilities;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWriteJSON<T> {
	String path="";
	ObjectMapper mapper;
	Class<T> type;
	
	public ReadWriteJSON(String path,Class<T> type) {
		this.path=path;
		mapper=new ObjectMapper();
		this.type=type;
	}
	
	public T readJSON() {
		try {
			return mapper.readValue(new File(path), type);
		} catch (IOException e) {
			return null;
		}
	}
	
	public void writeJSON(T object) {
		try {
			mapper.writeValue(new File(path), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
