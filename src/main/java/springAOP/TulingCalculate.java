package springAOP;

public class TulingCalculate implements Calculate {
    public int add(int numA, int numB) {
        System.out.println("开始计算");
        return numA+numB;
    }
    public int reduce(int numA, int numB) {
        System.out.println("开始计算");
        return numA-numB;
    }
    public int div(int numA, int numB) {
        System.out.println("开始计算");
        return numA/numB;
    }
    public int multi(int numA, int numB) {
        System.out.println("开始计算");
        return numA*numB;
    }
}
