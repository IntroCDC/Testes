package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 17/08/2025 - 05:41
 */

public class GameEvent {
    private final GameEventType type;
    private final int minute;
    private final String text;
    private final int homeScore;
    private final int visitorScore;

    public GameEvent(GameEventType type, int minute, String text, int homeScore, int visitorScore) {
        this.type = type;
        this.minute = minute;
        this.text = text;
        this.homeScore = homeScore;
        this.visitorScore = visitorScore;
    }
    public GameEventType getType() { return type; }
    public int getMinute() { return minute; }
    public String getText() { return text; }
    public int getHomeScore() { return homeScore; }
    public int getVisitorScore() { return visitorScore; }
}
