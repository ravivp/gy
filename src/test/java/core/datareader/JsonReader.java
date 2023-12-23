package core.datareader;

public class JsonReader {
    public static void main(String[] args)
    {

       // System.out.println(json.getVehicleTestData("vehicle").toString());

       // System.out.println(json.getValue("Vehicle.Make2"));
      //  System.out.println(json.jsonArray("company"));
        String str = "line 1\n"+
                "line 2\n"+
                "line 3\n";

        int newLineIndex = str.indexOf("\n");

        String first = str.substring(0, newLineIndex);
        System.out.println(first);
//        String[] split=str.split("\n",1);
//        System.out.println(split[0]);
       /* System.out.println(split[1]);
        System.out.println(split[2]);*/

    }
}
