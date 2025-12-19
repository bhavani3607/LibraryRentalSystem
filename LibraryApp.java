import java.util.*;

// Book class
class Book {
    private int bookId;
    String title;
    String author;
    int price;
    boolean isAvailable;
    static int totalBooks = 0;

    // Constructor
    public Book(int bookId, String title, String author, int price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
        totalBooks++;
    }

    public int getBookId() {
        return bookId;
    }

    public void rentBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book rented successfully.");
        } else {
            System.out.println("Book is already rented.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not rented.");
        }
    }

    public void displayDetails() {
        System.out.println("----------------------------");
        System.out.println("Book ID   : " + bookId);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Price     : " + price);
        System.out.println("Status    : " + (isAvailable ? "Available" : "Rented"));
    }
}

// Library class
class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to library.");
    }

    public Book searchByTitle(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        for (Book b : books) {
            if (b.author.equalsIgnoreCase(author)) {
                return b;
            }
        }
        return null;
    }

    public void rentBook(int id) {
        for (Book b : books) {
            if (b.getBookId() == id) {
                b.rentBook();
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.getBookId() == id) {
                b.returnBook();
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            if (b.isAvailable) {
                b.displayDetails();
            }
        }
    }

    public void showRentedBooks() {
        System.out.println("\nRented Books:");
        for (Book b : books) {
            if (!b.isAvailable) {
                b.displayDetails();
            }
        }
    }
}

// Main class
public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        System.out.println("===== LIBRARY RENTAL SYSTEM =====");

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by Author");
            System.out.println("4. Rent Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show Available Books");
            System.out.println("7. Show Rented Books");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    int price = sc.nextInt();

                    library.addBook(new Book(id, title, author, price));
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    Book bt = library.searchByTitle(sc.nextLine());
                    if (bt != null) bt.displayDetails();
                    else System.out.println("Book not found.");
                    break;

                case 3:
                    System.out.print("Enter author: ");
                    Book ba = library.searchByAuthor(sc.nextLine());
                    if (ba != null) ba.displayDetails();
                    else System.out.println("Book not found.");
                    break;

                case 4:
                    System.out.print("Enter Book ID to rent: ");
                    library.rentBook(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 6:
                    library.showAvailableBooks();
                    break;

                case 7:
                    library.showRentedBooks();
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);
    }
}
