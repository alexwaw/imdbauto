package imdb.app.base;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJSON {

    private static JSONObject dataFromJSON;

    ReadDataFromJSON() {
        dataFromJSON = dataFromJSON ();
    }

    public JSONObject dataFromJSON () {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("GlobalData.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            return (JSONObject) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDefaultWebFromJSON() {
        return dataFromJSON.get("web").toString();
    }

    public String getBrowserFromJSON() {
        return dataFromJSON.get("browser").toString();
    }
}
