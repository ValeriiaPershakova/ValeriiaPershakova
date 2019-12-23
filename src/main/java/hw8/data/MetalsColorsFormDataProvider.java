package hw8.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hw8.entities.MetalsColorsInput;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MetalsColorsFormDataProvider {
    @DataProvider(name = "Json Input for Metals&Colors Form")
    public Object[][] metalsColorsFormInput() {
        List<MetalsColorsInput> inputList;
        Type itemsListType = new TypeToken<List<MetalsColorsInput>>() {
        }.getType();
        try (FileReader reader = new FileReader("src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json")) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(itemsListType, new MetalsColorsDataSetDeserializer())
                    .create();
            inputList = gson.fromJson(reader, itemsListType);

            Object[][] dataList = new Object[inputList.size()][1];
            for (int i = 0; i < inputList.size(); i++) {
                dataList[i] = new Object[]{inputList.get(i)};
            }
            return dataList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
