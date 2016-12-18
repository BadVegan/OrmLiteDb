package pl.database.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pl.database.dao.BookDaoImpl;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by davit on 10.12.2016.
 */
@DatabaseTable(tableName = "BOOKS", daoClass = BookDaoImpl.class)
public class Book implements Model{

    public Book() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "AUTHOR_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Author author;

    @DatabaseField(columnName = "TITTLE", dataType = DataType.STRING, canBeNull = false)
    private String tittle;

    @DatabaseField(columnName = "ISBN", unique = true)
    private String isbn;

    @DatabaseField(columnName = "DATE_RELEASE", dataType = DataType.SERIALIZABLE)
    private LocalDate dateRelease;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    @DatabaseField(columnName = "RATING", width = 1)
    private Integer rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", tittle='" + tittle + '\'' +
                ", isbn='" + isbn + '\'' +
                ", dateRelease=" + dateRelease +
                ", addedDate=" + addedDate +
                ", rating=" + rating +
                '}';
    }
}
