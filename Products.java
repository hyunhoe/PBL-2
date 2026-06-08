
/**
 * Products 클래스의 설명을 작성하세요.
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public String getCode()
    {
        // 여기에 코드를 작성하세요
        return code;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public String getName()
    {
        // 여기에 코드를 작성하세요
        return name;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public int getPrice()
    {
        // 여기에 코드를 작성하세요
        return price;
    }

    public abstract int calculatePayment();
}