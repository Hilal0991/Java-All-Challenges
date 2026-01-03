🔍 What the Program Does

1.Reads config.txt

-First line: Expected to be an integer config version.

-Second line: Expected to be a file path.

2.Validates the Config Version

-Accepts version 2 or higher.

-Throws a custom exception (InvalidConfigVersionException) if version is too old.

3.Validates File Path

-Checks if the file at the given path exists.

-Throws a built-in IOException if the file is missing.

4.Handles All Major Errors Gracefully

-FileNotFoundException if config.txt is missing.

-NumberFormatException if version is not a number.

-IOException for invalid file paths.

-A generic catch-all Exception for any unexpected issues.

🛠 Key Concepts Demonstrated

-File I/O with BufferedReader, FileReader

-Custom exceptions via InvalidConfigVersionException

-Exception handling hierarchy with try-catch-finally

-Defensive programming and robust error reporting