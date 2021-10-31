package org.bridgelabz.assignmenttwentythree;

import java.util.regex.Pattern;

/***
 * @author Sameer Jadhav
 * @version 16.0.2
 * @since 2021.11.31
 */

//Created Custom Exceptions To Handle Different Exceptions
class InvalidUserInputException extends Exception {
    @Override
    public String getMessage(){
        return "Please Enter Valid Inputs.";
    }
}
class InvalidMobileNumberException extends Exception {
    @Override
    public String getMessage(){
        return "Mobile Number Should Start With Country Code Followed By Space" + " " + "And Then Number.";
    }
}
class InvalidPasswordException1 extends Exception {
    @Override
    public String getMessage(){
        return "Password Must Contain Minimum 8 Characters.";
    }
}
class InvalidPasswordException2 extends Exception {
    @Override
    public String getMessage(){
        return "Password Must Contain Minimum 8 Characters: Mandatory Fields-> 1 Upper Case.";
    }
}
class InvalidPasswordException3 extends Exception {
    @Override
    public String getMessage(){
        return "Password Must Contain Minimum 8 Characters: Mandatory Fields-> 1 Upper Case, 1 Numeric.";
    }
}
class InvalidPasswordException4 extends Exception {
    @Override
    public String getMessage(){
        return "Password Must Contain Minimum 8 Characters: Mandatory Fields-> 1 Upper Case, 1 Numeric, 1 Special.";
    }
}

public class UserValidator {

    private static final String emailIDPattern = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$"; //regex

    /***
     * @description ->  A regular expression, specified as a string, must first be compiled into an instance of this class.
     * The resulting pattern can then be used to create a Matcher object that can match arbitrary character sequences against the regular expression.
     * All of the state involved in performing a match resides in the matcher.
     * @param email Parameterized
     * @return
     */

    public boolean validateEmailAddressParameterized(String email){
        Pattern pattern8 = Pattern.compile(emailIDPattern);
        return pattern8.matcher(email).matches();
    }
}
