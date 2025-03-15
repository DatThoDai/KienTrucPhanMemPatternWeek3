package Library.decorator;

import Library.decorator.Borrowing;
import Library.decorator.BorrowingDecorator;

public class PriorityBorrowing extends BorrowingDecorator {
    private String priority;

    public PriorityBorrowing(Borrowing borrowing, String priority) {
        super(borrowing);
        this.priority = priority;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nMức độ ưu tiên: " + priority;
    }
}
