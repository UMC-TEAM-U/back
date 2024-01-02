package com.intp.domain.friend.entity;

public enum FriendLevel {
    SNOW_CRYSTAL(0, "눈결정"),
    SNOWFLAKE(1,"눈송이"),
    SNOWMAN(2,"눈사람");

    private final int level;
    private final String name;

    FriendLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }
    public String getName(){
        return name;
    }

    // 함수 추가
    public static FriendLevel fromLevel(int level) {
        for (FriendLevel friendLevel : FriendLevel.values()) {
            if (friendLevel.getLevel() == level) {
                return friendLevel;
            }
        }
        throw new IllegalArgumentException("Invalid FriendLevel level: " + level);
    }
}
