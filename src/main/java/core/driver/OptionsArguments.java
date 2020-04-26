package core.driver;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class OptionsArguments {

    public <T> T getOptionWithArguments(Class<T> cl, String arguments) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        T options = cl.newInstance();
        List<String> args = Arrays.asList(arguments.split(","));
        options.getClass().getMethod("addArguments", List.class).invoke(options,args);
        return options;
    }
}
