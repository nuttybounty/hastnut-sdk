package io.hashnut.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class PostRequest<T> implements Request<T> {

    @Override
    public boolean needSign(){return false;}

    @Override
    @JsonIgnore
    public String getMethod() {
        return "POST";
    }

    @Override
    @JsonIgnore
    public Map<String,Object> getPayload() throws Exception {
        return formatFields(this);
    }

    @Override
    @JsonIgnore
    public Class<T> getResponseClass(){
        Type superClass = getClass().getGenericSuperclass();

        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            if (typeArguments.length > 0) {
                Type typeArgument = typeArguments[0];

                if (typeArgument instanceof Class) {
                    @SuppressWarnings("unchecked")
                    Class<T> type = (Class<T>) typeArgument;
                    return type;
                }
            }
        }

        return null;
    }

    private static Map<String,Object> formatFields(Object obj) throws Exception{
        Map<String,Object> result=new HashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if(value!=null)
                result.put(fieldName,value);
        }
        return result;
    }
}
