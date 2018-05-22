package se.sveaekonomi.webpay.pmtapi.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.sveaekonomi.webpay.pmtapi.PmtApiClientRF;
import se.sveaekonomi.webpay.pmtapi.entity.Order;
import se.sveaekonomi.webpay.pmtapi.util.JsonUtil;

public class TestGetOrder {

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
			
			Long orderId = TestConfig.checkoutOrderId;
			
			Order order = client.getOrder(orderId);
			
			if (order==null) {
				fail("No such order: " + orderId);
				return;
			}
			
			System.out.println(JsonUtil.gson.toJson(order));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			fail(e.getMessage());
			
		}
		
	}
		



}
