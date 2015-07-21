package utfpr.ct.dainf.if62c.avaliacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Nikito(Lucas Vale)
 */
public class Aviso extends TimerTask{
    
    protected final Compromisso compromisso;

    public Aviso(Compromisso compromisso) {
       this.compromisso = compromisso;
    }
    
    @Override
    public void run()
    {
        //Pegando a data atual
        Date data = new Date();
        
        //Calculando a diferença da data atual até a data do compromisso
        data.setTime(compromisso.getData().getTime() - System.currentTimeMillis());
        
        //Definindo o formato que a data sera impressa
        SimpleDateFormat spd = new SimpleDateFormat("s");
        
        //Imprimindo a descrição do compromisso e o tempo que falta para o mesmo
        System.out.println(compromisso.getDescricao() + " começa em " + spd.format(data) + "s");
    }
        
}
