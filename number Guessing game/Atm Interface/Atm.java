import java.util.Scanner;
class Atm
{
    class Node
    {
        float cno;
        int pin;
        double balance;
        Node next;
        Node(float c,int p,double b)
        {
            this.cno=c;
            this.pin=p;
            this.balance=b;
            this.next=null;
        } 
    }
    static Node head=null;
    public void addLast(float cno,int p, double b)
    {
        Node last=new Node(cno,p,b);
        if(head==null)
        {
            head=last;
            return;
        }
            Node t=head;
             while(t.next!=null)
                {
                 t=t.next;
                }
            t.next=last;
    }
    
    public static void main(String[]args)
    {
        Atm a=new Atm();
        boolean found=true;
        double withdraw,deposit;
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("1- New User\n2-Existing user\n3-exit");
        System.out.println("Enter your choice\n");
        int c=sc.nextInt();
        switch(c)
        {
            case 1:
            System.out.println("Enter card number\n");
            float card=sc.nextFloat();
            System.out.println("Enter pin\n");
            int pi=sc.nextInt();
            double b=0;
            a.addLast(card,pi,b);
            System.out.println("User registered\n");
            break;
            case 2:
            System.out.println("Enter card no-\n");
            float cd=sc.nextFloat();
            Node find=head;
            if(find==null)
            {
                System.out.println("User not registered\n");
                break;
            }
            while(find.next!=null && find.cno!=cd)
            {
                find=find.next;     
            }
            if(find!=null)
            {
                System.out.println("Enter pin\n");
                int pinn=sc.nextInt();
               if(pinn==find.pin)
                {   
                    while(true)  
                    {  
                        System.out.println("Automated Teller Machine");  
                        System.out.println("Choose 1 for Withdraw");  
                        System.out.println("Choose 2 for Deposit");  
                        System.out.println("Choose 3 for Check Balance");  
                        System.out.println("Choose 4 for EXIT");  
                        System.out.print("Choose the operation you want to perform:");  
               
                        int choice = sc.nextInt();  
                        switch(choice)  
                        {  
                            case 1:  
                            System.out.print("Enter money to be withdrawn:");  
                            withdraw = sc.nextInt();  
                      
                            if(find.balance >= withdraw)  
                            {  
                                find.balance = find.balance - withdraw;  
                                System.out.println("Please collect your money");  
                            }  
                            else  
                            {   
                                System.out.println("Insufficient Balance");  
                            }  
                            System.out.println("");  
                            break;  
   
                            case 2:  
                            System.out.print("Enter money to be deposited:");   
                            deposit = sc.nextInt();  
                      
                            find.balance = find.balance + deposit;  
                            System.out.println("Your Money has been successfully depsited");  
                            System.out.println("");  
                            break;  
   
                            case 3:    
                            System.out.println("Balance : "+find.balance);  
                            System.out.println("");  
                            break;  
   
                            case 4:  
                            System.exit(0);  
                            break;
                        }
                    }
                }
                else
                {
                System.out.println("Pin code didn't match");
                }
            }
            else
            {
                System.out.println("Record not found");
            }
            
            break;
            case 3:
            System.exit(0);
            break;
            default:
            System.out.println("Invalid choice");
        }
    }
    }
}
