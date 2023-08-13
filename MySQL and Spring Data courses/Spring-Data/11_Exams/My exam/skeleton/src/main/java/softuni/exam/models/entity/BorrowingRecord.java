package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "borrowing_records")
public class BorrowingRecord extends BaseEntity{

    @Column(name = "borrow_date", nullable = false)
    private Date borrowDate;

    @Column(name = "return_date",nullable = false)
    private Date returnDate;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(targetEntity = LibraryMember.class)
    @JoinColumn(name = "member_id")
    private LibraryMember libraryMember;

    public BorrowingRecord() {
    }

    public BorrowingRecord(Date borrowDate, Date returnDate, String remarks) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.remarks = remarks;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }
}
