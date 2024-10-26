/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

/**
 *
 * @author ASUS
 */
public class Validator {
    public static String regexPhoneNumber = "[0-9]{10}";
    
    public static boolean CheckInput(String s, String regex){
        return s.matches(regex);
    }
}
