class Solution {
    public boolean validUtf8(int[] data) {

        int bytesToCheck = 0;

        for (int num : data) {

            if (bytesToCheck == 0) {

                if ((num >> 7) == 0) {
                    bytesToCheck = 0;
                }
                else if ((num >> 5) == 0b110) {
                    bytesToCheck = 1;
                }
                else if ((num >> 4) == 0b1110) {
                    bytesToCheck = 2;
                }
                else if ((num >> 3) == 0b11110) {
                    bytesToCheck = 3;
                }
                else {
                    return false;
                }

            } else {

                if ((num >> 6) != 0b10) {
                    return false;
                }

                bytesToCheck--;
            }
        }

        return bytesToCheck == 0;
    }
}