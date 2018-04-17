package be.niels.jpaskeleton.domain.division;

import javax.persistence.*;

@Entity
@Table(name = "DIVISIONS")
public class Division {

    @Id
    @Column(name = "DIVISION_ID")
    @SequenceGenerator(name = "division_seq", sequenceName = "division_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq")
    private int divisionId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ORIGINALNAME")
    private String originalName;
    @Column(name = "DIRECTOR")
    private String director;

    public Division() {
    }

    private Division(int divisionId, String name, String originalName, String director) {
        this.divisionId = divisionId;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public static class DivisionBuilder {
        private int divisionId;
        private String name;
        private String originalName;
        private String director;

        public static DivisionBuilder divsionBuilder(){
            return new DivisionBuilder();
        }

        public void withDivisionId(int divisionId){
            this.divisionId = divisionId;
        }

        public void withName(String name) {
            this.name = name;
        }

        public void withOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public void withDirector(String director) {
            this.director = director;
        }

        public Division createDivision(){
            return new Division(divisionId, name, originalName, director);
        }
    }
}
