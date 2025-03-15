package Library.decorator;

import Library.decorator.Borrowing;
import Library.decorator.BorrowingDecorator;

public class SpecialEditionBorrowing extends BorrowingDecorator {
    private String specialFeature;

    public SpecialEditionBorrowing(Borrowing borrowing, String specialFeature) {
        super(borrowing);
        this.specialFeature = specialFeature;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nPhiên bản đặc biệt: " + specialFeature;
    }
}

