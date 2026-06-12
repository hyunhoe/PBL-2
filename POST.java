import java.util.Scanner;
import java.util.InputMismatchException;
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
    
    private final int MAX_PRODUCTS = 6;
    private final int MAX_SALES = 20;

    /**
     * POST 클래스의 객체 생성자
     */
    public POST()
    {
        productDB = new double[MAX_PRODUCTS][3]; 
        productNameDB = new String[MAX_PRODUCTS];
        saleDB = new Sale[MAX_SALES];

        productCount = 0;
        saleCount = 0;
        saveProductDB();
    }

    /**
     * 상품DB에 상품 정보를 저장하는 메소드 
     * 
     */
    public void saveProductDB() {
            // 주류: 최종 판매가 기준으로 원가를 역산해서 저장
            int[] codes = {1017, 1024, 1115, 7741, 2613, 5925};
            int[] types = {1, 2, 1, 0, 0, 0};
            double[] prices = {892.1863, 2166.7245, 1549.5868, 2454.5455, 1818.1818, 1818.1818};
            String[] names = {
                "참이슬(후)", "카스캔500ml", "하이트)진로16.0도페트640ML",
                "티오피)더블랙캔275ml", "칠성)펩시콜라355ml", "칠성)칠성사이다제로355ml"
            };
    
            for (int i = 0; i < codes.length; i++) {
                productDB[i][0] = codes[i];
                productDB[i][1] = types[i];
                productDB[i][2] = prices[i];
                productNameDB[i] = names[i];
            }
            productCount = codes.length; // 등록한 상품 개수
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
            System.out.print("바코드 뒷자리 입력, 상품 입력 종료는 0: ");
            
            //예외처리
            try{
                code = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("오류: 숫자만 입력해주세요!");
                sc.nextLine(); 
                continue;
            }

            if (code == 0){
                break;
            }

            productIndex = checkBarcode(code);

            if (productIndex == -1){
                System.out.println("존재하지 않는 바코드입니다.");

            }else{
                Products product = createProduct(productIndex);
                
                System.out.print("수량 입력: ");
                try{
                    quantity = sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("오류: 수량은 숫자로 입력해주세요! 처음부터 다시 시도하세요.");
                    sc.nextLine(); 
                    continue; 
                }

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

        while (true){
            System.out.print("받은 현금 입력: ");
            try {
                receivedAmount = sc.nextInt();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("오류: 금액은 숫자로만 입력해주세요!");
                sc.nextLine();
            }
        }

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
            System.out.println("바코드 뒷자리: " + inputProducts[i].getCode());
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
        System.out.println("\t상품명" + "\t수량" + "\t금액(원)");

        for (int i = 0 ; i < inputCount ; i++ ){
            unitPrice = (int)inputProducts[i].calculatePayment();
            itemTotal = unitPrice * inputQuantities[i];

            vat = (int)(inputProducts[i].calculateVAT() + 0.5);
            itemVAT = vat * inputQuantities[i];

            System.out.println(inputProducts[i].getName() + "\t"+ inputQuantities[i] + "\t" +itemTotal);
            
            System.out.println("------------------------");
        }

        System.out.println("\t총 부가가치세:\t " + totalVAT + "원");
        System.out.println("\t총 결제금액:\t " + totalAmount + "원");
        System.out.println("\t받은 현금:\t " + receivedAmount + "원");
        System.out.println("\t거스름돈:\t " + balance + "원");
        System.out.println("\t판매정보가 판매DB에 저장되었습니다.");
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
