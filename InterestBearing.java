public interface InterestBearing {
    /* Decided not to have a fixed interest rate
     * between all classes that extend Interface
     * Each subclass will define its own rate
    */  

    void applyInterest();
    double calculateInterest();
    int getLimit();
}
