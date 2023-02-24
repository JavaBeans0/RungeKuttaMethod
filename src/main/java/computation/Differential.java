package computation;

public class Differential {

    private double linearCoefficient;
    private double derivedCoefficient;

    public Differential() { this(0.0, 0.0); }
    public Differential(double linearCoefficient, double derivedCoefficient) { this.linearCoefficient = linearCoefficient; this.derivedCoefficient = derivedCoefficient; }

    public double getLC() { return this.linearCoefficient; }
    public double getDC() { return this.derivedCoefficient; }

    @Override public String toString() { return "y' = " + this.linearCoefficient + "t + " + this.derivedCoefficient + "y"; }
}
