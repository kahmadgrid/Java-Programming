package Project_1_v2.service;


import Project_1_v2.domain.BookDTO;
import Project_1_v2.domain.MemberDTO;

public interface LibraryService {

    void addBook(BookDTO bookDTO);

    void viewBooks();

    void searchBookById(int id);

    void searchBookByTitle(String title);

    void addMember(MemberDTO memberDTO);

    void viewMembers();

    void issueBook(int memberId, int bookId);

    void returnBook(int bookId);

}
