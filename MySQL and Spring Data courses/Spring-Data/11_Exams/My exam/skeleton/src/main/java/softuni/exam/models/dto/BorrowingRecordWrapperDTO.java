package softuni.exam.models.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordWrapperDTO {

    @XmlElement(name = "borrowing_record")
    List<BorrowingRecordImportDTO> borrowingRecords;

    public List<BorrowingRecordImportDTO> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(List<BorrowingRecordImportDTO> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }
}
