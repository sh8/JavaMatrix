class Max22 {
    private double[][] m;

    Max22(double[][] a){
        m = new double[2][2];
        m[0][0] = a[0][0];
        m[0][1] = a[0][1];
        m[1][0] = a[1][0];
        m[1][1] = a[1][1];
    }

    Max22 add( Max22 max){
        Max22 ans = new Max22(this.m);
        ans.m[0][0] += max.m[0][0]; ans.m[0][1] += max.m[0][1];
        ans.m[1][0] += max.m[1][0]; ans.m[1][1] += max.m[1][1];
        return ans;
    }

    void printMatrix() {
        System.out.print( "a00=" + m[0][0] );
        System.out.println( " a01=" + m[0][1] );
        System.out.print( "a10=" + m[1][0] );
        System.out.println( " a11=" + m[1][1] );
    }
}

class TestMax22 {
    public static void main(String[] args) {
        double[][] a = {{1.0, 0.0}, {3.0, 0.0}};
        Max22 m1 = new Max22( a );
        double[][] b = {{0.0, 2.0}, {0.0, 4.0}};
        Max22 m2 = new Max22( b );
        ( m1.add(m2) ).printMatrix();
    }
}
