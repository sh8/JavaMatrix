class RMatrix {
    private double[][] m;

    RMatrix( double[][] a ){
        m = new double[a.length][a[0].length];
        for (int i=0; i < a.length; i++ ) {
            for(int j=0; j < a[0].length; j++ ) {
                m[i][j] = a[i][j];
            }
        }
    }

    RMatrix( int row, int column ){
        m = new double[row][column];
        for (int i=0; i < row; i++ ) {
            for(int j=0; j < column; j++ ) {
                m[i][j] = 0.0;
            }
        }
    }

    RMatrix add( RMatrix max ) { 
        if( this.m.length != max.m.length || this.m[0].length != max.m[0].length ) {
            System.out.println( "Matrix addition not defined!" );
            return null;
        }

        RMatrix ans = new RMatrix( m );
        for (int i=0; i < this.m.length; i++ ) {
            for(int j=0; j < m[0].length; j++ ) {
                ans.m[i][j] += max.m[i][j];
            }
        }
        return ans; 
    }

    RMatrix subtract( RMatrix max ) {
        if( this.m.length != max.m.length || this.m[0].length != max.m[0].length ) {
            System.out.println( "Matrix addition not defined!" );
            return null;
        }

        RMatrix ans = new RMatrix( this.m );
        for (int i=0; i < this.m.length; i++ ) {
            for(int j=0; j < this.m[0].length; j++ ) {
                ans.m[i][j] -= max.m[i][j];
            }
        }
        return ans; 
    }
    
    RMatrix multiply( RMatrix max ) {
        if( this.m[0].length != max.m.length ) {
            System.out.println( "Matrix multiplication not defined!" );
            return null;
        }

        RMatrix ans = new RMatrix( max.m.length, this.m[0].length );
        for (int i=0; i < this.m.length; i++ ) {
            for(int j=0; j < max.m[0].length; j++ ) {
                ans.m[i][j] = 0.0;
                for(int k = 0; k < this.m[0].length; k++){
                    ans.m[i][j] += this.m[i][k] * max.m[k][j];
                }
            }
        }
        return ans; 
    }

    double[] solveSimultaneousLinearEquations( double[] b ){
        if( m.length != m[0].length || b.length != m.length ) {
            System.out.println("正方行列ではないので解けません.");
            return null;
        }
        int n = m.length;
        RMatrix Aex = new RMatrix( n, n + 1 );
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++) {
                Aex.m[i][j] = this.m[i][j];
            }
        }
        for(int i=0;i<n;i++) Aex.m[i][n] = b[i]; // 解を格納する配列を生成&初期化
        double[] ans = new double[n];
        double[] work = new double[n+1];
        int n_pivot = 0; // ピボットの配列添え字
        double max;
        double p;
        double q;
        double sum;
        for( int i = 0; i < n-1; i++){
            max = 0.0;
            n_pivot = i; //対角要素の絶対値が一番大きい係数を求める
            for(int j = i; j < n; j++){
                if( Math.abs( Aex.m[j][i] ) > max ) {
                    n_pivot = j;
                    max = Math.abs( Aex.m[j][i] );
                }
            }
            // 最大の係数が 0 にとても近い(逆数を取ったらオーバーフローする)場合
            if ( Math.abs(max) < 1.0/Double.MAX_VALUE ){
                System.out.println("0 でないピボットが見つからない!");
                return null; //終了
            }

           // 対角要素が最大でない場合は行を入れ替える 
            if ( n_pivot != i ){
                for(int k=0;k<n+1;k++){
                    work[k]=Aex.m[n_pivot][k];
                    Aex.m[n_pivot][k]=Aex.m[i][k];
                    Aex.m[i][k]=work[k];
                }
            }
        }

        for(int i = 0; i <= n-1; i++){

            p = Aex.m[i][i];
            for (int l = i; l <= n; l++){
                Aex.m[i][l] /= p;
            }

            for(int a = i+1; a <= n-1; a++){
                q = Aex.m[a][i];
                for(int l = i; l <= n; l++){
                  Aex.m[a][l] -= Aex.m[i][l] * q;
                }
            }
        }

        for(int i=n-1;i>=0;i--) {
            sum = 0.0;
            for(int j = i+1; j < n; j++){
                sum += Aex.m[i][j] * ans[j];
            }
            ans[i] = Math.round((Aex.m[i][n] - sum)*100.0)/100.0;
        }

        return ans; 
    }

    void printMatrix() {
        for (int i=0; i < m.length; i++ ) {
            for(int j=0; j < m[0].length; j++ ) {
                System.out.print( m[i][j] + " " );
            }
            System.out.println();
        }
    }
}
