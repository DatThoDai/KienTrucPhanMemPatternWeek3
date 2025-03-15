package adapter;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // Kiểm thử XML sang JSON
        System.out.println("Test XML to JSON conversion:");
        XMLSystemOld xmlDataSystemOld = new XMLDataSystemOldImpl();
        String xmlString = xmlDataSystemOld.getXMLData();
        System.out.println("XML Data: " + xmlString);

        JsonSystemNew jsonAdapter = new XMLToJsonAdapter(xmlDataSystemOld);
        String jsonData = jsonAdapter.getJsonData();
        System.out.println("Converted JSON Data: " + jsonData);

        // Kiểm thử JSON sang XML
        System.out.println("\nTest JSON to XML conversion:");
        JsonSystemNew jsonDataSystemNew = new JsonDataSystemNewImpl();
        String jsonString = jsonDataSystemNew.getJsonData();
        System.out.println("JSON Data: " + jsonString);

        XMLSystemOld xmlAdapter = new JsonToXMLAdapter(jsonDataSystemNew);
        String xmlData = xmlAdapter.getXMLData();
        System.out.println("Converted XML Data: " + xmlData);
    }
}
