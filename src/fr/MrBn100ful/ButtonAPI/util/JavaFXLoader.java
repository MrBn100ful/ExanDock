
package fr.MrBn100ful.ButtonAPI.util;
/**
 *  
 * @author MrBn100ful
 * 
 */
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public final class JavaFXLoader {


    public static boolean addToSystemClassLoader(File file) {
        if ((ClassLoader.getSystemClassLoader() instanceof URLClassLoader)) {
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            try {
                Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                method.setAccessible(true);
                method.invoke(classLoader, file.toURI().toURL());

                return true;
            } catch (Throwable t) {
                return false;
            }
        }

        return false;
    }


    public static boolean loadJavaFX() {
        if (isJavaFXLoaded())
            return true;

        File javaFxJar = new File(System.getProperty("java.home"), "lib/jfxrt.jar");
        if (javaFxJar.isFile())
            try {
                addToSystemClassLoader(javaFxJar);
                return true;
            } catch (Throwable e) {
                return false;
            }

        return false;
    }

    public static boolean isJavaFXLoaded() {
        try {
            JavaFXLoader.class.getClassLoader().loadClass("javafx.embed.swing.JFXPanel");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}
