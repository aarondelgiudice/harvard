public class CalcBackend {
    private double total;
    private String currentInput;
    private char operator;
    private boolean clearNext;

    public CalcBackend() {
        total = 0.0;
        currentInput = "";
        operator = ' ';
        clearNext = true;
    }

    public void feedChar(char c) {
        if (Character.isDigit(c) || (c == '.' && !currentInput.contains("."))) {
            if (clearNext) {
                currentInput = "";
                clearNext = false;
            }
            currentInput += c;
        } else {
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    calculate();
                    operator = c;
                    clearNext = true;
                    break;
                case '=':
                    calculate();
                    operator = ' ';
                    clearNext = true;
                    break;
                case 'C':
                    clear();
                    break;
                case '√':
                    squareRoot();
                    break;
                case '±':
                    toggleSign();
                    break;
            }
        }
    }

    private void toggleSign() {
        if (!currentInput.isEmpty()) {
            if (currentInput.startsWith("-")) {
                currentInput = currentInput.substring(1);
            } else {
                currentInput = "-" + currentInput;
            }
        } else if (clearNext) {
            total = -total;
            currentInput = String.valueOf(total);
            clearNext = false;
        }
    }

    public String getDisplayVal() {
        if (!currentInput.isEmpty()) {
            return currentInput;
        }
        // Handle special case where total is NaN (division by zero error)
        if (Double.isNaN(total)) {
            return "Error";
        }
        return String.format("%.2f", total); // Format to 2 decimal places for display
    }

    private void clear() {
        total = 0.0;
        currentInput = "";
        operator = ' ';
        clearNext = true;
    }

    private void squareRoot() {
        if (!currentInput.isEmpty()) {
            total = Math.sqrt(Double.parseDouble(currentInput));
            currentInput = String.valueOf(total);
            clearNext = true;
        } else if (clearNext) {
            total = Math.sqrt(total);
            currentInput = String.valueOf(total);
        }
    }

    private void calculate() {
        if (!currentInput.isEmpty()) {
            double currentValue = Double.parseDouble(currentInput);
            if (operator != ' ') { // Ensure there is an operation to perform
                switch (operator) {
                    case '+':
                        total += currentValue;
                        break;
                    case '-':
                        total -= currentValue;
                        break;
                    case '*':
                        total *= currentValue;
                        break;
                    case '/':
                        if (currentValue != 0) {
                            total /= currentValue;
                        } else {
                            // Set error state
                            total = Double.NaN; // NaN (not a number) to indicate error
                            currentInput = ""; // Clear current input
                            return;
                        }
                        break;
                }
            } else {
                // If no operation has been performed yet, set the total to the current value
                total = currentValue;
            }
            // Prepare for the next number
            clearNext = true;
        }
        // After calculation, clear current input but show the total
        currentInput = "";
    }
}
