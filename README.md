

## Overview

This repository contains a Java application designed to process and analyze mobile device data from a CSV file. The program is built using Java, heavily object-oriented language and robust. Java is renowned for its portability and extensive library support.

## Language Choice: Java


Java was chosen for this project due to its robust object-oriented programming capabilities and static typing, which are essential for accurately modeling complex real-world entities and ensuring a structured approach to handling large-scale data. These features make Java particularly well-suited for developing applications that require rigorous data management and processing. Additionally, Java's comprehensive standard libraries support crucial operations such as file ingestion and data manipulation, which are fundamental to the core functionalities of this application. These libraries streamline the development process by providing well-tested, ready-to-use functions that enhance efficiency and reliability.

---


## Programming Features

### Object-Oriented Programming (OOP)
- **Description**: Leveraged Java's robust object-oriented programming capabilities to design modular and scalable software components. Classes like `Cell` encapsulate data and behavior related to mobile devices, utilizing inheritance to extend base functionality and polymorphism to handle varied behaviors through a unified interface.
- **Benefits**: Enhances code maintainability and makes the application easier to extend and modify over time.

### File Ingestion
- **Description**: Utilized the `java.io` package extensively for reading from and writing to CSV files. This is crucial for managing data persistence, allowing the application to process large datasets effectively.
- **Implementation**: Classes like `FileReader` and `BufferedReader` are used to read CSV files line-by-line, while `PrintWriter` and `FileWriter` are employed to output processed data back into CSV format.

### Conditional Statements
- **Description**: Employed `if` and `else` statements throughout the code to control the flow of execution based on different conditions, such as parsing different aspects of cell data or handling various file reading scenarios.
- **Benefits**: Allows for decision-making in the code, leading to dynamic execution paths and robust error handling.

### Assignment Statements
- **Description**: Used extensively for setting and updating the values of variables, important for storing intermediate data states and results from operations like data parsing and calculations.
- **Example**: Variables such as `launchYear` and `bodyWeight` are assigned values extracted and parsed from the CSV file lines.

### Loops
- **Description**: Implemented `for` and `while` loops to efficiently iterate over collections, such as lists and maps, which manage the application's core data structures.
- **Usage**: `for` loops iterate over `Map` entries to output data, and `while` loops are used in file reading to process each line until the end of the file is reached.

### Subprograms (Methods)
- **Description**: Developed methods like `processCsvFile` and `calculateAverageLaunchYear` to encapsulate specific functionalities, enhancing modularity and reusability of code.
- **Benefits**: Improves code organization and readability, simplifying both development and troubleshooting by isolating functionality into manageable sections.

### Exception Handling
- **Description**: Implemented robust exception handling using try-catch blocks to manage potential I/O errors during file operations, ensuring the application remains stable and can provide informative feedback on failures.
- **Example**: Try-catch blocks in `processCsvFile` gracefully handle `IOExceptions`, preventing the application from crashing due to file access issues.

---

## Libraries Used

### java.io
- **Purpose**: Enables file reading and writing, which is essential for data import and export operations within the application.
- **Key Classes Used**:
    - `FileReader`: Facilitates efficient reading of character files.
    - `BufferedReader`: Reads text from input streams, buffering characters to provide efficient reading of characters, arrays, and lines.
    - `IOException`: Handles errors arising from failed or interrupted I/O operations, ensuring the application can gracefully manage exceptions during file operations.

### java.util
- **Purpose**: Provides a collection of utility classes that are fundamental for handling data structures and performing system operations.
- **Key Classes Used**:
    - `HashMap`: Offers a map implementation based on a hash table. It's used extensively for efficient mapping of keys to values which is crucial for indexing and quick data retrieval.
    - `ArrayList`: Implements a resizable-array, which is used to store lists of objects that need frequent insertion and removal.
    - `List`: An interface providing a protocol for collections that maintain an ordered sequence of elements.
    - `Comparator`: A comparison function, which imposes a total ordering on some collection of objects, often used to sort or prioritize data.
    - `Optional`: Containers that may or may not contain a non-null value, used to represent nullable with absent values potentially reducing `NullPointerExceptions`.
    - `Collectors`: Implementations of various useful reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.

### java.util.regex
- **Purpose**: Provides classes for pattern matching, using regular expressions, which are used for searching, extracting, and manipulating text.
- **Key Classes Used**:
    - `Pattern`: Represents a compiled representation of a regular expression.
    - `Matcher`: An engine that interprets the pattern and performs match operations against an input string.

---
## Conclusion

 By utilizing Java's extensive standard libraries and robust object-oriented programming capabilities, we have successfully created a scalable and efficient solution for managing and interpreting mobile device data. The application not only adheres to best practices in software development but also leverages Java's strengths in handling large-scale data operations efficiently.

Through well-structured code and comprehensive use of Java features such as exception handling, loops, conditional and assignment statements, and subprograms, the project ensures code readability, maintainability, and reusability. Each component has been carefully crafted to contribute to the overall functionality, allowing for easy modifications and enhancements in the future.

