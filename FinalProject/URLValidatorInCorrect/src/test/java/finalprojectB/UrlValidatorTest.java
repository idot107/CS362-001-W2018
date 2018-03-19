
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {

    public UrlValidatorTest(String testName) {
        super(testName);
    }


    UrlValidator checkValid = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);


    public void testManualTest() {
        StringBuilder testBuffer = new StringBuilder();

    }
    public void testMV00() { assertFalse(checkValid.isValid(null)); }
    public void testMV01() { assertTrue(checkValid.isValid("http://www.google.com")); }
    public void testMV11() { assertTrue(checkValid.isValid("http://www.google.com/")); }
    public void testMVU() { assertFalse(checkValid.isValid("http://.com")); }
    public void testMV02() { assertTrue(checkValid.isValid("http://google.com")); }
    public void testMV03() { assertFalse(checkValid.isValid("http:google.com")); }
    public void testMVU2() { assertFalse(checkValid.isValid("HTTP:GOOGLE.COM")); }
    public void testMV04() { assertFalse(checkValid.isValid("http://www.google.com~")); }
    public void testMV05() { assertTrue(checkValid.isValid("ftp://0.0.0.0:0?action=edit&mode=up")); }
    public void testMV06() { assertTrue(checkValid.isValid("ftp://www.google.com")); }

    public void testRP01() {
        ResultPair t0 = new ResultPair("hello",true);
        assertEquals("hello", t0.item);
    }
    public void testRP02() {
        ResultPair t0 = new ResultPair("hello",true);
        assertEquals(true, t0.valid);
    }
    public void testRP03() {
        ResultPair t0 = new ResultPair("hello",false);
        assertEquals(false, t0.valid);
    }


    //You need to create more test cases for your Partitions if you need to
    public void testURLSchemePartition(){
        boolean passed = true;
        for (ResultPair p : testUrlScheme ){
            if(p.item == ""){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(p.item);
            sb.append("www.google.com");
            if(p.valid != checkValid.isValid(sb.toString())){
                System.out.println("ERROR Scheme: " + p.item);
                passed = false;
            }
        }
        assertTrue(passed);
    }
    public void testAuthorityPartition(){
        boolean passed = true;
        for (ResultPair p : testUrlAuthority ){
            StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(p.item);
            if(p.valid != checkValid.isValid(sb.toString())){
                System.out.println("ERROR Authority: " + p.item);
                passed = false;
            }
        }
        assertTrue(passed);
    }
    public void testPortPartition(){
        boolean passed = true;
        for (ResultPair p : testUrlPort ){
            StringBuilder sb = new StringBuilder();
            sb.append("ftp://0.0.0.0");
            sb.append(p.item);
            if(p.valid != checkValid.isValid(sb.toString())){
                System.out.println("ERROR Port: " + p.item);
                passed = false;
            }
        }
        assertTrue(passed);
    }
    public void testPathPartition(){
        boolean passed = true;
        for (ResultPair p : testPath ){
            StringBuilder sb = new StringBuilder();
            sb.append("http://www.google.com");
            sb.append(p.item);
            if(p.valid != checkValid.isValid(sb.toString())){
                System.out.println("ERROR Pathy: " + p.item);
                passed = false;
            }
        }
        assertTrue(passed);
    }
    /*/
    public void testPathOptionsPartition(){
        boolean passed = true;
        for (ResultPair p : testUrlPathOptions ){
            StringBuilder sb = new StringBuilder();
            sb.append("http://www.google.com");
            sb.append(p.item);
            if(p.valid != checkValid.isValid(sb.toString())){
                System.out.println("ERROR PathOption: " + p.item);
                passed = false;
            }
        }
        assertTrue(passed);
    }
    /**/
    /*/
    public void testQueryPartition(){
        boolean passed = true;
        for (ResultPair p : testUrlQuery ){
            StringBuilder sb = new StringBuilder();
            sb.append("ftp://0.0.0.0:0");
            sb.append(p.item);
            if(p.valid != checkValid.isValid(p.item)){
                System.out.println("ERROR Query: " + p.item);
                passed = false;
            }
        }
        assertTrue(passed);
    }
    /**/

    public void testIsValid()
    {
        //You can use this function for programming based testing
        boolean doPass = true;
        for (ResultPair S : testUrlScheme){
            StringBuilder sb = new StringBuilder();
            boolean expected = S.valid;
            sb.append(S.item);

            for (ResultPair A : testUrlAuthority){
                sb.append(A.item);
                if ( A.valid == false) {
                    expected = false;
                }
                for (ResultPair Port : testUrlPort){
                    sb.append(Port.item);
                    if ( Port.valid == false) {
                        expected = false;
                    }
                    for (ResultPair Path : testPath) {
                        sb.append(Path.item);
                        if ( Path.valid == false) {
                            expected = false;
                        }
                        if(!(expected == checkValid.isValid(sb.toString()))){
                            System.out.println("ERROR DETECTED IN: " + sb.toString());
                            doPass = false;
                        }
                    }
                }
            }
        }
        assertTrue(doPass);
    }

    ResultPair[] testUrlScheme = {new ResultPair("http://", true),
            new ResultPair("ftp://", true),
            new ResultPair("h3t://", true),
            new ResultPair("3ht://", false),
            new ResultPair("http:/", false),
            new ResultPair("http:", false),
            new ResultPair("http/", false),
            new ResultPair("://", false),
            new ResultPair("", true)};

    ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
            new ResultPair("go.com", true),
            new ResultPair("go.au", true),
            new ResultPair("0.0.0.0", true),
            new ResultPair("255.255.255.255", true),
            new ResultPair("256.256.256.256", false),
            new ResultPair("255.com", true),
            new ResultPair("1.2.3.4.5", false),
            new ResultPair("1.2.3.4.", false),
            new ResultPair("1.2.3", false),
            new ResultPair(".1.2.3.4", false),
            new ResultPair("go.a", false),
            new ResultPair("go.a1a", false),
            new ResultPair("go.1aa", false),
            new ResultPair("aaa.", false),
            new ResultPair(".aaa", false),
            new ResultPair("aaa", false),
            new ResultPair("", false)
    };
    ResultPair[] testUrlPort = {new ResultPair(":80", true),
            new ResultPair(":65535", true),
            new ResultPair(":0", true),
            new ResultPair("", true),
            new ResultPair(":-1", false),
            new ResultPair(":65636",false),
            new ResultPair(":65a", false)
    };
    ResultPair[] testPath = {new ResultPair("/test1", true),
            new ResultPair("/t123", true),
            new ResultPair("/$23", true),
            new ResultPair("/..", false),
            new ResultPair("/../", false),
            new ResultPair("/test1/", true),
            new ResultPair("", true),
            new ResultPair("/test1/file", true),
            new ResultPair("/..//file", false),
            new ResultPair("/test1//file", false)
    };
    //Test allow2slash, noFragment
    ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
            new ResultPair("/t123", true),
            new ResultPair("/$23", true),
            new ResultPair("/..", false),
            new ResultPair("/../", false),
            new ResultPair("/test1/", true),
            new ResultPair("/#", false),
            new ResultPair("", true),
            new ResultPair("/test1/file", true),
            new ResultPair("/t123/file", true),
            new ResultPair("/$23/file", true),
            new ResultPair("/../file", false),
            new ResultPair("/..//file", false),
            new ResultPair("/test1//file", true),
            new ResultPair("/#/file", false)
    };

    ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
            new ResultPair("?action=edit&mode=up", true),
            new ResultPair("", true)
    };

    Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
    Object[] testUrlPartsOptions = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPathOptions, testUrlQuery};
    int[] testPartsIndex = {0, 0, 0, 0, 0};

    //---------------- Test data for individual url parts ----------------
    ResultPair[] testScheme = {new ResultPair("http", true),
            new ResultPair("ftp", false),
            new ResultPair("httpd", false),
            new ResultPair("telnet", false)};

}
