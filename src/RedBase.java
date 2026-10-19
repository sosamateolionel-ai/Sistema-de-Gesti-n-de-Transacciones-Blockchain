import java.util.HashMap;
import java.util.Map;

public abstract class RedBase implements RedBlockchain {

    protected String nombre;
    protected String moneda;
    private Map<String, Double> saldos = new HashMap<>(); // dirección -> saldo

    public RedBase(String nombre, String moneda) {
        this.nombre = nombre;
        this.moneda = moneda;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    // Simula el alta de una billetera con fondos iniciales
    public boolean registrarWallet(String direccion, double saldoInicial) {

        if (!direccionValida(direccion)) {
            System.out.println("[" + nombre + "] No se puede registrar: formato de dirección inválido.");
            return false;
        }

        saldos.put(direccion, saldoInicial);
        return true;
    }

    @Override
    public double verificarSaldo(String direccionWallet) {

        if (!direccionValida(direccionWallet)) {
            System.out.println("[" + nombre + "] Dirección con formato inválido: " + direccionWallet);
            return -1;
        }

        if (!saldos.containsKey(direccionWallet)) {
            System.out.println("[" + nombre + "] Billetera no registrada en la red.");
            return -1;
        }

        return saldos.get(direccionWallet);
    }

    @Override
    public boolean ejecutarTransaccion(String origen, String destino, double monto) {

        System.out.println("\n[" + nombre + "] Transferencia de " + monto + " " + moneda + " solicitada.");

        if (monto <= 0) {
            System.out.println("[" + nombre + "] Error: el monto debe ser mayor a cero.");
            return false;
        }

        if (!direccionValida(origen)) {
            System.out.println("[" + nombre + "] Error: dirección de origen inválida.");
            return false;
        }

        if (!direccionValida(destino)) {
            System.out.println("[" + nombre + "] Error: dirección de destino inválida.");
            return false;
        }

        if (origen.equals(destino)) {
            System.out.println("[" + nombre + "] Error: origen y destino son la misma billetera.");
            return false;
        }

        if (!saldos.containsKey(origen) || !saldos.containsKey(destino)) {
            System.out.println("[" + nombre + "] Error: alguna de las billeteras no está registrada.");
            return false;
        }

        double comision = calcularComision(monto);
        double total = monto + comision;

        if (saldos.get(origen) < total) {
            System.out.println("[" + nombre + "] Error: saldo insuficiente (se necesitan " + total
                    + " " + moneda + " con comisión, hay " + saldos.get(origen) + ").");
            return false;
        }

        saldos.put(origen, saldos.get(origen) - total);
        saldos.put(destino, saldos.get(destino) + monto);

        System.out.println("[" + nombre + "] Transacción emitida (comisión: " + comision + " " + moneda + ").");
        System.out.println("[" + nombre + "] " + detalleConfirmacion());
        return true;
    }

    // Cada red define lo suyo
    protected abstract boolean direccionValida(String direccion);

    protected abstract double calcularComision(double monto);

    protected abstract String detalleConfirmacion();
}