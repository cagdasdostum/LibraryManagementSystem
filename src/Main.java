//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        Library lib = new Library();

        Book book1 = new Book("1984", "George Orwell", "9694837593462", true);
        Book book2 = new Book("Suikast Bürosu", "Jack London", "9643685368123", true);
        Book book3 = new Book("Kendime Düşünceler", "Marcus Aurelius", "9643278945572", true);

        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);

        Member member1 = new Member("Çağdaş", 0);
        Member member2 = new Member("Pınar", 1);
        Member member3 = new Member("Metin", 2);

        lib.addMember(member1);
        lib.addMember(member2);
        lib.addMember(member3);

        lib.displayBooks();
        lib.displayMembers();

        lib.borrowBook(0,"9643278945572");
        lib.borrowBook( 1, "9643685368123");
        lib.borrowBook(2, "9643278945572");

        lib.returnBook(0,"9643278945572");

        System.out.println(lib.searchBooks("kendime"));

        lib.removeBook("9643685368123");

        lib.borrowBook( 1, "9643685368123");

        lib.removeMember(4);

        lib.listBorrowedBooks(1);




    }
}