/**
 * Products - 모든 상품의 공통 정보를 저장하는 추상 슈퍼클래스 
 * 상품코드, 상품명, 가격 정보를 가지며 서브클래스(Beverages와 AlcoholicDrinks)가 상속받아 사용한다. 
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public abstract class Products 
{
    protected String code;
    protected String name;
    protected int price;

    /**
     * Products 클래스의 객체 생성자
     */
    public Products(String code, String name, int price)
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
    public String getCode()
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
    public int getPrice()
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