import java.util.Random;

public class bankaccount {
    private  String acHolder;
    private String acType;
    private int acNumber;
    private int acBalance=0;
    bankaccount(){

    }
    bankaccount(String acHolder,String acType){
        this.acHolder=acHolder;
        this.acType=acType;
        this.acNumber= genarate1();
    }
    public int getAcBalance() {
        return acBalance;
    }

    public void setAcBalance(int acBalance) {
        this.acBalance = acBalance;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public String getAcHolder() {
        return acHolder;
    }

    public void setAcHolder(String acHolder) {
        this.acHolder = acHolder;
    }

    public int getAcNumber() {
        return this.acNumber;
    }

    public int genarate1()
    {  Random r=new Random();
        return r.nextInt(1000,10000);
    }

    public void deposit(int amount ){
        this.acBalance=this.acBalance+amount;
    }
}
