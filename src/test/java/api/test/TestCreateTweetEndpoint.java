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
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import api.endpoints.TweetEndpoints;
import api.helper.JsonHelper;
import api.payload.GetAllTweetsResponse;
import api.payload.TweetRequest;
import api.payload.TweetResponse;
import api.utility.ConfigReaderUtil;
import io.restassured.response.Response;

public class TestCreateTweetEndpoint {

	Response response;
	Faker faker;
	TweetResponse tweetResponse;
	private String myParam;
	static ConfigReaderUtil configReader;
	static Properties prop;
	JsonHelper jsonHelper = new JsonHelper();
	TweetEndpoints tweetEndpoints = new TweetEndpoints();

	@BeforeTest
	public void setupData() {
		faker = new Faker();
	}

	@Test(dataProvider = "tweetTestData")
	public void testCreateTweet(TweetRequest tweet, ITestContext context) throws IOException {
		response = tweetEndpoints.createTweet(tweet);
		tweetResponse = jsonHelper.BusinessObjectToJson(response);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(tweetResponse.getTitle(), tweet.getTitle());
		Assert.assertEquals(tweetResponse.getUserId(), tweet.getUserId());
		Assert.assertEquals(tweetResponse.getBody(), tweet.getBody());
		context.setAttribute("user_id", tweetResponse.getUserId());
		context.setAttribute("title", tweetResponse.getTitle());
		context.setAttribute("body", tweetResponse.getBody());
		context.setAttribute("id", tweetResponse.getId());
		context.setAttribute("resp", tweetResponse);
	}

	@DataProvider(name = "tweetTestData")
	public static Iterator<Object[]> readExcelUsingDataProvider() {
		FileInputStream fis;
		List<Object[]> li = new ArrayList<Object[]>();
		try {
			configReader = new ConfigReaderUtil();
			prop = configReader.init_properties();
			fis = new FileInputStream(prop.getProperty("ResourcePath"));
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("testData");
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow rowData = sheet.getRow(i);
				if (rowData != null) {
					double userId = Double.parseDouble(rowData.getCell(0).toString());
					String title = rowData.getCell(1).getStringCellValue();
					String body = rowData.getCell(2).getStringCellValue();
					TweetRequest tweetRequest = new TweetRequest(title, body, userId);
					li.add(new Object[] { tweetRequest });
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
