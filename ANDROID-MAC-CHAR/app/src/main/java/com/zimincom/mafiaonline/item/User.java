package com.zimincom.mafiaonline.item;

import java.io.Serializable;

/**
 * Created by Zimincom on 2017. 4. 3..
 */

public class User implements Serializable {

    private long id;
    private String email;
    private String password;
    private String nickname;
    private Role role;
    private Status status;
    private boolean isReady = false;
    private boolean isVoted = false;
    private long enteredRoomId;
    private long LOBBY_ID = 0;

    public User(String nickname) {
        //temporary constructer for Player.class
        this.nickname = nickname;
    }

    public User(String nickname, Status status) {
        this.nickname = nickname;
        this.status = status;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public String getNickName() {
        return nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", status=" + status +
                ", enteredRoomId=" + enteredRoomId +
                ", LOBBY_ID=" + LOBBY_ID +
                '}';
    }

    public enum Role {
        MAFIA, CITIZEN, DOCTER, POLICE
    }

    public enum Status {
        LOBBY, READY, NOT_READY, IN_GAME;

        public boolean isReady() { return this == Status.READY; }
    }

    public boolean isReady() {
        return status.isReady();
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public void setRoleTo(String roleName) {
        if (roleName.equals("Mafia")) {
            role = Role.MAFIA;
        } else if (roleName.equals("Citizen")) {
            role = Role.CITIZEN;
        } else if (roleName.equals("Doctor")) {
            role = Role.DOCTER;
        } else if (roleName.equals("Police")) {
            role = Role.POLICE;
        }
    }
}
