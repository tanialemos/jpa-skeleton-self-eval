//package be.niels.jpaskeleton.domain.division;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "DIVISIONS")
//public class Division {
//
//    @Id
//    @Column(name = "DIVISION_ID")
//    private int divisionId;
//    @Column(name = "DIVISION_ID")
//    private String name;
//    private String originalName;
//    private String director;
//
//    public Division() {
//    }
//
//    private Division(int divisionId, String name, String originalName, String director) {
//        this.divisionId = divisionId;
//        this.name = name;
//        this.originalName = originalName;
//        this.director = director;
//    }
//
//    public int getDivisionId() {
//        return divisionId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getOriginalName() {
//        return originalName;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public static class DivsionBuilder{
//        private int divisionId;
//        private String name;
//        private String originalName;
//        private String director;
//
//        public static DivsionBuilder divsionBuilder(){
//            return new DivsionBuilder();
//        }
//
//        private int withDivisionId(int divisionId){
//            this.divisionId = divisionId;
//        }
//
//        public void withName(String name) {
//            this.name = name;
//        }
//
//        public void withOriginalName(String originalName) {
//            this.originalName = originalName;
//        }
//
//        public void withDirector(String director) {
//            this.director = director;
//        }
//
//        public Division createDivision(){
//            return new Division(divisionId, name, originalName, director);
//        }
//    }
//}
