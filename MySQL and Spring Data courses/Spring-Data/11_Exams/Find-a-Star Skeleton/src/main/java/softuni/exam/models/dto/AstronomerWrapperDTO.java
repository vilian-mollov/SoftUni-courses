package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerWrapperDTO {

    @XmlElement(name = "astronomer")
    List<AstronomerImportDTO> astronomers;

    public List<AstronomerImportDTO> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(List<AstronomerImportDTO> astronomers) {
        this.astronomers = astronomers;
    }
}
