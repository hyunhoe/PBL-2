/**
 * Products - 모든 상품의 공통 정보를 저장하는 추상 슈퍼클래스 
 * 상품코드, 상품명, 가격 정보를 가지며 서브클래스(Beverages와 AlcoholicDrinks)가 상속받아 사용한다. 
 *
 * @author (9팀_2025310070 와뇨니 에즈라 브래들리, 2023320023 이현회, 2023320017 정윤재, 2025320057 홍권찬)
 * @version (2026.06.12.)
 */
public abstract class Products 
{
    protected int code;
    protected String name;
    protected double price;

    /**
     * Products 클래스의 객체 생성자
     */
    public Products(int code, String name, double price)
    {
        this.code = code;
        this.name = name;
        this.price = price;
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
     * @return name 
     */
    public String getName()
    {
        return name;
    }

    /**
     * 상품 가격을 반환하는 메소드 
     *
     * @return price 
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * 상품의 부가가치세를 계산하는 추상 메소드 
     *
     */
    public abstract double calculateVAT();

    /**
     * 상품의 최종 결제 금액을 계산하는 추상 메소드 
     *
     */
    public abstract double calculatePayment();
}