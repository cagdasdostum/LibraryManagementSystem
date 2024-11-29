import java.util.ArrayList;

public class Member {

    private String name;
    private int memberID;
    private ArrayList<Book> borrowedBooks;

    public Member(String name, int memberID, ArrayList<Book> borrowedBooks) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = borrowedBooks;

    }

    public void BorrowBook(Book book) {
        if (borrowedBooks.size() < 5) {
            borrowedBooks.add(book);
            System.out.println("Kitap ödünç alındı.");
        }
        else {
            System.out.println("Kitap ödünç alma limitini aştınız.");
        }
    }

    public void ReturnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println("Kitap iade edildi.");
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberID=" + memberID +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
