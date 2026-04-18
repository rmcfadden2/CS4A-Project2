public interface InterestBearing {
    private float interestRate;

    public float applyInterest() {
        balance += balance * interestRate;
    }
}
