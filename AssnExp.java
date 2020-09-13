package model;

public class AssnExp extends Expr {
    private final String s;
    private final Expr expr;

    public AssnExp(String s, Expr expr) {
        this.s = s;
        this.expr = expr;
    }

    public Value eval(Env e) throws EvalError {

        Value value = expr.eval(e);
        Value Svalue= e.lookup(s);

        if ((Svalue instanceof BoolVal && value instanceof BoolVal)
                || (Svalue instanceof IntVal && value instanceof IntVal)
                || (Svalue instanceof FunVal && value instanceof FunVal)) {
            e.updateBinding(s, value);
            return value;
        }

        throw new EvalError("missing compatible types in assignment operator function");
    }

    public String toString() {
            return s + " :=" + expr.toString();
    }
}
