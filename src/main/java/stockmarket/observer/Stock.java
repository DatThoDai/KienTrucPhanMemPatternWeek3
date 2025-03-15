package stockmarket.observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements StockSubject {
    private List<StockObserver> observers;
    private String stockSymbol;
    private double price;
    private boolean changed;
    private final Object MUTEX = new Object();

    public Stock(String symbol) {
        this.stockSymbol = symbol;
        this.observers = new ArrayList<>();
        this.price = 0.0;
    }

    @Override
    public void register(StockObserver observer) {
        if (observer == null) throw new NullPointerException("Người theo dõi không hợp lệ");
        synchronized (MUTEX) {
            if (!observers.contains(observer)) observers.add(observer);
        }
    }

    @Override
    public void unregister(StockObserver observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<StockObserver> observersLocal = null;

        synchronized (MUTEX) {
            if (!changed) return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }

        for (StockObserver observer : observersLocal) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(StockObserver observer) {
        return "Cổ phiếu " + this.stockSymbol + " đã cập nhật giá: " + this.price + " VND";
    }

    public void updatePrice(double newPrice) {
        System.out.println("Cổ phiếu " + this.stockSymbol + " thay đổi giá từ " + this.price + " VND thành " + newPrice + " VND");
        this.price = newPrice;
        this.changed = true;
        notifyObservers();
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getPrice() {
        return price;
    }
}
