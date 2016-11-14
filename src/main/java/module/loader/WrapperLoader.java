package module.loader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import module.base.HtmlWrapper;


/**
 * 
 * Looking and initialization wrappers from package "module.wrappers".
 *   
 * @author Sergey Stotskiy
 *
 */
public class WrapperLoader {

    Logger logger = Logger.getLogger(WrapperLoader.class);

    /** Package with wrappers */
    private static final String PACKAGE_WRAPPERS = "module.wrappers";

    /**
     * Looking and initialization wrappers from package "module.wrappers".
     *
     * @return Map of wrappers.
     */
    public Map<String, HtmlWrapper> initializationWrappers() {

        Map<String, HtmlWrapper> parsers = new HashMap<>();

        try {
            Class[] classes = getClasses(PACKAGE_WRAPPERS);

            logger.info(String.format("Was founded %s wrappers ", classes.length));

            for (Class wrapperClass : classes) {
                HtmlWrapper wrapper = (HtmlWrapper) wrapperClass.newInstance();
                // store wrapper for this execution tag
                parsers.put(wrapper.getTagName(), wrapper);
            }
        } catch (ClassNotFoundException | IOException | InstantiationException
            | IllegalAccessException | IllegalArgumentException e1) {
            logger.error("Couldn't to instantiate wrapper " + e1);
        }
        return parsers;
    }

    /**
     * Get classes over package name
     * 
     * @param packageName
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public final Class[] getClasses(String packageName)
        throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            logger.error("ClassLoader is null");
        }
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory
     *            The base directory
     * @param packageName
     *            The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private final List<Class> findClasses(File directory, String packageName)
        throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.'
                    + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
