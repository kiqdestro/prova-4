package utfpr.ct.dainf.if62c.avaliacao;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Nikito(Lucas Vale)
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
    }
    
    @Override
    public void run()
    {
        //Imprimindo na tela a mensagem do compromisso
        System.out.println( compromisso.getDescricao() + " começa agora.");
        
        //Deletando todos os avisos relacionados a esse compromisso
        for(Aviso i : compromisso.getAvisos()){
            i.cancel();
        }  
    }
    
}
