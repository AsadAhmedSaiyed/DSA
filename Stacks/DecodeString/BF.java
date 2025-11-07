package DecodeString;

public class BF {
    public String decodeString(String s) {
        int lastOpen = -1;
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') {
                    lastOpen = i;
                }
            }
            if (lastOpen == -1) {
                break;
            }
            int close = lastOpen;
            while (close < s.length() && s.charAt(close) != ']') {
                close++;
            }
            int kStart = lastOpen - 1;
            while (kStart >= 0 && Character.isDigit(s.charAt(kStart))) {
                kStart--;
            }
            kStart++;
            // forming number
            int k = 0;
            for (int j = kStart; j < close; j++) {
                k = k * 10 + (s.charAt(j) - '0');
            }
            String inner = "";
            String expanded = "";
            for (int i = lastOpen + 1; i < close; i++) {
                inner += s.charAt(i);
            }
            // expanded
            for (int i = 0; i < k; i++) {
                expanded += inner;
            }
            String newStr = "";
            // new string
            for (int i = 0; i < kStart; i++) {
                newStr += s.charAt(i);
            }
            newStr += expanded;
            for (int i = close + 1; i < s.length(); i++) {
                newStr += s.charAt(i);
            }
            s = newStr;
        }
        return s;
    }
}
