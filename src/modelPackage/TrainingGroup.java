package modelPackage;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TrainingGroup {

    private Integer trainingGroupID;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private Integer day;
    private Integer roomID;
    private Room room;
    private Integer trainerID;
    private Trainer trainer;

    public TrainingGroup(Integer trainingGroupID, LocalTime timeStart, LocalTime timeEnd
            , Integer day, Integer roomID, Integer trainerID){

       setTrainingGroupID(trainingGroupID);
       setTimeStart(timeStart);
       setTimeEnd(timeEnd);
       setDay(day);
       setRoomID(roomID);
       setTrainerID(trainerID);

    }

    public Integer getTrainingGroupID() {
        return trainingGroupID;
    }

    public void setTrainingGroupID(Integer trainingGroupID) {
        this.trainingGroupID = trainingGroupID;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String toString(){
        StringBuilder training = new StringBuilder("");
        training.append(DayOfWeek.of(day) + " from " + timeStart + " to " + timeEnd);
        training.append(" by " + trainer.getFirstName() + " " + trainer.getLastName());
        training.append(" in room number " + room.getNumber() + " at ");
        training.append(room.getStreetName() + " ," + room.getStreetNumber() + " " + room.getPostalCode() + " " + room.getLocality());

        return training.toString();
    }


}
