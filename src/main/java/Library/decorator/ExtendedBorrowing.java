package Library.decorator;

import Library.decorator.Borrowing;
import Library.decorator.BorrowingDecorator;

public class ExtendedBorrowing extends BorrowingDecorator {
    private int extraDays;

    public ExtendedBorrowing(Borrowing borrowing, int extraDays) {
        super(borrowing);
        this.extraDays = extraDays;
        this.dueDate = borrowing.getDueDate().plusDays(extraDays);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nGia hạn thêm: " + extraDays + " ngày";
    }
}
