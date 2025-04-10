import com.librarysystem.model.*;
import com.librarysystem.service.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BillingService billingService = new BillingService();
        BookService bookService = new BookService(library);
        LibraryService libraryService = new LibraryService(library, billingService);

        Scanner scanner = new Scanner(System.in);

        //örnek kullanıcı ve kayıt
        Reader reader = new Reader("Fikret");
        library.registerReader(reader);
        MemberRecord memberRecord = new MemberRecord("1", LocalDate.now(), reader);

        boolean running = true;
        while (running) {

            System.out.println("**Kütüphane Sistemi**");
            System.out.println("1- Kitap Ekle");
            System.out.println("2- Kitap Ara (ID)");
            System.out.println("3- Kitap Ara (Yazar)");
            System.out.println("4- Kitap Ara (Kategori)");
            System.out.println("5- Kitap Sil");
            System.out.println("6- Kitap Ödünç Al");
            System.out.println("7- Kitap İade Et");
            System.out.println("8- Kullanıcı Fatura Görüntüle");
            System.out.println("9- Çıkış");
            System.out.println("Seçiminiz: ");

            // sonra bunlarıda ekle!
            // System.out.println("Kategorideki Kitapları Listele");
            // System.out.println("Yazara Göre Kitap Listele");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Kitap ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Kitap Adı: ");
                    String name = scanner.nextLine();
                    System.out.println("Yazar Adı: ");
                    String authorName = scanner.nextLine();
                    System.out.println("Baskı: ");
                    String edition = scanner.nextLine();
                    System.out.println("Kategori (Journal, Study Book, Magazine): ");
                    BookCategory category = BookCategory.valueOf(scanner.nextLine().toUpperCase());

                    Author author = new Author(authorName);
                    Book book = new Book(id, name, author, edition, LocalDate.now(), category);
                    bookService.addBook(book);
                    break;

                case 2:
                    System.out.println("ID giriniz: ");
                    String searchId = scanner.nextLine();
                    Book foundBook = bookService.searchById(searchId);
                    if(foundBook != null)
                        foundBook.display();
                    else
                        System.out.println("Kitap bulunamadı!");
                    break;

                case 3:
                    System.out.println("Yazar adı giriniz: ");
                    String authorSearch = scanner.nextLine();
                    List<Book> byAuthor = bookService.searchByAuthor(authorSearch);
                    bookService.displayBooks(byAuthor);
                    break;

                case 4:
                    System.out.println("Kategori giriniz (Journal, Study Book, Magazine): ");
                    BookCategory cat = BookCategory.valueOf(scanner.nextLine().toUpperCase());
                    List<Book> byCat = bookService.searchByCategory(cat);
                    bookService.displayBooks(byCat);
                    break;

                case 5:
                    System.out.println("Silinecek kitabın ID'si: ");
                    String removeId = scanner.nextLine();
                    bookService.removeBookById(removeId);
                    break;

                case 6:
                    System.out.println("Ödünç alınacak kitabın ID'si: ");
                    String borrowId = scanner.nextLine();
                    Book bookToBorrow = bookService.searchById(borrowId);
                    if(bookToBorrow != null)
                        libraryService.borrowBook(bookToBorrow, reader, memberRecord);
                    else
                        System.out.println("Kitap bulunamadı!");
                    break;

                case 7:
                    System.out.println("İade edilecek kitabın ID'si: ");
                    String returnId = scanner.nextLine();
                    Book bookToReturn = bookService.searchById(returnId);
                    if(bookToReturn != null)
                        libraryService.returnBook(bookToReturn, reader, memberRecord);
                    else System.out.println("Kitap bulunamadı!");
                    break;

                case 8:
                    double bill = billingService.getBill(reader);
                    System.out.println("Toplam borcunuz: " + bill + " TL");
                    break;

                case 9:
                    running = false;
                    System.out.println("Sistemden çıkılıyor..");

                default:
                    System.out.println("Geçerli bir seçim yapınız..!");
            }
        }

        scanner.close();
    }
}