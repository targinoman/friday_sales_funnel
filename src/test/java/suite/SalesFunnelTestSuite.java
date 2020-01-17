package suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * This class is used to run all test classes
 * 
 * @author rstargino
 * 
 **/

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Friday Sales Funnel Test Suite")
@SelectPackages("tests")
public class SalesFunnelTestSuite {

}
