package springIOC.generic;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class TypeTest<T> {
    // 基本数据类型
    private int i;
    // 普通对象
    private Integer it;
    // 普通数组
    private int[] iarray;
    // 普通对象
    private List list;
    // 泛型类型
    private List<String> slist;
    // 泛型类型
    private List<T> tlist;
    //泛型变量
    private T t;
    // 是普通数组，是泛型数组
    private T[] tarray;

    public static void main(String[] args) throws NoSuchFieldException {
        test(TypeTest.class.getDeclaredField("i"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("it"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("iarray"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("list"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("slist"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("tlist"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("t"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("tarray"));
        System.out.println("=======");
        test(TypeTest.class.getDeclaredField("sarray"));
    }

    public static void test(Field field) {
        if (field.getType().isPrimitive()) {
            System.out.println(field.getName() + "是基本数据类型");
        } else {
            System.out.println(field.getName() + "不是基本数据类型");
        }

        if (field.getGenericType() instanceof ParameterizedType) {
            System.out.println(field.getName() + "是泛型类型");
        } else {
            System.out.println(field.getName() + "不是泛型类型");
        }

        if (field.getType().isArray()) {
            System.out.println(field.getName() + "是普通数组");
        } else {
            System.out.println(field.getName() + "不是普通数组");
        }

        if (field.getGenericType() instanceof GenericArrayType) {
            System.out.println(field.getName() + "是泛型数组");
        } else {
            System.out.println(field.getName() + "不是泛型数组");
        }

        if (field.getGenericType() instanceof TypeVariable) {
            System.out.println(field.getName() + "是泛型变量");
        } else {
            System.out.println(field.getName() + "不是泛型变量");
        }
    }
}
