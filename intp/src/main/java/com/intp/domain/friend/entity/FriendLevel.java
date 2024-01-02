package com.intp.domain.friend.entity;

public enum FriendLevel {
    SNOW_CRYSTAL(0),
    SNOWFLAKE(1),
    SNOWMAN(2);

    private final int level;

    FriendLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
