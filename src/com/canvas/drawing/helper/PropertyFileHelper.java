/*
 * @author Anurup Borah
 * @package com.canvas.drawing.helper
 * 
 * PropertyFileHelper Class is helper class to access the property file and wirte and read to property file 
 */
package com.canvas.drawing.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.canvas.drawing.constant.DrawingConstant;
import com.canvas.drawing.exception.DrawingException;

public class PropertyFileHelper {
	private String propertiesfile;
	
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	Map<String,String> getSetValue = null;
	
	
	public PropertyFileHelper(String propertiesfile){
		this.propertiesfile = propertiesfile;
		this.getSetValue = new HashMap<String,String>();
	}
	
	public void writeToProperties(Map<?,?> maptoWrite) throws DrawingException{
		try {
			output = new FileOutputStream(this.propertiesfile);
			// set the properties value
			//Java 8 Streams Lambda Expression
			maptoWrite.entrySet().stream().forEach(entry -> System.out.println(prop.setProperty(entry.getKey().toString(), entry.getValue().toString())));
	
			// save properties to project root folder
			prop.store(output, null);
			} catch (Exception e) {
				throw new DrawingException(e,  DrawingConstant.PROP_CANNOT_OPEN);
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (Exception e) {
						throw new DrawingException(e,DrawingConstant.PROP_CANNOT_CLOSE);
					}
				}
			}
		}
	
	
	public Map<String,String> readFromProperties() throws DrawingException{
		try {
			//input = new FileInputStream(getClass().getClassLoader().getResourceAsStream(this.propertiesfile));
			input = getClass().getClassLoader().getResourceAsStream(this.propertiesfile);
			if(input==null){
	            System.out.println(DrawingConstant.PROP_NOT_FOUND + this.propertiesfile);
	            return null;
			}
			// load a properties file
			prop.load(input);
			
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				this.getSetValue.put(key, value);
			}
			
		} catch (Exception e) {
			throw new DrawingException(e, DrawingConstant.PROP_CANNOT_OPEN);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e) {
					throw new DrawingException(e, DrawingConstant.PROP_CANNOT_CLOSE);
				}
			}
		}
		return this.getSetValue;
	}
	
	
	public Map<String,String> readFromPropertiesByKeyNames(String[] readFromFile) throws DrawingException{
		try {
			//input = new FileInputStream(getClass().getClassLoader().getResourceAsStream(this.propertiesfile));
			input = getClass().getClassLoader().getResourceAsStream(this.propertiesfile);
			if(input==null){
	            System.out.println(DrawingConstant.PROP_NOT_FOUND + this.propertiesfile);
	            return null;
			}
			// load a properties file
			prop.load(input);
			
			Enumeration<?> e = prop.propertyNames();
			List<String> listStr = Arrays.asList(readFromFile);
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				if(listStr.contains(key)){
					this.getSetValue.put(key, value);
				}
			}
			
		} catch (Exception e) {
			throw new DrawingException(e, DrawingConstant.PROP_CANNOT_OPEN);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e) {
					throw new DrawingException(e, DrawingConstant.PROP_CANNOT_CLOSE);
				}
			}
		}
		return this.getSetValue;
	}
	
	
	
}
