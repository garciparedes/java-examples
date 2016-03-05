package linearProgramming.robots;

import scpsolver.problems.LPWizard;

/**
 * Created by garciparedes on 04/03/16.
 */
public class Robots {
    
    private static final String
            C1 = "c1",C2 = "c2", C3 = "c3" , C4 = "c4",
            V1 = "v1",V2 = "v2", V3 = "v3" , V4 = "v4",
            R1 = "r1",R2 = "e2", R3 = "r3" , R4 = "r4",
            F1 = "f1",F2 = "f2", F3 = "f3" , F4 = "f4",
            D1 = "d1",D2 = "d2", D3 = "d3"
    ;

    public static void main(String[] args) {

        LPWizard linearPr = new LPWizard();
        
        linearPr.setMinProblem(true);
        linearPr.setAllVariablesInteger();

        linearPr.plus(C1,5000.0).plus(C2,5000.0).plus(C3,5000.0).plus(C4,5000.0)
                .plus(V1,-3000.0).plus(V2,-3000.0).plus(V3,-3000.0).plus(V4,-3000.0)
                .plus(R1,500.0).plus(R2,500.0).plus(R3,500.0).plus(R4,500.0)
                .plus(F1,20.0).plus(F2,20.0).plus(F3,20.0).plus(F4,20.0)
                .plus(D1,30.0).plus(D2,30.0).plus(D3,30.0);

        linearPr.addConstraint("res1",2,"<=").plus(R1);
        linearPr.addConstraint("res5",2,"<=").plus(R4);

        linearPr.addConstraint("res1",0,"=").plus(R1).plus(V1).plus(C1,-1.0);
        linearPr.addConstraint("res2",0,"=").plus(R2).plus(V2).plus(C2,-1.0).plus(R1,-1.0);
        linearPr.addConstraint("res3",0,"=").plus(R3).plus(V3).plus(C3,-1.0).plus(R2,-1.0);
        linearPr.addConstraint("res4",0,"=").plus(R4).plus(V4).plus(C4,-1.0).plus(R3,-1.0);



        linearPr.addConstraint("res6",2,">=").plus(C1);
        linearPr.addConstraint("res7",2,">=").plus(C2);
        linearPr.addConstraint("res8",2,">=").plus(C3);
        linearPr.addConstraint("res9",2,">=").plus(C4);


        linearPr.addConstraint("res10",0,">=").plus(F1).plus(R1,-200.0);
        linearPr.addConstraint("res11",0,">=").plus(F2).plus(R2,-200.0);
        linearPr.addConstraint("res12",0,">=").plus(F3).plus(R3,-200.0);
        linearPr.addConstraint("res13",0,">=").plus(F4).plus(R4,-200.0);


        linearPr.addConstraint("res14",600,"=").plus(F1).plus(D1);
        linearPr.addConstraint("res15",800,"=").plus(F2).plus(D2).plus(D1,-1.0);
        linearPr.addConstraint("res16",500,"=").plus(F3).plus(D3).plus(D2,-1.0);
        linearPr.addConstraint("res17",400,"=").plus(F4).plus(D3,-1.0);


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

        System.out.println(linearPr.solve().toString());

    }
}
