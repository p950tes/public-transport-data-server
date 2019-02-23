package se.p950tes.publictransport.app.repository.datasource;

import java.net.URL;

import org.apache.commons.io.IOUtils;

import se.p950tes.publictransport.app.Test;

public class FileDataSource implements DataSource {

	private String filePath;
	
	public FileDataSource(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public String fetchData() throws Exception {
		URL fileUrl = Test.class.getResource(filePath);
		
		return IOUtils.toString(fileUrl.openStream(), "UTF-8");
	}

}
