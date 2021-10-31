package org.bridgelabz.assignmenttwentythree;

@FunctionalInterface
public interface IMobileNumberValidator {
    boolean mobileValidator(String a) throws InvalidMobileNumberException;
}

