package adapter;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class JsonToXMLAdapter implements XMLSystemOld {
    private JsonSystemNew jsonSystemNew;

    public JsonToXMLAdapter(JsonSystemNew jsonSystemNew) {
        this.jsonSystemNew = jsonSystemNew;
    }

    @Override
    public String getXMLData() {
        try {
            String jsonString = jsonSystemNew.getJsonData();

            JsonMapper jsonMapper = new JsonMapper();
            Data dataInstance = jsonMapper.readValue(jsonString, Data.class);

            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(dataInstance);
        } catch (IOException e) {
            e.printStackTrace();
            return "<Error>Failed to convert JSON to XML</Error>";
        }
    }
}
