import java.io.FileNotFoundException;

public class Program {
    public static SimpleLinkedList<Integer> swapMaxMin(SimpleLinkedList<Integer> list) throws SimpleLinkedList.SimpleLinkedListException {
        int maxValue = list.get(0);
        int minValue = list.get(0);
        int indexMax = 0;
        int indexMin = 0;

        for (int i = 0; i < list.size(); i++) {
            if(minValue > list.get(i)){
                minValue = list.get(i);
                indexMin = i;

            }
            if(maxValue <= list.get(i)){
                maxValue = list.get(i);
                indexMax = i;
            }
        }

        list.remove(indexMax);
        list.insert(indexMax, minValue);

        list.remove(indexMin);
        list.insert(indexMin, maxValue);

        System.out.println();
        return list;
    }
    public static void startProgram(String path) throws FileNotFoundException, SimpleLinkedList.SimpleLinkedListException {

        SimpleLinkedList<Integer> list = Utils.readListFromFile(path);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        list.swapMinMax();

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
