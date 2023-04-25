/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

// ./gradlew run --args "input output transform"
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {

        System.out.println(new App().getGreeting());
        System.out.println(System.getProperty("user.dir"));
        linterJS("gates.js");
    }

    public static void getFile() {

    }

    // Need a method to lint files
    public static void linterJS(String fileToBeRead) throws IOException {
        // Get a Path to the file
        Path fileToBeLinted = Path.of(fileToBeRead);
        String errorMessage = "";
        int lineNumber = 0;
        //Scanner
        try (Scanner fileScanner = new Scanner(fileToBeLinted);) {
            // check if line ends with a semicolon
            // don't show an error if the line is empty
            // don't show an error if the line ends with an opening curly brace
            // don't show an error if the line ends with a closing curly brace
            // don't show an error if the line contains if, or else
            // while file hasNextLine
            while (fileScanner.hasNextLine()) {
                // grab current line
                String currentLine = fileScanner.nextLine();
                // increment line number
                lineNumber++;
                // check for !endsWith(";")
                if (!currentLine.endsWith(";")) {
                    // check other conditions
                    if (currentLine.isEmpty() || currentLine.endsWith("{") || currentLine.endsWith("}") || currentLine.contains("if") || currentLine.contains("else")) {
                        continue;
                        // do nothing
                    }
                }
                // if all false, print error message
                errorMessage += "Line " + lineNumber + ": Missing semicolon.\n";
                System.out.println(errorMessage);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
