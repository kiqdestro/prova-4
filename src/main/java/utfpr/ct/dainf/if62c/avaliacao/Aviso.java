package utfpr.ct.dainf.if62c.avaliacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author
 */
public class Aviso extends TimerTask{
    
    protected final Compromisso compromisso;

    public Aviso(Compromisso compromisso) {
       this.compromisso = compromisso;
    }
    
    @Override
    public void run()
    {
        Date data = new Date();
        data.setTime(compromisso.getData().getTime() - System.currentTimeMillis());
        SimpleDateFormat spd = new SimpleDateFormat("s");
        System.out.println(compromisso.getDescricao() + " começa em " + spd.format(data) + "s");
    }
        
}
