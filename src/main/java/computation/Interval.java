package computation;

public class Interval {
    /* Private Data Fields */
    private double leftBound;
    private double rightBound;
    /* Overloaded Constructors */
    public Interval() { this(0.0, 0.0); }
    public Interval(double leftBound, double rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }
    /* Getter Setter Methods */
    public double getLeft() { return this.leftBound; }
    public double getRight() { return this.rightBound; }
    @Override public String toString() { return "[" + this.leftBound + ", " + this.rightBound + "]"; }
}
