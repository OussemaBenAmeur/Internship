import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class BookStore {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
    }

    public void listBooks() {
        System.out.println("\nListing Books:");
        for (Book b : books) {
            System.out.println("- " + b.title + " by " + b.author);
        }
    }

    public void searchByTitle(String keyword) {
        System.out.println("\nSearch Results for '" + keyword + "':");
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("- " + b.title + " by " + b.author);
            }
        }
    }

    public static void main(String[] args) {
        BookStore store = new BookStore();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions: 1) Add 2) List 3) Search 4) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                store.addBook(title, author);
            } else if (choice == 2) {
                store.listBooks();
            } else if (choice == 3) {
                System.out.print("Search keyword: ");
                String keyword = scanner.nextLine();
                store.searchByTitle(keyword);
            } else {
                break;
            }
        }
        scanner.close();
    }
}
