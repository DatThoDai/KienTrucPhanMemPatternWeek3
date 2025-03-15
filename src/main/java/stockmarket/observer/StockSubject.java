package stockmarket.observer;

public interface StockSubject {
    void register(StockObserver observer);
    void unregister(StockObserver observer);

    void notifyObservers();

    Object getUpdate(StockObserver observer);
}
