public class JavaConcurrency implements Runnable{
    
    private boolean finished;
    
    @Override
    public void run() {
        int i = 0;
        while(!finished) {
            System.out.println("Run : "  + i++);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Stopped.");
    }
    
    public void finish() {
        this.finished = true;
    }
    
    public static void main(String[] args)  {
        
        JavaConcurrency r = new JavaConcurrency();
        Thread t = new Thread(r);
        t.start();
        
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
        
        r.finish();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }


}
