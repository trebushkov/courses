package com.senlainc.courses.lecture5;

public class Box<T> {
    T thing;

    public T put(T thing) {
        return this.thing = thing;
    }

    public <E> E getElement(){
        return (E) thing;
    }

    public <E> E getValue(Object smth, Class<E> clazz){
        return (E) smth;
    }

    public <E extends Number> E getValueOnlyNumbers(Object smth, Class<E> clazz){
        return (E) smth;
    }

    public <E> E getValueSuper(Object smth, Class<? super E> clazz){
        return (E) smth;
    }
}
