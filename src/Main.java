public class Main {
    public static void main(String[] args) {

        String passcode = "346125";
        String keyboard = "963852741";

//        int[][] keyboard = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[] passcodeInt = convertPasscode(passcode);
        int[][] keyboardInt = convertKeyboard(keyboard);
        printKeyboard(keyboardInt);

        int time = 0;
        int[] previousPosition = getPosition(passcodeInt[0], keyboardInt);
        for (int i = 1; i < passcodeInt.length; i++) {
            int[] currentPosition = getPosition(passcodeInt[i], keyboardInt);

            time += calculateTime(previousPosition, currentPosition);
            previousPosition = currentPosition;

        }
        System.out.println("Time is:" + time);



//        int[] position = getPosition(key, keyboard);
//        System.out.println(position[0]);
//        System.out.println(position[1]);

    }


    // get position of any key
    public static int[] getPosition(int key, int[][] keypad) {
        int[] position = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] == key) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }

        return null;
    }

    public static int calculateTime(int[] key1, int[] key2) {
        int rowDelta = Math.abs(key1[0] - key2[0]);
        int columnDelta = Math.abs(key1[1] - key2[1]);

        System.out.println("needed Time:" + Math.max(rowDelta, columnDelta));
        return Math.max(rowDelta, columnDelta);
    }

    public static int[] convertPasscode(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return result;
    }

    public static int[][] convertKeyboard(String s) {
        int position = 0;
        int[][] keyboard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyboard[i][j] = Integer.parseInt(String.valueOf(s.charAt(position)));
                position++;
            }
        }

        return keyboard;
    }

    public static void printKeyboard(int[][] keyboard) {
        System.out.println();
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(keyboard[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


