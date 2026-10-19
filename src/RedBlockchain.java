public interface RedBlockchain {

    double verificarSaldo(String direccionWallet);

    boolean ejecutarTransaccion(String origen, String destino, double monto);

    String getNombre();
}