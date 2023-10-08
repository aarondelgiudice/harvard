public class BarCode {
    // data fields
    // 5 digit zip code
    // 32-char bar code ((5 digits + 1 check digit) * 5 bars per digit + 2 frame
    // bars = 32 chars)
    private String myZipCode;
    private String myBarCode;

    // constructor
    public BarCode(String input) {
        if (input.length() == 5) {
            // Takes a zip code as a parameter and stores it in myZipCode; then calls the
            // encode method to initialize myBarCode.
            if (isValidZipCode(input)) {
                this.myZipCode = input;
                this.myBarCode = encode(input);
            } else {
                throw new IllegalArgumentException("Illegal zip code values: " + input);
            }
        } else if (input.length() == 32) {
            // Takes a bar code as a parameter and stores it in myBarCode; then calls decode
            // to initialize myZipCode.
            if (isValidBarcode(input)) {
                this.myBarCode = input;
                this.myZipCode = decode(input);
            } else {
                throw new IllegalArgumentException("Illegal bar code values: " + input);
            }
        } else {
            // TODO: error handling
            throw new IllegalArgumentException(
                    "Illegal input values: " + input);
        }
    }

    // getter methods
    public String getZipCode() {
        return myZipCode;
    }

    public String getBarCode() {
        return myBarCode;
    }

    // helper methods
    private String digitToCode(int digit) {
        /*
         * Takes a digit 0-9 as a parameter and returns the five-character bar code
         * segment that represent the digit.
         * 0: "||:::"
         * 1: ":::||"
         * 2: "::|:|"
         * 3: "::||:"
         * 4: ":|::|"
         * 5: ":|:|:"
         * 6: ":||::"
         * 7: "|:::|"
         * 8: "|::|:"
         * 9: "|:|::"
         */
        // if (digit < 0 || digit > 9) {
        // System.out.println("Invalid digit. Expected 0-9. Received: " + digit);
        // }
        if (0 <= digit && digit <= 9) {
            switch (digit) {
                case 1:
                    return ":::||";
                case 2:
                    return "::|:|";
                case 3:
                    return "::||:";
                case 4:
                    return ":|::|";
                case 5:
                    return ":|:|:";
                case 6:
                    return ":||::";
                case 7:
                    return "|:::|";
                case 8:
                    return "|::|:";
                case 9:
                    return "|:|::";
                default:
                    // digit is 0
                    return "||:::";
            }
        } else
            return "";
    }

    private int codeToDigit(String barCodeSegment) {
        /*
         * takes a five-character bar code segment as a parameter and returns the
         * corresponding digit 0-9.
         * "||:::" = 0
         * ":::||" = 1
         * "::|:|" = 2
         * "::||:" = 3
         * ":|::|" = 4
         * ":|:|:" = 5
         * ":||::" = 6
         * "|:::|" = 7
         * "|::|:" = 8
         * "|:|::" = 9
         */
        // if (barCodeSegment.length() != 5) {
        // System.out.println("Invalid bar code segment. Expected 5 chars. Received: " +
        // barCodeSegment);
        // }
        if (barCodeSegment.length() == 5) {
            switch (barCodeSegment) {
                case ":::||":
                    return 1;
                case "::|:|":
                    return 2;
                case "::||:":
                    return 3;
                case ":|::|":
                    return 4;
                case ":|:|:":
                    return 5;
                case ":||::":
                    return 6;
                case "|:::|":
                    return 7;
                case "|::|:":
                    return 8;
                case "|:|::":
                    return 9;
                case "||:::":
                    return 0;
                default:
                    // barCodeSegment is not valid"
                    return -1;
            }
        } else
            return -1;
    }

    private boolean isValidBarcode(String barCode) {
        /*
         * checks the 32 symbol bar code (a String parameter) to determine if it is
         * valid. This method checks for correct delimiters, correct digit patterns,
         * etc. It returns a boolean value.
         */
        if (barCode.length() != 32) {
            System.out.println("invalid length");
            return false;
        }
        if (barCode.charAt(0) != '|' || barCode.charAt(31) != '|') {
            System.out.println("invalid frame bars");
            return false;
        }
        for (int i = 1; i < 31; i++) {
            if (barCode.charAt(i) != ':' && barCode.charAt(i) != '|') {
                System.out.println("invalid character at index " + i);
                return false;
            }
        }
        // check if check digit is valid
        // TODO: this should be its own function
        // String _barCode = barCode.substring(1, 26);
        String _checkDigit = barCode.substring(26, 31);
        int checkDigitActual = codeToDigit(_checkDigit);
        String _zipCode = "";
        for (int i = 1; i < 26; i += 5) {
            _zipCode += codeToDigit(barCode.substring(i, i + 5));
        }
        int checkDigitExpected = getCheckDigit(_zipCode);
        if (checkDigitActual != checkDigitExpected) {
            return false;
        }

        // all checks passed
        return true;
    }

    private boolean isValidZipCode(String zipCode) {
        /*
         * checks the 5 digit zip code (a String parameter) to determine if it is valid.
         * This method checks for correct length and valid digits. It returns a boolean
         * value.
         */
        if (zipCode.length() != 5) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (zipCode.charAt(i) < '0' || zipCode.charAt(i) > '9') {
                return false;
            }
        }

        // all checks passed
        return true;
    }

    private int getCheckDigit(String zipCode) {
        /*
         * returns the integer 0-9 that is necessary for the sum of the digits to equal
         * the next multiple of 10
         */
        int sum = 0;

        for (char digitChar : zipCode.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            sum += digit;
        }

        int checkDigit = 10 - (sum % 10);

        if (checkDigit == 10) {
            return 0;
        } else {
            return checkDigit;
        }
    }

    private String encode(String zipCode) {
        /*
         * tests the 5 digit zip code myZipCode and returns the 32 symbol barcode. It
         * should return the empty string “” if passed an invalid argument.
         */
        if (!isValidZipCode(zipCode)) {
            return "";
        }
        String barCode = "|";
        for (int i = 0; i < 5; i++) {
            barCode += digitToCode(zipCode.charAt(i) - '0');
        }
        barCode += digitToCode(getCheckDigit(zipCode)) + "|";
        return barCode;
    }

    private String decode(String barCode) {
        /*
         * tests the 32 symbol bar code myBarCode and returns the 5 digit zip code as a
         * String. If the bar code is invalid, this method also returns “” .
         */
        if (!isValidBarcode(barCode)) {
            return "";
        }
        String zipCode = "";
        for (int i = 1; i < 26; i += 5) {
            zipCode += codeToDigit(barCode.substring(i, i + 5));
        }
        return zipCode;
    }
}