
/**
 * Beverages - 음료수 상품을 담당하는 클래스 
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Beverages extends Products implements TAX
{
    public double taxValue; 

    /**
     * Beverages 클래스의 객체 생성자
     * 상품코드, 상품명, 가격을 슈퍼클래스인 Products에 전달하고, 부가가치세를 10%로 설정 
     */
    public Beverages(String code, String name, int price)
    {
        super(code, name, price);
        taxValue = 0.1;
    }

    /**
     *  상품 가격에 대한 부가가치세를 계산하는 메소드
     *
     * @return vat
     */
    public double calculateVAT()
    {
        taxValue = 0.1;
        
        double vat =  price * taxValue;
        return vat;
    }

    /**
     * Beverages 상품에 적용되는 전체 세금을 계산하는 메소드 
     *
     * @return tax  
     */
    public double calculateTax()
    {
        double tax = calculateVAT();
        return tax;
    }

    /**
     * 상품의 최종 결제 금액을 계산하는 메소드
     *
     * @return finalPrice;
     */
    public double calculatePayment()
    {
        double finalPrice = price + calculateTax();
        return finalPrice;
    }
}