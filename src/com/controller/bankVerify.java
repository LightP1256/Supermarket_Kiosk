import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class bankVerify extends JFrame {

    private JPanel mainPanel;
    private JLabel titleLbl;
    private JLabel detailsLbl;
    private JButton cPayBtn;
    public ArrayList<bankInfo> cBankVer = new ArrayList<>();
    public ArrayList<bankInfo> aviSheet() {
        return cBankVer;
    }
    public bankVerify() {
        modelLoader mModelLoader = new modelLoader();
        mModelLoader.logBankInfo();
        modelLoader.bInfoSave();
        cBankVer = mModelLoader.getArrayListBankInfo();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 600));
        pack();
        // Goes to pay receipt
        cPayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payReceipt Page = new payReceipt();
                Page.show();
            }
        });
    }
}
