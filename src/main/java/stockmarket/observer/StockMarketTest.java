package stockmarket.observer;

public class StockMarketTest {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL");
        Stock googleStock = new Stock("GOOGL");

        Investor investor1 = new Investor("John", "Đầu tư dài hạn");
        Investor investor2 = new Investor("Emily", "Giao dịch ngắn hạn");
        Investor investor3 = new Investor("Mark", "Đầu tư giá trị");

        appleStock.register(investor1);
        appleStock.register(investor2);

        googleStock.register(investor2);
        googleStock.register(investor3);

        investor1.setSubject(appleStock);
        investor2.setSubject(appleStock);
        investor2.setSubject(googleStock);
        investor3.setSubject(googleStock);

        appleStock.updatePrice(150750);
        googleStock.updatePrice(2750250);

        System.out.println("Sau khi nhà đầu tư 2 hủy đăng ký theo dõi Apple:");
        appleStock.unregister(investor2);

        appleStock.updatePrice(152300);
    }
}
