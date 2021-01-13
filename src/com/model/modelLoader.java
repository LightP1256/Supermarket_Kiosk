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
    // Array for Receipt
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
            File file = new File(filePathAdminAcc);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String columnRow = scanner.nextLine();
                String[] adAccount = columnRow.split(spacer);
                adminAcc admin = new adminAcc();
                admin.setUser(adAccount[0]);
                admin.setPass(adAccount[0]);
                aAccount.add(admin);
                System.out.println(admin);
            }
        scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
