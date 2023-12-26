package core.datareader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import core.data.VehicleTestData;
import core.utils.CustomException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class json {

     public static VehicleTestData vehicleTestData;
    public static  HashMap<String,Object> getJsonData;


    static {
          ObjectMapper mapper=new ObjectMapper();
         getJsonData=new HashMap<String,Object>();
        try {

            getJsonData=  mapper.readValue(new File("src/test/resources/testdata.json"),
                    new TypeReference<HashMap<String,Object>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    synchronized public static VehicleTestData getVehicleTestData(String key){

        HashMap<String,String> vehicleDataInKeyValue= (HashMap<String, String>) getJsonData.get(key);
        System.out.println(vehicleDataInKeyValue.toString());
       return vehicleTestData= (VehicleTestData) parseHashMapToObject(vehicleDataInKeyValue,VehicleTestData.class);

    }

  /*  synchronized public static VehicleTestData getVehicleTestData(String searchObjectKey){

        vehicleTestData=new VehicleTestData();
        return vehicleTestData= (VehicleTestData) getJsonData.get(searchObjectKey);
    }*/
    synchronized public static List<String > getConvertedVehicleToList(String searchObjectKey){


        return new ArrayList<>((Collection) ((HashMap<?, ?>) getJsonData.get(searchObjectKey)).values());
    }

   synchronized public static Object parseHashMapToObject(HashMap map, Class cls) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String jsonString = gson.toJson(map);
        return gson.fromJson(jsonString, cls);
    }
    synchronized public static HashMap<Object,Object> getKeyValueTestDataFromJsonObject(String key){

        HashMap<Object,Object> testDataInMapFormat= (HashMap<Object, Object>) getJsonData.get(key);
        return testDataInMapFormat;

    }
   synchronized public static Object getValue(String mainKey){
       String[] keys=mainKey.split("\\.");
       HashMap<String, Object> getEntry= (HashMap<String, Object>) getJsonData.get(keys[0].toLowerCase());
       if(getEntry.containsKey(keys[1].toLowerCase())) {
           return getEntry.get(keys[1].toLowerCase());
       }else {
           throw new CustomException("Looking "+keys[1].toLowerCase()+ " test data not available in test data file");
       }


   }

   synchronized public static List<String> jsonArray(String searchKey){

        List<String> arrayList;
      //  JsonArray jsonArray= (JsonArray) getJsonData.get(searchKey);

       //arrayList=new JsonArray();
//        Iterator<JsonElement> arrays= jsonArray.iterator();
//        while (arrays.hasNext()){
//
//            arrayList.add(arrays.next().toString());
//        }

       arrayList= (List<String>) getJsonData.get(searchKey);


        return arrayList;
   }
}
