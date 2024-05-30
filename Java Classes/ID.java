import java.math.BigInteger;
import java.util.UUID;
public class ID {
    private String ID;
    private static ID serial;
    private ID(String ID){
        this.ID = ID;
    }

    private static String generateID(){
        String generateUUIDNo = String.format("%010d",
        new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
        String id;
        id = generateUUIDNo.substring( generateUUIDNo.length() - 10);
        return id;
    }

    public String getID(){
        return ID;
    }

    public static ID getInstance(){
        ID id = serial;
        if (serial == null){
            synchronized (ID.class){
                id = serial;
                if(id == null){
                    serial = id = new ID(generateID());
                }
            }
        }
        return serial;
    }
}
