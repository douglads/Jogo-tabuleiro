import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        String sj1, sj2, sj3, jogador1 = "", jogador2 = "", jogador3 = "";

        System.out.println("Olá, jogadores. Vamos jogar tabuleiro \n");
        System.out.print("\nPrimeiro jogador informe seu nome: ");
        sj1 = entrada.next().toUpperCase();
        System.out.print("\nSegundo jogador informe seu nome: ");
        sj2 = entrada.next().toUpperCase();
        System.out.print("\nTerceiro jogador informe seu nome: ");
        sj3 = entrada.next().toUpperCase();
        System.out.print("Pressione <Enter> para sortear os jogadores: ");
        System.in.read();

        int ij1 = aleatorio.nextInt(3);
        int ij2 = aleatorio.nextInt(3);
        int ij3 = aleatorio.nextInt(3);
        ij1++;
        ij2++;
        ij3++;

        while (ij2 == ij1) {
            ij2 = aleatorio.nextInt(3);
            ij2++;

        }
        while (ij3 == ij1 || ij3 == ij2) {
            ij3 = aleatorio.nextInt(3);
            ij3++;

        }
        // aqui faz o sorteio dos jogadores e é setado numa variavel qual ordem eles ficaram.
        if (ij1 == 1) {
            System.out.println("Olá " + sj1 + " Você será o primeiro(a) a jogar");
            jogador1 = sj1;
        } else if (ij1 == 2) {
            System.out.println("Olá " + sj1 + " Você será o segundo(a) a jogar");
            jogador2 = sj1;
        } else {
            System.out.println("Olá " + sj1 + " Você será o terçeiro(a) a jogar");
            jogador3 = sj1;
        }

        if (ij2 == 1) {
            System.out.println("Olá " + sj2 + " Você será o primeiro a jogar");
            jogador1 = sj2;
        } else if (ij2 == 2) {
            System.out.println("Olá " + sj2 + " Você será o segundo(a) a jogar");
            jogador2 = sj2;
        } else {
            System.out.println("Olá " + sj2 + " Você será o terçeiro(a) a jogar");
            jogador3 = sj2;
        }

        if (ij3 == 1) {
            System.out.println("Olá " + sj3 + " Você será o primeiro a jogar");
            jogador1 = sj3;
        }

        else if (ij3 == 2) {
            System.out.println("Olá " + sj3 + " Você será o segundo(a) a jogar");
            jogador2 = sj3;
        } else {
            System.out.println("Olá " + sj3 + " Você será o terçeiro(a) a jogar");
            jogador3 = sj3;
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
