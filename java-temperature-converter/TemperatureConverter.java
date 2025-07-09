import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Temperature Converter Console Program
 * Converts between Celsius and Fahrenheit with error handling
 */
public class TemperatureConverter {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Temperature Converter ===");
        System.out.println("Welcome to the Temperature Converter!");
        System.out.println();
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            try {
                // Get temperature input
                double temperature = getTemperatureInput();
                
                // Get conversion type
                int conversionType = getConversionType();
                
                // Perform conversion and display result
                performConversion(temperature, conversionType);
                
                // Ask if user wants to continue
                continueProgram = askToContinue();
                
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                System.out.println("Please try again.");
            }
            
            System.out.println(); // Add spacing between iterations
        }
        
        System.out.println("Thank you for using the Temperature Converter!");
        scanner.close();
    }
    
    /**
     * Gets temperature input from user with validation
     * @return valid temperature value
     */
    private static double getTemperatureInput() {
        while (true) {
            try {
                System.out.print("Enter the temperature value: ");
                double temperature = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return temperature;
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter a valid numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    /**
     * Gets conversion type from user with validation
     * @return 1 for Celsius to Fahrenheit, 2 for Fahrenheit to Celsius
     */
    private static int getConversionType() {
        while (true) {
            try {
                System.out.println("\nSelect conversion type:");
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.print("Enter your choice (1 or 2): ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.err.println("Error: Please enter 1 or 2 only.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter a valid number (1 or 2).");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    /**
     * Performs the temperature conversion and displays the result
     * @param temperature the input temperature
     * @param conversionType 1 for C to F, 2 for F to C
     */
    private static void performConversion(double temperature, int conversionType) {
        double result;
        String fromUnit, toUnit;
        
        if (conversionType == 1) {
            // Celsius to Fahrenheit: °F = (°C × 9/5) + 32
            result = (temperature * 9.0 / 5.0) + 32;
            fromUnit = "°C";
            toUnit = "°F";
        } else {
            // Fahrenheit to Celsius: °C = (°F − 32) × 5/9
            result = (temperature - 32) * 5.0 / 9.0;
            fromUnit = "°F";
            toUnit = "°C";
        }
        
        System.out.println("\n--- Conversion Result ---");
        System.out.printf("%.2f%s = %.2f%s%n", temperature, fromUnit, result, toUnit);
        
        // Additional information for extreme temperatures
        if (conversionType == 1 && temperature <= -273.15) {
            System.out.println("Note: This temperature is at or below absolute zero!");
        } else if (conversionType == 2 && temperature <= -459.67) {
            System.out.println("Note: This temperature is at or below absolute zero!");
        }
    }
    
    /**
     * Asks user if they want to perform another conversion
     * @return true to continue, false to exit
     */
    private static boolean askToContinue() {
        while (true) {
            System.out.print("\nWould you like to perform another conversion? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.err.println("Error: Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
}
