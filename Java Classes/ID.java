/*
 * Singleton ID 
 */
import java.math.BigInteger;
import java.util.UUID;//universally unique identifier
public class ID {
    private String ID;
    private static ID serial;//variable of type ID

    /*
     * Private constructor
     */
    private ID(String ID){
        this.ID = ID;
    }


    /*
     * Private helper method to generate a universally unique string 
     */
    private static String generateID(){
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

    /*
     * public method that 
     */
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
        return serial;//return the object
    }

    public String getID(){
        return ID;
    }

}
