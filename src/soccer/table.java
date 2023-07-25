package soccer;

public class table {
    private int width;
    private int length;
    private int friction;
    private int gateLength;
    public table (int width,int length,int friction,int gateLength){
        this.width=width;
        this.length=length;
        this.gateLength=gateLength;
        this.friction=friction;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFriction() {
        return friction;
    }

    public void setFriction(int friction) {
        this.friction = friction;
    }

    public int getGateLength() {
        return gateLength;
    }

    public void setGateLength(int gateLength) {
        this.gateLength = gateLength;
    }
    public boolean isGoal(int x,int y){
        if(x==0 || x==length){
            if(y<=width/2+gateLength/2 || y>=width/2-gateLength/2)
                return true;
        }
        return false;
    }
}
