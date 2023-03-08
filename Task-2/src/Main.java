public class Main {

    public static void main(String[] args) throws Exception {
        if(args[0].equals("--window")){
            Utils.winMain();
        }
        if(args[0].equals("--cmd")){
            String path = args[1];
            Program.startProgram(path);

        }
    }
}