package essincronizzazione;


public class EsSincronizzazione {

    
    public static void main(String[] args) throws InterruptedException {
        Memoria USB = new Memoria("USB", 500);
        Utente t1 = new Utente("Lulli", USB);
        Utente t2 = new Utente("Sartorio", USB);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        
    }
    
}
