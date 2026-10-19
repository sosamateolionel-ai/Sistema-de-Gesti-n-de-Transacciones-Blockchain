//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    RedBitcoin bitcoin = new RedBitcoin();
    RedEthereum ethereum = new RedEthereum();
    RedSolana solana = new RedSolana();

    String btcA = "1BoatSLRHtKNngkdXEeobR76b53LETtpyT";
    String btcB = "3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy";
    String ethA = "0x52908400098527886E0F7030069857D2E4169EE7";
    String ethB = "0x8617E340B3D01FA5F11F306F4090FD50E238070D";
    String solA = "7EqQdEULxWcraVx3mXKFjc84LhCkMGZCkRuDpvcMwJeK";
    String solB = "DRpbCBMxVnDK7maPM5tGv6MvB3v1sRMC86PZ8okm21hy";

    bitcoin.registrarWallet(btcA, 1.5);
    bitcoin.registrarWallet(btcB, 0.2);
    ethereum.registrarWallet(ethA, 10.0);
    ethereum.registrarWallet(ethB, 1.0);
    solana.registrarWallet(solA, 100.0);
    solana.registrarWallet(solB, 5.0);

    RedBlockchain red; // variable del tipo de la interfaz

    System.out.println("===== Red Bitcoin =====");
    red = bitcoin;
    red.ejecutarTransaccion(btcA, btcB, 0.5);
    System.out.println("Saldo origen : " + red.verificarSaldo(btcA) + " BTC");
    System.out.println("Saldo destino: " + red.verificarSaldo(btcB) + " BTC");

    System.out.println("\n===== Cambio a Ethereum =====");
    red = ethereum;
    red.ejecutarTransaccion(ethA, ethB, 2.5);
    red.ejecutarTransaccion(ethA, ethB, 50.0);          // saldo insuficiente
    System.out.println("Saldo origen : " + red.verificarSaldo(ethA) + " ETH");

    System.out.println("\n===== Cambio a Solana =====");
    red = solana;
    red.ejecutarTransaccion(solA, solB, 20.0);

    System.out.println("\n===== Validaciones de formato =====");
    red = ethereum;
    red.ejecutarTransaccion(ethA, btcB, 1.0);           // destino con formato de Bitcoin
    red = bitcoin;
    red.ejecutarTransaccion(ethA, btcB, 0.1);           // origen con formato de Ethereum
    red = solana;
    red.verificarSaldo("direccion-corta");              // formato inválido
    red.ejecutarTransaccion(solA, solA, 1.0);           // misma billetera

}
