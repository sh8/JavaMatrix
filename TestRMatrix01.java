class TestRMatrix01 { 
    public static void main(String[] args) {
        double[][] a = {{1.0, 0.0}, {3.0, 0.0}};
        RMatrix m1 = new RMatrix(a);
        double[][] b = {{0.0, 2.0}, {0.0, 4.0}};
        RMatrix m2 = new RMatrix(b);
        double[][] c = {{0.0, 2.0, 4.0 }, {1.0, 3.0, 5.0}};
        RMatrix m3 = new RMatrix( c );
        double[][] d = { {0.0, 2.0, 4.0, 8.0 }, {1.0, 3.0, 5.0, 2.0},
            {-1.0, -2.0, -3.0, -4.0} };
        RMatrix m4 = new RMatrix( d );
        ( m1.multiply(m2) ).printMatrix();
    }
}
