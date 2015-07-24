class CMatrix {
    private Complex[][] m;

    CMatrix( Complex[][] array ){
        this.m = new Complex[array.length][array[0].length];
        for (int i=0; i < array.length; i++ ) {
            for(int j=0; j < array[0].length; j++ ) {
                m[i][j] = array[i][j];
            }
        }
    }

    CMatrix( int row, int column ){
        this.m = new Complex[row][column];
        for (int i=0; i < row; i++ ) {
            for(int j=0; j < column; j++ ) {
                m[i][j] = new Complex(0.0, 0.0);
            }
        }
    }

    public int getRowSize () {
        return this.m.length;
    }

    public int getColumnSize () {
        return this.m[0].length;
    }

    public void copy (CMatrix mate) {
        if(this.getRowSize() == mate.getRowSize() &&
            this.getColumnSize() == mate.getColumnSize()){
            this.m = mate.m;
        }
    }

    CMatrix add( CMatrix max ) { 
        if( this.m.length != max.m.length || this.m[0].length != max.m[0].length ) {
            System.out.println( "Matrix addition not defined!" );
            return null;
        }

        CMatrix ans = new CMatrix( this.m );
        for (int i=0; i < this.m.length; i++ ) {
            for(int j=0; j < m[0].length; j++ ) {
                ans.m[i][j] = ans.m[i][j].add(max.m[i][j]);
            }
        }
        return ans; 
    }

    CMatrix subtract( CMatrix max ) {
        if( this.m.length != max.m.length || this.m[0].length != max.m[0].length ) {
            System.out.println( "Matrix addition not defined!" );
            return null;
        }

        CMatrix ans = new CMatrix( this.m );
        for (int i=0; i < this.m.length; i++ ) {
            for(int j=0; j < this.m[0].length; j++ ) {
                ans.m[i][j] = ans.m[i][j].subtract(max.m[i][j]);
            }
        }
        return ans; 
    }
    
    CMatrix multiply( CMatrix max ) {
        if( this.m[0].length != max.m.length ) {
            System.out.println( "Matrix multiplication not defined!" );
            return null;
        }

        CMatrix ans = new CMatrix( max.m.length, this.m[0].length );
        for (int i=0; i < this.m.length; i++ ) {
            for(int j=0; j < max.m[0].length; j++ ) {
                ans.m[i][j] = new Complex(0.0, 0.0);
                for(int k = 0; k < this.m[0].length; k++){
                    ans.m[i][j] = ans.m[i][j].add(this.m[i][k].multiply(max.m[k][j]));
                }
            }
        }
        return ans; 
    }

    boolean equals ( CMatrix mate ) {
        for (int i=0; i < m.length; i++ ) {
            for(int j=0; j < m[0].length; j++ ) {
                if(!this.m[i][j].equals(mate.m[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    void printMatrix() {
        for (int i=0; i < m.length; i++ ) {
            for(int j=0; j < m[0].length; j++ ) {
                System.out.println( this.m[i][j].re() + " + " + this.m[i][j].im() + "j");
            }
        }
        System.out.println();
    }
}
