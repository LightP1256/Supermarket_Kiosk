import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class modelLoader {
    // File path locations in resources
    public String filePathAdminAcc = "resources\\admin.txt";
    public String filePathBankInfo = "resources\\bankInfo.txt";
    public String filePathProductData = "resources\\stock.txt";
    // Split spacer
    public String spacer = "\\|";
    // Array for receipt
    public ArrayList<productData> pReceipt = new ArrayList<>();
    // Array for admin account
    public ArrayList<adminAcc> aAccount = new ArrayList<>();
    // Array for bank information
    private  static final ArrayList<bankInfo> cBankVer = new ArrayList<>();
    // Array for product data
    public ArrayList<productData> availableProduct = new ArrayList<>();
    // Getters
    public ArrayList<bankInfo> getArrayListBankInfo() {
        return cBankVer;
    }
    public ArrayList<productData> getArrayListProductData() {
        return availableProduct;
    }
    public void LogAdminAcc() {
        try {
            // Setting up file
            File file = new File(filePathAdminAcc);
            // Scanner to read each line within the file
            Scanner scanner = new Scanner(file);
            // Getting data from scanner
            while (scanner.hasNextLine()) {
                String columnRow = scanner.nextLine();
                String[] adAccount = columnRow.split(spacer);
                adminAcc admin = new adminAcc();
                admin.setUser(adAccount[0]);
                admin.setPass(adAccount[0]);
                aAccount.add(admin);
                System.out.println(admin);
            }
            // Close scanner when finished reading file
            scanner.close();
        }
        // Catches any errors
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void logBankInfo() {
        try {
            // Setting up file
            File file = new File(filePathBankInfo);
            // Scanner to read each line within the file
            Scanner scanner = new Scanner(file);
            // Getting data from scanner
            while (scanner.hasNextLine()) {
                String columnRow = scanner.nextLine();
                String[] userBankInfo = columnRow.split(spacer);
                System.out.println(userBankInfo[0]);
                bankInfo bUser = new bankInfo();
                bUser.setAccountName(userBankInfo[0]);
                int ageToInt = Integer.parseInt(userBankInfo[1]);
                bUser.setAge(ageToInt);
                float aBalanceToFloat = Float.parseFloat(userBankInfo[2]);
                bUser.setAccountBalance(aBalanceToFloat);
                boolean acAccount = Boolean.parseBoolean(userBankInfo[3]);
                bUser.setActiveAccount(acAccount);
                cBankVer.add(bUser);
            }
            // Close scanner when finished reading file
            scanner.close();
        }
        // Catches any errors
        catch (FileNotFoundException e) { // Finding any errors in the try section
            e.printStackTrace();
        }
    }

}