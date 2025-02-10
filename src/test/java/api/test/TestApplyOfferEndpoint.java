package api.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.ApplyOfferEndpoints;
import api.helper.JsonHelper;
import api.payload.ApplyOfferRequest;
import api.payload.ApplyOfferResponse;
import api.utility.ConfigReaderUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestApplyOfferEndpoint {
	Response response;
	static ConfigReaderUtil configReader;
	static Properties prop;
	JsonHelper jsonHelper = new JsonHelper();
	ApplyOfferEndpoints applyOfferEndpoints = new ApplyOfferEndpoints();
	ApplyOfferResponse applyOfferResponse = new ApplyOfferResponse();

	@Test(dataProvider = "cartOfferTestData")
	public void applyOfferTest(ApplyOfferRequest applyofferRequest, int cart_value_after_discount) throws IOException {
		response = applyOfferEndpoints.applyOfferToCart(applyofferRequest);
		applyOfferResponse = jsonHelper.JsonToBusinessObject(response);
		response.then().log().all();
		int actualCartValueAfterOffer = applyOfferResponse.getCart_value();
		int expectedCartValueAfterOffer = cart_value_after_discount;
		System.out.println("actual value: " + actualCartValueAfterOffer);
		System.out.println("Expected value: " + expectedCartValueAfterOffer);
		Assert.assertTrue(response.statusCode()==200);	
		Assert.assertEquals(response.getContentType(),"application/json");
		Assert.assertEquals(actualCartValueAfterOffer, expectedCartValueAfterOffer);
		
		
	}

	@DataProvider(name = "cartOfferTestData")
	public static Iterator<Object[]> readExcelUsingDataProvider() {
		FileInputStream fis;
		List<Object[]> li = new ArrayList<Object[]>();
		try {
			configReader = new ConfigReaderUtil();
			prop = configReader.init_properties();
			fis = new FileInputStream(prop.getProperty("ResourcePath"));
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("TestData_CartOffer");
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow rowData = sheet.getRow(i);
				if (rowData != null) {
					int cart_value = (int) rowData.getCell(0).getNumericCellValue();
					int user_id = (int) rowData.getCell(1).getNumericCellValue();
					int restaurant_id = (int) rowData.getCell(2).getNumericCellValue();
					int cart_value_after_discount = (int) rowData.getCell(3).getNumericCellValue();
					ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest(cart_value, user_id, restaurant_id);
					li.add(new Object[] { applyOfferRequest, cart_value_after_discount });
				}
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
			// System.out.println("file not found exception:::::::::::::::");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li.iterator();
	}

}
