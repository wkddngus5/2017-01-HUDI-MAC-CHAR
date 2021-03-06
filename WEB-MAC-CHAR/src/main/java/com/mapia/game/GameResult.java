package com.mapia.game;

public class GameResult {
    private static final String MAFIA_WIN_MESSAGE = "마피아가 승리하였습니다.";
    private static final String CITIZEN_WIN_MESSAGE = "시민이 승리하였습니다.";

    private String msg;
    private boolean isFinished;
    private boolean completeVote;

    public GameResult() {
    }

    public boolean isCompleteVote() {
        return completeVote;
    }

    public void setCompleteVote(boolean completeVote) {
        this.completeVote = completeVote;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public GameResult(GameResultType type) {
        this.isFinished = true;
        this.completeVote = true;
        switch (type) {
            case MAFIA_WIN:
                this.msg = MAFIA_WIN_MESSAGE;
                break;
            case CITIZEN_WIN:
                this.msg = CITIZEN_WIN_MESSAGE;
        }
    }

    public GameResult(String killedUser, boolean completeVote) {
        this.isFinished = false;
        this.completeVote = completeVote;
        this.msg = killedUser;
    }

    public static GameResult votingStatus() {
        return new GameResult("투표가 진행중입니다", false);
    }

    public static GameResult returnMafiaWin() {
        return new GameResult(GameResultType.MAFIA_WIN);
    }

    public static GameResult returnCitizenWin() {
        return new GameResult(GameResultType.CITIZEN_WIN);
    }

    public static GameResult returnSelectedUser(String killedUserNickName) {
        return new GameResult(killedUserNickName, true);
    }

    @Override
    public String toString() {
        return String.format("[isFinished:%s] msg: %s", isFinished, msg);
    }
}
