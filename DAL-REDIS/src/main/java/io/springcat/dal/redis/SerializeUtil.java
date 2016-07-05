/**
 * 
 */
package io.springcat.dal.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author adampeng
 *
 */
public class SerializeUtil {

	//jdk原生序列换方案
	 
    /**
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (oos != null)
                try {
                    oos.close();
                    baos.close();
                } catch (IOException e) {
                }
        }
    }
 
    /**
     * @param bits
     * @return
     */
    public static Object deserialize(byte[] bits) {
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bits);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ois != null)
                try {
                    ois.close();
                    bais.close();
                } catch (IOException e) {
                }
        }
    }
	
}
