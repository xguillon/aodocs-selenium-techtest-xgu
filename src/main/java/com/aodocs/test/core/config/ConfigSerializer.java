/**
 * 
 */
package com.aodocs.test.core.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Xavier Guillon
 *
 */
public class ConfigSerializer {

	public Config deserialize(String filePath) throws IOException {
		String json = new String(Files.readAllBytes(Paths.get(filePath)));
		return Mapper.INSTANCE.getObjectMapper().readValue(json, Config.class);
	}

}
