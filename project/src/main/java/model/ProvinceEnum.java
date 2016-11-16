package main.model;

public enum ProvinceEnum {

    GODE(0,600,1000,500,"Gode"),
    RUJA(400,1000,1100,500, "Ruja"),
    JABY(1100,1000,1400,500, "Jaby"),
    SCAVY(0,500,600,0, "Scavy"),
    GROOLA(600,500,800,0, "Groola"),
    NOVA(800,500,1400,0, "Nova");

    private int upperLeftX;
    private int upperLeftY;
    private int bottomRightX;
    private int bottomRightY;
    private String name;

    private ProvinceEnum(int upperLeftX,
        int upperLeftY,
        int bottomRightX,
        int bottomRightY,
        String name
    ) {
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
        this.name = name;
    }

    public int getUpperLeftX() {
        return this.upperLeftX;
    }
    public int getUpperLeftY() {
        return this.upperLeftY;
    }
    public int getBottomRightX() {
        return this.bottomRightX;
    }
    public int getBottomRightY() {
        return this.bottomRightY;
    }
    public String getName() {
        return this.name;
    }
}
