package com.irandoo.xhep.base.util;

import java.util.Properties;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import abu.crypto.Base64Util;

import com.huawei.bme.commons.encryption.EncryptTool;
import com.irandoo.base.crypto.Randoo3DES;
/**
 * 
 * @author ager
 * @version 1.0
 */
public class PropertyPlaceholderConfigurerEx extends
		PropertyPlaceholderConfigurer {

	private boolean secutiry = false;

	private EncryptTool eTool = new EncryptTool();

	protected String resolvePlaceholder(String placeholder, Properties props) {

		String placeholderValue = props.getProperty(placeholder);

		if (this.secutiry) {

			if (placeholder.equals("dbpass")) {
				Randoo3DES randoo3Des = new Randoo3DES();
				try {
					placeholderValue = new String(randoo3Des.decrypt(Base64Util.decode(placeholderValue)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return placeholderValue;

	}


	public boolean isSecutiry() {

		return secutiry;

	}

	public void setSecutiry(boolean secutiry) {

		this.secutiry = secutiry;

	}

	private String deEncrypt(String miwen) {

		String mingwen = "";
		
		try {
			
			mingwen = eTool.parseEncrypt(miwen);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return mingwen;

	}

}
