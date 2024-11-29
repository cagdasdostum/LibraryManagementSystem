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
        System.out.println("Kitap eklendi.");
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Üye eklendi.");
    }

}
