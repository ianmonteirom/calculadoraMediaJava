import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    public static Scanner scanner = new Scanner(System.in);

    public static NotasAluno semestre1 = new NotasAluno();
    public static NotasAluno semestre2 = new NotasAluno();
    public static List<NotasAluno> semestres = new ArrayList<>(List.of(semestre1, semestre2));
    public static List<Double> mediasSemestrais = new ArrayList<>();

    public static void main(String[] args) {

        boolean continuar = true;

        while (continuar) {

            int escolha = mostrarMenu();


            switch (escolha) {
                case 1:
                    List<Double> notas1Semestre = registrarNotasAluno(1);
                    System.out.println("Notas registradas: " + notas1Semestre);
                    double media1Semestre = calculaMediaSemestral(notas1Semestre);
                    System.out.println("Média do primeiro semestre: " + media1Semestre);
                    mediasSemestrais.add(media1Semestre);
                    break;
                case 2:
                    List<Double> notas2Semestre = registrarNotasAluno(2);
                    System.out.println("Notas registradas: " + notas2Semestre);
                    double media2Semestre = calculaMediaSemestral(notas2Semestre);
                    System.out.println("Média do segundo semestre: " + media2Semestre);
                    mediasSemestrais.add(media2Semestre);
                    break;
                case 3:
                    try {
                        if (mediasSemestrais.size() == 2) {
                            if (mediasSemestrais.get(0) != 0 && mediasSemestrais.get(1) != 0) {
                                double mediaAnual = calculaMediaAnual(mediasSemestrais);
                                System.out.println("Média anual do aluno: " + mediaAnual);
                            } else {
                                System.out.println("Médias semestrais não preenchidas corretamente ou iguais a zero!");
                            }
                        } else {
                            System.out.println("Médias semestrais não preenchidas corretamente!");
                        }
                        break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                case 4:
                    continuar = false;
                    break;
            }

        }

    }

    public static int mostrarMenu() {
        System.out.println("""
                1 - Calcular média 1° semestre
                2 - Calcular média 2° semestre
                3 - Calcular média anual
                4 - Sair
                Escolha uma opção:\s""");

        int opc = scanner.nextInt();

        return opc;

    }

    public static List<Double> registrarNotasAluno(int semestreSelecionado) {

        List<Double> notas = new ArrayList<>();

        NotasAluno semestre = semestres.get(semestreSelecionado - 1);

//        System.out.println("Digite a nota da CP 1: ");
//        semestre.notaCp1 = scanner.nextDouble();
//        System.out.println("Digite a nota da CP 2: ");
//        semestre.notaCp2 = scanner.nextDouble();
//        System.out.println("Digite a nota da CP 3: ");
//        semestre.notaCp3 = scanner.nextDouble();
//        System.out.println("Digite a nota da CHALLENGE: ");
//        semestre.notaChallenge = scanner.nextDouble();
        System.out.println("Digite a nota da PCCF: ");
        semestre.notaPCCF = scanner.nextDouble();
        System.out.println("Digite a nota da GS: ");
        semestre.notaGs = scanner.nextDouble();

//        notas.add(semestre.notaCp1);
//        notas.add(semestre.notaCp2);
//        notas.add(semestre.notaCp3);
//        notas.add(semestre.notaChallenge);
        notas.add(semestre.notaPCCF);
        notas.add(semestre.notaGs);

//        System.out.println("Notas registradas: " + notas);

        return notas;

    }

    public static double calculaMediaSemestral(List<Double> notas) {


//        double totalCps = (notas.get(0) + notas.get(1) + notas.get(2) + notas.get(3)) / 4;
        double totalGs = notas.get(1) * 0.6;
        double totalPCCF = notas.get(0) * 0.4;

//        double mediaSemestre = totalCps + totalGs;

        double mediaSemestre = (notas.get(0) * 0.4) + (notas.get(1) * 0.6);
//        System.out.println("Valor cps + challenge: " + totalCps);
        System.out.println("Valor PCCF: " + totalPCCF);
        System.out.println("Valor GS: " + totalGs);

        return mediaSemestre;

    }

    public static double calculaMediaAnual(List<Double> medias) {

        return (medias.getFirst() * 0.4) + (medias.get(1) * 0.6);
    }

}
