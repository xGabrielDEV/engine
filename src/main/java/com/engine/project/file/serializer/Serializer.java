package com.engine.project.file.serializer;

public abstract class Serializer {

    public abstract String serialize(Object object);
    public abstract <T> T deserialize(Class<? extends T> type, String serializedObject);

}
