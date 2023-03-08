import UtilsSolomatin.SwingUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Utils {
    public static SimpleLinkedList<Integer> readListFromFile(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        String[] arrElemFromFile = scanner.nextLine().split(" ");

        for (String number : arrElemFromFile) {
            list.addLast(Integer.parseInt(number));
        }
        return list;
    }

    public static String listToString(SimpleLinkedList<Integer> list, String itemFormat) throws SimpleLinkedList.SimpleLinkedListException {
        if (list == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, list.get(i)));
        }
        return sb.toString();
    }

    public static void winMain() throws Exception { // запуск приложения
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 20);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static SimpleLinkedList<Integer> StringToList(String str) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        String[] massivElemFromString = str.split(" ");

        for (String number : massivElemFromString) {
            list.addLast(Integer.parseInt(number));
        }
        return list;
    }
}
