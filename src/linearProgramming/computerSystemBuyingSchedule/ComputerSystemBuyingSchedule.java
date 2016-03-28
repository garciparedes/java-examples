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
            VA1 = "va1", VA2 = "va2", VA3 = "va3",
            VB1 = "vb1", VB2 = "vb2", VB3 = "vb3",
            VC1 = "vc1", VC2 = "vc2", VC3 = "vc3",
            P1 = "p1", P2 = "p2", P3 = "p3",
            R1 = "r1", R2 = "r2", R3 = "r3"
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
        linearPr.plus(VA3,1430).plus(VB3,624).plus(VC3, 550).plus(R3);



        linearPr.addConstraint("res1",0,">=")
                .plus(P1, -0.7).plus(P2, 0.3).plus(P3, 0.3);

        linearPr.addConstraint("res2",0,">=")
                .plus(P1, -0.4).plus(P2, -0.4).plus(P3, 0.6);


        linearPr.addConstraint("res3",16200,"=").plus(P1).plus(R1);


        linearPr.addConstraint("res4",0,"=")
                .plus(VA1,1800) .plus(VA2,1800) .plus(VA3,1800)
                .plus(VB1,900)  .plus(VB2,900)  .plus(VB3,900)
                .plus(VC1,1200) .plus(VC2,1200) .plus(VC3,1200)
                .plus(P1,-1).plus(P2,-1).plus(P3,-1);


        linearPr.addConstraint("res5",0,"=")
                .plus(VA1,2225).plus(VA2,875).plus(VA3,875)
                .plus(VB1,1010).plus(VB2,335).plus(VB3,335)
                .plus(VC1,1350).plus(VC2,450).plus(VC3,450)
                .plus(R1)
                .plus(R2, -1).plus(P2, -1.05).plus(P3,-0.05);


        linearPr.addConstraint("res6",0,"=")
                .plus(VA2, 1820).plus(VA3,920)
                .plus(VB2, 826).plus(VB3,376)
                .plus(VC2, 1200).plus(VC3,600)
                .plus(R2)
                .plus(R3, -1).plus(P3, -1.05);






        /**
         *
         * Restricciones de no negatividad de
         * las variables de decision.
         *
         */
        linearPr.addConstraint("res18",0,"<=").plus(VA1);
        linearPr.addConstraint("res19",0,"<=").plus(VA2);
        linearPr.addConstraint("res20",0,"<=").plus(VA3);

        linearPr.addConstraint("res21",0,"<=").plus(VB1);
        linearPr.addConstraint("res22",0,"<=").plus(VB2);
        linearPr.addConstraint("res23",0,"<=").plus(VB3);

        linearPr.addConstraint("res24",0,"<=").plus(VC1);
        linearPr.addConstraint("res25",0,"<=").plus(VC2);
        linearPr.addConstraint("res26",0,"<=").plus(VC3);

        linearPr.addConstraint("res27",0,"<=").plus(P1);
        linearPr.addConstraint("res28",0,"<=").plus(P2);
        linearPr.addConstraint("res29",0,"<=").plus(P3);

        linearPr.addConstraint("res30",0,"<=").plus(R1);
        linearPr.addConstraint("res31",0,"<=").plus(R2);
        linearPr.addConstraint("res32",0,"<=").plus(R3);


        /**
         *
         * Impresión del resultado por salida estandar.
         *
         */
        System.out.println(linearPr.solve().toString());

    }
}
