package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "stars")
public class Star{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Lob
    private String description;

    @Column(name = "light_years",nullable = false)
    private Double lightYears;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String starType;

    @OneToMany(mappedBy = "star",targetEntity = Astronomer.class,fetch = FetchType.EAGER)
    private List<Astronomer> observers;
    @ManyToOne(targetEntity = Constellation.class)
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;

    public Star() {
    }

    public Star(String description,
                Double lightYears,
                String name,
                String starType,
                List<Astronomer> observers,
                Constellation constellation) {
        this.description = description;
        this.lightYears = lightYears;
        this.name = name;
        this.starType = starType;
        this.observers = observers;
        this.constellation = constellation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public List<Astronomer> getObservers() {
        return observers;
    }

    public void setObservers(List<Astronomer> observers) {
        this.observers = observers;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00",symbols);
        String formattedValue = decimalFormat.format(this.getLightYears());

        return String.format("Star: %s\n" +
                "   *Distance: %s light years\n"+
                "   **Description: %s\n"+
                "   ***Constellation: %s\n",
                this.getName(),
                formattedValue,
                this.getDescription(),
                this.getConstellation().getName());
    }
}

