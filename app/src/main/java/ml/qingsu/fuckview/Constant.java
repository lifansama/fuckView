package ml.qingsu.fuckview;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by w568w on 18-3-2.
 *
 * @author w568w
 */

public class Constant {
    public static final String PKG_NAME = "ml.qingsu.fuckview";
    public static final String ACTIVITY_NAME = "ml.qingsu.fuckview.ui.activities.MainActivity";
    public static final String VAILD_METHOD = "isModuleActive";

    public static final String LIST_NAME = "block_list";
    public static final String SUPER_MODE_NAME = "super_mode";
    public static final String ONLY_ONCE_NAME = "only_once";
    public static final String STANDARD_MODE_NAME = "standard_mode";
    public static final String ENABLE_LOG_NAME = "enable_log";
    public static final String PACKAGE_NAME_NAME = "package_name";

    //DO not draw your attention to the codes below.

    private static Object[] helperArray = new Object[1];

    /**
     * 获取对象起始位置偏移量
     *
     * @param unsafe
     * @param object
     * @return
     */
    public static long getObjectAddress(Object unsafe, Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        helperArray[0] = object;
        Method arrayBaseOffset = unsafe.getClass().getDeclaredMethod("arrayBaseOffset", Class.class);
        Method getLong = unsafe.getClass().getDeclaredMethod("getLong", Object[].class, long.class);
        long baseOffset = (long) arrayBaseOffset.invoke(unsafe, Object[].class);
        return (long) getLong.invoke(unsafe, helperArray, baseOffset);
    }

    public static Object getUnsafe() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Class clz = Class.forName("sun.misc.Unsafe");
        Field theUnsafe = clz.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object unsafe = theUnsafe.get(null);
        return unsafe;
    }

    public static void main(String[] args) {
        try {
            System.out.print(getObjectAddress(getUnsafe(), new Object()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}