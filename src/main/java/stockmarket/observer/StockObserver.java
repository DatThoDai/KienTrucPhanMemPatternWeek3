package stockmarket.observer;

public interface StockObserver {
    void update();

    void setSubject(StockSubject subject);
}
