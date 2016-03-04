package linearProgramming.robots;

import scpsolver.problems.LPWizard;

/**
 * Created by garciparedes on 04/03/16.
 */
public class Robots {

    public static void main(String[] args) {
        LPWizard lpw = new LPWizard();
        lpw.plus("c1",5000.0).plus("c2",5000.0).plus("c3",5000.0).plus("c4",5000.0)
                .plus("v1",-3000.0).plus("v2",-3000.0).plus("v3",-3000.0).plus("v4",-3000.0)
                .plus("r1",500.0).plus("r2",500.0).plus("r3",500.0).plus("r4",500.0)
                .plus("f1",20.0).plus("f2",20.0).plus("f3",20.0).plus("f4",20.0)
                .plus("d1",30.0).plus("d2",30.0).plus("d3",30.0);

        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);

        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);

        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);

        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
        lpw.addConstraint("c2",4,"<=").plus("x2",4.0);
    }
}
