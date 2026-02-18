package Project_1_v2.model;


public class Member {

    public int memberId;
    public String name;

    public Member(int memberId, String name){

        this.memberId = memberId;
        this.name = name;
    }

    public void display(){

        System.out.println("Name: " + name + " | ID: " + memberId);
    }

}
