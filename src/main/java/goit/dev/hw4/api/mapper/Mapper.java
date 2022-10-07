package goit.dev.hw4.api.mapper;

public interface Mapper<T1,T2> {
    T1 toDto(T2 entity);
    T2 toEntity(T1 dto);
}
