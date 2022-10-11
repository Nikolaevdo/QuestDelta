package ua.com.javarush.quest.nikolaev.questdelta.mapper;

public interface Mapper<T,V> {

    T toDto(V entity);
}
