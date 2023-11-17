package com.g16.cdio3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Color {
    
    int index;
    String name;
    boolean chosen;
    String sgr_color_fg;
    String sgr_color_bg;

    public Color(int _index, String _name, boolean _chosen, String _sgr_color_fg, String _sgr_color_bg) {
        index = _index;
        name = _name;
        chosen = _chosen;
        sgr_color_fg = _sgr_color_fg;
        sgr_color_bg = _sgr_color_bg;
    }
}

public class GameData { // https://ss64.com/nt/syntax-ansi.html
    public static char escapeChar = (char)27;
    public static Color[] colorIndex = {
        new Color(0, "Red", false, escapeChar + "[31m", escapeChar + "[41m"),
        new Color(1, "Blue", false, escapeChar + "[34m", escapeChar + "[44m"),
        new Color(2, "Green", false, escapeChar + "[32m", escapeChar + "[42m"),
        new Color(3, "Yellow", false, escapeChar + "[33m", escapeChar + "[43m")
    };

    public static final String SGR_CLEAR = escapeChar + "[m";
    public static final String SGR_STRIKETHROUGH = escapeChar + "[9m";

    public static void ClearScreen() {
        System.out.print(escapeChar+"[H");// JUMP TO TOP OF SCREEN
        System.out.print(escapeChar+"[2J");// CLEAR SCREEN
        System.out.flush();  
    }

    public static void ClearRestOfScreen() {
        System.out.print(escapeChar+"[0J");// CLEAR SCREEN
    }

    public static void GotoTopOfScreen() {
        System.out.print(escapeChar+"[H");// JUMP TO TOP OF SCREEN
    }

    public static int WaitForInt() {
        while (true) {
            String ln = Game.scanner.nextLine();
            Matcher m = Pattern.compile("^([0-9]*)$", 0).matcher(ln);
                if (ln != "" && m.find()) {
                    return Integer.valueOf(m.group(1));
                }
        }
    }
}
