class Complex {
    private double re;
    private double im;

    public Complex (double x, double y) { 
        re = x; // 実部
        im = y; // 虚部
    }

    public double re() { // 実部を返すメソッド
        return re;
    }
    
    public double im() { // 虚部を返すメソッド
        return im;
    }

    public double abs() {
        return Math.sqrt( re * re + im * im );
    }

    public Complex add ( Complex c ) {
        return new Complex( this.re + c.re, this.im + c.im );
    }

    public Complex subtract ( Complex c ) {
        return new Complex( this.re - c.re, this.im - c.im );
    }

    public Complex multiply ( Complex c ) {
        return new Complex((this.re * c.re) - (this.im * c.im), (this.re * c.im) + (c.re * this.im));
    }

    public Complex divide ( Complex c ){
        Complex tmp_c = new Complex(c.re, -c.im);
        return new Complex(this.multiply(tmp_c).re / (c.abs() * c.abs()), this.multiply(tmp_c).im / (c.abs() * c.abs()));
    }

    public void printValue(){
        System.out.println( this.re + " + " + this.im + "j");

    }
    public String toString() {
        return this.re + "+" + this.im + "j";
    }

    public boolean equals(Object o) {
        Complex c = (Complex)o;
        return re == c.re() && im == c.im();
    }
}
