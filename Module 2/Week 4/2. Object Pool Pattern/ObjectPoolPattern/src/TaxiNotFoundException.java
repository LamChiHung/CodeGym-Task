public class TaxiNotFoundException extends Throwable {
    public TaxiNotFoundException(String noTaxiAvaible) {
        System.out.println(noTaxiAvaible);
    }
}
