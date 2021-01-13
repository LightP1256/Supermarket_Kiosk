import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.*;
import java.util.Scanner;

public class payReceipt extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel titleLbl;
    private JButton shopReceiptBtn;
    private JTextArea productReceiptTxa;
    public String filePathProductData = "resources\\stock.txt";
    public String spacer = "\\|";
    public ArrayList<productData> stockLevel = new ArrayList<>();
    public payReceipt() {
        logProduct();
        System.out.println(stockLevel);
        selfCheckout sSelfCheckout = new selfCheckout();
        sSelfCheckout.pTotalP();
        gReceipt();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 600));
        setResizable(true);
        pack();
        shopReceiptBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gReceipt();
            }
        });
    }
    public void logProduct() {
        try {
            File file = new File(filePathProductData);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String columnRow = scanner.nextLine();
                String[] tProduct = columnRow.split(spacer);
                productData productData = new productData();
                productData.pName = tProduct[0];
                productData.pPrice = tProduct[1];
                productData.pQuantity = Integer.parseInt(tProduct[2]);
                productData.pTotal = Float.parseFloat(tProduct[3]);
                stockLevel.add(productData);
                float pPriceToFloat = Float.parseFloat(tProduct[1]);
                productData.setPP(pPriceToFloat);
                int pStockInt = Integer.parseInt(tProduct[2]);
                productData.setPInStock(pStockInt);
                float productTotal = Float.parseFloat(tProduct[3]);
                productData.setPTotal(productTotal);
            }
            scanner.close();
            System.out.println("Product loaded");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void gReceipt() {
        new SwingWorker<Void, Object>() {
            @Override
            protected Void doInBackground() throws Exception {
                System.out.println("SwingWorker: " + Thread.currentThread().getName());
                productReceiptTxa.setText("Processing receipt");
                Thread.sleep(3000);
                productReceiptTxa.setText("");
                double pTotal = 0.0;
                for (productData p : selfCheckout.hMap.keySet()) {
                    pTotal += selfCheckout.hMap.get(p) * Double.parseDouble(p.pPrice);
                    if (selfCheckout.hMap.get(p) > 0) {
                        productReceiptTxa.setText(productReceiptTxa.getText() + selfCheckout.hMap.get(p) + " x " + p.pName + "\n £"+ p.pPrice + "\n");
                    }
                }
                productReceiptTxa.setText(productReceiptTxa.getText() + "Amount: £"+ pTotal);
                return null;
            }
        }
        .execute();
    }
}
