public class Logger {
    // Private static instance of the class
    private static Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Public static method to get the single instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A simple method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
