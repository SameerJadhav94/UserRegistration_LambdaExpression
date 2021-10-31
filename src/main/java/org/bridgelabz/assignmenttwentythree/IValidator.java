package org.bridgelabz.assignmenttwentythree;

@FunctionalInterface
public interface IValidator {
    boolean validator(String a) throws InvalidUserInputException;
}
