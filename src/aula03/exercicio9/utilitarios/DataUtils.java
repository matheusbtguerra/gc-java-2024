package aula03.exercicio9.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
    public static String formatData(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    public static <Date> String formatHora(Date data) {
        return new SimpleDateFormat("HH:mm:ss").format(data);
    }
}
