package computation;

public class TaylorSeriesExpansion {

    private int n;
    private Interval interval;
    private double stepsize;
    private Differential differential; // linearCoefficient, derivedCoefficient
    private Condition ivc; // initialValueCondition

    public TaylorSeriesExpansion() { this(0, null, 0.0, null, null); }
    public TaylorSeriesExpansion(int n, Interval interval, double stepsize, Differential differential, Condition initialValueCondition) {
        this.n = n;
        this.interval = interval;
        this.stepsize = stepsize;
        this.differential = differential;
        this.ivc = initialValueCondition;
    }

    public String printGenericF() {
        String generic = "";
        for(int i = 0; i < this.n; i++) {
            generic += "\nf" + (i + 1) + " = f(" + this.ivc.getX() + (i == 0 ? "" : " + " + stepsize + (i == 3 ? "" : "/2.0")) + ", " + this.ivc.getY() + (i == 0 || i == 3 ? "" : " + " + stepsize + "/2.0") + (i == 0 ? "" : " * f" + i) + ")\n";
            System.out.println();
            generic += f(i);
            generic += Double.toString(f_of(i));
        }
        return generic += y_next();
    }

    public String f(int order) {
        double val = this.ivc.getX();
        switch(order) {
            case 0: break;
            case 1: case 2: val += (this.stepsize / 2.0); break;
            case 3: val += (this.stepsize); break;
            default: System.out.println("Sorry! There is an error in your choice of input. ");
        }

        return "   = f(" + val + ", " + (order == 1 || order == 2 ? this.ivc.getY() + this.stepsize / 2.0 : this.ivc.getY() ) + " * f" + order + ")\n";
    }

    /* Write code for the function */
    public double f_of(int order) {
        switch(order) {
            case 0: return this.ivc.getX() - this.ivc.getY() / 2;
            case 1: return this.ivc.getX() + this.stepsize / 2.0;
            case 2: return ((this.ivc.getX() - this.ivc.getY()) / 2.0 - 1.0) / 4.0;
            case 3: return 0;

            default: return -1;
        }
    }
    /* Final output */
    public double y_next() { return this.ivc.getY() + (this.stepsize * (f_of(1) + 2 * (f_of(2) + f_of(3)) + f_of(4))) / 6.0; }

    public double process(int order) { return order == 0 ? 0.0 : this.stepsize + 0.25 / 2.0; }
    @Override public String toString() { return "Use RK" + this.n + " method of order N = " + this.n + " to solve " + this.differential + " on [" + interval.getLeft() + "," + interval.getRight() + "] with " + this.ivc; }
}
