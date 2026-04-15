package org.tester.stremapi;

/**
 * @created : 14/04/2026,16:52,mar.
 **/
@FunctionalInterface
public interface Book {
    void reedBook();
    /*void writeBook();*/
}
/*
class TestBook implements Book{

    @Override
    public void reedBook() {
        System.out.println("I am reading story book");
    }
}
class Test{
    public static void main(String[] args) {
        TestBook testBook = new TestBook();
        testBook.reedBook();
    }
}*/
class TestLambda{
    public static void main(String[] args) {
        Book book=()-> System.out.println("I am reading story book");
        book.reedBook();
    }
}
