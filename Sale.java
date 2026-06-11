
/**
 * Sale 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Sale
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
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
        // 인스턴스 변수 초기화
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
        // 여기에 코드를 작성하세요.
        return code;
    }
    
    /**
     * 상품명을 반환하는 메소드 
     *
     * @return productName
     */
    public String getProductName()
    {
        // 여기에 코드를 작성하세요.
        return productName;
    }
    
    /**
     * 상품 개별 가격을 반환하는 메소드
     *
     * @return unitPrice
     */
    public int getUnitPrice()
    {
        // 여기에 코드를 작성하세요.
        return unitPrice;
    }
    
    /**
     * 상품 수량을 반환하는 메소드
     *
     * @return quantity
     */
    public int getQuantity()
    {
        // 여기에 코드를 작성하세요.
        return quantity;
    }
    
    /**
     * 최종 가격을 반환하는 메소드
     *
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        // 여기에 코드를 작성하세요.
        return totalPrice;
    }
}