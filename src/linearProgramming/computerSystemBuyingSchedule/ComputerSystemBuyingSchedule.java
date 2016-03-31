package linearProgramming.computerSystemBuyingSchedule;

import scpsolver.problems.LPWizard;

/**
 *
 * Programa Java que resuelve el problema 2 de la tarea 1 de la asignatura
 * "Modelos para la Toma de Decisiones" de la "Universidad de Valladolid"
 * impartida por Luis Augusto San José Nieto.
 *
 * El enunciado del problema es:
 *
 *
 *
 * Created by garciparedes on 23/03/16.
 */
public class ComputerSystemBuyingSchedule {



    private static final String
            A = "a", B = "b", C = "c",
            P1 = "p1", P2 = "p2", P3 = "p3"
    ;



    /**
     *
     * Metodo Main que inicializa el programa.
     *
     * @param args null
     */
    public static void main(String[] args) {


        /**
         *
         * Inicializacion del problema
         *
         */
        LPWizard linearPr = new LPWizard();


        /**
         *
         * Definicion del problema como de maximizacion.
         *
         */
        linearPr.setMinProblem(false);




        /**
         *
         * Definicion de la funcion objetivo.
         *
         */
        linearPr.plus(A, 875 + 920 + 980 + 1800 * 0.25 + 1800)
                .plus(B, 335 + 376 + 399 + 900 * 0.25 + 900)
                .plus(C, 450 + 600 + 250 + 1200 * 0.25 + 1200)
                .plus(P1,-1)
                .plus(P2,-1)
                .plus(P3,-1)
        ;
        
        linearPr.addConstraint("res1",0,">=")
                .plus(A, 540).plus(B, 270).plus(C, 360).plus(P1,-1);

        linearPr.addConstraint("res2",0,">=")
                .plus(A, 1134).plus(B, 567).plus(C, 756).plus(P1,-0.63).plus(P2,-1);

        linearPr.addConstraint("res3",0,"=")
                .plus(A, 1984.5).plus(B, 992.25).plus(C, 1323).plus(P1,-1.1025).plus(P2,-1.05).plus(P3,-1);


        linearPr.addConstraint("res4",16200,">=")
                .plus(A,1800)
                .plus(B,900)
                .plus(C,1200);






        /**
         *
         * Restricciones de no negatividad de
         * las variables de decision.
         *
         */
        linearPr.addConstraint("res20",0,"<=").plus(A);

        linearPr.addConstraint("res23",0,"<=").plus(B);

        linearPr.addConstraint("res26",0,"<=").plus(C);

        linearPr.addConstraint("res27",0,"<=").plus(P1);
        linearPr.addConstraint("res28",0,"<=").plus(P2);
        linearPr.addConstraint("res29",0,"<=").plus(P3);


        /**
         *
         * Impresión del resultado por salida estandar.
         *
         */
        System.out.println(linearPr.solve().toString());

    }
}
