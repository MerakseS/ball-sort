package com.innowisegroup.sergeilosev.model.impl;

import com.innowisegroup.sergeilosev.model.Ball;
import com.innowisegroup.sergeilosev.model.Color;

public class PingPongBall extends Ball {

    private static final int DEFAULT_PING_PONG_BALL_SIZE = 4;
    private static final Color DEFAULT_PING_PONG_BALL_COLOR = Color.WHITE;

    public PingPongBall() {
        super(DEFAULT_PING_PONG_BALL_SIZE, DEFAULT_PING_PONG_BALL_COLOR);
    }

    public PingPongBall(int size) {
        super(size, DEFAULT_PING_PONG_BALL_COLOR);
    }

    public PingPongBall(Color color) {
        super(DEFAULT_PING_PONG_BALL_SIZE, color);
    }

    public PingPongBall(int size, Color color) {
        super(size, color);
    }

    @Override
    public String toString() {
        return "PingPongBall{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
