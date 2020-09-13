
import model.*;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

import java.util.Scanner;

public class InterpretMain {

    public static void main(String[] args) throws Exception {
        // to run the program unless user calls exit
        while (true) {
            System.setErr(System.out);
          //  System.out.println("hello user enter expression : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            CharStream charStream = new ANTLRStringStream(input);
            if (input.equalsIgnoreCase("exit")) {
                System.exit(-1);
            }
            ProjLangLexer lexer = new ProjLangLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ProjLangParser parser = new ProjLangParser(tokens);
            try {
                Expr e = parser.input();
                Env emptyEnv = new EnvImp();
                System.out.println(e.eval (emptyEnv));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
       //     System.out.println("please enter next expression !!!!!");
        }
    }
}
