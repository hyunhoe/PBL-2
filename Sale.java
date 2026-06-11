
/**
 * Sale 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Sale
{
    private int code; // 상품코드
    private String productName; // 상품이름
    private int unitPrice; // 개당 가격
    private int quantity; // 수량
    private int totalPrice; // 전체 가격
    
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
}