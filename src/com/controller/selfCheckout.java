import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class selfCheckout extends JFrame {
    private JPanel mainPanel;
    private JLabel payTitleLbl;
    private JButton adminBtn;
    private JLabel productsScannedLbl;
    private JTextArea productListTxa;
    private JButton addProductBtn;
    private JTextField addPTxf;
    private JLabel totalLbl;
    private JLabel totalCostLbl;
    private JButton cardPayBtn;
    private JButton cashPayBtn;
    private JLabel cAmountLbl;
    private JTextField cTAmountTxf;
    private JLabel changeLbl;
    private JLabel changeAmountLbl;
    public static HashMap<productData, Integer> hMap = new HashMap<>();
    private float tPrice;
    public static ArrayList<productData> stockLevel = new ArrayList<>();
    public selfCheckout() {
        System.out.println("service");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 600));
        pack();
        modelLoader modelLoader = new modelLoader();
        modelLoader.logProduct();
        stockLevel = modelLoader.getArrayListProductData();
        System.out.println();
        adminBtn.addActionListener(new ActionListener() {
            @Override
            // Goes to admin login page
            public void actionPerformed(ActionEvent e) {
                adminLog Page = new adminLog();
                Page.setVisible(true);
                dispose();
            }
        });
        // Card Button
        cardPayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Goes to bank verify page
                bankVerify Page = new bankVerify();
                Page.show();
                dispose();
            }
        });
        // Cash option on screen payment
        cashPayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float pTotal = Float.parseFloat(cTAmountTxf.getText()) - Float.parseFloat(totalCostLbl.getText());
                changeAmountLbl.setText(String.valueOf(pTotal));
            }
        });
        // Adding products to list with price and amount
        addProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productListTxa.setText("");
                String pName = addPTxf.getText();
                // Map keys to values
                for (productData p : hMap.keySet()) {
                    System.out.println(p.pName + ":" + pName);
                    if (p.pName.equals(pName)) {
                        hMap.put(p, hMap.get(p) + 1);
                    }
                }
                double pTotal = 0.0;
                // Map keys to values
                for (productData p : hMap.keySet()) {
                    pTotal += hMap.get(p) * Double.parseDouble(p.pPrice);
                    if (hMap.get(p) > 0) {
                        productListTxa.setText(productListTxa.getText() + hMap.get(p) + " x " + p.pName + "\n" + "£"+ p.pPrice + "each" + "\n" + "\n" + "\n" + "\n");
                    }
                }
                totalCostLbl.setText(String.valueOf(pTotal));
            }
        });
    }
    // Working
    public static void service() {
        hMap.clear();
        for(productData productData : stockLevel) {
            hMap.put(productData, 0);
            System.out.println("Working");
        }
    }
    // Receipt
    public void pTotalP() {
        // Two decimal places
        totalCostLbl.setText(String.format("%.2f", tPrice));
    }


}
