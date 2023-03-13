package custom.autowired;

import java.lang.reflect.Field;

public class AutowiredInjector {
    public static void inject(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = findDependency(fieldType);
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }

    private static Object findDependency(Class<?> fieldType) {
        // 의존 주입 컨테이너에서 찾아서 주입
        return new Dependency();
    }
}
