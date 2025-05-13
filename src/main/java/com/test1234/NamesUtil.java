package com.test1234;

public class NamesUtil
{
    public static boolean isNamePalindrome(String name)
    {
        StringBuilder reversedName = new StringBuilder(name);
        reversedName.reverse();
        return name.equalsIgnoreCase(reversedName.toString());
    }
}
