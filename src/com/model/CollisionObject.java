package com.model;


public abstract class CollisionObject extends GameObject{

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    boolean isCollision(GameObject gameObject, Direction direction){
        int nX=getX();
        int nY=getY();
        if(direction.equals(Direction.DOWN)){
            nY+=Model.FIELD_SELL_SIZE;
        }else if(direction.equals(Direction.UP)){
            nY-=Model.FIELD_SELL_SIZE;
        }else if(direction.equals(Direction.LEFT)){
            nX-=Model.FIELD_SELL_SIZE;
        }else if(direction.equals(Direction.RIGHT)){
            nX+=Model.FIELD_SELL_SIZE;
        }
        if (nX==gameObject.getX() && nY==gameObject.getY() || nX==0 || nY==0 || nX==480 || nY==480){
            return true;
        }else {
            return false;
        }
    }
}
