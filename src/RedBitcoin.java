public class RedBitcoin extends RedBase {

    public RedBitcoin() {
        super("Bitcoin", "BTC");
    }

    @Override
    protected boolean direccionValida(String direccion) {
        // Simplificado: empieza con 1, 3 o bc1 y tiene entre 26 y 42 caracteres alfanuméricos
        return direccion != null && direccion.matches("(bc1|[13])[a-zA-Z0-9]{23,39}");
    }

    @Override
    protected double calcularComision(double monto) {
        return 0.0001; // comisión de red fija
    }

    @Override
    protected String detalleConfirmacion() {
        return "Esperando 6 confirmaciones de bloque (~60 minutos)... confirmada.";
    }
}