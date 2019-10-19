package com.example.a2048plus;

public interface GameManagerCallback {
    void gameOver();

    void updateScore(int delta);
}
