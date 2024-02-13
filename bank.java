import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class bank {
    Scanner sc = new Scanner(System.in);
    static  Map<Integer, bankaccount> list = new HashMap<>();
    bankaccount acc = new bankaccount();
    bank() {
        while ( true) {
            System.out.println("-------Welcome------");
            System.out.println("1.create account");
            System.out.println("2.remove an account");
            System.out.println("3.dispaly details");
            System.out.println("4.tranfer money to another account");
            int choice = sc.nextInt();
            if (choice == 1) {
                createAccount();
            }
            if (choice == 2) {
                removeAccount();

            }
            if (choice == 3) {
                Display();
            }
            if (choice == 4) {
                tranfer();
            }
            System.out.println("enter y for banking N for exit");
            char c=sc.next().charAt(0);
            if(c=='N'||c=='n'){
                break;
            }
        }
    }
    public void createAccount () {
        // bankaccount acc1=new bankaccount();
        System.out.println("enter name");
        sc.nextLine();
        String username = sc.nextLine();
        System.out.println("enter account type sv/cr");
        String type = sc.nextLine();

        bankaccount acc1=new bankaccount(username,type);
        int acnum = acc1.getAcNumber();
        list.put(acnum, acc1);
        bankaccount temp1 = list.get(acnum);
        System.out.println(" account number :"+temp1.getAcNumber());
        addamount(acnum);
        // System.out.println(list.get(acnum));
        //Display(int acnum);
    }
    public void removeAccount () {
        System.out.println("enter account number to remove account");
        int acnum = sc.nextInt();
        if (list.get(acnum)!=null) {
            list.remove(acnum);
        } else {
            System.out.println("invalid acount number");
        }
    }
    public void Display () {
        System.out.println(" enter acnumber");
        int acnum = sc.nextInt();
        if (list.get(acnum)!=null) {
            bankaccount temp = list.get(acnum);
            System.out.println("account holder name :" + temp.getAcHolder());
            System.out.println("account number     :" + temp.getAcNumber());
            System.out.println("account Type       :" + temp.getAcType());
            System.out.println("account balance     :" + temp.getAcBalance());
        } else {
            System.out.println("invalid acount number");
        }
    }
    public void addamount(int acnum){
        System.out.println("enter amount to deposit");
        int amount=sc.nextInt();
        bankaccount t=list.get(acnum);
        t.deposit(amount);
    }
    public void tranfer(){
        System.out.println(" enter sender account number");
        int sender=sc.nextInt();
        if(list.containsKey(sender)){
            System.out.println("enter reciver account number");
            int reciver =sc.nextInt();
            bankaccount send=list.get(sender);
            bankaccount recive=list.get(reciver);
            if(list.containsKey(reciver)){
                System.out.println("enter amount to transfer");
                int money=sc.nextInt();
                if(money<=send.getAcBalance()){
                    int debit=-money;
                    // int credit=money;
                    send.deposit(debit);
                    recive.deposit(money);
                    System.out.println(" balance after transaction :"+ send.getAcBalance());
                }else {
                    System.out.println("insuficient funds");}

            }else{
                System.out.println("enter valid number");
            }
        }
        else {
            System.out.println("enter a valid account number");
        }

    }

}