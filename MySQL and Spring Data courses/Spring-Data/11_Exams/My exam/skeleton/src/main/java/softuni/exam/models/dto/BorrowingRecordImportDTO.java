package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordImportDTO {

    @NotNull
    @XmlElement(name = "borrow_date")
    private String borrowDate;

    @NotNull
    @XmlElement(name = "return_date")
    private String returnDate;

    @NotNull
    @XmlElement(name = "book")
    private InnerBook book;

    @NotNull
    @XmlElement(name = "member")
    private InnerMember member;

    @Size(min = 3,max = 100)
    @XmlElement(name = "remarks")
    private String remarks;




    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public InnerBook getBook() {
        return book;
    }

    public void setBook(InnerBook book) {
        this.book = book;
    }

    public InnerMember getMember() {
        return member;
    }

    public void setMember(InnerMember member) {
        this.member = member;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
