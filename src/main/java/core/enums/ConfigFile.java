package core.enums;

public enum ConfigFile {
	/**
	 * Data access file
	 */
	MYSQLSRV("mysqlsrv.properties"),
	
	/**
	 * Encryption configuration file
	 */
	ENCRYPT("encrypt.properties");

	
	/**
	 * Configuration file name
	 */
	private String var_string_fileName;
	
	/**
	 * Initialize a configuration file
	 * @param fileName file name
	 */
	private ConfigFile(String fileName) {
		this.var_string_fileName = fileName;
	}
}
