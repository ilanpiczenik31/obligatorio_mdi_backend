"""
Temperature Converter Console Program
Converts between Celsius and Fahrenheit with error handling
"""

def get_temperature_input():
    """
    Gets temperature input from user with validation
    Returns: valid temperature value
    """
    while True:
        try:
            temperature = float(input("Enter the temperature value: "))
            return temperature
        except ValueError:
            print("Error: Please enter a valid numeric value.")

def get_conversion_type():
    """
    Gets conversion type from user with validation
    Returns: 1 for Celsius to Fahrenheit, 2 for Fahrenheit to Celsius
    """
    while True:
        try:
            print("\nSelect conversion type:")
            print("1. Celsius to Fahrenheit")
            print("2. Fahrenheit to Celsius")
            
            choice = int(input("Enter your choice (1 or 2): "))
            
            if choice == 1 or choice == 2:
                return choice
            else:
                print("Error: Please enter 1 or 2 only.")
        except ValueError:
            print("Error: Please enter a valid number (1 or 2).")

def perform_conversion(temperature, conversion_type):
    """
    Performs the temperature conversion and displays the result
    Args:
        temperature: the input temperature
        conversion_type: 1 for C to F, 2 for F to C
    """
    if conversion_type == 1:
        # Celsius to Fahrenheit: °F = (°C × 9/5) + 32
        result = (temperature * 9.0 / 5.0) + 32
        from_unit = "°C"
        to_unit = "°F"
    else:
        # Fahrenheit to Celsius: °C = (°F − 32) × 5/9
        result = (temperature - 32) * 5.0 / 9.0
        from_unit = "°F"
        to_unit = "°C"
    
    print("\n--- Conversion Result ---")
    print(f"{temperature:.2f}{from_unit} = {result:.2f}{to_unit}")
    
    # Additional information for extreme temperatures
    if conversion_type == 1 and temperature <= -273.15:
        print("Note: This temperature is at or below absolute zero!")
    elif conversion_type == 2 and temperature <= -459.67:
        print("Note: This temperature is at or below absolute zero!")

def ask_to_continue():
    """
    Asks user if they want to perform another conversion
    Returns: True to continue, False to exit
    """
    while True:
        response = input("\nWould you like to perform another conversion? (y/n): ").strip().lower()
        
        if response in ["y", "yes"]:
            return True
        elif response in ["n", "no"]:
            return False
        else:
            print("Error: Please enter 'y' for yes or 'n' for no.")

def main():
    """Main program function"""
    print("=== Temperature Converter ===")
    print("Welcome to the Temperature Converter!")
    print()
    
    continue_program = True
    
    while continue_program:
        try:
            # Get temperature input
            temperature = get_temperature_input()
            
            # Get conversion type
            conversion_type = get_conversion_type()
            
            # Perform conversion and display result
            perform_conversion(temperature, conversion_type)
            
            # Ask if user wants to continue
            continue_program = ask_to_continue()
            
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
            print("Please try again.")
        
        print()  # Add spacing between iterations
    
    print("Thank you for using the Temperature Converter!")

if __name__ == "__main__":
    main()