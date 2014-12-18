import java.util.ArrayList;

public class Principal {
   
    public static void main(String [ ] args) {
        if( args.length < 2 ) {
            System.err.println("Uso: java -jar backup [origen] [destino]");
            System.exit(1);
        }

        Backup backup = new Backup();
        backup.correr(args[0],args[1]);
        System.exit(0);
    }
}
