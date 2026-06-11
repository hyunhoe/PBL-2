
/**
 * AlcoholicDrinks - 주류 상품을 담당하는 클래스 
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

    /**
     * 주류 종류(맥주, 소주)를 반환하는 메소드 
     *
     * @return 주류 종류 
     */
    public String getAlcoholType()
    {
        // 여기에 코드를 작성하세요.
        return this.AlcoholType;
    }

    /**
     * 주세 계산 메소드 
     * 소주는 기준가격의 72%를 주세로 계산하고, 맥주는 500ml의 정해진 가격인 442.85원을 주세로 계산한다. 
     *
     * @return liquortax
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

    /**
     * 주세를 기준으로 교육세를 계산하는 메소드 
     * 교육세는 주세의 30%로 계산한다. 
     * 
     * @return eduTax;
     */
    public double calculateEduTax()
    {
        // 여기에 코드를 작성하세요.

        double liquorTax = calculateLiquorTax();
        double eduTax = liquorTax * 0.3;

        return eduTax;
    }

    /**
     * 주류 상품에 적용도되는 부가가치세를 계산하는 메소드
     * 소주는 원가, 주세, 교육세를 더한 금액의 10%를 부가가치세로 계산한다. 
     * 맥주는 주세와 교육세를 기준으로 10%의 부가가치세를 계산한다. 
     * 
     * @return VAT
     */
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
        return VAT;
    }

    /**
     * 주류 상품에 적용되는 전체 세금을 계산하는 메소드 
     * 주세, 교육세, 부가가치세를 모두 더한 금액 
     *
     * @return taxAlcohol
     */
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
     * 주류 상품의 최종 결제 금액을 계산하는 메소드 
     * 최종 결제 금액 = 원가 + 전체 세금 
     * 
     * @return finalPrice 
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