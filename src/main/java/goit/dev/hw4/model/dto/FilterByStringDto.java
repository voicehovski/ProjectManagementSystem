package goit.dev.hw4.model.dto;

// todo Переименовать DTO по приницпу вход-выход
public class FilterByStringDto {
    private String value;

    public FilterByStringDto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
