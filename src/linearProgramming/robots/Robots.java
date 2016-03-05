package linearProgramming.robots;

import scpsolver.problems.LPWizard;

/**
 * Created by garciparedes on 04/03/16.
 */
public class Robots {

    public static void main(String[] args) {

        LPWizard linearPr = new LPWizard();
        
        linearPr.setMinProblem(true);
        linearPr.setAllVariablesInteger();

        linearPr.plus("c1",5000.0).plus("c2",5000.0).plus("c3",5000.0).plus("c4",5000.0)
                .plus("v1",-3000.0).plus("v2",-3000.0).plus("v3",-3000.0).plus("v4",-3000.0)
                .plus("r1",500.0).plus("r2",500.0).plus("r3",500.0).plus("r4",500.0)
                .plus("f1",20.0).plus("f2",20.0).plus("f3",20.0).plus("f4",20.0)
                .plus("d1",30.0).plus("d2",30.0).plus("d3",30.0);

        linearPr.addConstraint("res1",2,"<=").plus("r1");
        linearPr.addConstraint("res5",2,"<=").plus("r4");

        linearPr.addConstraint("res1",0,"=").plus("r1").plus("v1").plus("c1",-1.0);
        linearPr.addConstraint("res2",0,"=").plus("r2").plus("v2").plus("c2",-1.0).plus("r1",-1.0);
        linearPr.addConstraint("res3",0,"=").plus("r3").plus("v3").plus("c3",-1.0).plus("r2",-1.0);
        linearPr.addConstraint("res4",0,"=").plus("r4").plus("v4").plus("c4",-1.0).plus("r3",-1.0);



        linearPr.addConstraint("res6",2,">=").plus("c1");
        linearPr.addConstraint("res7",2,">=").plus("c2");
        linearPr.addConstraint("res8",2,">=").plus("c3");
        linearPr.addConstraint("res9",2,">=").plus("c4");


        linearPr.addConstraint("res10",0,">=").plus("f1").plus("r1",-200.0);
        linearPr.addConstraint("res11",0,">=").plus("f2").plus("r2",-200.0);
        linearPr.addConstraint("res12",0,">=").plus("f3").plus("r3",-200.0);
        linearPr.addConstraint("res13",0,">=").plus("f4").plus("r4",-200.0);


        linearPr.addConstraint("res14",600,"=").plus("f1").plus("d1");
        linearPr.addConstraint("res15",800,"=").plus("f2").plus("d2").plus("d1",-1.0);
        linearPr.addConstraint("res16",500,"=").plus("f3").plus("d3").plus("d2",-1.0);
        linearPr.addConstraint("res17",400,"=").plus("f4").plus("d3",-1.0);


        linearPr.addConstraint("res18",0,"<=").plus("c1");
        linearPr.addConstraint("res19",0,"<=").plus("c2");
        linearPr.addConstraint("res20",0,"<=").plus("c3");
        linearPr.addConstraint("res21",0,"<=").plus("c4");

        linearPr.addConstraint("res22",0,"<=").plus("v1");
        linearPr.addConstraint("res23",0,"<=").plus("v2");
        linearPr.addConstraint("res24",0,"<=").plus("v3");
        linearPr.addConstraint("res25",0,"<=").plus("v4");

        linearPr.addConstraint("res26",0,"<=").plus("r1");
        linearPr.addConstraint("res27",0,"<=").plus("r2");
        linearPr.addConstraint("res28",0,"<=").plus("r3");
        linearPr.addConstraint("res29",0,"<=").plus("r4");

        linearPr.addConstraint("res30",0,"<=").plus("f1");
        linearPr.addConstraint("res31",0,"<=").plus("f2");
        linearPr.addConstraint("res32",0,"<=").plus("f3");
        linearPr.addConstraint("res33",0,"<=").plus("f4");

        linearPr.addConstraint("res34",0,"<=").plus("d1");
        linearPr.addConstraint("res35",0,"<=").plus("d2");
        linearPr.addConstraint("res36",0,"<=").plus("d3");

        System.out.println(linearPr.solve().toString());

    }
}
