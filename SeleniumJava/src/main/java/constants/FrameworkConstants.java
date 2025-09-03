package constants;

public final class FrameworkConstants {
	private FrameworkConstants() {}
	
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	public static final String TEST_RESOURCES_PATH=PROJECT_PATH+"/src/test/resources";
	public static final String CONFIG_FILE_PATH=TEST_RESOURCES_PATH+"/config/config.properties";
	public static final String FEATURE_FILE_PATH=TEST_RESOURCES_PATH+"/feature";
	public static final String TEST_DATA_PATH=TEST_RESOURCES_PATH+"/testdata/";
	public static final String REPORTS_PATH=PROJECT_PATH+"/Reports/";
	public static final String SCREENSHOT_PATH=PROJECT_PATH+"/Screenshots/";
	
}
