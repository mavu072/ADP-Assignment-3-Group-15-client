package za.ac.cput.ADP3LabBookingSystem.Entity;

/***
 * Entity for building class
 *Author: Xola Mngeni 218268017
 */

public class Building {
    private String buildingId;
    private Building(Builder builder){
        this.buildingId = builder.buildingId;

    }
    //To string
    @Override
    public String toString() {
        return "Building{" +
                "bulidingId='" + buildingId + '\'' +
                '}';
    }
    //Builder
    public static class Builder{
        private String buildingId;

        public Builder setBuildingId(String buildingId) {
            this.buildingId = buildingId;
            return this;
        }
        public Building build(){
            return new Building(Builder.this);

        }
        public Builder copy(Building building){
            this.buildingId = building.buildingId;
            return this;
        }
    }
}
