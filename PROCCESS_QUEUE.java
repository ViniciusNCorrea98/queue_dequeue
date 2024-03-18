public class PROCCESS_QUEUE {

    private static class NO{
        public int dado;
        public NO prox;
    }

    private static NO inicio;
    private static NO fim;

    static class Retorno{
        public int item;
        public boolean status;
    }

    public void Init(){
        inicio = null;
        fim = null;
    }

    public boolean IsEmpty() {
        return (inicio == null && fim == null);
    }

    public void Enqueue(int item){
        NO novo = new NO();
        novo.dado = item;
        novo.prox = null;

        if(IsEmpty())
            inicio = novo;
        else
            fim.prox = novo;

        fim = novo;
    }

    public Retorno Dequeue(){
        Retorno saida = new Retorno();

        if(!IsEmpty()){
            saida.item = inicio.dado;
            inicio = inicio.prox;

            if (inicio==null) fim = null;

            saida.status = true;
        }
        else
            saida.status = false;

        return saida;
    }

    public Retorno First(){
        Retorno saida = new Retorno();

        if(!IsEmpty()){
            saida.item = inicio.dado;;
            saida.status = true;
        }
        else
            saida.status = false;
        return saida;
    }
}
