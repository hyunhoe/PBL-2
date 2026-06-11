
/**
 * POST 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class POST
{
    private double[][] productDB;
    private String[] productNameDB;
    private Sale[] saleDB;
    private int productCount;
    private int saleCount;
    
    /**
     * POST 클래스의 객체 생성자
     */
    public POST()
    {
        productDB = new double[6][3]; 
        productNameDB = new String[6];
        saleDB = new Sale[20];
        
        productCount = 0;
        saleCount = 0;
        saveProductDB();
    }

    /**
     * 상품DB에 상품 정보를 저장하는 메소드 
     * 
     */
    public void saveProductDB() {
        productDB[0][0] = 1017;
        productDB[0][1] = 1;
        productDB[0][2] = 892.1863;
        productNameDB[0] = "참이슬(후)";

        productDB[1][0] = 1024;
        productDB[1][1] = 2;
        productDB[1][2] = 2166.7245;
        productNameDB[1] = "카스캔500ml";

        productDB[2][0] = 1115;
        productDB[2][1] = 1;
        productDB[2][2] = 1549.5868;
        productNameDB[2] = "하이트)진로16.0도페트640ML";

        productDB[3][0] = 7741;
        productDB[3][1] = 0;
        productDB[3][2] = 2454.5455;
        productNameDB[3] = "티오피)더블랙캔275ml";

        productDB[4][0] = 13;
        productDB[4][1] = 0;
        productDB[4][2] = 1818.1818;
        productNameDB[4] = "칠성)펩시콜라355ml";

        productDB[5][0] = 925;
        productDB[5][1] = 0;
        productDB[5][2] = 1818.1818;
        productNameDB[5] = "칠성)칠성사이다제로355ml";

        productCount = 6; // 등록한 상품 개수
    }
    
    /**
     * 입력한 바코드가 존재하는지 확인하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public int checkBarcode(int code)
    {
        int row = 0;
        while(row < productCount){
            if(code == productDB[row][0]){
                return row;
            }
            row++;
        }
        
    }
    
    /**
     * 상품(음료, 주류) 객체 생성하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public Products createProduct(int row)
    {
        int code = (int)productDB[row][0];
        int typeNo = (int)productDB[row][1];
        String name = productNameDB[row];
        double price = productDB[row][2];
        Products product;
        
        if (typeNo == 0){
            product = new Beverages(code, name, price);
        } else if (typeNo == 1){
            product = new AlcoholicDrinks(code, name, price, "소주", 1);
        } else{
            product = new AlcoholicDrinks(code, name, price, "맥주", 2);
        }
        return product;
    }
    
    /**
     * 결제 끝난 상품 정보 저장하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void saveSaleDB(Products product, int quantity, int totalPrice)
    {
        int code = product.getCode();
        String productName = product.getName();
        double unitPrice = product.calculatePayment();
        
        if(saleCount < saleDB.length){
            saleDB[saleCount] = new Sale(code, productName, (int)unitPrice, quantity, totalPrice);
            saleCount++;
        } else{
            System.out.println("판매DB가 가득 찼습니다.");
        }
    }
    
    /**
     * 판매 배열 반환하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public Sale[] getSaleDB()
    {
        // 여기에 코드를 작성하세요.
        return saleDB;
    }
    
    /**
     * 판매 건수가 얼마인지 반환하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public int SaleCount()
    {
        // 여기에 코드를 작성하세요.
        return saleCount;
    }
    
    /**
     * 결제를 진행하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void calculateAllTotal()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 입력된 상품 정보를 화면에 출력하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void printProductInfo()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 모든상품의 결제금액의 합을 계산하는 메소드 
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public double calculateTotalPrice()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 모든 상품의 세금 합계 계산하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public double calculateAllVAT()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 거스름돈 계산하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public double calculateBalance()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 판매한 상품들 DB에 저장하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void saveAllSaleDB()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 영수증 출력하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void printReceipt()
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }
    
    /**
     * 결제 과정 실행하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void runPost()
    {
        // 여기에 코드를 작성하세요.
        calculateAllTotal();
    }
}