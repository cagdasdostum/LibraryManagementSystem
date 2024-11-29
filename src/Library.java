import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Üye eklendi: " + member);
    }

    public void displayBooks() {
        System.out.println("Kütüphanedeki kitaplar: ");
        if (books.isEmpty()) {
            System.out.println("Kütüphanede hiç kitap yok.");
        }

        else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayMembers() {
        System.out.println("Kütüphanedeki üyeler: ");
        if (members.isEmpty()) {
            System.out.println("Kütüphanede hiç üye yok.");
        }
        else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    public void borrowBook(int memberId, String isbn) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Üye bulunamadı. ID: " + memberId);
        }

        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Kitap bulunamadı. Isbn: " + isbn);
        }

        member.BorrowBook(book);
    }

    public void returnBook(int memberId, String isbn) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Üye bulunamadı. ID: " + memberId);
        }

        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Kitap bulunamadı. Isbn: " + isbn);
        }

        member.ReturnBook(book);
    }

    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if (memberId == member.getMemberID()) {
                return member;
            }
        }
        return null;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


}
