package CinemaBig;

public class CinemaSeat {

    private String type;
    private int costPlace;
    private boolean isFree;

    public CinemaSeat(String type, int costPlace, boolean isFree){
        this.type = type;
        this.costPlace = costPlace;
        this.isFree = isFree;
    }

    public String getType() {
        return type;
    }

    public int getCostNormalPlace() {
        return costPlace;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCostNormalPlace(short costPlace) {
        this.costPlace = costPlace;
    }

    public void setIsFree(boolean isfree) {
        isFree = isfree;
    }
}
