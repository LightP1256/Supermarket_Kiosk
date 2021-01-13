import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class adminLog extends JFrame {
    private JPanel mainPanel;
    private JPanel logDetailPnl;
    private JLabel titleLbl;
    private JTextField aUsernameTxf;
    private JTextField aPasswordTxf;
    private JLabel adminUsernameLbl;
    private JLabel adminPasswordLbl;
    private JButton LogBtn;
    static adminAcc[] adminAccounts = new adminAcc[1];
    public static void main(String[] args) {
        modelLoader modelLoader = new modelLoader();
        modelLoader.LogAdminAcc();
        launchAppCheckOut Page = new launchAppCheckOut();
        Page.setVisible(true);
        String filepath = ("resources//admin.txt");
        try {
            File file = new File(filepath);
            try (Scanner scanner = new Scanner(file)) {
                scanner.useDelimiter("\n");
                while (scanner.hasNextLine()) {
                    for (int i = 0; i < adminAccounts.length; i++) {
                        String aName = scanner.nextLine();
                        String aPass = scanner.nextLine();
                        adminAccounts[i] = new adminAcc(aName, aPass);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public adminLog() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 600));
        pack();
        LogBtn.addActionListener(e -> authAdmin(aUsernameTxf.getText(), aPasswordTxf.getText()));
    }
    public void authAdmin(String adminName, String adminPass) {
        boolean noMatch = true;
        for (int i = 0; i < adminAccounts.length; i++) {
            if (adminAccounts[i].username.equals(adminName) && adminAccounts[i].password.equals(adminPass)) {
                noMatch = false;
                break;
            }
        }
        // If there are no matches
        if (noMatch) {
            System.out.println("No match");
            JOptionPane.showMessageDialog(null, "No match, please try again ");
        }
        // If there is a match
        else {
            productSheet nextPage = new productSheet("Next Page");
            nextPage.setVisible(true);
            System.out.println("Logged in");
            JOptionPane.showMessageDialog(null, "Logged in");
        }
    }
}