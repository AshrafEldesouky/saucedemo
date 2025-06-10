package utilities;


import java.io.*;
import java.util.Random;

public class utility {


    //1. Method to generate a random FirstName
    private static final String[] Get_NAMES = {
            "James", "Mary", "John", "Patricia", "Robert",
            "Jennifer", "Michael", "Linda", "William", "Elizabeth",
            "David", "Barbara", "Richard", "Susan", "Joseph",
            "Jessica", "Thomas", "Sarah", "Charles", "Karen"
    };

    //1. Method to generate a random FirstName
    public static String generateRandomFirstName() {
        Random random = new Random();
        int index = random.nextInt(Get_NAMES.length);
        return Get_NAMES[index];
    }


    //2. Method to generate a random FirstName
    public static String generateRandomLastName() {
        Random random = new Random();
        int index = random.nextInt(Get_NAMES.length);
        return Get_NAMES[index];
    }

    //3. Method to generate a random Postalcode
    public static String generatePostalCode() {
        Random random = new Random();
        int postalCode = random.nextInt(100000); // 0 to 99999
        return String.format("%05d", postalCode); // pad with leading zeros if needed
    }

        // TODO: start html report
    public static void startHtmlReport(String reportDirName, String reportFileName) throws IOException {
        String path = System.getProperty("user.dir") + "/testReport.html";
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd " + reportDirName + " && " + reportFileName);
        builder.redirectErrorStream(true);
        Process p = builder.start();
    }
}
