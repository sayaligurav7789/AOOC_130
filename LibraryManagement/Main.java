import LibraryManagement.Book;
import LibraryManagement.Member;

public class Main {
    public static void main(String[] args) {
        // Create book
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");

        // Create member
        Member member1 = new Member("Sayali Gurav", 101);

        // Display details
        System.out.println("Book Details:");
        book1.displayInfo();
        System.out.println();

        System.out.println("Member Details:");
        member1.displayInfo();
    }
}
