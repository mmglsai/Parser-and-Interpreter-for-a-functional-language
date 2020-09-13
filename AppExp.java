package model;

public class AppExp extends Expr {
    private final String str;
    private final Expr expr;

    public AppExp(String str, Expr expr) {
        this.str = str;
        this.expr = expr;
    }

    @Override
    public Value eval(Env e) throws EvalError {
        Value value = e.lookup(str);
        if (value instanceof FunVal ) {
            Value value1 = expr.eval(e);
            FunVal funval = (FunVal)value;
            Env env1 = funval.getEnv().addBinding(funval.getS(), value1);
            return funval.getEx().eval(env1);
        } else {
            throw new EvalError("Please pass correct values");
        }

    }

    @Override
    public String toString() {
        return str + "(" + expr.toString() + ")";
    }
}


