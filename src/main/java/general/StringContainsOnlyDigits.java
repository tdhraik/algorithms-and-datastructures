package main.java.general;

public class StringContainsOnlyDigits {

    public static void main(String[] args) {
        String inputStr = "Check if there is any digit like 1 or 2";
        System.out.println(inputStr.chars().anyMatch(Character::isDigit));
    }
}
