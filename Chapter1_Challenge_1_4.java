import java.io.*; // For File, FileReader, BufferedReader

// Custom exception class for invalid config version
class InvalidConfigVersionException extends Exception {
    public InvalidConfigVersionException(String message) {
        super(message);
    }
}

public class Chapter1_Challenge_1_4 {
    public static void main(String[] args) {

        BufferedReader reader = null;

        try {
            // Step 1: Try to read the file config.txt
            File configFile = new File("config.txt");
            reader = new BufferedReader(new FileReader(configFile));

            // Step 2: Read the first line (config version)
            String versionLine = reader.readLine();
            int version = Integer.parseInt(versionLine);

            // Step 3: Check version validity
            if (version < 2) {
                throw new InvalidConfigVersionException(
                    "Config version too old!"
                );
            }

            // Step 4: Read the second line (file path)
            String filePath = reader.readLine();
            File pathFile = new File(filePath);

            if (!pathFile.exists()) {
                throw new IOException(
                    "Configured file path does not exist: " + filePath
                );
            }

            // If everything is fine
            System.out.println("Configuration loaded successfully!");
            System.out.println("Version: " + version);
            System.out.println("File path: " + filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: config.txt file not found.");

        } catch (InvalidConfigVersionException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println(
                "Error: The first line of config.txt must be a number."
            );

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println(
                "An unexpected error occurred: " + e.getMessage()
            );

        } finally {
            System.out.println("Config read attempt finished.");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file reader.");
            }
        }
    }
}
