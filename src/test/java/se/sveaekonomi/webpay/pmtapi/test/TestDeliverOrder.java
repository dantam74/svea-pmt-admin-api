package se.sveaekonomi.webpay.pmtapi.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.sveaekonomi.webpay.pmtapi.PmtApiClientRF;

public class TestDeliverOrder {

	@Before
	public void setUp() throws Exception {
			
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetOrder() {

		PmtApiClientRF client = new PmtApiClientRF();
		try {
			
			client.init(TestConfig.SERVER, TestConfig.MERCHANT_ID, TestConfig.SECRET_WORD);

			if (TestConfig.checkoutOrderId==null) {
				fail("No valid checkout order id specified in test-credentials.properties");
			}
			
			String result = client.deliverCompleteOrder(TestConfig.checkoutOrderId);
			
			System.out.println(result);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			fail(e.getMessage());
			
		}
		
	}
		



}
