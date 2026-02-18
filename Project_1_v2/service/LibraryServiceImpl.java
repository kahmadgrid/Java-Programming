package Project_1_v2.service;


import Project_1_v2.domain.BookDTO;
import Project_1_v2.domain.MemberDTO;
import Project_1_v2.model.Book;
import Project_1_v2.model.Member;
import Project_1_v2.repository.LibraryRepository;

public class LibraryServiceImpl implements LibraryService {

    LibraryRepository repo = new LibraryRepository();


// DTO → Model
    @Override
    public void addBook(BookDTO dto){

        Book book = new Book(
                dto.bookId,
                dto.title,
                dto.author
        );

        repo.books.add(book);

        System.out.println("Book added successfully");

    }


    @Override
    public void viewBooks(){

        for(Book b : repo.books)
            b.display();

    }


    public Book searchBook(int id){

        for(Book b : repo.books)

            if(b.bookId == id)

                return b;

        return null;

    }


    public Book searchBook(String title){

        for(Book b : repo.books)

            if(b.title.equalsIgnoreCase(title))

                return b;

        return null;

    }


    @Override
    public void searchBookById(int id){

        Book b = searchBook(id);

        if(b == null)

            System.out.println("Not found");

        else

            b.display();

    }


    @Override
    public void searchBookByTitle(String title){

        Book b = searchBook(title);

        if(b == null)

            System.out.println("Not found");

        else

            b.display();

    }


// DTO → Model
    @Override
    public void addMember(MemberDTO dto){

        Member m = new Member(
                dto.memberId,
                dto.name
        );

        repo.members.add(m);

        System.out.println("Member added");

    }


    @Override
    public void viewMembers(){

        for(Member m : repo.members)

            m.display();

    }


    public Member searchMember(int id){

        for(Member m : repo.members)

            if(m.memberId == id)

                return m;

        return null;

    }


    @Override
    public void issueBook(int memberId, int bookId){

        Member m = searchMember(memberId);

        Book b = searchBook(bookId);


        if(m == null || b == null){

            System.out.println("Not found");

            return;
        }


        if(!b.isAvailable){

            System.out.println("Already issued");

            return;
        }


        b.isAvailable = false;

        System.out.println("Issued successfully");

    }


    @Override
    public void returnBook(int bookId){

        Book b = searchBook(bookId);


        if(b == null){

            System.out.println("Not found");

            return;
        }


        b.isAvailable = true;

        System.out.println("Returned successfully");

    }

}

