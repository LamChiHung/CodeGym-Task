package ss08_clean_code.excercise.model;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        if (scoreOfFirstPlayer == scoreOfSecondPlayer) {
            return getScoreOfFirstPlayer(scoreOfFirstPlayer);
        }
        if (scoreOfFirstPlayer >= 40 || scoreOfSecondPlayer >= 40) {
            return getMinusResult(scoreOfFirstPlayer, scoreOfSecondPlayer);
        }
        return getTempScore(scoreOfFirstPlayer, scoreOfSecondPlayer);
    }

    public static String getScoreOfFirstPlayer(int scoreOfFirstPlayer) {
        switch (scoreOfFirstPlayer) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String getMinusResult(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        int minusScore = scoreOfFirstPlayer - scoreOfSecondPlayer;
        if (minusScore == 1) {
            return "Advantage First Player";
        }
        if (minusScore == -1) {
            return "Advantage Second Player";
        }
        if (minusScore >= 2) {
            return "Win for First Player";
        }
        return "Win for Second Player";
    }

    public static String getTempScore(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scoreOfFirstPlayer;
            } else {
                tempScore = scoreOfSecondPlayer;
            }
            switch (tempScore) {
                case LOVE:
                    return "Love";

                case FIFTEEN:
                    return "Fifteen";

                case THIRTY:
                    return "Thirty";

                case FORTY:
                    return "Forty";
            }
        }
        return "Error";
    }
}


