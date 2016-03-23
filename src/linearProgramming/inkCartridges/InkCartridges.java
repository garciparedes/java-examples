package linearProgramming.inkCartridges;

import scpsolver.problems.LPWizard;

/**
 *
 * Programa Java que resuelve el problema 1 de la tarea 1 de la asignatura
 * "Modelos para la Toma de Decisiones" de la "Universidad de Valladolid"
 * impartida por Luis Augusto San José Nieto.
 *
 * El enunciado del problema es:
 *  Un pequeño empresario de consumibles informáticos posee una cadena de siete
 *  tiendas en la ciudad. El número de cartuchos disponibles en cada una de las
 *  tiendas al final de la semana es el siguiente:
 *
 *      Tienda 1: 95        Tienda 2: 75        Tienda 3: 70
 *      Tienda 4: 165       Tienda 5: 130       Tienda 6: 75
 *      Tienda 7: 120
 *
 *  El empresario desea que al comienzo del lunes de la semana siguiente haya al
 *  menos 100 cartuchos en cada una de las tiendas. Para cumplir con este
 *  requerimiento se debe envíar cartuchas de aquellas tiendas con mayor número
 *  de cartuchos a aquellas que no tengan los 100 necesarios. Los costes de
 *  envío por cartucho (en céntimos de euro son los siguientes:
 *
 *  1 <--> 2 = 35        1 <--> 3 = 50        1 <--> 4 = 80        1 <--> 5 = 96
 *  2 <--> 3 = 44        2 <--> 4 = 76        2 <--> 5 = 84        3 <--> 4 = 60
 *  3 <--> 5 = 60        3 <--> 6 = 70        3 <--> 7 = 130       4 <--> 5 = 22
 *  4 <--> 6 = 40        4 <--> 7 = 60        5 <--> 6 = 30        5 <--> 7 = 55
 *  6 <--> 7 = 70
 *
 *
 *
 * Created by garciparedes on 23/03/16.
 */
public class InkCartridges {



    private static final String
            X41 = "x41", X42 = "x42", X43 = "x43" , X46 = "x46",
            X51 = "x51", X52 = "x52", X53 = "x53" , X56 = "x56",
            X73 = "x73", X76 = "x76"
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



        /**
         *
         * Definicion de la funcion objetivo.
         *
         */
        linearPr.plus(X41,80).plus(X42,76).plus(X43,60).plus(X46,40)
                .plus(X51,96).plus(X52,84).plus(X53,60).plus(X56,30)
                .plus(X73,130).plus(X76,70);



        linearPr.addConstraint("res1",65,">=").plus(X41).plus(X42).plus(X43).plus(X46);
        linearPr.addConstraint("res2",30,">=").plus(X51).plus(X52).plus(X53).plus(X56);
        linearPr.addConstraint("res3",20,">=").plus(X73).plus(X76);



        linearPr.addConstraint("res6",5,"<=").plus(X41).plus(X51);
        linearPr.addConstraint("res7",25,"<=").plus(X42).plus(X52);
        linearPr.addConstraint("res8",30,"<=").plus(X43).plus(X53).plus(X73);
        linearPr.addConstraint("res9",25,"<=").plus(X46).plus(X56).plus(X76);



        /**
         *
         * Restricciones de no negatividad de
         * las variables de decision.
         *
         */
        linearPr.addConstraint("res18",0,"<=").plus(X41);
        linearPr.addConstraint("res19",0,"<=").plus(X42);
        linearPr.addConstraint("res20",0,"<=").plus(X43);
        linearPr.addConstraint("res21",0,"<=").plus(X46);

        linearPr.addConstraint("res22",0,"<=").plus(X51);
        linearPr.addConstraint("res23",0,"<=").plus(X52);
        linearPr.addConstraint("res24",0,"<=").plus(X53);
        linearPr.addConstraint("res25",0,"<=").plus(X56);

        linearPr.addConstraint("res26",0,"<=").plus(X73);
        linearPr.addConstraint("res27",0,"<=").plus(X76);



        /**
         *
         * Impresión del resultado por salida estandar.
         *
         */
        System.out.println(linearPr.solve().toString());

    }
}
