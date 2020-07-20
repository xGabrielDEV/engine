package com.engine.project.file.serializer;

import com.google.common.base.Splitter;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LocationSerializer extends Serializer {

    @Override
    public String serialize(Object object) {

        if (!(object instanceof Location)) throw new IllegalArgumentException("Object must be a location!");

        Location location = (Location) object;

        return location.serialize().toString();
    }

    @Override
    public <T> T deserialize(Class<? extends T> type, String serializedObject) {
        T instanceType;

        try {
            instanceType = type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

        if (!(instanceType instanceof Location)) throw new IllegalArgumentException("Type must be a location!");

        Map<String, Object> values = new HashMap<>();

        for (Entry<String, String> entry : Splitter.on(",")
                                           .withKeyValueSeparator(":")
                                           .split(serializedObject).entrySet()) {
            values.put(entry.getKey(), entry.getValue());
        }

        return (T) Location.deserialize(values);
    }

}
