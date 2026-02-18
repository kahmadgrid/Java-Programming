package Project_1;
import java.util.*;
class Book{
    int bookId;
    String title;
    String author;
    boolean isAvailable;
    Book(int bookId, String title, String author){
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        isAvailable = true;
    }
    public void display() {
        System.out.println(bookId + " | " + title + " | " + author +
                " | Available: " + isAvailable);
    }
}
class Member{
    int memberId;
    String name;
    Member(int memberId, String name){
        this.memberId = memberId;
        this.name = name;

    }
    public void display(){
        System.out.println("Name: " + this.name + " | " + "ID: " + this.memberId);
    }
}
class Library{
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    // Book management
    public void addBook(Book book){
        books.add(book);
        System.out.println("Boook is added successfully!");
    }
    public void viewAllbook(){
        for(Book book: books){
            book.display();
        }
    }
    public Book searchBook(int bookId){
        for(Book b: books){
            if(b.bookId == bookId)
                return b;
        }
        return null;
    }
    public Book searBook(String title){       // overloading
        for(Book b: books){
            if(b.title.equalsIgnoreCase(title))
                return b;
        }
        return null;
    }

    // member management
    public void addMember(Member m){
        members.add(m);
        System.out.println("Member added successfully!");
    }
    public Member searchMember(int memId){

        for(Member m: members){
            if(m.memberId == memId)
                return m;
        }
        return null;
    }

    public void viewAllMember(){
        for(Member m: members){
            m.display();
        }
    }

    // book issue.....
    
    public void issueBook(int memId, int bId){
        Member m = searchMember(memId);
        Book b = searchBook(bId);
        if(m == null || b == null){
            System.out.println("Book or Member not found!");
            return;
        }
        if(!b.isAvailable){
            System.out.println("Book is already issued!");
            return;
        }
        b.isAvailable = false;
        System.out.println("Book is issued successfully!");
        return;

    }
    // return book
    public void returnBook(int bId){
        Book b = searchBook(bId);
        if(b == null){
            System.out.println("Book is not found!");
            return;
        }
        b.isAvailable = true;
        System.out.println("Book is returned successfully!");
        return;
    }


}
public class BookManagement {
    public static void main(String args[]){
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n----- Select Option -----");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. View Members");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter book ID: ");
                    int bId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Book title: ");
                    String t = sc.nextLine();

                    System.out.println("Enter author name: ");
                    String a = sc.nextLine();

                    Book b = new Book(bId, t, a);
                    library.addBook(b);
                    break;

                case 2:
                    System.out.println("List of Books in Library:");
                    library.viewAllbook();
                    break;

                case 3:
                    System.out.println("Select the Option:");
                    System.out.println("1. Search by book ID");
                    System.out.println("2. Search by book Title");
                    int opt = sc.nextInt();
                    
                    if(opt == 1){
                        System.out.println("Enter the book ID: ");
                        int bkId = sc.nextInt();
                        Book book = library.searchBook(bkId);
                        if(book == null){
                            System.out.println("Book not found!");
                        }
                        else{
                            book.display();
                        } 
                    }
                    else{
                        System.out.println("Enter title: ");
                        Book book = library.searBook(sc.nextLine());
                        if(book != null) book.display();
                        else
                            System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter member ID:");
                    int mId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter name:");
                    String mName = sc.nextLine();

                    library.addMember(new Member(mId, mName));
                    break;
                
                case 5:
                    library.viewAllMember();
                    break;
                
                case 6:
                    System.out.println("Enter the book ID:");
                    int bookId = sc.nextInt();

                    System.out.println("Enter member ID:");
                    int memId = sc.nextInt();

                    library.issueBook(memId, bookId);
                    break;
                
                case 7:
                    System.out.println("Enter the book ID:");
                    int bID = sc.nextInt();

                    library.returnBook(bID);
                    break;
                
                case 8:
                    System.out.println("Thank you! ");
                    return;
                
                default:
                    System.out.println("Please select correct option!");

            }
        }
    }
}
