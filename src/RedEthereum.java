public class RedEthereum extends RedBase {

    public RedEthereum() {
        super("Ethereum", "ETH");
    }

    @Override
    protected boolean direccionValida(String direccion) {
        // "0x" seguido de exactamente 40 caracteres hexadecimales
        return direccion != null && direccion.matches("0x[a-fA-F0-9]{40}");
    }

    @Override
    protected double calcularComision(double monto) {
        return 0.002; // gas simulado
    }

    @Override
    protected String detalleConfirmacion() {
        return "Incluida en un bloque, finalización en ~12 segundos... confirmada.";
    }
}