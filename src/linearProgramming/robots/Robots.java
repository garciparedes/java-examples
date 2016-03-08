package linearProgramming.robots;

import scpsolver.problems.LPWizard;

/**
 *
 * Programa Java que resuelve el problema 1.22
 * de la asignatura "Modelos para la Toma de Decisiones"
 * de la "Universidad de Valladolid" impartida por
 * Luis Augusto San José Nieto.
 *
 * El enunciado del problema es:
 *
 * Tekaka utiliza robots para producir frigorícos. Hay que cumplir
 * con las siguientes demandas de frigorícos al final del trimestre 4:
 * trimestre 1, 600; trimestre 2, 800; trimestre 3, 500 y trimestre 4, 400.
 * Al inicio del trimestre 1, Tekaka tiene 2 robots. Se pueden comprar
 * a lo más 2 robots al inicio de cada trimestre. Cada robot puede producir
 * hasta 200 frigorícos por trimestre. Un robot cuesta 5000 euros.
 * Durante cada trimestre, se tienen unos costes de mantenimiento de 500 euros
 * por robot (aunque no se use para construir frigorícos). También se puede
 * vender los robots al inicio de cada trimestre, a 3000 euros el robot.
 * Al final de cada trimestre, se aplica un coste de mantenimiento del
 * inventario de 20 euros por cada frigoríco. Si se tiene una demanda
 * pendiente, se incurre en un coste de 30 euros por frigoríco y por cada
 * trimestre que se deja pendiente la demanda. Al nal del cuarto trimestre,
 * Tekaka debe tener por lo menos dos robots.
 *
 * Formular un modelo de PL que se pueda utilizar para minimizar los
 * costos totales incurridos para cumplir las demandas de los frigorícos
 * durante los cuatro próximos trimestres.
 *
 *
 * Created by garciparedes on 04/03/16.
 */
public class Robots {


    /**
     *
     * Variables de decisión del problema.
     *
     *  Ri: Nº de robots que se tienen en el trimestre i.   1 <= i <= 4
     *  Ci: Nº de robots que se compran en el trimestre i.   1 <= i <= 4
     *  Vi: Nº de robots que se venden en el trimestre i.   1 <= i <= 4
     *  Fi: Nº de frigoríficos que se fabrican en el trimestre i.   1 <= i <= 4
     *  Di: Nº de robots que se fabrican de menos en el trimestre i.   1 <= i <= 3
     *          Nota: Di es hasta 3 para no dejar robots sin fabricar al final
     *          del último trimestre.
     *
     */
    private static final String
            C1 = "c1",C2 = "c2", C3 = "c3" , C4 = "c4",
            V1 = "v1",V2 = "v2", V3 = "v3" , V4 = "v4",
            R1 = "r1",R2 = "r2", R3 = "r3" , R4 = "r4",
            F1 = "f1",F2 = "f2", F3 = "f3" , F4 = "f4",
            D1 = "d1",D2 = "d2", D3 = "d3"
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
         * Definicion del problema como de minimizacion y
         * ademas restringimos el valor de variables a enteros
         * para que los resultados sean coherentes.
         *
         */
        linearPr.setMinProblem(true);
        linearPr.setAllVariablesInteger();

        /**
         *
         * Definicion de la funcion objetivo.
         *
         */
        linearPr.plus(C1,5000.0).plus(C2,5000.0).plus(C3,5000.0).plus(C4,5000.0)
                .plus(V1,-3000.0).plus(V2,-3000.0).plus(V3,-3000.0).plus(V4,-3000.0)
                .plus(R1,500.0).plus(R2,500.0).plus(R3,500.0).plus(R4,500.0)
                .plus(F1,20.0).plus(F2,20.0).plus(F3,20.0).plus(F4,20.0)
                .plus(D1,30.0).plus(D2,30.0).plus(D3,30.0);

        /**
         *
         * Restriccion del numero de robots en el
         * ultimo trimestre.
         *
         */
        linearPr.addConstraint("res5",2,"<=").plus(R4);

        /**
         *
         * Restricciones asociadas a que el numero de robots
         * tiene que ser igual a los que se compran menos los
         * que se venden mas los del trimestre anterior.
         *
         * El caso del primer trimestre es especial ya que tiene no
         * hay un trimestre anterior y ya hay dos robots.
         *
         */
        linearPr.addConstraint("res1",2,"=").plus(R1).plus(V1).plus(C1,-1.0);
        linearPr.addConstraint("res2",0,"=").plus(R2).plus(V2).plus(C2,-1.0).plus(R1,-1.0);
        linearPr.addConstraint("res3",0,"=").plus(R3).plus(V3).plus(C3,-1.0).plus(R2,-1.0);
        linearPr.addConstraint("res4",0,"=").plus(R4).plus(V4).plus(C4,-1.0).plus(R3,-1.0);


        /**
         *
         * Restricciones asociadas al numero maximo de robots
         * que se pueden comprar por trismestre.
         *
         */
        linearPr.addConstraint("res6",2,">=").plus(C1);
        linearPr.addConstraint("res7",2,">=").plus(C2);
        linearPr.addConstraint("res8",2,">=").plus(C3);
        linearPr.addConstraint("res9",2,">=").plus(C4);


        /**
         *
         * Restricciones asociadas al numero maximo de frigorificos
         * que puede producir cada robot.
         *
         */
        linearPr.addConstraint("res10",0,">=").plus(F1).plus(R1,-200.0);
        linearPr.addConstraint("res11",0,">=").plus(F2).plus(R2,-200.0);
        linearPr.addConstraint("res12",0,">=").plus(F3).plus(R3,-200.0);
        linearPr.addConstraint("res13",0,">=").plus(F4).plus(R4,-200.0);


        /**
         *
         * Restricciones asociadas a la cantidad de frigorificos
         * que se deben produccir cada trimestre.
         *
         */
        linearPr.addConstraint("res14",600,"=").plus(F1).plus(D1);
        linearPr.addConstraint("res15",800,"=").plus(F2).plus(D2).plus(D1,-1.0);
        linearPr.addConstraint("res16",500,"=").plus(F3).plus(D3).plus(D2,-1.0);
        linearPr.addConstraint("res17",400,"=").plus(F4).plus(D3,-1.0);


        /**
         *
         * Restricciones de no negatividad de
         * las variables de decision.
         *
         */
        linearPr.addConstraint("res18",0,"<=").plus(C1);
        linearPr.addConstraint("res19",0,"<=").plus(C2);
        linearPr.addConstraint("res20",0,"<=").plus(C3);
        linearPr.addConstraint("res21",0,"<=").plus(C4);

        linearPr.addConstraint("res22",0,"<=").plus(V1);
        linearPr.addConstraint("res23",0,"<=").plus(V2);
        linearPr.addConstraint("res24",0,"<=").plus(V3);
        linearPr.addConstraint("res25",0,"<=").plus(V4);

        linearPr.addConstraint("res26",0,"<=").plus(R1);
        linearPr.addConstraint("res27",0,"<=").plus(R2);
        linearPr.addConstraint("res28",0,"<=").plus(R3);
        linearPr.addConstraint("res29",0,"<=").plus(R4);

        linearPr.addConstraint("res30",0,"<=").plus(F1);
        linearPr.addConstraint("res31",0,"<=").plus(F2);
        linearPr.addConstraint("res32",0,"<=").plus(F3);
        linearPr.addConstraint("res33",0,"<=").plus(F4);

        linearPr.addConstraint("res34",0,"<=").plus(D1);
        linearPr.addConstraint("res35",0,"<=").plus(D2);
        linearPr.addConstraint("res36",0,"<=").plus(D3);

        /**
         *
         * Impresión del resultado por salida estandar.
         *
         */
        System.out.println(linearPr.solve().toString());

    }
}
