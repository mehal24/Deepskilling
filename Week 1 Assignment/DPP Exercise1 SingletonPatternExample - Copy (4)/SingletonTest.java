public class SingletonTest {
    public static void main(String[] args) {
        // Attempt to get multiple instances of the Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the log method
        logger1.log("Application started.");
        logger2.log("Processing data.");

        // Verify that both references point to the exact same object in memory
        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 hold the same instance.");
        } else {
            System.out.println("Failure: Different instances exist.");
        }
    }
}
