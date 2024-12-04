import java.util.ArrayList;

public class Member{

    private String name;
    private int memberID;
    private ArrayList<Book> borrowedBooks;


    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();

    }

    public void BorrowBook(Book book) {
        if (book == null) {
            System.out.println("Hata: Geçersiz kitap (null).");
            return;
        }

        if (borrowedBooks.size() >= 5) {
            System.out.println("Aynı anda en fazla 5 kitap ödünç alabilirsiniz.");
        }

        if (!book.GetAvailable()) {
            System.out.println("Bu kitap şu anda mevcut değil: " + book);
        }

        else if (book.GetAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println("Kitap başarıyla ödünç alındı: " + book);
        }
    }

    public void ReturnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("Kitap başarıyla iade edildi: " + book);
        }
        else {
            System.out.println("Bu kitap henüz ödünç alınmamış.");
        }
    }

    @Override
    public String toString() {
        // StringBuilder sınıfı kullanmak + operatörü kullanmaktan daaha performanslı ve kod okunurluğunu artırıyor.
        StringBuilder details = new StringBuilder();
        details.append("Member{")
                .append("name='").append(name).append('\'')
                .append(", memberId=").append(memberID)
                .append(", borrowedBooks=");

        if (borrowedBooks.isEmpty()) {
            details.append("Hiç kitap ödünç alınmamış.");
        } else {
            for (Book book : borrowedBooks) {
                details.append("\n   ").append(book);
            }
        }
        details.append("]}");
        return details.toString();
    }

    public int getMemberID() {
        return memberID;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
