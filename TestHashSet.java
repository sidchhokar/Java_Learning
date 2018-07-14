import java.util.*;
class KeyData {
    String cityCountry;
    String gender;

    public KeyData(String country, String gender) {
        this.cityCountry = country;
        this.gender = gender;
    }

 /*   public boolean equals(Object obj) {
        boolean result = false;
        String keyobj1 = this.cityCountry + "+" + this.gender;
        KeyData keyObj = (KeyData)obj;
        String keyobj2 = keyObj.cityCountry + "+" + keyObj.gender;

        if(keyobj1.equals(keyobj2))
            result = true;

        return result;
    } */

    public int hashCode() {
        String keyobj1 = this.cityCountry + "+" + this.gender;
        System.out.println("code working");
        return keyobj1.hashCode();
    }


}

public class TestHashSet {
    
    public static void main(String argv[]) {

        Set<KeyData> set = new HashSet<KeyData>();
        List<KeyData> list = new ArrayList<KeyData>();

        KeyData keyObj1 = new KeyData("IND","M");
        KeyData keyObj2 = new KeyData("IND","M");

        list.add(keyObj1);
        System.out.println("list contains keyobj2: "+ list.contains(keyObj2));


        set.add(keyObj1);
        System.out.println("set contains keyobj2: " + set.contains(keyObj2));
    }
}

