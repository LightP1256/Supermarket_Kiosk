public class productData {
    // Declaring variables
    public String pName;
    public String pPrice;
    public int pQuantity;
    public float pTotal;
    public int pBought;
    public float setPP;
    // Getters
    public String getPName() {
        return  pName;
    }
    public String getPPrice() {
        return pPrice;
    }
    public int getPQuantity() {
        return pQuantity;
    }
    public float getPTotal() {
        return  pTotal;
    }
    public int getPBought() {
        return pBought;
    }
    // Setters
    public void setPName(String productName) {
        this.pName = productName;
    }
    public void setPPrice(String productPrice) {
        this.pPrice = productPrice;
    }
    public void setPQuantity(int productQuantity) {
        this.pQuantity = productQuantity;
    }
    public void setPTotal(float productTotal) {
        this.pTotal = productTotal;
    }
    public void setPBought(int productBought) {
        this.pBought = productBought;
    }
    public void setPP(float pPriceToFloat) {
        this.setPP = pPriceToFloat;
    }
    public void setPInStock(int pStockInt) {
        this.setPP = pStockInt;
    }
}
