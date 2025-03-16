package org.avi.plurahsight.airport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
@NoArgsConstructor
public class Passenger {
    @Id
    @Column(name = "PASSENGER_ID")
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(name = "PASSANGER_NAME", table = "PASSENGERS")
    private String name;
    @Getter
    @Setter
    @Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
    private String address;

    public Passenger(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
