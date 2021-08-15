package pl.coderslab.charity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    //@ToString.Exclude
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    //@ToString.Exclude
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

    @ManyToOne
    private User user;

}
