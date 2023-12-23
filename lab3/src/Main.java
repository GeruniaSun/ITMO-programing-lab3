import lab3.*;

public class Main {
    public static void main (String[] args){
        // initialize heroes
        Carlson carlson = new Carlson();
        Baby baby = new Baby();
        UncleJulius uncleJulius = new UncleJulius();
        FrekenBok frekenBok = new FrekenBok();
        // initialize house of heroes
        Place house = new Place("family house");
        house.setVisitors(baby, frekenBok, uncleJulius);
        // story starts here
        carlson.talk("If I'm not fed, I'm not me");

        
        Placeable r = (Person person, Place place) -> {
            person.beIn(place);
        };
        frekenBok.dream(carlson, r, house);


        // argument starts
        Argument CarlsonCancelling = new Argument("Carlson can spend time with them",
            new Person[]{baby, uncleJulius}, new Person[]{frekenBok});
        CarlsonCancelling.printPros();
        // initialize table
        Table houseTable = new Table("wood", house.getDescription(),999.0);
        houseTable.setSeaters(house.getVisitors());
        houseTable.printSeaters();
        // story continue
        carlson.land(house);
        houseTable.setSeaters(house.getVisitors());
        frekenBok.grumble();
        frekenBok.talk("I can't do something!!!!");
        houseTable.printSeaters();
    }
}