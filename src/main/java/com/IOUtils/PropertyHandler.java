
package com.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Provides means of reading property files and get the runtime properties.
 */
public class PropertyHandler {

	/** The property file name. */
	private String propertyFileName;

	/** The property object. */
	private Properties props;

	/**
	 * Instantiates a new property handler.
	 * 
	 * @param propertyFile
	 *            the property file
	 */
	public PropertyHandler(final String propertyFile) {
		initLocations(propertyFile);
	}

	/**
	 * Inits the locations.
	 * 
	 * @param propertyFile
	 *            the property file
	 */
	private void initLocations(final String propertyFile) {

		propertyFileName = propertyFile;
	}

	/**
	 * Gets the runtime property.
	 * 
	 * @param key
	 *            the key
	 * @return the runtime property
	 */
	public final String getRuntimeProperty(final String key) {

		FileInputStream fis = null;
		String value = "";

		try {
			fis = new FileInputStream(new File(propertyFileName));
			props = new Properties();
			props.load(fis);
			value = props.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	/**
	 * Sets the run time property.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public final void setRuntimeProperty(final String key, final String value) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(propertyFileName);
			props = new Properties();
			props.setProperty(key, value);
			props.store(fos, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Gets the property object.
	 * 
	 * @return the property object
	 */
	public final Properties getPropertyObject() {
		return props;
	}
}
