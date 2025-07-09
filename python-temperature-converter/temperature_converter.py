"""Temperature Converter Console Program
Converts between Celsius and Fahrenheit with error handling.
"""

def get_temperature_input():
    while True:
        try:
            value = float(input("Enter the temperature value: "))
            return value
        except ValueError:
            print("Error: Please enter a valid numeric value.")


def get_conversion_type():
    while True:
        print("\nSelect conversion type:")
        print("1. Celsius to Fahrenheit")
        print("2. Fahrenheit to Celsius")
        choice = input("Enter your choice (1 or 2): ")
        if choice in ("1", "2"):
            return int(choice)
        else:
            print("Error: Please enter 1 or 2 only.")


def perform_conversion(temperature, conversion_type):
    if conversion_type == 1:
        result = (temperature * 9.0 / 5.0) + 32
        from_unit = "°C"
        to_unit = "°F"
    else:
        result = (temperature - 32) * 5.0 / 9.0
        from_unit = "°F"
        to_unit = "°C"

    print("\n--- Conversion Result ---")
    print(f"{temperature:.2f}{from_unit} = {result:.2f}{to_unit}")

    if conversion_type == 1 and temperature <= -273.15:
        print("Note: This temperature is at or below absolute zero!")
    elif conversion_type == 2 and temperature <= -459.67:
        print("Note: This temperature is at or below absolute zero!")


def ask_to_continue():
    while True:
        response = input("\nWould you like to perform another conversion? (y/n): ").strip().lower()
        if response in ("y", "yes"):
            return True
        elif response in ("n", "no"):
            return False
        else:
            print("Error: Please enter 'y' for yes or 'n' for no.")


def main():
    print("=== Temperature Converter ===")
    print("Welcome to the Temperature Converter!\n")

    continue_program = True
    while continue_program:
        try:
            temperature = get_temperature_input()
            conversion_type = get_conversion_type()
            perform_conversion(temperature, conversion_type)
            continue_program = ask_to_continue()
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
            print("Please try again.")
        print()

    print("Thank you for using the Temperature Converter!")


if __name__ == "__main__":
    main()
