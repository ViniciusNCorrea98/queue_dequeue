import java.util.Scanner;


public class main {

    static PROCCESS_QUEUE queue = new PROCCESS_QUEUE();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        queue.Init();
        PROCCESS_QUEUE.Retorno resultado = new PROCCESS_QUEUE.Retorno();

        int proccess_id, op, resp;
        do{
            System.out.println("1-Inserir processo: \n");
            System.out.println("2-Executar processo: \n");
            System.out.println("3-Sair: \n");

            op = sc.nextInt();

            switch(op){
                case 1:
                    System.out.println("proccess_id: \n");
                    proccess_id = sc.nextInt();
                    queue.Enqueue(proccess_id);
                    break;
                case 2:
                    resultado = queue.Dequeue();
                    if(resultado.status) {
                        System.out.println("Processing in execution: " + resultado.item);
                        System.out.println("Was Proccess finish? (1-Yes/2-No): ");
                        resp = sc.nextInt();
                        if (resp == 2)
                            queue.Enqueue(resultado.item);
                        else
                            System.out.println("Proccess is finished!\n" + resultado.item);

                        break;
                    }
                case 3:
                    System.out.println("This is the end of programin! :)!\n");

                    resultado = queue.Dequeue();

                    while(resultado.status){
                        System.out.println("The is process finished!\n" + resultado.item);
                        resultado = queue.Dequeue();
                    }
                    break;
                default:
                    System.out.println("Wrong option\n");
            }

        } while(op != 3);

        sc.close();
    }

}
