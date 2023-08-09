package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "constellations")
public class Constellation {

//id – accepts integer values, a primary identification field, an auto incremented field.
//name – accepts char sequence (between 3 to 20 inclusive). The values are unique in the database.
//description - accepts char sequence about the naming of the constellation with a character length value higher than or equal to 5.
//stars – a collection of all stars that are part the constellation
//Constraint: The constellations table has a relation with the stars table.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "constellation", targetEntity = Star.class)
    private List<Star> stars;

    public Constellation() {
    }

    public Constellation(String description, String name, List<Star> stars) {
        this.description = description;
        this.name = name;
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
