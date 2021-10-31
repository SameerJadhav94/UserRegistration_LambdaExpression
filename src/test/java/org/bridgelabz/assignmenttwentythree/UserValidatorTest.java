package org.bridgelabz.assignmenttwentythree;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;


public class UserValidatorTest {

    @Test
    public void givenFirstNameWhenProperShouldReturnTrue() {
        IValidator validator = firstName ->{
            String firstNamePattern = "^[A-Z][a-z]{2,}$"; //regex
            Pattern pattern = Pattern.compile(firstNamePattern);
            if (!pattern.matcher(firstName).matches()){
                throw new InvalidUserInputException();
            }
            return pattern.matcher(firstName).matches();
        };
        try {
            boolean result = validator.validator("Sameer");
            assertTrue(result);
        }catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenLastNameWhenProperShouldReturnTrue() {
        IValidator validator = lastName ->{
            String lastNamePattern = "^[A-Z][a-z]{2,}$"; //regex
            Pattern pattern = Pattern.compile(lastNamePattern);
            if (!pattern.matcher(lastName).matches()){
                throw new InvalidUserInputException();
            }
            return pattern.matcher(lastName).matches();
        };
        try {
            boolean result = validator.validator("Jadhav");
            Assert.assertTrue(result);
        }catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenEmailIDeWhenValidShouldReturnTrue() {
        IValidator validator = email ->{
            String emailIDPattern = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$"; //regex
            Pattern pattern = Pattern.compile(emailIDPattern);
            if (!pattern.matcher(email).matches()){
                throw new InvalidUserInputException();
            }
            return pattern.matcher(email).matches();
        };
        try{
            boolean result = validator.validator("abc+100@yahoo.com");
            Assert.assertTrue(result);
        }catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenMobileNumberWhenValidFormatShouldReturnTrue() {
        IMobileNumberValidator validator = mobile ->{
            String mobileNumberPattern = "(0|91)*[ ][7-9][0-9]{9}"; //regex
            Pattern pattern = Pattern.compile(mobileNumberPattern);
            if (!pattern.matcher(mobile).matches()){
                throw new InvalidMobileNumberException();
            }
            return pattern.matcher(mobile).matches();
        };
        try {
            boolean result = validator.mobileValidator("0 7568 438745");
            Assert.assertTrue(result);
        }catch (InvalidMobileNumberException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void givenPasswordWhenValidPattern1ShouldReturnTrue() {
        IPassword1Validator validator = pass1 ->{
            String passwordPattern1 = "^[a-zA-Z]{8,}$"; //regex
            Pattern pattern = Pattern.compile(passwordPattern1);
            if (!pattern.matcher(pass1).matches()){
                throw new InvalidPasswordException1();
            }
            return pattern.matcher(pass1).matches();
        };
        try {
            boolean result = validator.pass1Validator("PassWordSam");
            Assert.assertTrue(result);
        }catch (InvalidPasswordException1 e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenPasswordWhenValidPattern2ShouldReturnTrue() {
        IPassword2Validator validator = pass2 ->{
            String passwordPattern2 = "^(?=.*[A-Z])[A-Za-z]{8,}$"; //regex
            Pattern pattern = Pattern.compile(passwordPattern2);
            if (!pattern.matcher(pass2).matches()){
                throw new InvalidPasswordException2();
            }
            return pattern.matcher(pass2).matches();
        };
        try {
            boolean result = validator.pass2Validator("passwordSam");
            Assert.assertTrue(result);
        }catch (InvalidPasswordException2 e){
            System.out.println(e.getMessage());
        }

    }

    //Handled With Custom Exception
    @Test
    public void givenPasswordWhenValidPattern3ShouldReturnTrue() {
        IPassword3Validator validator = pass3 ->{
            String passwordPattern3 = "^(?=.*[0-9])(?=.*[A-Z])[A-Za-z0-9]{8,}$"; //regex
            Pattern pattern = Pattern.compile(passwordPattern3);
            if (!pattern.matcher(pass3).matches()){
                throw new InvalidPasswordException3();
            }
            return pattern.matcher(pass3).matches();
        };
        try {
            boolean result = validator.pass3Validator("pas swordSam19");
            Assert.assertTrue(result);
        }catch (InvalidPasswordException3 e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void givenPasswordWhenValidPattern4ShouldReturnTrue() {
        IPassword4Validator validator = pass4 ->{
            String passwordPattern4 = "^(?=.*[0-9])(?=.*[A-Z])(?=.*([$&+,:;=?@#|/'<>.^*()%!-]))(?=.{8,}$).*$"; //regex
            Pattern pattern = Pattern.compile(passwordPattern4);
            if (!pattern.matcher(pass4).matches()){
                throw new InvalidPasswordException4();
            }
            return pattern.matcher(pass4).matches();
        };
        try {
            boolean result = validator.pass4Validator("Sameer@@1994");
            Assert.assertTrue(result);
        }catch (InvalidPasswordException4 e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void givenEmailIDSamplesWhenValidShouldReturnTrue() {
        IValidator validator = email ->{
            String emailIDPattern = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$"; //regex
            Pattern pattern = Pattern.compile(emailIDPattern);
            if (!pattern.matcher(email).matches()){
                throw new InvalidUserInputException();
            }
            return pattern.matcher(email).matches();
        };
        try {
            boolean result1 = validator.validator("abc+100@yahoo.com");
            boolean result2 = validator.validator("abc@yahoo.com");
            boolean result3 = validator.validator("abc-100@yahoo.com");
            boolean result4 = validator.validator("abc.100@yahoo.com");
            boolean result5 = validator.validator("abc111@abc.com");
            boolean result6 = validator.validator("abc-100@abc.net");
            boolean result7 = validator.validator("abc.100@abc.com.au");
            boolean result8 = validator.validator("abc@1.com");
            boolean result9 = validator.validator("abc@gmail.com.com");
            boolean[] test = {result1, result2, result3, result4, result5, result6, result7, result8, result9};
            for (boolean element : test) {
                Assert.assertTrue(element);
            }
        }catch (InvalidUserInputException e){
            System.out.println(e.getMessage());
        }

    }
}
