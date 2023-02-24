package computation;

public class Condition {
    /* Private Data Fields */
    private double initialX;
    private double initialY;
    /* Overloaded Constructors */
    public Condition() { this(0.0, 0.0); }
    public Condition(double initialX, double initialY) { this.initialX = initialX; this.initialY = initialY; }
    /* Getter Setter Methods */
    public double getX() { return this.initialX; }
    public double getY() { return this.initialY; }
    @Override public String toString() { return "y(" + this.initialX + ") = " + this.initialY; }
}
