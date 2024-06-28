import java.util.Scanner;
import java.io.IOException;
//Interacts with the user through text-based commands.
//Opens specified applications on the user's computer.
//Opens a web browser and searches for a specified query using a keyword.
//This implementation uses Java's ProcessBuilder to open applications and perform web searches.
public class ConsoleChatbot {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    	//main method
//    	Initializes the chatbot and greets the user.
//    	Continuously prompts the user for commands until they type "exit".
        System.out.println("Welcome to the Console Chatbot!");
        System.out.println("You can ask me to open applications or search the web.");
        
        while (true) {
            System.out.print("\nEnter a command (type 'exit' to quit): ");
            String command = scanner.nextLine();
            
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            
            handleCommand(command);
          
        }
    }
    //handle command method:
//  Checks if the command is to open an application or perform a web search.
//  Calls the appropriate method based on the command.
    
    private static void handleCommand(String command) {
        if (command.startsWith("open ")) {
            String application = command.substring(5).trim();
            openApplication(application);
        } else if (command.startsWith("search ")) {
            String query = command.substring(7).trim();
            openWebBrowserWithSearch(query);
        } else {
            System.out.println("Unknown command. Please use 'open <application>' or 'search <query>'.");
        }
    }
//    openapplication method:
//    Uses ProcessBuilder to open specified applications.
//    Currently supports Notepad and Calculator (can be extended for more applications).
    private static void openApplication(String application) {
        try {
            ProcessBuilder processBuilder = null;
            switch (application.toLowerCase()) {
                case "notepad":
                    processBuilder = new ProcessBuilder("notepad.exe");
                    break;
                case "calculator":
                    processBuilder = new ProcessBuilder("calc.exe");
                    break;
                default:
                    System.out.println("Application not recognized.");
                    return;
            }
            processBuilder.start();
            System.out.println(application + " opened successfully.");
        } catch (IOException e) {
            System.out.println("Error opening " + application + ": " + e.getMessage());
        }
    }
//    openWebBrowserWithSearch Method:
//
//    	Constructs a Google search URL from the query.
//    	Uses ProcessBuilder to open the default web browser with the search URL.
    
    private static void openWebBrowserWithSearch(String query) {
        try {
            String url = "https://www.google.com/search?q=" + query.replace(" ", "+");
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", url);
            processBuilder.start();
            System.out.println("Web browser opened with search query: " + query);
        } catch (IOException e) {
            System.out.println("Error opening web browser: " + e.getMessage());
        }
    }
}
