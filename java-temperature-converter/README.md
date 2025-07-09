# Temperature Converter

A Java console application that converts temperatures between Celsius and Fahrenheit with comprehensive error handling.

## Features

- **Interactive console interface**: User-friendly prompts and clear instructions
- **Bidirectional conversion**:
  - Celsius to Fahrenheit: °F = (°C × 9/5) + 32
  - Fahrenheit to Celsius: °C = (°F − 32) × 5/9
- **Precise output**: Results displayed with two decimal places
- **Robust error handling**:
  - Invalid numeric input validation
  - Invalid conversion type choice validation
  - Graceful error recovery
- **Continuous operation**: Option to perform multiple conversions
- **Additional features**: Warnings for extreme temperatures (absolute zero)

## Requirements

- Java JDK 8 or higher
- Terminal/Command prompt access

## How to Run

Navigate to this folder and run the following commands:

```bash
# Navigate to the temperature-converter folder
cd temperature-converter

# Compile the program
javac TemperatureConverter.java

# Run the program
java TemperatureConverter
```

## Usage Example

```text
=== Temperature Converter ===
Welcome to the Temperature Converter!

Enter the temperature value: 25

Select conversion type:
1. Celsius to Fahrenheit
2. Fahrenheit to Celsius
Enter your choice (1 or 2): 1

--- Conversion Result ---
25.00°C = 77.00°F

Would you like to perform another conversion? (y/n): y

Enter the temperature value: 32

Select conversion type:
1. Celsius to Fahrenheit
2. Fahrenheit to Celsius
Enter your choice (1 or 2): 2

--- Conversion Result ---
32.00°F = 0.00°C

Would you like to perform another conversion? (y/n): n

Thank you for using the Temperature Converter!
```

## Error Handling

The program handles various error scenarios:

- **Non-numeric temperature input**: Prompts user to enter a valid number
- **Invalid conversion choice**: Only accepts 1 or 2 as valid options
- **Invalid continue choice**: Only accepts y/yes or n/no responses
- **Extreme temperatures**: Provides warnings for temperatures at or below absolute zero

## Technical Details

- Uses `Scanner` class for user input
- Implements `InputMismatchException` handling for invalid numeric inputs
- Modular design with separate methods for each functionality
- Proper resource management with scanner cleanup
