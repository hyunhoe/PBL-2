import java.util.Scanner;
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

        productDB[4][0] = 2613;
        productDB[4][1] = 0;
        productDB[4][2] = 1818.1818;
        productNameDB[4] = "칠성)펩시콜라355ml";

        productDB[5][0] = 5925;
        productDB[5][1] = 0;
        productDB[5][2] = 1818.1818;
        productNameDB[5] = "칠성)칠성사이다제로355ml";

        productCount = 6; // 등록한 상품 개수
    }

    /**
     * 입력한 바코드가 존재하는지 확인하는 메소드
     *
     * @param code
     * @return -1
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
        return -1;
    }

    /**
     * 상품(음료, 주류) 객체 생성하는 메소드
     *
     * @param row
     * @return product
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
     * @param product, quantity, totalPrice
     */
    public void saveSaleDB(Products product, int quantity, int totalPrice)
    {
        int code = product.getCode();
        String productName = product.getName();
        double unitPrice = product.calculatePayment();

        if (saleCount  < saleDB.length){
            saleDB[saleCount] = new Sale(code, productName, (int)unitPrice, quantity, totalPrice);
            saleCount++;
        }else{
            System.out.println("판매DB가 가득 찼습니다.");
        }
    }

    /**
     * 판매 배열 반환하는 메소드
     *
     * @return saleDB
     */
    public Sale[] getSaleDB()
    {
        return saleDB;
    }

    /**
     * 판매 건수가 얼마인지 반환하는 메소드
     *
     * @return saleCount
     */
    public int SaleCount()
    {
        return saleCount;
    }

    /**
     * 결제를 진행하는 메소드
     *
     */
    public void calculateAllTotal()
    {
        
        Scanner sc = new Scanner(System.in);
        Products[] inputProducts;
        int[] inputQuantities;
        
        int code;
        int productIndex;
        int quantity;
        int inputCount = 0;
        int totalAmount;
        int receivedAmount;
        int balance;

        inputProducts = new Products[20];
        inputQuantities = new int[20];

        while (true) {
            System.out.print("바코드 뒤자리 입력, 상품 입력 종료는 0: ");
            code = sc.nextInt();

            if (code == 0){
                break;
            }

            productIndex = checkBarcode(code);

            if (productIndex == -1){
                System.out.println("존재하지 않는 바코드입니다.");

            }else{
                Products product = createProduct(productIndex);

                System.out.print("수량 입력: ");
                quantity = sc.nextInt();

                inputProducts[inputCount] = product;
                inputQuantities[inputCount] = quantity;
                inputCount++;

                // 상품을 입력 출력
                printProductInfo(inputProducts, inputQuantities, inputCount);

                totalAmount = (int)calculateTotalPrice(inputProducts, inputQuantities, inputCount);
                System.out.println("현재 총 결제금액: " + totalAmount + "원");
            }
            System.out.println();
        }

        if (inputCount == 0 ){
            System.out.println("입력된 상품이 없습니다.");
            return;
        }

        totalAmount = (int)calculateTotalPrice(inputProducts, inputQuantities, inputCount);

        System.out.println("받은 현금 입력: ");
        receivedAmount = sc.nextInt();

        balance = (int)calculateBalance(receivedAmount, totalAmount);

        if (balance < 0 ){
            System.out.println("현금이 부족합니다.");
            return;
        }

        saveAllSaleDB(inputProducts, inputQuantities, inputCount);

        printReceipt(inputProducts, inputQuantities, inputCount, receivedAmount, totalAmount, balance);

    }

    /**
     * 입력된 상품 정보를 화면에 출력하는 메소드
     *
     * @param inputProducts, inputQuantities, inputCount
     */
    public void printProductInfo(Products[] inputProducts, int[] inputQuantities, int inputCount)
    {
        int unitPrice;
        int itemTotal;
        System.out.println();
        System.out.println("===== 입력된 상품 종보  ====");

        for (int i = 0; i < inputCount; i++){
            unitPrice = (int)inputProducts[i].calculatePayment();
            itemTotal = unitPrice * inputQuantities[i];

            System.out.println("상품: " + inputProducts[i].getName());
            System.out.println("바코드 뒤자리: " + inputProducts[i].getCode());
            System.out.println("수량: " + inputQuantities[i]);
            System.out.println("단가: " + unitPrice + "원");
            System.out.println("상품 금액: " + itemTotal + "원");
            System.out.println("--------------------");    
        }
    }

    /**
     * 모든상품의 결제금액의 합을 계산하는 메소드 
     *
     * @param  inputProducts, inputQuantities, inputCount
     * @return totalAmount
     */
    public double calculateTotalPrice(Products[] inputProducts, int[] inputQuantities, int inputCount)
    {
        // 여기에 코드를 작성하세요.
        int totalAmount = 0;
        for (int i = 0 ; i < inputCount ; i++){
            totalAmount = totalAmount + (int)inputProducts[i].calculatePayment()*inputQuantities[i];

        }
        return totalAmount;
    }

    /**
     * 모든 상품의 세금 합계 계산하는 메소드
     *
     * @param  inputProducts, inputQuantities, inputCount
     * @return totalVAT
     */
    public double calculateAllVAT(Products[] inputProducts, int[] inputQuantities, int inputCount)
    {
        // 여기에 코드를 작성하세요.
        int vat;
        int totalVAT = 0;

        for (int i = 0 ; i < inputCount ; i++){
            vat = (int)(inputProducts[i].calculateVAT() + 0.5);
            totalVAT = totalVAT + vat* inputQuantities[i];
        }

        return totalVAT;
    }

    /**
     * 거스름돈 계산하는 메소드
     *
     * @param receivedAmount, totalAmount
     * @return balance
     */
    public double calculateBalance(int receivedAmount, int totalAmount)
    {

        int balance = receivedAmount - totalAmount;

        return balance;
    }

    /**
     * 판매한 상품들 DB에 저장하는 메소드
     *
     * @param  inputProducts, inputQuantities, inputCount 
     */
    public void saveAllSaleDB(Products[] inputProducts, int[] inputQuantities, int inputCount)
    {
        int totalPrice;

        for(int i = 0 ; i < inputCount ; i++){
            totalPrice = (int)inputProducts[i].calculatePayment()*inputQuantities[i];

            saveSaleDB(inputProducts[i], inputQuantities[i], totalPrice);
        }

    }

    /**
     * 영수증 출력하는 메소드
     *
     * @param inputProducts, inputQuantities, inputCount, receivedAmount, totalAmount, balance
     */
    public void printReceipt(Products[] inputProducts, int[] inputQuantities, int inputCount,
    int receivedAmount, int totalAmount, int balance)
    {
        int unitPrice;
        int itemTotal;
        int vat;
        int itemVAT;
        int totalVAT;

        totalVAT = (int)calculateAllVAT(inputProducts, inputQuantities, inputCount);

        System.out.println();
        System.out.println("====== 영수증 ======");

        for (int i = 0 ; i < inputCount ; i++ ){
            unitPrice = (int)inputProducts[i].calculatePayment();
            itemTotal = unitPrice * inputQuantities[i];

            vat = (int)(inputProducts[i].calculateVAT() + 0.5);
            itemVAT = vat * inputQuantities[i];

            System.out.println("상품: " + inputProducts[i].getName());
            System.out.println("수량: " + inputQuantities[i]);
            System.out.println("단가: " + unitPrice + "원");
            System.out.println("부가가치세: " + itemVAT + "원");
            System.out.println("상품  금액: " + itemTotal + "원");
            System.out.println("------------------------");
        }

        System.out.println("총 부가가치세: " + totalVAT + "원");
        System.out.println("총 결제금액: " + totalAmount + "원");
        System.out.println("받은 현금: " + receivedAmount + "원");
        System.out.println("거스름돈: " + balance + "원");
        System.out.println("판매정보가 판매DB에 저장되었습니다.");
        System.out.println("====== 결제 종료 =====");
    }

    /**
     * 결제 과정 실행하는 메소드
     * 
     */
    public void runPost()
    {
        calculateAllTotal();
    }
}
