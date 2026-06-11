
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
    private int typeNo; // 1일때 소주, 2일때 맥주

    /**
     * AlcoholicDrinks 클래스의 객체 생성자
     */
    public AlcoholicDrinks(String code, String name, int price, String AlcoholType, int typeNo)
    {
        // 인스턴스 변수 초기화
        super(code, name, price);
        this.AlcoholType = AlcoholType;
        this.taxAlcohol = taxAlcohol;
        this.typeNo = typeNo;

    }

    public String getAlcoholType()
    {
        // 여기에 코드를 작성하세요.
        return this.AlcoholType;
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public double calculateLiquorTax()
    {
        // 여기에 코드를 작성하세요.
        double liquortax;
        double basePrice;
        if(typeNo == 1){
            liquortax = baseprice * 0.72;
        }
        else if(typeNo == 2){
            liquortax = 442.85;
        }
        return liquortax;
    }

    public double calculateEduTax()
    {
        // 여기에 코드를 작성하세요.

        double liquorTax = calculateLiquorTax();
        double eduTax = liquorTax * 0.3;

        return eduTax;
    }

    public double calculateVAT()
    {
        double VAT;
        double basePrice = ?;
        double liquorTax = calculateLiquorTax();
        double eduTax = calculateEduTax();
        if (typeNo == 1){
            VAT = (basePrice + liquorTax + eduTax) * 0.10;
        } else if (typeNo == 2){
            VAT = (442.85 + eduTax) * 0.1;
        }
        return VAT
    }

    public double calculateTax()
    {
        // 여기에 코드를 작성하세요.
        double VAT = calculateVAT();
        double basePrice = ?;
        double liquorTax = calculateLiquorTax();
        double eduTax = calculateEduTax();
        
        double totalTax = liquorTax + eduTax + VAT;
        
        double taxAlcohol = totalTax;
        
        return taxAlcohol;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public double calculatePayment()
    {
        // 여기에 코드를 작성하세요
        double basePrice = ?;
        double taxAlcohol = calculateTax();
        double finalPrice = basePrice + taxAlcohol;
        return finalPrice;
    }
}