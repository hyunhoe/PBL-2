
/**
 * Beverages - 음료수 상품을 담당하는 클래스 
 *
 * @author (9팀_2025310070 와뇨니 에즈라 브래들리, 2023320023 이현회, 2023320017 정윤재, 2025320057 홍권찬)
 * @version (2026.06.12.)
 */
public class Beverages extends Products implements TAX
{
    public double taxValue; 

    /**
     * Beverages 클래스의 객체 생성자
     * 상품코드, 상품명, 가격을 슈퍼클래스인 Products에 전달하고, 부가가치세를 10%로 설정 
     */
    public Beverages(int code, String name, double price)
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