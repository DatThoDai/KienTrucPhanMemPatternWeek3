package Library.decorator;

import Library.decorator.Borrowing;

public abstract class BorrowingDecorator extends Borrowing {
    protected Borrowing borrowing;

    public BorrowingDecorator(Borrowing borrowing) {
        super(borrowing.getBook(), borrowing.getBorrower());
        this.borrowing = borrowing;
        this.borrowDate = borrowing.getBorrowDate();
        this.dueDate = borrowing.getDueDate();
    }

    @Override
    public String getDetails() {
        return borrowing.getDetails();
    }
}
