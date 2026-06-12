
/**
 * Sale 클래스의 설명을 작성하세요.
 *
 * @author (9팀_2025310070 와뇨니 에즈라 브래들리, 2023320023 이현회, 2023320017 정윤재, 2025320057 홍권찬)
 * @version (2026.06.12.)
 */
public class Sale
{
    private int code;
    private String productName; 
    private int unitPrice; 
    private int quantity; 
    private int totalPrice;

    /**
     * Sale 클래스의 객체 생성자
     */
    public Sale(int code, String productName, int unitPrice, int quantity, int totalPrice)
    {
        this.code = code;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    /**
     * 바코드 번호를 반환하는 메소드
     *
     * @return code
     */
    public int getCode()
    {
        return code;
    }

    /**
     * 상품명을 반환하는 메소드 
     *
     * @return productName
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * 상품 개별 가격을 반환하는 메소드
     *
     * @return unitPrice
     */
    public int getUnitPrice()
    {
        return unitPrice;
    }

    /**
     * 상품 수량을 반환하는 메소드
     *
     * @return quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * 최종 가격을 반환하는 메소드
     *
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * 상품의 단가와 수량을 곱하여 상품별 총액을 계산하는 메소드
     *
     * @return totalPrice 
     */
    public int calculateItemTotal()
    {
        totalPrice = unitPrice * quantity;

        return totalPrice;
    }
}