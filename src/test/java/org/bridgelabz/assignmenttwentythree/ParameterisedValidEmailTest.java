package org.bridgelabz.assignmenttwentythree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/***
 * Parameterized tests make it possible to run a test multiple times with different arguments.
 * They are declared just like regular @Test methods but use the @ParameterizedTest annotation instead.
 * In addition, you must declare at least one source that will provide the arguments for each invocation and then consume the arguments in the test method.
 */

@RunWith(Parameterized.class)
public class ParameterisedValidEmailTest {
    private String emailTest;
    private boolean expectedResult;

    public ParameterisedValidEmailTest(String email, boolean expectedResult){
        this.emailTest = email;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection daata(){
        //Storing Samples and result in a 2D Array
        return Arrays.asList(new Object[][] {
                {"abc+100@yahoo.com", true},
                {"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc@gmail.com.com", true},
                {"abc", false},
                {"abc@.com.my", false},
                {"abc123@gmail.a", false},
                {"abc123@.com", false},
                {"abc123@.com.com", false},
                {".abc@abc.com", false},
                {"abc()*@gmail.com", false},
                {"abc..2002@gmail.com", false},
                {"abc.@gmail.com", false},
                {"abc@abc@gmail.com", false},
                {"abc@gmail.com.1a", false},
                {"abc@gmail.com.aa.au", false} } );
    }

    @Test
    public void givenEmailAsVarShouldReturnAsPeTheParameterizedResult(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddressParameterized(this.emailTest);
        Assert.assertEquals(this.expectedResult, result);
    }

}
