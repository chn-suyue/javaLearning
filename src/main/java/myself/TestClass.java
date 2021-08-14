package myself;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/14 0:25
 */

public class TestClass {

    private volatile Integer var;

    public TestClass(Integer var) {
        this.var = var;
    }

    public Integer getVar() {
        return var;
    }

    public void setVar(Integer var) {
        this.var = var;
    }
}
