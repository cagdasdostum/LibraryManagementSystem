//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        Library lib = new Library();

        Book book1 = new Book("1984", "George Orwell", "123456789", true);
        Book book2 = new Book("Suikast Bürosu", "Jack London", "234567891", false);

        lib.addBook(book1);
        lib.addBook(book2);

        Member member1 = new Member("Çağdaş", 1);
        Member member2 = new Member("Pınar", 2);

        lib.addMember(member1);
        lib.addMember(member2);

        lib.borrowBook(0,"234567891");
        lib.borrowBook( 1, "123456789");

        lib.displayBooks();
        lib.displayMembers();


    }
}