package essincronizzazione;


public class Memoria{
    private String nome;
    private int capienza;
    private int capLibera;

    public Memoria(String nome, int capienza) {
        this.nome = nome;
        this.capienza = capienza;
        this.capLibera = capienza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public int getCapLibera() {
        return capLibera;
    }

    public void setCapLibera(int capLibera) {
        this.capLibera = capLibera;
    }
    
    public synchronized void save(int spazio){
       // if(this.capLibera > spazio){
       while(this.capLibera < spazio){
            System.out.println(Thread.currentThread().getName() + " ASPETTA non puoi salvare " + spazio +" MB");
            
            try{wait();}
            catch(InterruptedException e){}
            
            System.out.println(Thread.currentThread().getName() + " RISVEGLIATI forse puoi salvare");
       }
            capLibera = capLibera - spazio;
            System.out.print(Thread.currentThread().getName() + " salvataggio di " + spazio + " dati");
            System.out.println("memoria disponibile : " + capLibera);
            notify();
       // }
    }
    
    public synchronized void delete(int spazio){
       // if(this.capLibera + spazio <= this.capienza){
       while(spazio > this.capienza - this.capLibera){
           
           System.out.println(Thread.currentThread().getName() + " ASPETTA non puoi eliminare " + spazio +" MB");
           
           try{wait();}
           catch(InterruptedException e){}
           
           System.out.println(Thread.currentThread().getName() + " RISVEGLIATI forse puoi eliminare");
       }
            this.capLibera += spazio;
            System.out.print(Thread.currentThread().getName() + " eliminazione di " + spazio + " dati");
            System.out.println("memoria disponibile : " + capLibera);
            notify();
      //  }
    }
    
    public synchronized void format(){
        this.capLibera = this.capienza;
    }

    @Override
    public String toString() {
        return "Memoria{" + "nome=" + nome + ", capienza=" + capienza + ", capLibera=" + capLibera + '}';
    }
}
