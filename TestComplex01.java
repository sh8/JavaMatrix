class TestComplex01 { //Complexテスト用クラス 
    public static void main(String[] args) {
        Complex[] c = new Complex[4];
        // 4つの配列要素それぞれに任意の初期値を与える
        c[0] = new Complex( 1.0, 2.0 );
        c[1] = new Complex( -1.0, 5.0 );
        c[2] = new Complex( 3.0, 4.0 );
        c[3] = new Complex( -2.0, -7.0 );
        Complex[][] c_a = {{c[0], c[1]}, {c[2], c[3]}};
        CMatrix cm = new CMatrix(c_a);
        CMatrix cm1 = cm.add(cm);
        CMatrix cm2 = cm.subtract(cm);
        CMatrix cm3 = cm.multiply(cm);
        cm1.printMatrix();
        cm2.printMatrix();
        cm3.printMatrix();
    }
}
