/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essincronizzazione;

/**
 *
 * @author HP
 */
public class Utente extends Thread{
    private String nome;
    private Memoria memo;

    public Utente(String nome, Memoria memo) {
        this.nome = nome;
        this.setName(nome);
        this.memo = memo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            int n = (int) (Math.random()*250);
            memo.save(n);
            int m = (int) (Math.random()*250);
            memo.delete(m);
        }
    }
}
