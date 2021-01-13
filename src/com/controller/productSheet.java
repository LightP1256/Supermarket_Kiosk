import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class productSheet extends JFrame {
    public String filepathProductData = "resources\\stock.txt";
    private JPanel mainPanel;
    private JLabel pSheetLbl;
    private JPanel pSheetPanel;
    private JLabel aOptionsLbl;
    private JLabel productsLbl;
    private JButton editPBtn;
    private JButton deletePBtn;
    private JTextArea productTxa;
    private JButton savePBtn;
    private JTextField productNameTxf;
    private JTextField productQuantityTxf;
    private JLabel pNameLbl;
    private JLabel pQuantityLbl;
    public String spacer = "\\|";
    public ArrayList<productData> stockLevel = new ArrayList<>();
    public productSheet(String ttl) {
        // Loading products function
        loadProducts();
        System.out.println(stockLevel);
        // inputting into text area
        inputDataProduct();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 600));
        pack();
        editPBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editSheet();
            }
        });
        savePBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });
        deletePBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }
        });
    }
    public void inputDataProduct() {
        String sheet = "";
        for(productData product : stockLevel){
            sheet += product.pName + "  |  " + product.pQuantity + "\n";
        }
        productTxa.setText(sheet);
    }
    public int checkProduct(String idInt) {
        int pAIS = -1;
        for(productData product : stockLevel) {
            if(product.pName.equals(idInt)) {
                pAIS = stockLevel.indexOf(product);
            }
        }
        return pAIS;
    }
    public void loadProducts() {
        try {
            File file = new File(filepathProductData);
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
                float tCash = Float.parseFloat(tProduct[3]);
                productData.setPTotal(tCash);
            }
            scanner.close();
            System.out.println("Product Data file loaded");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void editSheet() {
        try {
            String sheetSt = productNameTxf.getText();
            int amountEdit = Integer.parseInt(productQuantityTxf.getText());
            int pAIS = checkProduct(sheetSt);
            stockLevel.get(pAIS).pQuantity += amountEdit;
            inputDataProduct();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong input, please try again");
        }
        productQuantityTxf.setText("");
        productNameTxf.setText("");
    }
    public void saveProduct() {
        try {
            FileWriter writer = new FileWriter(filepathProductData);
            for(int pIndex = 0; pIndex < stockLevel.size(); pIndex++) {
                String dColumnRow = "";
                if(pIndex > 0) {
                    dColumnRow += "\n";
                }
                String pName = (stockLevel.get(pIndex).getPName());
                dColumnRow += pName;
                String pPrice = (stockLevel.get(pIndex).getPPrice());
                dColumnRow += "|" + pPrice;
                int pQuantity = (stockLevel.get(pIndex).getPQuantity());
                dColumnRow += "|" + pQuantity;
                int pTotal = 0;
                dColumnRow += "|" + pTotal;
                writer.write(dColumnRow);

            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteProduct() {
        try{
            String sheetSt = productNameTxf.getText();
            int amountDelete = Integer.parseInt(productQuantityTxf.getText());
            int pAIS = checkProduct(sheetSt);
            stockLevel.get(pAIS).pQuantity -= amountDelete;
            inputDataProduct();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong input, please try again");
        }
    }
}
