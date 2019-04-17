package com.framework.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 属性提取器
 * 
 * @author zhangl
 *
 */
public class PropertiesUtil {

	/**
	 * 根据指定文件获取属性对象
	 * 
	 * @param fileName
	 * @return
	 */
	public static Properties load(String fileName) {
		Properties properties = new Properties();
		try {
			String path = PropertiesUtil.class.getResource("/").getPath() + fileName;
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 从指定的文件名中获取支指定的参数值
	 * 
	 * @param fileName
	 *            文件名
	 * @param key
	 *            参数名
	 * @return
	 */
	public static String getProperty(String fileName, String key) {
		return load(fileName).getProperty(key);
	}

	/**
	 * 从配置文件中获取 指定属性值
	 * 
	 * @param key
	 * @return
	 */
	public static String getPropertyFromConfig(String key) {
		return load("config/config.properties").getProperty(key);
	}

	public static void main(String[] args) {
		String value = PropertiesUtil.load("config/jdbc.properties").getProperty("jdbc.driver");

		System.out.println(value);
	}

}
