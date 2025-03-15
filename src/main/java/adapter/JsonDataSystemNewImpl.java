package adapter;

import java.io.IOException;

public class JsonDataSystemNewImpl implements JsonSystemNew {
    @Override
    public String getJsonData() throws IOException {
        return "{\"id\":2,\"name\":\"Kỳ\"}";
    }
}
