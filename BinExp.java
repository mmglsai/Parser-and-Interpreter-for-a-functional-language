package model;

public class BinExp extends Expr {

    private BinOp binOp;
    private Expr value1;
    private Expr value2;

    public BinExp(BinOp binOp, Expr value1, Expr value2) {
        this.binOp = binOp;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Value eval(Env e) throws EvalError {

        if ((value1 instanceof IntConst && value2 instanceof  IntConst) ||
                (value1 instanceof BinExp || value2 instanceof BinExp) ||
                (value1 instanceof VarExp || value2 instanceof VarExp)) {
            int num1 = ((IntVal)value1.eval(e)).value;
            int num2 = ((IntVal)value2.eval(e)).value;
            return binOp.evaluateIntegerExpression(num1, num2);

        // value1 and value2 should of boolean values
        } else if (value1 instanceof BoolConst && value2 instanceof BoolConst) {
            boolean boolValue1 = ((BoolVal)value1.eval(e)).value;
            boolean boolValue2 = ((BoolVal)value2.eval(e)).value;
            return binOp.evaluateBooleanExpression(boolValue1, boolValue2);
        }

        throw new EvalError("Please pass input of both integers or  both boolean values for operator " + binOp.getOperator());
    }

    public String toString() {
        return binOp.getStringValue(value1, value2);
    }
}
