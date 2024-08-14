//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int step = 0;
        if(args.length>0) {
            try {
                step = Integer.parseInt(args[0]);
            }catch(Exception e) {
                step = 0;
            }

        }
        new MyFrame(step);


    }
}