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


        if (memberId < 0 || memberId >= members.size()) {
            System.out.println("Üye bulunamadı. ID: " + memberId);
            return;
        }

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



    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public String searchBooks (String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return null;
        }
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                return book.getTitle();
            }
        }
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                return book.getTitle();
            }
        }
        return null;
     }

     public void removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println(book.getTitle() + " kitabı kütüphaneden silinmiştir.");
            }
        }
     }

     public void removeMember(int memberId) {
        boolean removed = members.removeIf(member -> member.getMemberID() == memberId);
        if (removed) {
            System.out.println("Üye silindi.");
        }
        else {
            System.out.println("Üye bulunamadı.");
        }
     }

     public void listBorrowedBooks(int memberId) {
        for (Member member : members) {
            if (member.getMemberID() == memberId) {
                System.out.println(member.getBorrowedBooks());
            }
        }
     }




}
