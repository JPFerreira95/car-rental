package com.jferreira95.microservice.commonlib.util.mapper;

import org.modelmapper.ModelMapper;

/**
 * <p>The type Mapper.</p>
 * <p>The objective of this class is to map source objects to target objects in some different ways.</p>
 */
public class Mapper {

    private static ModelMapper initModelMapper(boolean skipNull) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(skipNull);

        return modelMapper;
    }

    /**
     * <p>Map a source object fields to a target class with the same fields.</p>
     * <p>It creates a new instance of the target class and then maps the fields.</p>
     * <p>The fields to be mapped to the target class should have the same name and type of the source object.</p>
     *
     * @param <T>         the type parameter
     * @param source      the source
     * @param targetClass the target class
     * @return the t
     */
    public static <T> T map(Object source, Class<T> targetClass) {
        ModelMapper modelMapper = initModelMapper(false);
        return modelMapper.map(source, targetClass);
    }

    /**
     * <p>Map a source object fields to a target object with the same fields.</p>
     * <p>The fields to be mapped to the target object should have the same name and type of the source object.</p>
     *
     * @param <T>    the type parameter
     * @param source the source
     * @param target the target
     */
    public static <T> void map(Object source, Object target) {
        ModelMapper modelMapper = initModelMapper(false);
        modelMapper.map(source, target);
    }

    /**
     * <p>Map a source object fields with not null values to a target class with the same fields.</p>
     * <p>It creates a new instance of the target class and then maps the fields.</p>
     * <p>The fields to be mapped to the target class should have the same name and type of the source object.</p>
     *
     * @param <T>         the type parameter
     * @param source      the source
     * @param targetClass the target class
     * @return the t
     */
    public static <T> T mapNotNullValues(Object source, Class<T> targetClass) {
        ModelMapper modelMapper = initModelMapper(true);
        return modelMapper.map(source, targetClass);
    }

    /**
     * <p>Map a source object fields with not null values to a target object with the same fields.</p>
     * <p>The fields to be mapped to the target object should have the same name and type of the source object.</p>
     *
     * @param <T>    the type parameter
     * @param source the source
     * @param target the target
     */
    public static <T> void mapNonNullValues(Object source, Object target) {
        ModelMapper modelMapper = initModelMapper(true);
        modelMapper.map(source, target);
    }

    /**
     * <p> Updates a target object with the same fields of the source object. </p>
     * <p> The behaviour of this method consists in: </p>
     * <ul>
     * <li> Convert and update values from the source object to the target object;
     * <li> The null values from the source object are not updated to the target object;
     * <li> The empty values from the source object are set to null in the target object.
     * </ul>
     *
     *  <p> This is a specific behaviour to help updating mongodb documents. </p>
     */
    public void update(Object source, Object target) {
        // TODO
    }

}
