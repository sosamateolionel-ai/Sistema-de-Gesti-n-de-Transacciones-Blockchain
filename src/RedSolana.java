public class RedSolana extends RedBase {

    public RedSolana() {
        super("Solana", "SOL");
    }

    @Override
    protected boolean direccionValida(String direccion) {
        // Base58 (sin 0, O, I, l) con entre 32 y 44 caracteres
        return direccion != null && direccion.matches("[1-9A-HJ-NP-Za-km-z]{32,44}");
    }

    @Override
    protected double calcularComision(double monto) {
        return 0.000005; // comisión mínima por firma
    }

    @Override
    protected String detalleConfirmacion() {
        return "Confirmada en ~400 ms.";
    }
}