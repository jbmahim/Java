public class Log {
    private static Log instance;
    private StringBuilder logData;

    private Log() {
        logData = new StringBuilder();
    }

    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }
    public String getLogData() {
        return logData.toString();
    }
    
    public void addLog(String message) {
        logData.append(message).append("\n");
    }

    public void displayLog() {
        System.out.println(logData.toString());
    }
}
