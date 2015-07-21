package utfpr.ct.dainf.if62c.avaliacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Nikito(Lucas Vale)
 */
public class Agenda {
    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }
    
    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        timer.schedule(aviso, compromisso.getData());
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia) {
        //Criando o aviso
        Aviso aviso = new Aviso(compromisso);
        
        //Registrando o novo aviso na lista do compromisso
        compromisso.registraAviso(aviso);
        
        //Capturando o horario do pc
        Date atual = new Date();
        atual.setTime(System.currentTimeMillis());
        
        //Utilizando o timer para agendar o aviso
        timer.schedule(aviso, compromisso.getData().getTime() - atual.getTime() -
                (antecedencia * 1000));
        
    }
    
    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {
    
        //Esse metodo é bem semelhante ao anterior porem agora há um intervalo de repetições
        

        //Criando o aviso
        Aviso aviso = new Aviso(compromisso);
        
        //Registrando o novo aviso na lista do compromisso
        compromisso.registraAviso(aviso);
        
        //Capturando o horario do pc
        Date atual = new Date();
        atual.setTime(System.currentTimeMillis());
        
        //Utilizando o timer para agendar o aviso
        timer.schedule(aviso, compromisso.getData().getTime() - atual.getTime() - 
                (antecedencia * 1000), (intervalo*1000));
      
    }
    
    public void cancela(Compromisso compromisso) {
        //Percorrendo todos os avisos, cancelando-os
        for(Aviso i : compromisso.getAvisos()){
            i.cancel();
        }
        //Removendo um compromisso da agenda
        this.compromissos.remove(compromisso);
    }
    
    public void cancela(Aviso aviso) {
        //Apagando o timer
        aviso.cancel();
        //Removendo o aviso do compromisso
        aviso.compromisso.getAvisos().remove(aviso);
    }
    
    public void destroi() {
        //Todos os contadores estão relacionados ao timer global
        timer.cancel();
    }
}
