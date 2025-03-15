package adapter;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XMLToJsonAdapter implements JsonSystemNew {
    private XMLSystemOld xmlSystemOld;

    public XMLToJsonAdapter(XMLSystemOld xmlSystemOld) {
        this.xmlSystemOld = xmlSystemOld;
    }

    @Override
    public String getJsonData() throws IOException {
        String xmlString = xmlSystemOld.getXMLData();

        XmlMapper xmlMapper = new XmlMapper();
        Data dataInstance = xmlMapper.readValue(xmlString.getBytes(), Data.class);

        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.writeValueAsString(dataInstance);
    }
}
