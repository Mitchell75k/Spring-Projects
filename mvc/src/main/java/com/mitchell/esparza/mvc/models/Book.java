package com.mitchell.esparza.mvc.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Objects;

@Entity //@Entity annotation tells Hibernate to create a table out of this class
@Table(name="books") // This tells Hibernate to name the table as books in the database when it is run

//below we are creating a class called Book that will be used to create a table in the database called  'books'
//the varying private attributes of the Book class will be the columns of the table and the varying instances of the Book class that we create will be the rows of the table
public class Book {
    @Id                                                  // @Id annotation tells Hibernate that this is the primary key of this entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue annotation tells Hibernate to generate the value for this field automatically
    private Long id;                                   // This is the primary key of this entity and is of type Long
    @NotNull                                          // @NotNull annotation tells Hibernate that this field cannot be null in the database
    @Size(min = 5, max = 200)                        // @Size annotation tells Hibernate that the size of the String in the database must be between 5 and 200
    private String title;                           // This is the title of the book
    @NotNull
    @Size(min = 5) 
    @Column(columnDefinition = "TEXT")            //this specifies the column type to TEXT in the database instead of the default VARCHAR(255), with a max length of 1000 characters by default
    private String description;                  // This is the description of the book
    @NotNull
    @Size(min = 3, max = 40, message="Language must be between 3 and 40 characters long.")      //ERROR MESSAGE
    private String language;
    @NotNull
    @Min(value = 100, message="Number of pages must be at least 100 pages long.")           //ERROR MESSAGE
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd") // @DateTimeFormat annotation tells Hibernate to format the date in the specified pattern
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Book() { //empty constructor will be used to create an instance of the Book class that will be used to create a row in the books table
    }
    public Book(String title, String desc, String lang, int pages) {
        //this.id = id; will be automatically generated by Hibernate and applied to the instance of the Book class that we create 
        //same with this.createdAt and this.updatedAt 
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }

    //below are the getters and setters for the Book class
    @PrePersist                                         // @PrePersist runs the method right before the object is created
    protected void onCreate(){                         //this method will be used to set the createdAt attribute of the Book class
        this.createdAt = new Date();
    }
    @PreUpdate                                         // @PreUpdate runs the method when the object is modified
    protected void onUpdate(){                        //this method will be used to set the updatedAt attribute of the Book class
        this.updatedAt = new Date();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Book id(Long id) {
        setId(id);
        return this;
    }

    public Book title(String title) {
        setTitle(title);
        return this;
    }

    public Book description(String description) {
        setDescription(description);
        return this;
    }

    public Book language(String language) {
        setLanguage(language);
        return this;
    }

    public Book numberOfPages(Integer numberOfPages) {
        setNumberOfPages(numberOfPages);
        return this;
    }
}
