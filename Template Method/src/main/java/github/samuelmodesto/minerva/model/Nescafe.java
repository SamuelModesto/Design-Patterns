package github.samuelmodesto.minerva.model;

public class Nescafe extends CafeTemplate{
    @Override
    protected void adicionarTipoCafe() {
        System.out.println("Nescafé adicionado");
        System.out.println("####################");
        System.out.println("          {\n" +
                "       }   }   {\n" +
                "      {   {  }  }\n" +
                "       }   }{  {\n" +
                "      {  }{  }  }\n" +
                "     ( }{ }{  { )\n" +
                "    .-{   }   }-.\n" +
                "   ( ( } { } { } )\n" +
                "   |`-.._____..-'|\n" +
                "   |             ;--.\n" +
                "   |            (__  \\\n" +
                "   |   Nescafé   | )  )\n" +
                "   |             |/  /\n" +
                "   |             /  / \n" +
                "   |            (  /\n" +
                "   \\             /'\n" +
                "    `-.._____..-'");
    }
}
