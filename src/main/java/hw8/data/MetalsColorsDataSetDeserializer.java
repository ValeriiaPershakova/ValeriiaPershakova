package hw8.data;

import com.google.gson.*;
import hw8.entities.MetalsColorsInput;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MetalsColorsDataSetDeserializer implements JsonDeserializer<List<MetalsColorsInput>> {
    @Override
    public List<MetalsColorsInput> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        List<MetalsColorsInput> dataList = new ArrayList<>();
        JsonObject jsonObject = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            MetalsColorsInput dataSet = context.deserialize(entry.getValue(), MetalsColorsInput.class);
            dataList.add(dataSet);
        }
        return dataList;
    }
}
