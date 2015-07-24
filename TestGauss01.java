class TestGauss01 {
    public static void main(String[] args) {
        double[][] a1 = {{2,-2,3}, {2,-1,1},{1,3,-5}};
        double[][] a2 = {{1,-2,1,4}, {2,-6,1,7},{1,0,2,5},{2,-2,3,9}};
        RMatrix A= new RMatrix( a1 );
        double[] b1 = {5,6,2};
        double[] b2 = {5,13,2,4};
        double[] sol;
        sol = A.solveSimultaneousLinearEquations( b1 );
        for(int i=0;i<sol.length;i++) System.out.println("x" + i + ":" + sol[i] );
    }
}
