package Project_1_v2.main;

import Project_1_v2.domain.BookDTO;
import Project_1_v2.domain.MemberDTO;
import Project_1_v2.service.LibraryService;
import Project_1_v2.service.LibraryServiceImpl;

import java.util.Scanner;

public class BookManagement {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        LibraryService service = new LibraryServiceImpl();


        while(true){

            System.out.println("\n1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Search Book");
            System.out.println("4 Add Member");
            System.out.println("5 View Members");
            System.out.println("6 Issue Book");
            System.out.println("7 Return Book");
            System.out.println("8 Exit");


            int choice = sc.nextInt();


            switch(choice){


                case 1:

                    BookDTO bookDTO = new BookDTO();

                    System.out.println("Enter ID");

                    bookDTO.bookId = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter title");

                    bookDTO.title = sc.nextLine();

                    System.out.println("Enter author");

                    bookDTO.author = sc.nextLine();


                    service.addBook(bookDTO);

                    break;



                case 2:

                    service.viewBooks();

                    break;



                case 3:

                    System.out.println("1 by ID");

                    System.out.println("2 by title");

                    int op = sc.nextInt();

                    sc.nextLine();

                    if(op==1)

                        service.searchBookById(sc.nextInt());

                    else

                        service.searchBookByTitle(sc.nextLine());

                    break;



                case 4:

                    MemberDTO memberDTO = new MemberDTO();

                    System.out.println("Enter ID");

                    memberDTO.memberId = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter name");

                    memberDTO.name = sc.nextLine();


                    service.addMember(memberDTO);

                    break;



                case 5:

                    service.viewMembers();

                    break;



                case 6:

                    System.out.println("Enter member id");

                    int mem = sc.nextInt();

                    System.out.println("Enter book id");

                    int bid = sc.nextInt();


                    service.issueBook(mem,bid);

                    break;



                case 7:

                    System.out.println("Enter book id");

                    service.returnBook(sc.nextInt());

                    break;



                case 8:

                    return;

            }

        }

    }

}

