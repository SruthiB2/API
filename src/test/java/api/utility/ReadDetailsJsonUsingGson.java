package api.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import api.payload.Details;

/*
 * This is not part of project. This class is written to understand how to read nest 
 * json's pojo.
 */

public class ReadDetailsJsonUsingGson {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader(".\\Resources\\Details.json");
			Gson gson = new Gson();
			Details d = gson.fromJson(reader, Details.class);
			System.out.println("before setter: "+d.getFirstName());
			
			d.setFirstName("Bill gates");
			System.out.println("after setter: "+d.getFirstName());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
