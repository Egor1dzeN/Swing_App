package com.mycompany.mavenproject1.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@jakarta.persistence.Table(name = "watch_table")
@Getter
@Setter
@NoArgsConstructor
public class WatchTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    TypeWatch typeWatch = TypeWatch.WatchHM;
    String name;
    int cost;
    int hour;
    int minutes;
    int seconds;

    int posRow;

    public WatchTable( int cost, String name, int hour, int minutes,int posRow) {
        this.name = name;
        this.cost = cost;
        this.hour = hour;
        this.minutes = minutes;
        this.posRow = posRow;
    }

    @Override
    public String toString() {
        return "WatchTable{" +
                "id=" + id +
                ", typeWatch=" + typeWatch +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", hour=" + hour +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                ", posRow=" + posRow +
                '}';
    }
}