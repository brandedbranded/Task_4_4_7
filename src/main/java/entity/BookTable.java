package entity;

import lombok.Data;

@Data
public class BookTable {
    private long id;
    private final String bookTitle;
    private long authorId;
}
