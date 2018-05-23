package pl.waw.sgh.threads;

public class Notifier implements Runnable{
    private Messege msg;

    public Notifier(Messege msg){
        this.msg = msg;
    }
    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
    }
}
