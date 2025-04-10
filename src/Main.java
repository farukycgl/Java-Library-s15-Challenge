import com.librarysystem.model.Book;
import com.librarysystem.model.Librarian;
import com.librarysystem.model.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Librarian librarian = new Librarian("Fikret", "admin1881");


        while (true) {

            System.out.println("1- Kitap Ekle");
            System.out.println("2- Kitap Sil");
            System.out.println("3- Kitap Ara");
            System.out.println("4- Kitap Ödünç Ver");
            System.out.println("5- Kitap Teslim Al");
            System.out.println("6- Kategorideki Kitapları Listele");
            System.out.println("7- Yazara Göre Kitap Listele");
            System.out.println("0- Çıkış");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("Kitap Adı: ");
                    String name = scanner.nextLine();
                    System.out.println("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.println("ID: ");
                    String id = scanner.nextLine();
                    Book newBook = new Book(id, name, author, 50, "müsait", "12.03.2025", "1", "Tarih");
                    librarian.addBook(newBook, library);
                    break;

                case 2:
                    System.out.println("Silinecek Kitabın ID'si: ");
                    String deleteId = scanner.nextLine();
                    Book deleteBook = null;
                    for(Book b : library.getBooks()){
                        if(b.getBookId().equals(deleteId)){
                            deleteBook = b;
                            break;
                        }
                    }
                    if(deleteBook != null){
                        librarian.removeBook(deleteBook, library);
                        System.out.println("Kitap silindi.");
                    }else {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;

                case 3:
                    System.out.println("Aranacak Kitabın Adı: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for(Book b : library.getBooks()){
                        if(b.getTitle().equalsIgnoreCase(searchName)){
                            System.out.println("Kitap bulundu.");
                            b.display();
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;

                case 4:
                    System.out.println("Ödünç Verilecek Kitabın ID'si: ");
                    String lendId = scanner.nextLine();
                    for(Book b : library.getBooks()){
                        if(b.getBookId().equals(lendId)){
                            library.lendBook(b, librarian);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("İade Edilecek Kitabın ID'si: ");
                    String returnId = scanner.nextLine();
                    for(Book b : library.getBooks()) {
                        if(b.getBookId().equals(returnId)){
                            library.takeBackBook(b);
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Kategori: ");
                    String category = scanner.nextLine();
                    for(Book b : library.getBooks()){
                        if(b.getCategory().equalsIgnoreCase(category)){
                            b.display();
                        }
                    }
                    break;

                case 7:
                    System.out.println("Yazar Adı: ");
                    String author = scanner.nextLine();
                    library.listBooksByAuthor(author);
                    break;

                default:
                    System.out.println("Geçerli bir seçim yapınız..!");
            }
        }
    }
}