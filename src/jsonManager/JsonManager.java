package jsonManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.Book;

public class JsonManager {
	
	
	public static void writer(ArrayList<Book> array) throws IOException {
		JsonArray gSonArray = new JsonArray();//gson google json
		for (Book book : array) {
			JsonObject gSonObj = new JsonObject();
			gSonObj.addProperty("id", book.getId());
			gSonObj.addProperty("name", book.getName());
			gSonObj.addProperty("tittle", book.getTittle());
			JsonArray gSonArrayType = new JsonArray();
			for (int i = 0; i < book.getType().length; i++) {
				gSonArrayType.add(book.getType()[i]);
			}
			gSonObj.add("type", gSonArrayType);
			
			gSonArray.add(gSonObj);
		}//---------------------
		
		File myFile = new File("misObjs.json");
		myFile.createNewFile();
		FileOutputStream fOut = new FileOutputStream(myFile);
		OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
		myOutWriter.append(gSonArray.toString());
		myOutWriter.close();
		fOut.close();
		
	}
	
	
	public static ArrayList<Book> read() throws FileNotFoundException, IOException, ParseException {
		ArrayList<Book> arrayToRead = new ArrayList<Book>();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("misObjs.json"));
		JSONArray jsonArray = (JSONArray) obj;
		for (Object objArray : jsonArray) {
			JSONObject jSonObj = (JSONObject) objArray;
			int id = Integer.parseInt( jSonObj.get("id").toString());
			String name = jSonObj.get("name").toString();
			String tittle = jSonObj.get("tittle").toString();
			JSONArray typeArray = (JSONArray) jSonObj.get("type");  
			String[] type = new String [typeArray.size()];
			for (int i = 0; i < typeArray.size(); i++) {
				type[i] = typeArray.get(i).toString();
			}
			arrayToRead.add(new Book(id, name, tittle, type));
		}
		
		
		
		return arrayToRead;
		
	}

}
