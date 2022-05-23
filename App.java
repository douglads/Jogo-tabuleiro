import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        String jogador1 = "", jogador2 = "", jogador3 = "";
        String[] sj = new String[4];

        System.out.println("Olá, jogadores. Vamos jogar tabuleiro \n");
        for (int i = 1; i >= 1 && i < 4; i++)  {            
            System.out.print("\n"+ i +"º jogador informe seu nome: ");
            sj[i] = entrada.next().toUpperCase();
        }
        
        System.out.print("Pressione <Enter> para sortear os jogadores: ");
        System.in.read();

        int ij[] = new int[4];
        for (int i = 1; i >= 1 && i < 4; i++ ) {
            ij[i] = aleatorio.nextInt(3)+1;
            i++;
        }

        while (ij[2] == ij[1]) {
            ij[2] = aleatorio.nextInt(3)+1;

        }
        while (ij[3] == ij[1] || ij[3] == ij[2]) {
            ij[3] = aleatorio.nextInt(3)+1;

        }

        // aqui faz o sorteio dos jogadores e é setado numa variavel qual ordem eles ficaram.

        
        if (ij[1] == 1) {
            System.out.println("Olá " + sj[1] + " Você será o primeiro(a) a jogar");
            jogador1 = sj[1];
        } else if (ij[1] == 2) {
            System.out.println("Olá " + sj[1] + " Você será o segundo(a) a jogar");
            jogador2 = sj[1];
        } else {
            System.out.println("Olá " + sj[1] + " Você será o terçeiro(a) a jogar");
            jogador3 = sj[1];
        }

        if (ij[2] == 1) {
            System.out.println("Olá " + sj[2] + " Você será o primeiro a jogar");
            jogador1 = sj[2];
        } else if (ij[2] == 2) {
            System.out.println("Olá " + sj[2] + " Você será o segundo(a) a jogar");
            jogador2 = sj[2];
        } else {
            System.out.println("Olá " + sj[2] + " Você será o terçeiro(a) a jogar");
            jogador3 = sj[2];
        }

        if (ij[3] == 1) {
            System.out.println("Olá " + sj[3] + " Você será o primeiro a jogar");
            jogador1 = sj[3];
        }

        else if (ij[3] == 2) {
            System.out.println("Olá " + sj[3] + " Você será o segundo(a) a jogar");
            jogador2 = sj[3];
        } else {
            System.out.println("Olá " + sj[3] + " Você será o terçeiro(a) a jogar");
            jogador3 = sj[3];
        }

        
        System.in.read();

        int dado1, dado2, dadosSoma, pj1 = 0, pj2 = 0, pj3 = 0;

        boolean bj1 = true, bj2 = true, bj3 = true;

//Isto testa se o jogador esta dentro das casas limitantes que são 48 casas do jogo + 12 dos dados
        while (pj1 < 61 || pj2 < 61 || pj3 < 61) {
            System.in.read();// isso serve para parar o console
            if (pj1 == 48) {
                System.out.println("Parabéns: " + jogador1 + " você venceu o jogo!!!");
                System.in.read();
                break;
                
            } else if (pj2 == 48) {
                System.out.println("Parabéns: " + jogador2 + " você venceu o jogo!!!");
                System.in.read();
                break;
            }
            if (pj3 == 48) {
                System.out.println("Parabéns: " + jogador3 + " você venceu o jogo!!!");
                System.in.read();
                break;
            } else {

                if (bj1 == false) {
                    System.out.println("Bem vindo de volta ao jogo " + jogador1);//caso o jogador seja setado como falso quando cai na armadilha aqui ele se valida de novo
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    pj1 += dadosSoma;
                    bj1 = true;
                    System.out.println("Ande mais " + dadosSoma + " casas " + jogador1 + " você está na casa: " + pj1);
                } else if (bj1 == true && pj1 != 15 && pj1 != 23 && pj1 != 36 && pj1 < 48) {//se tudo o ocorrer bem sera seguido esta condição
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    pj1 += dadosSoma;
                    System.out.println("Ande mais " + dadosSoma + " casas " + jogador1 + " você está na casa: " + pj1);
                    System.in.read();
                } else if ((bj1 == true || pj1 == 15 || pj1 == 23 || pj1 == 36) && (pj1 < 48)) {//aqui sera testado se o jogador caiu na armadilha
                    System.out
                            .println("Você está na posição: " + pj1 + " você ficara esta rodada sem jogar " + jogador1);
                    bj1 = false;

                } else if (bj1 == true && pj1 > 48) {/*aqui verifica se o jogador passou a casa final do jogo que é a 48, caso tenha passado é subtraido o valor das casas passadas*/ 
                    int fimj1 = pj1 - 48;
                    pj1 = 48 - fimj1;
                    System.out.println(
                           jogador1 + " você passou as casas limitantes.\nentão você tera que jogar os dados até conseguir\no valor igual a quantidade de casas necessárias "
                                    + jogador1 + " você está na posição: " + pj1);                    
                    System.in.read();
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    System.in.read();
                }
                System.in.read();
                if (bj2 == false) {
                System.out.println("Bem vindo de volta ao jogo " + jogador2);
                dado1 = aleatorio.nextInt(5) + 1;
                dado2 = aleatorio.nextInt(5) + 1;
                dadosSoma = dado1 + dado2;
                pj2 += dadosSoma;
                bj2 = true;                
                System.out.println("Ande mais " + dadosSoma + " casas " + jogador2 + " você está na casa: " + pj2);
                } else if (bj2 == true && pj2 != 15 && pj2 != 23 && pj2 != 36 && pj2 < 48) {
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    pj2 += dadosSoma;
                    System.out.println("Ande mais " + dadosSoma + " casas " + jogador2 + " você está na casa: " + pj2);
                    System.in.read();
                } else if ((bj2 == true || pj2 == 15 || pj2 == 23 || pj2 == 36) && (pj2 < 48)) {                    
                    System.out
                            .println("Você está na posição: " + pj2 + " você ficara esta rodada sem jogar " + jogador2);
                    bj2 = false;
                } else if (bj2 == true && pj2 > 48) {
                    int fimj2 = pj2 - 48;
                    pj2 = 48 - fimj2;
                    System.out.println(
                            jogador2 + " você passou as casas limitantes.\nentão você tera que jogar os dados até conseguir\no valor igual a quantidade de casas necessárias "
                                    + jogador2 + " você está na posição: " + pj2);
                    System.in.read();
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    System.in.read();
                }
                System.in.read();
                if (bj3 == false) {
                    System.out.println("Bem vindo de volta ao jogo " + jogador3);
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    pj3 += dadosSoma;
                    bj3 = true;
                    System.out.println("Ande mais " + dadosSoma + " casas " + jogador3 + " você está na casa: " + pj3);
                } else if (bj3 == true && pj3 != 15 && pj3 != 23 && pj3 != 36 && pj3 < 48) {
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    pj3 += dadosSoma;
                    System.out.println("Ande mais " + dadosSoma + " casas " + jogador3 + " você está na casa: " + pj3);
                    System.in.read();
                } else if ((bj3 == true || pj3 == 15 || pj3 == 23 || pj3 == 36) && (pj3 < 48)) {
                    System.out
                            .println("Você está na posição: " + pj3 + " você ficara esta rodada sem jogar " + jogador3);
                    bj3 = false;

                } else if (bj3 == true && pj3 > 48) {
                    int fimj3 = pj3 - 48;
                    pj3 = 48 - fimj3;
                    System.out.println(
                            jogador3 +" você passou as casas limitantes.\nentão você tera que jogar os dados até conseguir\no valor igual a quantidade de casas necessárias "
                                    + jogador3 + " você está na posição: " + pj3);                    
                    System.in.read();
                    dado1 = aleatorio.nextInt(5) + 1;
                    dado2 = aleatorio.nextInt(5) + 1;
                    dadosSoma = dado1 + dado2;
                    System.in.read();
                }
            }

        }

    }

}
