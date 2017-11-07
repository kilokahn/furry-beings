package com.kilo.strings;

class DigitConverter {

    int convert(String input) {
        int length = input.length();
        int result = 0;
        for(int i = input.charAt(0) != '-' ? 0: 1; i < length; i++) {
            result = result * 10;
            int digit = input.charAt(i) - '0';
            result += digit;
        }
        return input.charAt(0) != '-' ? result : -result;
    }

    String convert(int input) {
        boolean isNegative = input < 0;
        input = Math.abs(input);
        StringBuilder sb = new StringBuilder();
        while(input != 0) {
            int digit = input %10;
            sb.append(digit);
            input = input / 10;
        }
        if(isNegative) {
            sb.append('-');
        }
        sb.reverse();
        if(sb.length() == 0 ) {
            sb.append('0');
        }
        return sb.toString();
    }

}
