package se.p950tes.publictransport.app.repository.parsing;

import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import se.p950tes.publictransport.app.repository.type.AreaPointDO;
import se.p950tes.publictransport.app.repository.type.DepartureDO;
import se.p950tes.publictransport.app.repository.type.DeparturesResponseDO;
import se.p950tes.publictransport.app.repository.type.PayloadResponseDO;

public class DeparturesParserTest {

	private static final int ID_KLOCKARANGEN = 700552;
	
	private static final String DEPARTURES_RESPONSE_FILE = "/ul-departures-from-stop-response.txt";
	
	@Test
	public void test1() throws Exception {
		
		URL fileUrl = DeparturesParserTest.class.getResource(DEPARTURES_RESPONSE_FILE);
		String responseString = IOUtils.toString(fileUrl.openStream(), "UTF-8");
		
		JsonParser parser = new JsonParser();
		PayloadResponseDO<DeparturesResponseDO> response = parser.parsePayloadResponse(responseString, DeparturesResponseDO.class);
		
		DeparturesResponseDO data = response.getParsedPayload();
		
		for (AreaPointDO areapoint : data.getAreaPoints()) {
			System.out.println(areapoint);
		}
		
		for (DepartureDO departure : data.getDepartures()) {
			System.out.println(departure);
		}
	}
}
