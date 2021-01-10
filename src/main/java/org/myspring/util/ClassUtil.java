package org.myspring.util;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lee
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包路径的类
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extraPackageClass(String packageName){
        //1.获取到类的加载器的实例
        ClassLoader classLoader = getClassLoader();
        //2.通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null){
            log.warn("unable to retrieve anything from package:"+ packageName);
            return null;
        }
        //3.以及不同类型的资源，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet = new HashSet<>();
            File packageDirectory = new File(url.getPath());
            extraPackageFile(classSet, packageDirectory, packageName);
        }
        return classSet;
    }

    /**
     * 实例化class
     * @param clazz
     * @param accessible
     * @param <T>
     * @return
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible){
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            return (T)constructor.newInstance();
        } catch (Exception e) {
            log.error("instantiate error " + e);
            throw new RuntimeException(e);
        }
    }

    public static void setField(Field field, Object target, Object value, boolean accessible){
        field.setAccessible(accessible);
        try {
            field.set(target,value);
        } catch (IllegalAccessException e) {
            log.error("set field error "+ e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 递归获取目标package里面的所有class文件(包括package里的class文件)
     * @param emptyClassSet
     * @param fileSource
     * @param packageName
     */
    private static void extraPackageFile(final Set<Class<?>> emptyClassSet, File fileSource, final String packageName) {
        if (!fileSource.isDirectory()){
            return;
        }
        final File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()){
                    return true;
                }else {
                    //获取文件的绝对路径
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(".class")){
                        //若是class文件直接加入set里
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            private void addToClassSet(String absoluteFilePath) {
                //1.从class文件的绝对值路径里提取出包含了package的类名
                //E.g: I:\git\myspring\target\classes\com\lxj\entity\Item ---> com.lxj.entity.Item
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0,className.lastIndexOf("."));
                //2.通过反射机制或地区对应的class对象并放入classSet里
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });
        //foreach要主要null的判断
        if (files !=null){
            for (File f: files){
                //递归调用
                extraPackageFile(emptyClassSet, f, packageName);
            }
        }
        return;
    }

    /**
     * 获取class对象
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error"+e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取classLoader
     * @return
     */
    public static ClassLoader getClassLoader(){
       return Thread.currentThread().getContextClassLoader();
    }
}
