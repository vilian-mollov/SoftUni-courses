package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ImportCountryDTO implements Serializable {
    @NotNull
    @Size(min = 2, max = 60)
    private String countryName;
    @NotNull
    @Size(min = 2, max = 20)
    private String currency;

    public ImportCountryDTO() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "name='" + countryName + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
