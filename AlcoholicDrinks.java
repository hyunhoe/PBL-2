
/**
 * AlcoholicDrinks 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class AlcoholicDrinks extends Products implements TAX
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String AlcoholType;
    private double taxAlcohol;
    private double liquorTax;
    private double eduTax;
    private double fixedTax;
    
    /**
     * AlcoholicDrinks 클래스의 객체 생성자
     */
    public AlcoholicDrinks(String code, String name, int price, String AlcoholType)
    {
        // 인스턴스 변수 초기화
        super(code, name, price);
        this.AlcoholType = AlcoholType;
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public double calculateTax()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public int calculatePayment()
    {
        // 여기에 코드를 작성하세요
        return price + (int)calculateTax();
    }
}