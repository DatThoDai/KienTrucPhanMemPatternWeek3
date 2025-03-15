package stockmarket.observer;

public class Investor implements StockObserver {
    private String name;
    private String investmentStrategy;
    private StockSubject subject;

    public Investor(String name, String strategy) {
        this.name = name;
        this.investmentStrategy = strategy;
    }

    @Override
    public void update() {
        String update = (String) subject.getUpdate(this);
        if (update == null) {
            System.out.println(name + " (Chiến lược: " + investmentStrategy + ") :: Không có cập nhật mới về cổ phiếu");
        } else {
            System.out.println(name + " (Chiến lược: " + investmentStrategy + ") :: " + update);
        }
    }

    @Override
    public void setSubject(StockSubject subject) {
        this.subject = subject;
    }
}
