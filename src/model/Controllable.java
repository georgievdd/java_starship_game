package model;

public interface Controllable {
    void onStartRight();
    void onStartLeft();
    void onEndRight();
    void onEndLeft();
    void onShootFast();
    void onShootHeavy();
    void onBoost();
}
