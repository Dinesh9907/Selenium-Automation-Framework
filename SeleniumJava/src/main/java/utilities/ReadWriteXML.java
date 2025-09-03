package utilities;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ReadWriteXML<T> {
	String path;
	XmlMapper mapper;
	Class<T> type;
	public ReadWriteXML(String path,Class<T> type) {
		this.path=path;
		this.type=type;
		this.mapper=new XmlMapper();
	}
	
	public T readXml() {
		try {
			return mapper.readValue(new File(path), type);
		} catch (IOException e) {
			return null;
		}
	}
	
	public void writeXml(T object) {
		try {
			mapper.writeValue(new File(path), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
